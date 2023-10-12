package com.example.MOERADTEACHER.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MOERADTEACHER.common.modal.TeacherTransferGround;
import com.example.MOERADTEACHER.common.modal.TeacherTransferProfile;

public interface TeacherTransferProfileRepository extends JpaRepository<TeacherTransferProfile, Integer>{
	TeacherTransferProfile  findByTeacherId(Integer teacherId);
}
