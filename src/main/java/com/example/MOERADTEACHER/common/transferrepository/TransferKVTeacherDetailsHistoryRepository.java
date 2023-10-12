package com.example.MOERADTEACHER.common.transferrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MOERADTEACHER.common.transfermodel.TransferKVTeacherDetails;
import com.example.MOERADTEACHER.common.transfermodel.TransferKVTeacherDetailsHistory;

public interface TransferKVTeacherDetailsHistoryRepository extends JpaRepository<TransferKVTeacherDetailsHistory, Integer>{

}
