package com.example.MOERADTEACHER.common.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MOERADTEACHER.common.modal.KvStationMaster;

@Repository
public interface KvStationMasterRepo extends JpaRepository<KvStationMaster, String>{

	List <KvStationMaster> findAllByRegionCode(String regionCode);
	
}
