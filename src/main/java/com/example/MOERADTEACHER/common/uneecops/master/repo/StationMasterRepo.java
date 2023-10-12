package com.example.MOERADTEACHER.common.uneecops.master.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.MOERADTEACHER.common.uneecops.master.eo.StationEo;
import com.example.MOERADTEACHER.common.uneecops.master.vo.StationMasterResVo;

@Repository
public interface StationMasterRepo extends JpaRepository<StationEo, Integer> {

	
	@Query(value = "SELECT new com.example.MOERADTEACHER.common.uneecops.master.vo.StationMasterResVo"
			+ "(s.id, s.stationCode, s.stationName, s.isActive) FROM StationEo s where s.isActive = :status order by s.stationName", nativeQuery = false)
	List<StationMasterResVo> findStationCodeAndStationName(@Param("status") Boolean status);

	@Query(value = "SELECT new com.example.MOERADTEACHER.common.uneecops.master.vo.StationMasterResVo"
			+ "(s.id, s.stationCode, s.stationName, s.isActive) FROM StationEo s order by s.stationCode ")
	List<StationMasterResVo> findListOfStationCodeAndStationName();

	Optional<StationEo> findById(Integer id);

	List<StationEo> findAllByStationName(String stationCode);

	StationEo findByStationCode(Integer stationCode);

	StationEo findStationNameByStationCode(Integer stationCode);

}
