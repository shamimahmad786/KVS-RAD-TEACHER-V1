package com.example.MOERADTEACHER.common.dropboxrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MOERADTEACHER.common.dropboxmodal.TeacherDropBox;
import com.example.MOERADTEACHER.common.masterbean.RegionMaster;

public interface TeacherDropBoxRepository extends JpaRepository<TeacherDropBox, Integer> {
List<TeacherDropBox>  findAllByKvCode(String kvCode);
TeacherDropBox  findAllByTeacherEmployeeCode(String teacherEmployeeCode);
}
