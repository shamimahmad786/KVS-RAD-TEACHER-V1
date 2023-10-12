package com.example.MOERADTEACHER.common.uneecops.master.service;

import javax.validation.Valid;

import com.example.MOERADTEACHER.common.uneecops.master.vo.RegionStationsMappingReqVo;
import com.example.MOERADTEACHER.common.uneecops.master.vo.SchoolStationMappingReqVo;
import com.example.MOERADTEACHER.common.uneecops.master.vo.StaffTypePostMappingReqVO;
import com.example.MOERADTEACHER.common.uneecops.master.vo.StationCategoryMappingReqVO;

//import com.example.MOERADTEACHER.common.uneecops.master.vo.RegionStationsMappingReqVo;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.SchoolStationMappingReqVo;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.StaffTypePostMappingReqVO;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.StationCategoryMappingReqVO;

public interface UneecopsMasterMappingService {
	

	public void saveRegionStationsMapping(RegionStationsMappingReqVo regionStationsMappingReqVo);
	
	
	public void saveStationCategoryMapping(StationCategoryMappingReqVO stationCategoryMappingReqVO);
	
	
	public void saveStationSchoolsMapping(SchoolStationMappingReqVo schoolStationMappingReqVo);


	public void saveStaffTypePostMapping(@Valid StaffTypePostMappingReqVO reqVo);



}
