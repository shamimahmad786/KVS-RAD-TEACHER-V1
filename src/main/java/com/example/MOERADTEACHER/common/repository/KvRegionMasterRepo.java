package com.example.MOERADTEACHER.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MOERADTEACHER.common.modal.KvRegionMaster;

@Repository
public interface KvRegionMasterRepo extends JpaRepository<KvRegionMaster, String> {
	
	
//	 KvRegionMaster fetchByRegionCode(String code);

}
