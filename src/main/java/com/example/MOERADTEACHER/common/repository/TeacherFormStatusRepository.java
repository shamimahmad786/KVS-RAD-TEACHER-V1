package com.example.MOERADTEACHER.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MOERADTEACHER.common.modal.TeacherExperience;
import com.example.MOERADTEACHER.common.modal.TeacherFormStatus;

public interface TeacherFormStatusRepository  extends JpaRepository<TeacherFormStatus, Integer>{
TeacherFormStatus findAllByTeacherId(Integer teacherId);

}
