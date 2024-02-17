package com.example.MOERADTEACHER.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MOERADTEACHER.security.modal.UserForgetPassword;
//import com.example.MOERADTEACHER.security.modal.UserForgetPasswordHistory;

public interface UserForgetPasswordRepository extends JpaRepository<UserForgetPassword, Long>{
	UserForgetPassword  findBySessionId(Integer sessionId);
}
