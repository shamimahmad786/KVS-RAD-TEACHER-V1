package com.example.MOERADTEACHER.common.uneecops.master.repo;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.MOERADTEACHER.common.uneecops.master.eo.RegionEo;
import com.example.MOERADTEACHER.common.uneecops.master.eo.SchoolMasterEO;
import com.example.MOERADTEACHER.common.uneecops.master.eo.StationEo;
import com.example.MOERADTEACHER.common.uneecops.master.vo.RegionMasterResVo;

@Repository
public interface RegionMasterRepo extends JpaRepository<RegionEo, Integer> {

	@Query(value = "SELECT new com.example.MOERADTEACHER.common.uneecops.master.vo.RegionMasterResVo"
			+ "(r.id, r.regionCode, r.regionName,r.regionAddress, r.isActive,r.regionType) from RegionEo r where r.isActive = :status order by r.regionName", nativeQuery = false)
	List<RegionMasterResVo> findRegionCodeAndRegionName(@Param("status") Boolean status);

	@Query(value = "SELECT new com.example.MOERADTEACHER.common.uneecops.master.vo.RegionMasterResVo"
			+ "(r.id, r.regionCode, r.regionName,r.regionAddress, r.isActive,r.regionType) from RegionEo r where r.regionType=3  order by r.regionType desc, r.isActive,r.regionCode")
	List<RegionMasterResVo> findListOfRegionCodeAndRegionName();

	
	Optional<RegionEo> findById(Integer id);

	List<RegionEo> findAllByRegionName(String regionName);

	RegionEo findRegionNameByRegionCode(int regionCode);

	RegionEo findByRegionCode(Integer regionCode);


	

}
