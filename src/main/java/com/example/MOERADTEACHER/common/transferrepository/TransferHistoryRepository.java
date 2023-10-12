package com.example.MOERADTEACHER.common.transferrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MOERADTEACHER.common.transfermodel.TransferHistory;
import com.example.MOERADTEACHER.common.transfermodel.TransferKVTeacherDetailsHistory;

public interface TransferHistoryRepository extends JpaRepository<TransferHistory, Integer>{
void deleteByTeacherId(Integer teacherId);
List<TransferHistory> findAllByTeacherIdOrderByWorkStartDateDesc(Integer teacherId);
List<TransferHistory> findAllByTeacherId(Integer teacherId);
}
