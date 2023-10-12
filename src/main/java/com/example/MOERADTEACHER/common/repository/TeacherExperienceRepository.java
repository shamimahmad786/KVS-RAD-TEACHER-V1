package com.example.MOERADTEACHER.common.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MOERADTEACHER.common.modal.TeacherExperience;
import com.example.MOERADTEACHER.common.modal.TeacherProfile;

@Repository
public interface TeacherExperienceRepository extends JpaRepository<TeacherExperience, Integer>{
List<TeacherExperience> findByTeacherIdOrderByWorkStartDateDesc(Integer teacherId);
}
