package com.example.MOERADTEACHER.common.transferservice;

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
import com.example.MOERADTEACHER.common.transferrepository.TeacherTransferedDetailsRepository;
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
		
		
		String dynamicQuery=" select tp.teacher_employee_code ,tp.teacher_email ,tp.teacher_name,tp.teacher_dob,tp.kv_code,tp.last_promotion_position_type ,tp.work_experience_appointed_for_subject ,zed.emp_transfer_status,zed.kv_name_alloted ,\r\n"
				+ " zed.allot_kv_code ,zed.allot_stn_code,zed.transferred_under_cat,zed.join_date ,zed.relieve_date,zed.join_relieve_flag  \r\n"
				+ "from public.teacher_profile tp left join z_emp_details_3107 zed on tp.teacher_id =zed.teacher_id "+condition;
		
		
		System.out.println("dynamic query--->"+dynamicQuery);
		
		return nativeRepository.executeQueries(dynamicQuery);
	}
	
	@Transactional
	public Object adminTransfer(TeacherTransferedDetails data) throws Exception {
		TeacherProfile result=teacherInterface.getTeacherByTeacherEmployeeCode(data.getEmpCode());
		KvSchoolMaster schoolObj=kvSchoolMasterRepo.findAllByKvCode(String.valueOf(result.getKvCode()));
		
		data.setEmpName(result.getTeacherName());
		data.setEmpCode(result.getTeacherEmployeeCode());
//		data.setDob();
		data.setGender(Integer.parseInt(result.getTeacherGender()));
		data.setRegionCode(Integer.parseInt(String.valueOf(schoolObj.getRegionCode())));
		data.setRegionNamePresent(schoolObj.getRegionName());
		data.setPresentStationCode(Integer.parseInt(String.valueOf(schoolObj.getStationCode())));
		data.setStationNamePresent(schoolObj.getStateName());
		data.setKvNamePresent(schoolObj.getKvName());
		data.setPresentKvCode(Integer.parseInt(result.getKvCode()));
		data.setShift(Integer.parseInt(String.valueOf(schoolObj.getShiftType())));
		data.setTeacherId(result.getTeacherId());
		
		
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

		System.out.println("empcode-->"+data.getEmpCode());
		
		TeacherTransferedDetails  transObj=		teacherTransferedDetailsRepository.findAllByEmpCode(data.getEmpCode());
		
		if(transObj !=null && transObj.getEmpCode() !=null) {
			updateTransferHistory(data.getEmpCode());
			teacherTransferedDetailsRepository.deleteById(transObj.getId());
		}
		teacherTransferedDetailsRepository.save(data);
		
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
	
	
	
	
}
