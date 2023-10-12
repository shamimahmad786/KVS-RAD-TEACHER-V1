package com.example.MOERADTEACHER.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MOERADTEACHER.common.uneecops.master.eo.StationEo;
import com.example.MOERADTEACHER.security.modal.UserAuthOtpHistory;

public interface UserAuthOtpHistoryRepository extends JpaRepository<UserAuthOtpHistory, Long>{

}
