package com.example.MOERADTEACHER.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MOERADTEACHER.common.modal.TeacherProfile;
import com.example.MOERADTEACHER.common.modal.TeacherProfileConfirmation;

public interface TeacherProfileConfirmationRepository extends JpaRepository<TeacherProfileConfirmation, Integer>{
	TeacherProfileConfirmation findAllByTeacherId(Integer teacherId);
	
	
}
