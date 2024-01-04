package com.example.MOERADTEACHER;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
//import com.moe
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.example.MOERADTEACHER.common.exceptions.UserNotAuthorizedException;
import com.example.MOERADTEACHER.common.transferbean.Transfer;
import com.example.MOERADTEACHER.common.util.NativeRepository;
import com.example.MOERADTEACHER.common.util.QueryResult;
import com.example.MOERADTEACHER.common.util.UtilCalculation;

@SpringBootApplication(exclude = {MultipartAutoConfiguration.class})
//@EnableDiscoveryClient
@EnableCaching
@EnableScheduling
@Import(UserNotAuthorizedException.class)

public class MoeRadTeacherApplication {

	private static final Logger LOGGER=LoggerFactory.getLogger(MoeRadTeacherApplication.class);
	
	@Autowired
	NativeRepository nativeRepository;
	
	@Autowired
	UtilCalculation utilCalculation;
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
//		TimerServiceApplication.main(null);
	}
	public static void main(String[] args) {
		SpringApplication.run(MoeRadTeacherApplication.class, args);
		LOGGER.info("Simple log statement with inputs {}, {} and {}", 1,2,3);
	}
	
	
	 @Scheduled(fixedDelay = 1000)
	  public void checkStay() throws InterruptedException, ParseException {
//		 System.out.println("Check Stay--->"+utilCalculation.calDcStayAtStation(12690));
	 }
	
	
	 @Scheduled(fixedDelay = 7000)
	  public void update() throws InterruptedException {
			/*
			 * nativeRepository.
			 * updateQueries("update public.teacher_work_experience twe set udise_school_name= ksm.kv_name  from kv.kv_school_master ksm where ksm.kv_code = twe.kv_code  and (udise_school_name is null or udise_school_name='') "
			 * ); nativeRepository.
			 * updateQueries("update public.teacher_work_experience set kv_code = udise_sch_code where kv_code is null"
			 * ); nativeRepository.
			 * updateQueries("update public.teacher_profile set teacher_dob  = TO_CHAR(teacher_dob::timestamptz, 'YYYY-MM-DD')  where length(teacher_dob) = 24"
			 * ); nativeRepository.
			 * updateQueries("update public.teacher_profile set work_experience_work_start_date_present_kv  = TO_CHAR(work_experience_work_start_date_present_kv::timestamptz, 'YYYY-MM-DD') where length(work_experience_work_start_date_present_kv) = 24"
			 * ); nativeRepository.
			 * updateQueries("update public.teacher_profile set work_experience_position_type_present_station_start_date  = TO_CHAR(work_experience_position_type_present_station_start_date::timestamptz, 'YYYY-MM-DD') where length(work_experience_position_type_present_station_start_date) = 24 "
			 * ); nativeRepository.
			 * updateQueries("update public.teacher_profile set last_promotion_position_date  = TO_CHAR(last_promotion_position_date::timestamptz, 'YYYY-MM-DD') where length(last_promotion_position_date) = 24"
			 * );
			 */
	  }
	  
	  
		Integer returnStayCount=0;
		Integer count=0;

//		 @Scheduled(fixedDelay = 12000000)
//		  public  void updates() throws InterruptedException, ParseException {
//			  System.out.println("called Schedular");
//			  ++count;
//			  if(count==1) {
//			  String query="select * from public.teacher_profile";
//			  QueryResult qs=nativeRepository.executeQueries(query);
//			  for(int i=0;i<qs.getRowValue().size();i++) {
//			  LinkedList<Transfer> transfers = new LinkedList<>();
//				String QUERYstation = " select *, DATE_PART('day', work_end_date::timestamp - work_start_date::timestamp) as no_of_days from (\r\n"
//						+ "				 	select ksm.station_code , work_start_date , coalesce(work_end_date,'2023-06-30') as work_end_date, \r\n"
//						+ "				 	teacher_id   \r\n"
//						+ "				 	from 	public.teacher_work_experience twe , kv.kv_school_master ksm \r\n"
//						+ "				 	where teacher_id = '" + qs.getRowValue().get(i).get("teacher_id") + "'"
//						+ "				 	and ksm.kv_code = twe.udise_sch_code \r\n"
//						+ "				 	order by work_start_date \r\n"
//						+ "				 	) aa order by work_start_date desc ";
//				
//				QueryResult qr = nativeRepository.executeQueries(QUERYstation);
//				
//				for (int j = 0; j < qr.getRowValue().size(); j++) {
//					SimpleDateFormat sObj = new SimpleDateFormat("yyyy-MM-dd");
//
//					Date date1 = sObj
//							.parse(String.valueOf(qr.getRowValue().get(j).get("work_start_date").toString()));
//
//					try {
//						transfers.add(new Transfer(String.valueOf(qr.getRowValue().get(j).get("station_code")),
//								sObj.parse(
//										String.valueOf(qr.getRowValue().get(j).get("work_start_date").toString())),
//								sObj.parse(String.valueOf(qr.getRowValue().get(j).get("work_end_date").toString())),
//								(int) Double
//										.parseDouble((String.valueOf(qr.getRowValue().get(j).get("no_of_days"))))));
//
//					} catch (Exception ex) {
//						ex.printStackTrace();
//					}
//				}
//
//				int returnStay = calculateReturnStay(transfers);
//				
//				if(returnStay>0) {
//					++returnStayCount;
//				System.out.println("returnStay--->"+returnStay+"----returnStayCount--->"+returnStayCount);
//		
//				}
//				nativeRepository.updateQueries("update transfer.transfer_teacher_check set returnstay2='"+returnStay+"' where teacher_id="+qs.getRowValue().get(i).get("teacher_id"));
//				
//			  }
//			  }
//		  }
		  
		  
//		    public static List<Transfer> getHighestThreeRows(List<Transfer> transfers) {
//		        return transfers.stream()
//		                .sorted(Comparator.comparingInt(Transfer::getRowNumber).reversed())
//		                .limit(3)
//		                .collect(Collectors.toList());
//		    }
//		    
		    
//			  public  int calculateReturnStay(List<Transfer> transfers) {
//			        int totalStay = 0;
//			        int key=0;
//		       	
//			        
//			        if (transfers.size() >= 3) {
//			            Transfer firstRow = transfers.get(0);
//			            Transfer secondRow = transfers.get(1);
//			            Transfer thirdRow = transfers.get(2);
//			            
//			            if (firstRow.getStation().trim().equalsIgnoreCase(thirdRow.getStation().trim())) {
//			            	if(!secondRow.getStation().equalsIgnoreCase(firstRow.getStation())) {
//			            		
//			            		String stationThird=thirdRow.getStation().trim();
//			            		
//			            		
//			            		
//			            	if(secondRow.getNoOfDays()<=1095) {
//			            		totalStay = thirdRow.getNoOfDays();	
//			            		for(int i=3;i<transfers.size();i++) {
//			            			if(stationThird.equalsIgnoreCase(transfers.get(i).getStation())) {
//			            				totalStay +=transfers.get(i).getNoOfDays();
//			            			}else {
//			            				break;
//			            			}
//			            		}
//			            	}else {
//			            		totalStay =0;
//			            	}
//			            	
//			            	System.out.println(totalStay);
//			            	if (key==1)
//			            	 return totalStay;
//			            	}
//			                  
//			            } else {
//			                System.out.println("Station pattern doesn't match.");
//			            }
//			        } else {
//			            System.out.println("Not enough transfers to check the district pattern.");
//			        }
//			        
//			        	      
//			        return totalStay;
//			    } 
		    
		
			  
//			  public  String calculateReturnStayTenure(String StatinCode, int noOfDays, Date startDate, int typeToCalculate) {
//			       
//			        String returnString ="0:O:0:0";
//			        try {
//			        	int category_id = -1;
//			        	
//			        	String TenureCalculateQry = "select count(*) as no_of_record, category_id  from uneecops.station_category_mapping scm where scm.station_code ='"+StatinCode+"'   "
//			        			 +" and '"+startDate +"' between from_date and to_date "
//			        			+ "group by category_id ";
//
//			          	QueryResult	rs=nativeRepository.executeQueries(TenureCalculateQry);  
//				          if (typeToCalculate == 1) {
//			        		
//				        	  
//				        	  for(int i=0;i<rs.getRowValue().size();i++) {
//				        	  
//
//				        			category_id =Integer.parseInt(String.valueOf(rs.getRowValue().get(i).get("category_id")));
//				        					if(category_id==4) {
//							        			double noOf_Year = Double.parseDouble(String.valueOf(noOfDays))/ 364;
//							        			if (noOf_Year < 2.0 ) { // Did not Complete 2 Year 
//							        				returnString = "1:VH:"+noOf_Year+":"+noOfDays;// 1 = True , VH Very Hard ,  
//							        				return returnString;
//							        			}
//							        			
//							        		}else { 
//							        			double noOf_Year = Double.parseDouble(String.valueOf(noOfDays))/ 364;
//							        			if (noOf_Year < 3.0 ) { 
//							        				returnString = "1:O:"+noOf_Year+":"+noOfDays;
//							        				return returnString;
//							        			}
//							        		}
//				        					return returnString;		
//				        		
//				        	  }
//				        		
//				        		  return returnString;
//			        		
//			        	}
//			        	
//			        }catch(Exception e) {
//			        	e.printStackTrace();
//			        }
//			        finally {
//			        
//			        }
//			      
//			        return returnString;	
//			     
//			    } 
	  

	
	
}
