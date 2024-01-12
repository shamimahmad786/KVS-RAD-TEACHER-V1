package com.example.MOERADTEACHER.common.transferrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MOERADTEACHER.common.transfermodel.TransferQuery;
import com.example.MOERADTEACHER.common.transfermodel.TransferTempoaryData;

public interface TransferTempoaryDataRepository extends JpaRepository<TransferTempoaryData, Long>{

}
