package com.example.MOERADTEACHER.common.uneecops.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MOERADTEACHER.common.uneecops.master.eo.RegionStationMappingEo;
@Repository
public interface RegionStationMappingRepository extends JpaRepository<RegionStationMappingEo, Integer> {

	List<RegionStationMappingEo> findByStationCode(Integer stationCode);
	List<RegionStationMappingEo> findByRegionCode(Integer regionCode);

}
