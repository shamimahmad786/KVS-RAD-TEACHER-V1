package com.example.MOERADTEACHER.common.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.MOERADTEACHER.common.bean.KvsControllerOffice;
import com.example.MOERADTEACHER.common.bean.TransferSpouseBean;
import com.example.MOERADTEACHER.common.modal.Master;
import com.example.MOERADTEACHER.common.modal.TeacherProfile;
import com.example.MOERADTEACHER.common.util.QueryResult;

public interface TeacherProfileRepository  extends JpaRepository<TeacherProfile, Integer>{
List<TeacherProfile> findAllByCurrentUdiseSchCode(String udisecode);
List<TeacherProfile> findAllByTeacherMobile(String mobile);
TeacherProfile findAllByTeacherId(Integer teacherId);
TeacherProfile findAllByTeacherAccountId(String accountId);
List<TeacherProfile> findAllByCurrentUdiseSchCodeOrderByTeacherNameAsc(String udisecode);
@Query(value = "SELECT tp.teacher_id,tp.work_experience_position_type_present_kv,kvs.station_name,kvs.station_code FROM teacher_profile tp, kv.kv_school_master kvs where tp.teacher_employee_code=? and tp.current_udise_sch_code=kvs.udise_sch_code", nativeQuery = true)
Map<String,Object> getSpouseByEmpCode(String empCode);
//@Query(value = "select tp.teacher_id,tp.teacher_name,tp.teacher_mobile,tp.teacher_email,tp.teacher_dob ,tfs.final_status ,k.kv_name,k.station_name from public.teacher_profile tp,public.teacher_form_status tfs,kv.kv_school_master k where tp.teacher_id=tfs.teacher_id and tp.current_udise_sch_code =k.udise_sch_code  and tp.teacher_employee_code= :teacherEmployeeCode", nativeQuery = true)
//QueryResult  getTeacherEmployeeCode(String teacherEmployeeCode);

List<TeacherProfile> findByCurrentUdiseSchCodeAndDropBoxFlag(String udisecode,Integer dropBoxid);
List<TeacherProfile> findByDropBoxFlag(Integer dropBoxid);
TeacherProfile findAllByTeacherEmployeeCode(String teacherEmployeeCode);


@Query(value = " from TeacherProfile tp where tp.kvCode =:kvCode ")
List<TeacherProfile> getTeacherByKvCode(@Param("kvCode") String kvCode);

}
