package com.example.MOERADTEACHER.common.masterrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MOERADTEACHER.common.masterbean.RegionMaster;
import com.example.MOERADTEACHER.common.masterbean.SchoolMaster;

public interface SchoolMasterRepository extends JpaRepository<SchoolMaster, Integer>{
List<SchoolMaster>  findAllByStationCode(String stationCode);
List<SchoolMaster> findByStationCodeOrderByKvNameAsc(String stationCode);
}
