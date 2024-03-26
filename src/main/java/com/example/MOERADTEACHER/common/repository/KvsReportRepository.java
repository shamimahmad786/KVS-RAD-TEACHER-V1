package com.example.MOERADTEACHER.common.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MOERADTEACHER.common.modal.KvsControllerOffice;
import com.example.MOERADTEACHER.common.modal.KvsReport;

public interface KvsReportRepository extends JpaRepository<KvsReport, String>{
List<KvsReport>	findAllByStatusOrderByReportIdAsc(Integer status);

}
