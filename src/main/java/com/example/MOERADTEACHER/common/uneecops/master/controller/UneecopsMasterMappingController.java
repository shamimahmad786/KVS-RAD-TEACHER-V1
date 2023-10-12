package com.example.MOERADTEACHER.common.uneecops.master.controller;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MOERADTEACHER.common.uneecops.master.service.UneecopsMasterMappingService;
import com.example.MOERADTEACHER.common.uneecops.master.utils.UneeApiResMsgEnum;
import com.example.MOERADTEACHER.common.uneecops.master.vo.RegionStationsMappingReqVo;
import com.example.MOERADTEACHER.common.uneecops.master.vo.SchoolStationMappingReqVo;
import com.example.MOERADTEACHER.common.uneecops.master.vo.StaffTypePostMappingReqVO;
import com.example.MOERADTEACHER.common.uneecops.master.vo.StationCategoryMappingReqVO;

//import com.example.MOERADTEACHER.common.uneecops.master.service.UneecopsMasterMappingService;
//import com.example.MOERADTEACHER.common.uneecops.master.utils.UneeApiResMsgEnum;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.RegionStationsMappingReqVo;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.SchoolStationMappingReqVo;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.StaffTypePostMappingReqVO;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.StationCategoryMappingReqVO;
import lombok.extern.slf4j.Slf4j;
@RestController
@RequestMapping("/unee-api/v1/mapping/save")
@Slf4j
public class UneecopsMasterMappingController {

	@Autowired
	private UneecopsMasterMappingService uneecopsMasterMappingService;

	// one to many
	@PostMapping("/region-stations")
	public ResponseEntity<?> saveRegionStationsMapping(
			@Valid @RequestBody RegionStationsMappingReqVo regionStationsMappingReqVo) {
	//	log.debug("Request received in UneecopsMasterMappingController --> saveRegionStationsMapping()"				+ regionStationsMappingReqVo.toString());
		uneecopsMasterMappingService.saveRegionStationsMapping(regionStationsMappingReqVo);
		return new ResponseEntity<>(UneeApiResMsgEnum.SUCCESS, HttpStatus.OK);
	}

	// one to many
	@PostMapping("/schools-station")
	public ResponseEntity<?> saveStationSchoolsMapping(@Valid @RequestBody SchoolStationMappingReqVo reqVO) {
	//	log.debug("Request received in UneecopsMasterMappingController --> saveStationSchoolsMapping()"				+ reqVO.toString());
		uneecopsMasterMappingService.saveStationSchoolsMapping(reqVO);
		return new ResponseEntity<>(UneeApiResMsgEnum.SUCCESS, HttpStatus.OK);
	}

	@PostMapping("/station-category")
	public ResponseEntity<?> saveStationCategoryMapping(
			@Valid @RequestBody StationCategoryMappingReqVO stationCategoryMappingReqVO) {
	//	log.debug("Request received in UneecopsMasterMappingController --> saveStationCategoryMapping()"				+ stationCategoryMappingReqVO.toString());
		uneecopsMasterMappingService.saveStationCategoryMapping(stationCategoryMappingReqVO);
		return new ResponseEntity<>(UneeApiResMsgEnum.SUCCESS, HttpStatus.OK);
	}
	
	@PostMapping("/staff-type-post")
	public ResponseEntity<?> saveStaffTypePostMapping(
			@Valid @RequestBody StaffTypePostMappingReqVO reqVo) {
	//	log.debug("Request received in UneecopsMasterMappingController --> saveStationCategoryMapping()"				+ reqVo.toString());
		uneecopsMasterMappingService.saveStaffTypePostMapping(reqVo);
		return new ResponseEntity<>(UneeApiResMsgEnum.SUCCESS, HttpStatus.OK);
	}

}
