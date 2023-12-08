package com.example.MOERADTEACHER.common.transferservice;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.MOERADTEACHER.common.interfaces.TeacherInterface;
import com.example.MOERADTEACHER.common.modal.KvSchoolMaster;
import com.example.MOERADTEACHER.common.modal.TeacherProfile;
import com.example.MOERADTEACHER.common.repository.KvSchoolMasterRepo;
import com.example.MOERADTEACHER.common.service.KVTeacherImpl;
import com.example.MOERADTEACHER.common.transferbean.SearchBeans;
import com.example.MOERADTEACHER.common.transferbean.TeacherTransferBean;
import com.example.MOERADTEACHER.common.transfermodel.TeacherTransferedDetails;
import com.example.MOERADTEACHER.common.transfermodel.TransferQuery;
import com.example.MOERADTEACHER.common.transferrepository.TeacherTransferedDetailsRepository;
import com.example.MOERADTEACHER.common.transferrepository.TransferQueryRepository;
import com.example.MOERADTEACHER.common.util.CustomResponse;
import com.example.MOERADTEACHER.common.util.NativeRepository;
import com.example.MOERADTEACHER.security.LoginNativeRepository;

@Service
public class TransferProcessImpl {

	@Autowired
	NativeRepository nativeRepository;
	
	@Autowired
	private LoginNativeRepository loginNativeRepository;
	
	@Autowired
	KVTeacherImpl kvTeacherImpl;
	
	@Autowired
	TeacherInterface  teacherInterface;
	
	@Autowired
	KvSchoolMasterRepo kvSchoolMasterRepo;
	
	@Autowired
	TeacherTransferedDetailsRepository teacherTransferedDetailsRepository;
	
	@Autowired
	TransferQueryRepository  transferQueryRepository;
	
	
	public Object searchEmployeeForTransfer(SearchBeans data) throws Exception {
		String condition="";
		if(data.getTeacherName() !=null && data.getTeacherName() !="") {
			condition="tp.teacher_name like '%"+data.getTeacherName()+"%'";
		}else if(data.getTeacherEmployeeCode() !=null  && data.getTeacherEmployeeCode() !="") {
			condition +=condition !=""?" and tp.teacher_employee_code='"+data.getTeacherEmployeeCode()+"'":"tp.teacher_employee_code='"+data.getTeacherEmployeeCode().toUpperCase()+"'";
		}else if(data.getTeacherDob() !=null && data.getTeacherDob() !="") {
			condition +=condition !=""?" and tp.teacher_dob='"+data.getTeacherDob()+"'":"tp.teacher_dob='"+data.getTeacherDob()+"'";
		}else if(data.getTeacherEmail() !=null  && data.getTeacherEmail() !="") {
			condition +=condition !=""?" and tp.teacher_email='"+data.getTeacherDob()+"'":"tp.teacher_email='"+data.getTeacherDob()+"'";
		}else if(data.getTeacherMobile() !=null && data.getTeacherMobile() !="") {
			condition +=condition !=""?" and tp.teacher_mobile='"+data.getTeacherDob()+"'":"tp.teacher_mobile='"+data.getTeacherDob()+"'";
		}
		
		if(condition !="") {
			condition=" where "+condition;
		}else {
			condition="";
		}
		
		
		String dynamicQuery=" select distinct on (emp_code) emp_code,ksm.kv_name as kv_name_present,modified_date_time,  tp.teacher_employee_code ,tp.teacher_email ,tp.teacher_name,tp.teacher_dob,tp.kv_code,tp.last_promotion_position_type ,tp.work_experience_appointed_for_subject ,zed.emp_transfer_status,zed.kv_name_alloted ,\r\n"
				+ " zed.allot_kv_code ,zed.allot_stn_code,zed.transferred_under_cat,zed.join_date ,zed.relieve_date,zed.join_relieve_flag,zed.transfer_type ,zed.transferred_under_cat_id,zed.is_automated_transfer,zed.is_admin_transfer,zed.present_kv_code,zed.kv_name_present,zed.present_station_code,zed.station_name_present,zed.region_name_present \r\n"
				+ "from public.teacher_profile tp left join z_emp_details_3107 zed on tp.teacher_id =zed.teacher_id left join kv.kv_school_master ksm on tp.kv_code=ksm.kv_code "+condition +"  order by  emp_code,  modified_date_time";
		
		
		System.out.println("dynamic query--->"+dynamicQuery);
		
		return nativeRepository.executeQueries(dynamicQuery);
	}
	
	@Transactional
	public Object adminTransfer(TeacherTransferedDetails data) throws Exception {
		TeacherProfile result=teacherInterface.getTeacherByTeacherEmployeeCode(data.getEmpCode());
		System.out.println(result.getLastPromotionPositionType());
		System.out.println(result.getWorkExperienceAppointedForSubject());
		int year = Calendar.getInstance().get(Calendar.YEAR);
		try {
		KvSchoolMaster schoolObj=kvSchoolMasterRepo.findAllByKvCode(String.valueOf(result.getKvCode()));
		
		data.setEmpName(result.getTeacherName());
		data.setEmpCode(result.getTeacherEmployeeCode());
		data.setDob(result.getTeacherDob());
		data.setGender(Integer.parseInt(result.getTeacherGender()));
		data.setRegionCode(Integer.parseInt(String.valueOf(schoolObj.getRegionCode())));
		data.setRegionNamePresent(schoolObj.getRegionName());
		data.setPresentStationCode(Integer.parseInt(String.valueOf(schoolObj.getStationCode())));
		data.setStationNamePresent(schoolObj.getStateName());
		data.setKvNamePresent(schoolObj.getKvName());
		data.setPresentKvCode(String.valueOf(result.getKvCode()));
		data.setPresentKvMasterCode((result.getKvCode()));
		data.setShift(Integer.parseInt(String.valueOf(schoolObj.getShiftType())));
		data.setTeacherId(result.getTeacherId());
		data.setPostId(Integer.parseInt(String.valueOf(result.getLastPromotionPositionType())));
		data.setPostName(String.valueOf(nativeRepository.executeQueries("select * from public.get_film6('master.mst_teacher_position_type', 'organization_teacher_type_name', 'organization_teacher_type_id="+data.getPostId()+"')").getRowValue().get(0).get("reason")));
		data.setSubjectId(Integer.parseInt(String.valueOf(result.getWorkExperienceAppointedForSubject())));
		data.setSubjectName(String.valueOf(nativeRepository.executeQueries("select * from public.get_film6('master.configured_position_subject_map cpsm , master.mst_teacher_position_type mtpt , master.mst_teacher_subject mts', ' mts.subject_name', 'mtpt.teacher_type_id = cpsm.teacher_type_id and cpsm.subject_id = mts.subject_id and mtpt.application_id::integer =2 and mtpt.teacher_type_id = 42')").getRowValue().get(0).get("reason")));
		data.setDob(result.getTeacherDob());
		data.setDojInPresentStnIrrespectiveOfCadre(result.getWorkExperiencePositionTypePresentStationStartDate());
		data.setTransferType("2");
		data.setIsAdminTransfer(true);
		
		//Not Not Manadatory to fill
		
		data.setIsjcmRjcm(9999);
		data.setIsPwd(9999);
		data.setIsHardServed(9999);		
		data.setIsCurrentlyInHard(9999);
		data.setStationCode_5(9999);
		data.setTotTc(9999);
		data.setTotTc2(9999);
		data.setTotDc(9999);
		data.setTransferAppliedFor(9999);
		data.setDcAppliedFor(9999);
		data.setIsTrasnferApplied(9999);
		data.setTransferredUnderCat(9999);
		data.setEmpTransferStatus(9999);
		data.setIsDisplaced(9999);
		data.setElgibleYn(9999);
		data.setIsNer(9999);
		data.setApplyTransferYn(9999);
		data.setGroundLevel(9999);
		data.setPrintOrder(9999);
		data.setTransferYear(String.valueOf(year));
		
		
		
		
		
		
		// Data From Client Side
//		data.setTransferredUnderCat(transferredUnderCat); //-- data come from client side
//		data.setEmpTransferStatus(empTransferStatus); // -- data come from client side
//		data.setRegionNameAlloted(regionNameAlloted); // --data come from client side
//		data.setRegionCodeAlloted(regionCodeAlloted); // -- data come from client side
//		data.setAllotStnCode(allotStnCode);// -- data come from client side
//		data.setStationNameAlloted(stationNameAlloted); //--data come from client side
//		data.setAllotShift(allotShift); // --data come from client side
//		data.setAllotKvCode(allotKvCode);// -- data come from client side
//		data.setKvNameAlloted(kvNameAlloted); //-- data come from client side
		data.setTransferType("A"); // --data come from client side

		List<TeacherTransferedDetails>  transObj=		teacherTransferedDetailsRepository.findByEmpCode(data.getEmpCode());
		
		if( transObj.size()>0 && transObj !=null && transObj.get(0) !=null   && transObj.get(0).getEmpCode() !=null) {
		System.out.println("111");
			updateTransferHistory(data.getEmpCode());
			for(int i=0;i<transObj.size();i++) {
				System.out.println(transObj.get(i).getAllotKvCode());
				if(String.valueOf(transObj.get(i).getAllotKvCode()).equalsIgnoreCase("-1")) {
					System.out.println("In delete condition");
					teacherTransferedDetailsRepository.deleteById(transObj.get(i).getId());
				}
			}

		}else {
			System.out.println("In else");
		}
		
		teacherTransferedDetailsRepository.save(data);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
//		
		return data;
	}
	
	
	public void updateTransferHistory(String empCode) {
		String query="insert into z_emp_details_history (teacher_id,emp_code,emp_name,gender,dob,post_id,subject_id,region_code,present_station_code,present_kv_code,present_kv_master_code\r\n"
				+ ",shift,doj_in_present_stn_irrespective_of_cadre,is_ner_recruited,isjcm_rjcm,is_pwd,is_hard_served,is_currently_in_hard,station_code_1,station_code_2,station_code_3,station_code_4,station_code_5,tot_tc\r\n"
				+ ",tot_tc2,tot_dc,transfer_applied_for,dc_applied_for,is_trasnfer_applied,allot_stn_code,allot_kv_code,allot_shift,transferred_under_cat,emp_transfer_status,is_displaced\r\n"
				+ ",elgible_yn,is_ner,apply_transfer_yn,ground_level,print_order,kv_name_present,kv_name_alloted,station_name1,station_name2,station_name3,station_name4,station_name5\r\n"
				+ ",region_name_present,region_code_alloted,region_name_alloted,station_name_present,station_name_alloted,post_name,subject_name,join_date,relieve_date,join_relieve_flag,transfer_type,modified_date_time)\r\n"
				+ "select teacher_id,emp_code,emp_name,gender,dob,post_id,subject_id,region_code,present_station_code,present_kv_code,present_kv_master_code\r\n"
				+ ",shift,doj_in_present_stn_irrespective_of_cadre,is_ner_recruited,isjcm_rjcm,is_pwd,is_hard_served,is_currently_in_hard,station_code_1,station_code_2,station_code_3,station_code_4,station_code_5,tot_tc\r\n"
				+ ",tot_tc2,tot_dc,transfer_applied_for,dc_applied_for,is_trasnfer_applied,allot_stn_code,allot_kv_code,allot_shift,transferred_under_cat,emp_transfer_status,is_displaced\r\n"
				+ ",elgible_yn,is_ner,apply_transfer_yn,ground_level,print_order,kv_name_present,kv_name_alloted,station_name1,station_name2,station_name3,station_name4,station_name5\r\n"
				+ ",region_name_present,region_code_alloted,region_name_alloted,station_name_present,station_name_alloted,post_name,subject_name,join_date,relieve_date,join_relieve_flag,transfer_type,modified_date_time  from  z_emp_details_3107 ze\r\n"
				+ "where ze.emp_code='"+empCode+"'";
		nativeRepository.insertQueries(query);
	}
	
	
	public Map<String,Object>  queryRaised(List<TransferQuery> data) {
		Map<String,Object> resObj=new HashMap<String,Object>();
//		TeacherTransferedDetails  transDetail=teacherTransferedDetailsRepository.findAllByEmpCode(data.get(0).getTeacherEmployeeCode());
//		transDetail.setTransferQueryType(Integer.parseInt(data.get(0).getQueryRaisedFor()));
		try {
		transferQueryRepository.saveAll(data);
		resObj.put("status", 1);
		resObj.put("message", "Query Raised Successfully");
		}catch(Exception ex) {
			resObj.put("status", 0);
			resObj.put("message", "Error While Query Raised");
			ex.printStackTrace();
		}
		return resObj;
	}
	
	public Map<String,Object> transferModification(TeacherTransferedDetails data){
		Map<String,Object>  mObj=new HashMap<String,Object>();
		try {
			System.out.println("EmployeeCode--->"+data.getEmpCode());
		List<TeacherTransferedDetails>  transDetail=teacherTransferedDetailsRepository.findByEmpCode(data.getEmpCode());
		System.out.println("transDetail.size()--->"+transDetail.size());
		if(transDetail.size()>1) {
			mObj.put("status", "0");
			mObj.put("message", "You can only update the transfer not modified");
			return mObj;
		}else if(transDetail.size()==1) {
			if(transDetail.get(0).getTransferType() ==null || (!transDetail.get(0).getTransferType().equalsIgnoreCase("A") && !transDetail.get(0).getTransferType().equalsIgnoreCase("AM"))) {
			transDetail.get(0).setTransferType("S");
			}
			teacherTransferedDetailsRepository.save(transDetail.get(0));
		
		}
		
		TeacherTransferedDetails  addModified =new TeacherTransferedDetails();
		
	
		
		addModified.setAllotKvCode(data.getAllotKvCode());
		addModified.setKvNameAlloted(data.getKvNameAlloted());
		addModified.setAllotShift(data.getAllotShift());
		addModified.setStationNameAlloted(data.getStationNameAlloted());
		addModified.setAllotStnCode(data.getAllotStnCode());
		addModified.setRegionNameAlloted(data.getRegionNameAlloted());
		addModified.setRegionCodeAlloted(data.getRegionCodeAlloted());
		addModified.setTransferType("AM");
		addModified.setTransferredUnderCat(data.getTransferredUnderCat());
		addModified.setTransferredUnderCatId(data.getTransferredUnderCatId());
		addModified.setIsAdminTransfer(true);
		addModified.setIsAutomatedTransfer(false);
		
		
//		addModified.setApplyTransferYn(applyTransferYn);
		addModified.setDob(transDetail.get(0).getDob());
//		addModified.setDojInPresentStnIrrespectiveOfCadre(dojInPresentStnIrrespectiveOfCadre);
//		addModified.setElgibleYn(elgibleYn);
		addModified.setEmpCode(transDetail.get(0).getEmpCode());
		addModified.setEmpName(transDetail.get(0).getEmpName());
//		addModified.setEmpTransferStatus(empTransferStatus);
		addModified.setGender(transDetail.get(0).getGender());
//		addModified.setGroundLevel(groundLevel);
		addModified.setIsCurrentlyInHard(transDetail.get(0).getIsCurrentlyInHard());
//		addModified.setIsDisplaced(isDisplaced);
		addModified.setIsHardServed(transDetail.get(0).getIsHardServed());
		addModified.setIsjcmRjcm(transDetail.get(0).getIsjcmRjcm());
		addModified.setIsNer(transDetail.get(0).getIsNer());
		addModified.setIsNerRecruited(transDetail.get(0).getIsNerRecruited());
		addModified.setIsPwd(transDetail.get(0).getIsPwd());
//		addModified.setIsTrasnferApplied(isTrasnferApplied);
		addModified.setPostId(transDetail.get(0).getPostId());
		addModified.setPostName(transDetail.get(0).getPostName());
		
//		addModified.setPresentKvCode(transDetail.get(0).getAllotKvCode());          
//		addModified.setPresentKvMasterCode(transDetail.get(0).getAllotKvCode());
		
		
		addModified.setPresentStationCode(transDetail.get(0).getPresentStationCode());
		addModified.setSubjectId(transDetail.get(0).getSubjectId());
		addModified.setSubjectName(transDetail.get(0).getSubjectName());
		addModified.setTeacherId(transDetail.get(0).getTeacherId());
		addModified.setTransferQueryType(transDetail.get(0).getTransferQueryType());
		addModified.setIsjcmRjcm(9999);
		addModified.setIsPwd(9999);
		addModified.setIsHardServed(9999);		
		addModified.setIsCurrentlyInHard(9999);
		addModified.setStationCode_5(9999);
		addModified.setTotTc(9999);
		addModified.setTotTc2(9999);
		addModified.setTotDc(9999);
		addModified.setTransferAppliedFor(9999);
		addModified.setDcAppliedFor(9999);
		addModified.setIsTrasnferApplied(9999);
		addModified.setTransferredUnderCat(9999);
		addModified.setEmpTransferStatus(9999);
		addModified.setIsDisplaced(9999);
		addModified.setElgibleYn(9999);
		addModified.setIsNer(9999);
		addModified.setApplyTransferYn(9999);
		addModified.setGroundLevel(9999);
		addModified.setPrintOrder(9999);
//		isjcm_rjcm
		
		
		
		
        
		List<TeacherTransferedDetails>  transObj =  teacherTransferedDetailsRepository.findByEmpCode(data.getEmpCode());
		if(transObj !=null && transObj.get(0).getEmpCode() !=null) {
			updateTransferHistory(data.getEmpCode());
//			teacherTransferedDetailsRepository.deleteById(transObj.getId());
		}
		
		System.out.println("addModified.getIsAdminTransfer()--->"+addModified.getIsAdminTransfer());
		
		teacherTransferedDetailsRepository.save(addModified);
		
		mObj.put("status", "1");
		mObj.put("message", "Transfer Modification Successfully");
		}catch(Exception ex) {
			ex.printStackTrace();
			mObj.put("status", "0");
			mObj.put("message", "Error during Transfer Modification");
		}
		return mObj;
	}
	
	public Map<String,Object>  transferCancelation(TeacherTransferedDetails data){
		Map<String,Object>  resObj=new HashMap<String,Object>();
		try {
		List<TeacherTransferedDetails>  transObj=teacherTransferedDetailsRepository.findByEmpCode(data.getEmpCode());
		transObj.get(0).setTransferType("AC");
		System.out.println("Id for cancel--->"+transObj.get(0).getId());
		teacherTransferedDetailsRepository.save(transObj.get(0));
		resObj.put("status", 1);
		resObj.put("message", "transfer has been canceled");
		System.out.println(transObj.get(0).getEmpCode());
		if(transObj !=null && transObj.get(0).getEmpCode() !=null) {
			updateTransferHistory(data.getEmpCode());
			for(int i=0;i<transObj.size();i++) {
				teacherTransferedDetailsRepository.deleteById(transObj.get(0).getId());	
			}
			
			resObj.put("status", 0);
			resObj.put("message", "Error during transfer cancelation");
		}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return resObj;
		
	}
	
	
	public List<TransferQuery> getRaisedQueryByEmpCode(String empCode){
		return transferQueryRepository.findAllByTeacherEmployeeCode(empCode);
		
	}
	
	public Object getTransferedList(Map<String,Object> data) {
		String condition="";
		String query="";
		if(String.valueOf(data.get("type")).equalsIgnoreCase("S")) {
			condition="where zed.is_automated_transfer=true";
			 query=" select tp.teacher_employee_code ,tp.teacher_email ,tp.teacher_name,tp.teacher_dob,tp.kv_code,tp.last_promotion_position_type ,tp.work_experience_appointed_for_subject ,zed.emp_transfer_status,zed.kv_name_alloted ,\r\n"
					+ " zed.allot_kv_code ,zed.allot_stn_code,zed.transferred_under_cat,zed.join_date ,zed.relieve_date,zed.join_relieve_flag,zed.transfer_type ,zed.transferred_under_cat_id,zed.is_automated_transfer,zed.is_admin_transfer,zed.present_kv_code,zed.kv_name_present,zed.present_station_code,zed.station_name_present,zed.region_name_present \r\n"
					+ "from public.teacher_profile tp left join z_emp_details_3107 zed on tp.teacher_id =zed.teacher_id "+condition;
			
		}else if(String.valueOf(data.get("type")).equalsIgnoreCase("A")) {
			condition="where zed.is_admin_transfer=true order by zed.emp_code,zed.id desc ";
			 query=" select distinct on (zed.emp_code)  emp_code ,tp.teacher_employee_code,zed.id ,tp.teacher_email ,tp.teacher_name,tp.teacher_dob,tp.kv_code,tp.last_promotion_position_type ,tp.work_experience_appointed_for_subject ,zed.emp_transfer_status,zed.kv_name_alloted ,\r\n"
						+ " zed.allot_kv_code ,zed.allot_stn_code,zed.transferred_under_cat,zed.join_date ,zed.relieve_date,zed.join_relieve_flag,zed.transfer_type ,zed.transferred_under_cat_id,zed.is_automated_transfer,zed.is_admin_transfer,zed.present_kv_code,zed.kv_name_present,zed.present_station_code,zed.station_name_present,zed.region_name_present \r\n"
						+ "from public.teacher_profile tp left join z_emp_details_3107 zed on tp.teacher_id =zed.teacher_id "+condition;
				
		}
		
		
		
		System.out.println("query--->"+query);
		
		return nativeRepository.executeQueries(query);
	}
	
	
	public Object getModifiedTransferDetails(Map<String,Object> data) {
		String query=" select tp.teacher_employee_code ,tp.teacher_email ,tp.teacher_name,tp.teacher_dob,tp.kv_code,tp.last_promotion_position_type ,tp.work_experience_appointed_for_subject ,zed.emp_transfer_status,zed.kv_name_alloted ,\r\n"
				+ " zed.id, zed.allot_kv_code ,zed.allot_stn_code,zed.transferred_under_cat,zed.join_date ,zed.relieve_date,zed.join_relieve_flag,zed.transfer_type ,zed.transferred_under_cat_id,zed.is_automated_transfer,zed.is_admin_transfer \r\n"
				+ "from public.teacher_profile tp left join z_emp_details_3107 zed on tp.teacher_id =zed.teacher_id where zed.emp_code='"+String.valueOf(data.get("empCode"))+"' order by zed.id desc";
		
		return nativeRepository.executeQueries(query);
	}
	
	
	
	
}
