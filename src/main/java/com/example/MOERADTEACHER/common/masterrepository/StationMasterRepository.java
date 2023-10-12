package com.example.MOERADTEACHER.common.masterrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import com.example.MOERADTEACHER.masterbean.RegionMaster;
import com.example.MOERADTEACHER.common.masterbean.StationMaster;


public interface StationMasterRepository  extends JpaRepository<StationMaster, Integer>{
List<StationMaster> findByRegionCodeOrderByStationNameAsc(String resionCode);
}
