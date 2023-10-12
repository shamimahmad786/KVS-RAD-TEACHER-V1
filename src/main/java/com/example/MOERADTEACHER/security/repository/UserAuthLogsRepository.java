package com.example.MOERADTEACHER.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MOERADTEACHER.security.modal.RefreshToken;
import com.example.MOERADTEACHER.security.modal.UserAuthLogs;

public interface UserAuthLogsRepository extends JpaRepository<UserAuthLogs, Long>{

}
