package com.example.MOERADTEACHER.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MOERADTEACHER.common.modal.TeacherTransferProfile;
import com.example.MOERADTEACHER.common.modal.UserActivityLogs;
import com.example.MOERADTEACHER.security.modal.UserAuthLogs;

public interface UserActivityLogsRepository extends JpaRepository<UserActivityLogs, Integer>{

}
