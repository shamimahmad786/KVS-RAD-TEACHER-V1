package com.example.MOERADTEACHER.common.util;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.MOERADTEACHER.common.transferbean.Transfer;

@Service
public class UtilCalculation {
	

	
	public Integer calDcStayAtStation(Integer teacherId,NativeRepository nativeRepository) throws ParseException {
		Integer returnStayCount=0;
		LinkedList<Transfer> transfers = new LinkedList<>();
		String QUERYstation = " select *, DATE_PART('day', work_end_date::timestamp - work_start_date::timestamp) as no_of_days from (\r\n"
				+ "				 	select ksm.station_code , work_start_date , coalesce(work_end_date,'2023-06-30') as work_end_date,twe.ground_for_transfer , \r\n"
				+ "				 	teacher_id ,id3  \r\n"
				+ "				 	from 	public.teacher_work_experience twe , kv.kv_school_master ksm \r\n"
				+ "				 	where teacher_id = '" + teacherId + "'"
				+ "				 	and ksm.kv_code = twe.udise_sch_code \r\n"
				+ "				 	order by work_start_date \r\n"
				+ "				 	) aa order by work_start_date desc ";
		
		
//		System.out.println(QUERYstation);
		
		QueryResult qr = nativeRepository.executeQueries(QUERYstation);
		
		for (int j = 0; j < qr.getRowValue().size(); j++) {
			SimpleDateFormat sObj = new SimpleDateFormat("yyyy-MM-dd");

			Date date1 = sObj
					.parse(String.valueOf(qr.getRowValue().get(j).get("work_start_date").toString()));

			try {
				transfers.add(new Transfer(String.valueOf(qr.getRowValue().get(j).get("station_code")),
						sObj.parse(
								String.valueOf(qr.getRowValue().get(j).get("work_start_date").toString())),
						sObj.parse(String.valueOf(qr.getRowValue().get(j).get("work_end_date").toString())),
						(int) Double
								.parseDouble((String.valueOf(qr.getRowValue().get(j).get("no_of_days")))),
								String.valueOf(qr.getRowValue().get(j).get("ground_for_transfer")), Integer.parseInt(String.valueOf(qr.getRowValue().get(j).get("id3"))		
						)));

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		
		int returnStay=0;
		if(qr.getRowValue().size()>0) {
			
			returnStay = calculateReturnStay(transfers,nativeRepository);

		}
		if(returnStay>0) {
			++returnStayCount;
		}
		
		System.out.println("returnStay--->"+returnStay);
		
		return returnStay;
	}
	
	
	  public  int calculateReturnStay(List<Transfer> transfers,NativeRepository nativeRepository) {	  
		  int  returnStay=0;
		  int checkStay=0;
		  int match=0;		 
		  int unmatchCodition=0;
		  int oneTimeUnmatch=0;

		  if(transfers.size()==1) {
			  returnStay +=transfers.get(0).getNoOfDays();
			  return  returnStay;
		  }
		  
		  Transfer firstRow = transfers.get(0);
		  Transfer secondRow = transfers.get(1);
		  int experienceSize=transfers.size();
		  
		  
		   
		  for(int i=0;i<transfers.size();i++) {			  
			  if(unmatchCodition==0) {
			  if(firstRow.getStation().equalsIgnoreCase(transfers.get(i).getStation())) {
				  if(experienceSize ==i+1) {
					  returnStay +=transfers.get(i).getNoOfDays();
					  }else {
				  if(firstRow.getStation().equalsIgnoreCase(transfers.get(i+1).getStation())) {
					  returnStay +=transfers.get(i).getNoOfDays(); 
				  }else {
				  if(transfers.get(i+1).getGroundForTransfer() !=null && (transfers.get(i+1).getGroundForTransfer().equalsIgnoreCase("1") ||  transfers.get(i+1).getGroundForTransfer().equalsIgnoreCase("2")  || transfers.get(i+1).getGroundForTransfer().equalsIgnoreCase("3") || transfers.get(i+1).getGroundForTransfer().equalsIgnoreCase("4") || transfers.get(i+1).getGroundForTransfer().equalsIgnoreCase("5") || transfers.get(i+1).getGroundForTransfer().equalsIgnoreCase("6") || transfers.get(i+1).getGroundForTransfer().equalsIgnoreCase("13") || transfers.get(i+1).getGroundForTransfer().equalsIgnoreCase("14") || transfers.get(i+1).getGroundForTransfer().equalsIgnoreCase("15") | transfers.get(i+1).getGroundForTransfer().equalsIgnoreCase("16") || transfers.get(i+1).getGroundForTransfer().equalsIgnoreCase("17") || transfers.get(i+1).getGroundForTransfer().equalsIgnoreCase("19"))) {
					  returnStay +=transfers.get(i).getNoOfDays();
				  }else {
					  returnStay +=transfers.get(i).getNoOfDays();
					  break;
				  }
				  }
					  }				  
			  }else {
				  unmatchCodition=1;
				  ++oneTimeUnmatch;
				  if(oneTimeUnmatch==1) {
				  if(transfers.get(i).getGroundForTransfer() !=null && (transfers.get(i).getGroundForTransfer().equalsIgnoreCase("1") ||  transfers.get(i).getGroundForTransfer().equalsIgnoreCase("2")  || transfers.get(i).getGroundForTransfer().equalsIgnoreCase("3") || transfers.get(i).getGroundForTransfer().equalsIgnoreCase("4") || transfers.get(i).getGroundForTransfer().equalsIgnoreCase("5") || transfers.get(i).getGroundForTransfer().equalsIgnoreCase("6") || transfers.get(i).getGroundForTransfer().equalsIgnoreCase("13") || transfers.get(i).getGroundForTransfer().equalsIgnoreCase("14") || transfers.get(i).getGroundForTransfer().equalsIgnoreCase("15") | transfers.get(i).getGroundForTransfer().equalsIgnoreCase("16") || transfers.get(i).getGroundForTransfer().equalsIgnoreCase("17") || transfers.get(i).getGroundForTransfer().equalsIgnoreCase("19"))) {
				  }else {
					  break;
				  }
				  }
				  
			  }
			  }
			  

			  if(unmatchCodition==1) {		  
			  if(firstRow.getStation().equalsIgnoreCase(transfers.get(i).getStation())) {
				  match=1;
				  checkStay=0; 
				  if(experienceSize ==i+1) {
				  returnStay +=transfers.get(i).getNoOfDays();
				  }else {
					  if(firstRow.getStation().equalsIgnoreCase(transfers.get(i+1).getStation())) {
						  returnStay +=transfers.get(i).getNoOfDays(); 
					  }else {
					  if(transfers.get(i+1).getGroundForTransfer() !=null && (transfers.get(i+1).getGroundForTransfer().equalsIgnoreCase("1") ||  transfers.get(i+1).getGroundForTransfer().equalsIgnoreCase("2")  || transfers.get(i+1).getGroundForTransfer().equalsIgnoreCase("3") || transfers.get(i+1).getGroundForTransfer().equalsIgnoreCase("4") || transfers.get(i+1).getGroundForTransfer().equalsIgnoreCase("5") || transfers.get(i+1).getGroundForTransfer().equalsIgnoreCase("6") || transfers.get(i+1).getGroundForTransfer().equalsIgnoreCase("13") || transfers.get(i+1).getGroundForTransfer().equalsIgnoreCase("14") || transfers.get(i+1).getGroundForTransfer().equalsIgnoreCase("15") | transfers.get(i+1).getGroundForTransfer().equalsIgnoreCase("16") || transfers.get(i+1).getGroundForTransfer().equalsIgnoreCase("17") || transfers.get(i+1).getGroundForTransfer().equalsIgnoreCase("19"))) {
					  returnStay +=transfers.get(i).getNoOfDays();
					  }else {
						  returnStay +=transfers.get(i).getNoOfDays();
						  break;
					  }
					  }
				  }
				  
			  }else {				
				 QueryResult qs= nativeRepository.executeQueries("select * from master.very_hard_hard_14_16 where id3="+transfers.get(i).getId3());				  
				  if(qs.getRowValue().size()>0) {
					  match=0;
					  if(checkStay<728) {
					  checkStay +=transfers.get(i).getNoOfDays();
					  if(checkStay>728) {
						  break;
					  }
					  }else {
						  break;
					  }
				  }else {
				  match=0;
				  if(checkStay<1095) {
				  checkStay +=transfers.get(i).getNoOfDays();
				  if(checkStay>1095) {
					  break;
				  }
				  }else {
					  break;
				  }
			  }
			  }
		  }
			  
		  }
	    	 return returnStay;
	    } 
	
	
}
