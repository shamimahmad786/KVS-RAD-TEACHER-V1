package com.example.MOERADTEACHER.common.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MOERADTEACHER.common.modal.TeacherFormStatus;
import com.example.MOERADTEACHER.common.modal.TeacherLeave;

public interface TeacherLeaveRepository extends JpaRepository<TeacherLeave, Long>{
    List<TeacherLeave>  findAllByTeacherIdOrderByStartDateDesc(Integer teacherId);
    void deleteAllByTeacherId(Integer teacherId);
}
