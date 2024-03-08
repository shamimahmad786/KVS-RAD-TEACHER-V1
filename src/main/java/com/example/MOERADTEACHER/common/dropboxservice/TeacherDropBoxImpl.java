package com.example.MOERADTEACHER.common.dropboxservice;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MOERADTEACHER.common.dropboxbean.DropboxMaster;
import com.example.MOERADTEACHER.common.dropboxbean.EmployeeDetailsSearchList;
import com.example.MOERADTEACHER.common.dropboxbean.EmployeeDropbox;
import com.example.MOERADTEACHER.common.dropboxmodal.TeacherDropBox;
import com.example.MOERADTEACHER.common.dropboxrepository.TeacherDropBoxRepository;
import com.example.MOERADTEACHER.common.modal.TeacherFormStatus;
import com.example.MOERADTEACHER.common.modal.TeacherProfile;
import com.example.MOERADTEACHER.common.repository.TeacherFormStatusRepository;
import com.example.MOERADTEACHER.common.repository.TeacherProfileRepository;
import com.example.MOERADTEACHER.common.responsehandler.ErrorResponse;
import com.example.MOERADTEACHER.common.responsehandler.ManageResponseCode;
import com.example.MOERADTEACHER.common.responsehandler.SucessReponse;
import com.example.MOERADTEACHER.common.util.NativeRepository;
import com.example.MOERADTEACHER.common.util.QueryResult;
import com.example.MOERADTEACHER.security.LoginNativeRepository;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TeacherDropBoxImpl {
	
	@Autowired
	TeacherDropBoxRepository  teacherDropBoxRepository;
	
	@Autowired
	TeacherProfileRepository  teacherProfileRepository;
	
	@Autowired
	NativeRepository nativeRepository;
	
	@Autowired
	TeacherFormStatusRepository  teacherFormStatusRepository;
	
	@Autowired
	LoginNativeRepository  loginNativeRepository;

public Object dropEmployeeToDropbox(TeacherProfile tp,EmployeeDropbox edb,String username,String ipaddress){
	
	QueryResult qr=new QueryResult();
	qr =nativeRepository.executeQueries("select get_film6('master.mst_teacher_position_type','organization_teacher_type_name','teacher_type_id::varchar = ( select last_promotion_position_type  from public.teacher_profile tp where teacher_id="+tp.getTeacherId()+")') as last_promotion_position_type");
	
	
	SimpleDateFormat  formatter = new SimpleDateFormat("yyyy-MM-dd");
	Map<String,Object> mp=new HashMap<String,Object>();
	try {
	String dateInString = formatter.format(new Date());
	TeacherDropBox tdb=new TeacherDropBox();
	tdb.setTeacherId(tp.getTeacherId());
	tdb.setTeacherName(tp.getTeacherName());
	tdb.setTeacherEmployeeCode(tp.getTeacherEmployeeCode());
	tdb.setTeacherGender(tp.getTeacherGender());
	tdb.setTeacherDob(tp.getTeacherDob());
	tdb.setTeachingNonteaching(tp.getTeachingNonteaching());
	tdb.setLastPromotionPositionType(String.valueOf(qr.getRowValue().get(0).get("last_promotion_position_type"))); 
	tdb.setKvCode(tp.getKvCode());
	tdb.setCreatedBy(username);
	tdb.setEmployeeDropId(edb.getEmployeeDropId());
	tdb.setDropBoxFlag(1);
	tdb.setIpaddress(ipaddress);
	tdb.setDropboxDescription(edb.getDropboxDescription());
	tdb.setImportDateTime(new java.sql.Date(formatter.parse(dateInString).getTime()));
	teacherDropBoxRepository.save(tdb);
	// Update Profile
	tp.setDropBoxFlag(1);
	tp.setDropboxDate( new java.sql.Date(formatter.parse(dateInString).getTime()));
	teacherProfileRepository.save(tp);
	
	//Update Status
	TeacherFormStatus tfs=  teacherFormStatusRepository.findAllByTeacherId(tp.getTeacherId());
	tfs.setForm1Status("");
	tfs.setForm2Status("");
	tfs.setForm3Status("");
	tfs.setForm4Status("");
	tfs.setProfile1FormStatus("");
	tfs.setProfile2FormStatus("");
	tfs.setProfile3FormStatus("");
	tfs.setProfileFinalStatus("");
	tfs.setTransferFinalStatus("");
	teacherFormStatusRepository.save(tfs);
	
	nativeRepository.insertQueries(" insert into audit_tray.teacher_profile_confirmation_history select * from audit_tray.teacher_profile_confirmation where teacher_id="+tp.getTeacherId());
  	nativeRepository.updateQueries("delete from audit_tray.teacher_profile_confirmation where teacher_id="+tp.getTeacherId());
	
	  return new SucessReponse(true, ManageResponseCode.RES0020.getStatusDesc(), ManageResponseCode.RES0020.getStatusDesc());
	}catch(Exception ex) {
		ex.printStackTrace();
		return	new ErrorResponse(false, ManageResponseCode.RES0019.getStatusCode(),
				ManageResponseCode.RES0019.getStatusDesc());
		
	}
	}


public Object getDroboxMaster() {
	ObjectMapper mapperObj = new ObjectMapper();
	List<DropboxMaster> tdata=new ArrayList<DropboxMaster>();
	try {
		tdata = mapperObj.convertValue(nativeRepository.executeQueries("select * from master.mst_dropbox order by dropbox_type ").getRowValue(), new TypeReference<List<DropboxMaster>>() {
		});
	}catch(Exception ex) {
		ex.printStackTrace();
	}
	return tdata;
}

public Object getDropedEmployeeByKvCode(String kvCode) {
	return teacherDropBoxRepository.findAllByKvCode(kvCode);
}

public Object searchEmployeeForImport(ArrayList<String> userList) {
	QueryResult qs=new QueryResult();
	ObjectMapper mapperObj = new ObjectMapper();
	List<EmployeeDetailsSearchList>  leds=new ArrayList<EmployeeDetailsSearchList>();
	
	System.out.println(userList);
	//String query="select tp.teacher_name,td.employeedropid,tp.drop_box_flag,tp.teacher_id,tp.teacher_employee_code,tp.teacher_gender,tp.teaching_nonteaching, tp.last_promotion_position_type,tp.kv_code,ksm.kv_name from public.teacher_profile tp left join kv.kv_school_master ksm on tp.kv_code=ksm.kv_code left join public.teacher_dropbox td on ksm.kv_code=td.kv_code  where tp.teacher_employee_code in ('"+String.join("','", userList)+"')";
	String query="select mtpt.organization_teacher_type_name as  last_promotion_position_type,tp.teacher_name,td.employeedropid,tp.drop_box_flag,tp.teacher_id,tp.teacher_employee_code,tp.teacher_gender,tp.teaching_nonteaching, tp.last_promotion_position_type,tp.kv_code,ksm.kv_name from public.teacher_profile tp  left join public.teacher_dropbox td on tp.teacher_employee_code =td.teacher_employee_code  left join kv.kv_school_master ksm on ksm.kv_code=tp.kv_code  left join master.mst_teacher_position_type mtpt on tp.last_promotion_position_type =mtpt.teacher_type_id::varchar   where tp.teacher_employee_code in ('"+String.join("','", userList)+"')";
	
	qs=  nativeRepository.executeQueries(query);
	
	try {
		leds = mapperObj.convertValue(qs.getRowValue(), new TypeReference<List<EmployeeDetailsSearchList>>() {
		});
	}catch(Exception ex) {
		ex.printStackTrace();
	}
	
	System.out.println(leds);
	System.out.println(leds.size());
	return leds;
	
}

public Object importEmployeeFromDropbox(Map<String, Object> mObj) {
	SimpleDateFormat  formatter = new SimpleDateFormat("yyyy-MM-dd");
	try {
		String dateInString = formatter.format(new Date());
	String userroleupdate = " update public.role_user  set    business_unit_type_code = '"
			+ String.valueOf(mObj.get("allotKvCode")) + "' where user_name ='" + mObj.get("username") + "' ";
	int u = loginNativeRepository.updateQueriesString(userroleupdate);
	
	String updateUser=" update user_details set parentuser='kv_"+String.valueOf(mObj.get("allotKvCode"))+"' where username='"+mObj.get("username")+"'";
	int v = loginNativeRepository.updateQueriesString(updateUser);
	
	
	TeacherProfile tp=teacherProfileRepository.findAllByTeacherEmployeeCode(String.valueOf(mObj.get("teacherEmployeeCode"))); 
	tp.setDropBoxFlag(0);
	tp.setDropboxDate(null);
	tp.setKvCode(String.valueOf(mObj.get("allotKvCode")));
	tp.setCurrentUdiseSchCode(String.valueOf(mObj.get("allotKvCode")));
	
	teacherProfileRepository.save(tp);
	
	TeacherDropBox tdb=teacherDropBoxRepository.findAllByTeacherEmployeeCode(String.valueOf(mObj.get("teacherEmployeeCode")));
	tdb.setDropBoxFlag(2);
	tdb.setActionTakenBy(String.valueOf(mObj.get("username")));
	tdb.setExportedSchoolBy(String.valueOf(mObj.get("allotKvCode")));
	tdb.setImportDateTime(new java.sql.Date(formatter.parse(dateInString).getTime()));
	
	
	teacherDropBoxRepository.save(tdb);
	
	nativeRepository.insertQueries("insert into public.teacher_dropbox_history  (id,action_taken_by,created_by,created_date_time,drop_box_flag,exported_school_by,ipaddress,kv_code,last_promotion_position_type,teacher_dob,teacher_employee_code,teacher_gender,teacher_id,teacher_name,teaching_nonteaching,employeedropid,dropbox_description,dropbox_id) \r\n"
			+ "select id,action_taken_by,created_by,created_date_time,drop_box_flag,exported_school_by,ipaddress,kv_code,last_promotion_position_type,teacher_dob,teacher_employee_code,teacher_gender,teacher_id,teacher_name,teaching_nonteaching,employeedropid,dropbox_description,dropbox_id\r\n"
			+ "from public.teacher_dropbox where teacher_employee_code ='"+String.valueOf(mObj.get("teacherEmployeeCode"))+"'");
	
	nativeRepository.updateQueries("delete from public.teacher_dropbox where teacher_employee_code='"+String.valueOf(mObj.get("teacherEmployeeCode"))+"'");
	
	return new SucessReponse(true, ManageResponseCode.RES0021.getStatusDesc(), ManageResponseCode.RES0021.getStatusDesc());
	}catch(Exception ex) {
		ex.printStackTrace();
	return new SucessReponse(true, ManageResponseCode.RES0022.getStatusDesc(), ManageResponseCode.RES0022.getStatusDesc());
	}
	
}


public Object revokeEmployeeFromDropbox(Map<String, Object> mObj) {
	try {
	TeacherDropBox tdb=teacherDropBoxRepository.findAllByTeacherEmployeeCode(String.valueOf(mObj.get("teacherEmployeeCode")));
	TeacherProfile tp=teacherProfileRepository.findAllByTeacherEmployeeCode(tdb.getTeacherEmployeeCode());
	tp.setDropBoxFlag(0);
	tp.setDropboxDate(null);
	teacherProfileRepository.save(tp);
	
	nativeRepository.insertQueries("insert into public.teacher_dropbox_history  (id,action_taken_by,created_by,created_date_time,drop_box_flag,exported_school_by,ipaddress,kv_code,last_promotion_position_type,teacher_dob,teacher_employee_code,teacher_gender,teacher_id,teacher_name,teaching_nonteaching,employeedropid,dropbox_description,dropbox_id) \r\n"
			+ "select id,action_taken_by,created_by,created_date_time,drop_box_flag,exported_school_by,ipaddress,kv_code,last_promotion_position_type,teacher_dob,teacher_employee_code,teacher_gender,teacher_id,teacher_name,teaching_nonteaching,employeedropid,dropbox_description,dropbox_id\r\n"
			+ "from public.teacher_dropbox where teacher_employee_code ='"+String.valueOf(mObj.get("teacherEmployeeCode"))+"'");
	
	nativeRepository.updateQueries("delete from public.teacher_dropbox where teacher_employee_code='"+String.valueOf(mObj.get("teacherEmployeeCode"))+"'");
	
	return new SucessReponse(true, ManageResponseCode.RES0026.getStatusDesc(), ManageResponseCode.RES0026.getStatusDesc());
	}catch(Exception ex) {
		ex.printStackTrace();
	return new SucessReponse(false, ManageResponseCode.RES0027.getStatusDesc(), ManageResponseCode.RES0027.getStatusDesc());
	}
}

	
}
