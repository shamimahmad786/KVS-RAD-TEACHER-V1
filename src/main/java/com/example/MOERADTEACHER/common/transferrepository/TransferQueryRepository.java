package com.example.MOERADTEACHER.common.transferrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MOERADTEACHER.common.transfermodel.TransferKVTeacherDetails;
import com.example.MOERADTEACHER.common.transfermodel.TransferQuery;

public interface TransferQueryRepository extends JpaRepository<TransferQuery, Long>{
List<TransferQuery>  findAllByTeacherEmployeeCode(String teacherEmployeeCode);
}
