package com.example.MOERADTEACHER.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MOERADTEACHER.common.modal.Master;
import com.example.MOERADTEACHER.common.modal.TeacherAuditTray;

public interface TeacherAuditTrayRepository extends JpaRepository<TeacherAuditTray, Integer>{

}
