package com.example.MOERADTEACHER.common.masterrepository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.MOERADTEACHER.common.masterbean.SchoolMaster;
import com.example.MOERADTEACHER.common.masterbean.StationManagementMaster;
import com.example.MOERADTEACHER.common.masterbean.StationMaster;

@Repository
@Transactional
public interface StationManagementMasterRepository extends JpaRepository<StationMaster, Integer>{
	
//	@Query()
	 @Modifying
	@Query(value = "delete from StationMaster u where u.statinCode  =:stationCode")
	void deleteByStatinCode(String stationCode);
	 
	List<StationMaster> findAllByOrderByStationNameAsc();

}
