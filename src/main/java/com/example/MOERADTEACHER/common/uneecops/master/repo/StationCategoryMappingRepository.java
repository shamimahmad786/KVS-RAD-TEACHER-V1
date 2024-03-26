package com.example.MOERADTEACHER.common.uneecops.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MOERADTEACHER.common.uneecops.master.eo.StationCategoryMappingEO;

@Repository
public interface StationCategoryMappingRepository extends JpaRepository<StationCategoryMappingEO, Integer>{


	List<StationCategoryMappingEO> findByStationCode(Integer stationCode);
	List<StationCategoryMappingEO> findByStationCodeOrderByFromDate(Integer stationCode);

}
