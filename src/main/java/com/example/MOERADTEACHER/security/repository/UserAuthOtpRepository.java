package com.example.MOERADTEACHER.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MOERADTEACHER.security.modal.UserAuthOtp;
import com.example.MOERADTEACHER.security.modal.UserAuthOtpHistory;

public interface UserAuthOtpRepository  extends JpaRepository<UserAuthOtp, Long> {
	UserAuthOtp findByMobileAndOtp(String mobile,Integer otp);
}
