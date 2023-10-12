package com.example.MOERADTEACHER.common.masterrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MOERADTEACHER.common.masterbean.PositionType;
import com.example.MOERADTEACHER.common.masterbean.TeacherQualification;

public interface TeacherQualificationRepository extends JpaRepository<TeacherQualification, Integer>{
List<TeacherQualification> findAllByQualificationType(String qualificationType);
} 
