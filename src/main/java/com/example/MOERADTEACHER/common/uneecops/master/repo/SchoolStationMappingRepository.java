package com.example.MOERADTEACHER.common.uneecops.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MOERADTEACHER.common.uneecops.master.eo.RegionStationMappingEo;
import com.example.MOERADTEACHER.common.uneecops.master.eo.SchoolStationMappingEo;

@Repository
public interface SchoolStationMappingRepository extends JpaRepository<SchoolStationMappingEo, Integer> {
	List<SchoolStationMappingEo> findBySchoolCode(Integer schoolCode);

}
