package com.example.MOERADTEACHER.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MOERADTEACHER.security.modal.UserAuthOtp;
import com.example.MOERADTEACHER.security.modal.UserForgetPasswordHistory;

public interface UserForgetPasswordHistoryRepository extends JpaRepository<UserForgetPasswordHistory, Long>{

}
