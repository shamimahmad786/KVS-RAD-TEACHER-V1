package com.example.MOERADTEACHER.common.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.MOERADTEACHER.common.modal.TeacherExperience;
import com.example.MOERADTEACHER.common.modal.TeacherProfile;

@Repository
public interface TeacherExperienceRepository extends JpaRepository<TeacherExperience, Integer>{
List<TeacherExperience> findByTeacherIdOrderByWorkStartDateDesc(Integer teacherId);

//@Query(value = "SELECT tp.teacher_id,tp.work_experience_position_type_present_kv,kvs.station_name,kvs.station_code FROM teacher_profile tp, kv.kv_school_master kvs where tp.teacher_employee_code=? and tp.current_udise_sch_code=kvs.udise_sch_code", nativeQuery = true)

//@Query(value ="select work_start_date from teacher_work_experience where teacher_id =? and (work_end_date is null ) order by work_start_date desc limit 1", nativeQuery = true)
@Query(value="from TeacherExperience u where u.teacherId = ?1")
TeacherExperience  findWorkStartDate(Integer teacherId);
List<TeacherExperience>  findAllByTeacherIdOrderByWorkStartDateDescWorkEndDateDesc(Integer teacherId);

}
