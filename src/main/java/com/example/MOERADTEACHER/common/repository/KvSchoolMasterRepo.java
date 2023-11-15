package com.example.MOERADTEACHER.common.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MOERADTEACHER.common.modal.KvSchoolMaster;

@Repository
public interface KvSchoolMasterRepo extends JpaRepository<KvSchoolMaster, String>{

//	List <KvSchoolMaster> findAllByStatinCode(String statinCode);
	
	List<KvSchoolMaster>  findAllByRegionCodeAndSchoolType(String regionCode,String schoolType);
	KvSchoolMaster  findAllByKvCode(String kvCode);
	
}
