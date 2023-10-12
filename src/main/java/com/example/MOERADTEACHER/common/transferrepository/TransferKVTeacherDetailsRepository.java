package com.example.MOERADTEACHER.common.transferrepository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.MOERADTEACHER.common.modal.KVTeacher;
import com.example.MOERADTEACHER.common.transfermodel.TransferKVTeacherDetails;

public interface TransferKVTeacherDetailsRepository extends JpaRepository<TransferKVTeacherDetails, Integer>{
	TransferKVTeacherDetails	findAllByTeacherId(Integer teacherId);
	void deleteByTeacherId(String teacherId);
	
//@Query(value = "SELECT tp.teacher_id,tp.work_experience_position_type_present_kv,kvs.station_name,kvs.station_code FROM teacher_profile tp, kv.kv_school_master kvs where tp.teacher_employee_code=? and tp.current_udise_sch_code=kvs.udise_sch_code", nativeQuery = true)
@Query(value = "select teacher_id,transfer_application_number,teacher_name,teacher_gender,teacher_dob,teacher_employee_code,teacher_mobile,teacher_email,transfer_status from transfer.transfer_kvteacher_detail where current_udise_sch_code=? ", nativeQuery = true)
List<Map<String,Object>> getInitiatedTransferByUdisecode(String current_udise_sch_code);
	
	
	
}
