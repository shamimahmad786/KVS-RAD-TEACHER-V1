package com.example.MOERADTEACHER.common.uneecops.master.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MOERADTEACHER.common.uneecops.master.eo.FreezMasterConfigurationEO;
import com.example.MOERADTEACHER.common.uneecops.master.service.UneecopsMasterFetchService;
import com.example.MOERADTEACHER.common.uneecops.master.vo.ActiveOrInactiveReqVO;
import com.example.MOERADTEACHER.common.uneecops.master.vo.RegionStationMappingSearchListReqVO;
import com.example.MOERADTEACHER.common.uneecops.master.vo.RegionStationMappingSearchResponseVO;
import com.example.MOERADTEACHER.common.uneecops.master.vo.SchoolStationMappingSearchReqVO;
import com.example.MOERADTEACHER.common.uneecops.master.vo.StaffTypePostMappingResVO;
import com.example.MOERADTEACHER.common.uneecops.master.vo.StaffTypePostMappingSearchReqVO;
import com.example.MOERADTEACHER.common.uneecops.master.vo.StationCategoryMappingSearchReqVO;
import com.example.MOERADTEACHER.common.uneecops.master.vo.StationMasterResVo;
import com.example.MOERADTEACHER.common.util.CustomObjectMapper;
import com.example.MOERADTEACHER.common.util.QueryResult;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

//import com.example.MOERADTEACHER.common.uneecops.master.service.UneecopsMasterFetchService;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.ActiveOrInactiveReqVO;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.RegionStationMappingSearchListReqVO;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.SchoolStationMappingSearchReqVO;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.StaffTypePostMappingSearchReqVO;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.StationCategoryMappingSearchReqVO;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.StationMasterResVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/unee-api/v1/master/fetch")
public class UneecopsMasterFetchController {

	@Autowired
	UneecopsMasterFetchService uneecopsMasterFetchService;
	
	@Autowired
	CustomObjectMapper  customObjectMapper;

	@PostMapping("/active-or-inactive-stations-list")
	public ResponseEntity<?> findListOfActiveInactiveStation(@RequestBody @Valid ActiveOrInactiveReqVO reqVO,
			Pageable pageable) {
		//log.debug("Request received in UneecopsMasterFetchController --> findListOfActiveInactiveStation()"	+ reqVO.toString());
		List<StationMasterResVo> list = uneecopsMasterFetchService.fetchListOfActiveInactiveStation(reqVO);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@PostMapping("/active-or-inactive-region-list")
	public ResponseEntity<?> fetchListOfActiveInactiveRegion(@RequestBody @Valid ActiveOrInactiveReqVO reqVO) {
		//log.debug("Request received in UneecopsMasterFetchController --> fetchListOfActiveInactiveRegion()"				+ reqVO.toString());
		return new ResponseEntity<>(uneecopsMasterFetchService.findListOfActiveInactiveRegion(reqVO), HttpStatus.OK);
	}

	@PostMapping("/active-or-inactive-category-list")
	public ResponseEntity<?> fetchListOfActiveInactiveCategory(@RequestBody @Valid ActiveOrInactiveReqVO reqVO) {
		//log.debug("Request received in UneecopsMasterFetchController --> fetchListOfActiveInactiveCategory()"				+ reqVO.toString());
		return new ResponseEntity<>(uneecopsMasterFetchService.findListOfActiveInactiveCategory(reqVO), HttpStatus.OK);
	}

	@PostMapping("/active-or-inactive-school-list")
	public ResponseEntity<?> fetchListOfActiveInactiveSchools(@RequestBody ActiveOrInactiveReqVO reqVO) {
		//log.debug("Request received in UneecopsMasterFetchController --> fetchListOfActiveInactiveSchools()"				+ reqVO.toString());
		return new ResponseEntity<>(uneecopsMasterFetchService.findListOfActiveInactiveSchools(reqVO), HttpStatus.OK);
	}
	

	@PostMapping("/active-or-inactive-designation-list")
	public ResponseEntity<?> fetchListOfActiveInactiveDesignation(@RequestBody ActiveOrInactiveReqVO reqVO) {
		//log.debug("Request received in UneecopsMasterFetchController --> fetchListOfActiveInactiveDesignation()"				+ reqVO.toString());
		return new ResponseEntity<>(uneecopsMasterFetchService.findListOfActiveInactiveDesignations(reqVO), HttpStatus.OK);
	}
	
	@PostMapping("/active-or-inactive-staff-type-list")
	public ResponseEntity<?> fetchListOfActiveInactiveStaffType(@RequestBody ActiveOrInactiveReqVO reqVO) {
		//log.debug("Request received in UneecopsMasterFetchController --> fetchListOfActiveInactiveStaffType()"				+ reqVO.toString());
		return new ResponseEntity<>(uneecopsMasterFetchService.findListOfActiveInactiveStaffType(reqVO), HttpStatus.OK);
	}
	
	@PostMapping("/active-or-inactive-subject-list")
	public ResponseEntity<?> fetchListOfActiveInactiveSubject(@RequestBody ActiveOrInactiveReqVO reqVO) {
		//log.debug("Request received in UneecopsMasterFetchController --> fetchListOfActiveInactiveStaffType()"				+ reqVO.toString());
		return new ResponseEntity<>(uneecopsMasterFetchService.findListOfActiveInactiveSubject(reqVO), HttpStatus.OK);
	}

	@PostMapping("/list-of-all-station")
	public ResponseEntity<?> findListOfAllStations() {
		//log.debug("Request received in UneecopsMasterFetchController --> findListOfAllStations()");
		return new ResponseEntity<>(uneecopsMasterFetchService.fetchListOfAllStation(), HttpStatus.OK);
	}
	
	@PostMapping("/list-of-unmaped-station")
	public ResponseEntity<?> findListOfAllUnmapedStations() {
		//log.debug("Request received in UneecopsMasterFetchController --> findListOfAllStations()");
		return new ResponseEntity<>(uneecopsMasterFetchService.findListOfAllUnmapedStations(), HttpStatus.OK);
	}
	

	@PostMapping("/list-of-all-region")
	public ResponseEntity<?> findListOfAllRegion() {
		System.out.println("List of All Region");
		//log.debug("Request received in UneecopsMasterFetchController --> findListOfAllRegion()");
		return new ResponseEntity<>(uneecopsMasterFetchService.fetchListOfAllRegion(), HttpStatus.OK);
	}

	@PostMapping("/list-of-all-category")
	public ResponseEntity<?> findListOfAllCategory() {
		//log.debug("Request received in UneecopsMasterFetchController --> findListOfAllCategory()");
		return new ResponseEntity<>(uneecopsMasterFetchService.fetchListOfAllCategory(), HttpStatus.OK);
	}
	
	
	@PostMapping("/list-of-all-station-by-region")
	public ResponseEntity<?> fetchStationListByRegion(@RequestBody RegionStationMappingSearchResponseVO reqVO) {
		System.out.println("called--->"+reqVO.getRegionCode());
		//log.debug("Request received in fetchStationListByRegion");
		return new ResponseEntity<>(uneecopsMasterFetchService.fetchStationListByRegion(reqVO), HttpStatus.OK);
	}
	
	
	

	@PostMapping("/list-of-all-school")
	public ResponseEntity<?> findListOfAllSchools() {
		//log.debug("Request received in UneecopsMasterFetchController --> findListOfAllSchools()");
		return new ResponseEntity<>(uneecopsMasterFetchService.fetchListOfAllSchools(), HttpStatus.OK);
	}
	
	@PostMapping("/list-of-all-unmapped-school")
	public ResponseEntity<?> findListOfAllUnmappedSchools() {
		//log.debug("Request received in UneecopsMasterFetchController --> findListOfAllSchools()");
		return new ResponseEntity<>(uneecopsMasterFetchService.findListOfAllUnmappedSchools(), HttpStatus.OK);
	}
	

	@PostMapping("/list-of-all-staff-type")
	public ResponseEntity<?> findListOfAllStaffTypes() {
	//	log.debug("Request received in UneecopsMasterFetchController --> findListOfAllStaffTypes()");
		return new ResponseEntity<>(uneecopsMasterFetchService.fetchListOfAllStaffType(), HttpStatus.OK);
	}

	@PostMapping("/list-of-designations")
	public ResponseEntity<?> findListOfAllDesignations() {
	//	log.debug("Request received in UneecopsMasterFetchController --> findListOfAllDesignations()");
		return new ResponseEntity<>(uneecopsMasterFetchService.fetchListOfDesignations(), HttpStatus.OK);
	}

	@PostMapping("/list-of-subjects")
	public ResponseEntity<?> findListOfAllSubjects() {
	//	log.debug("Request received in UneecopsMasterFetchController --> findListOfAllSubjects()");
		return new ResponseEntity<>(uneecopsMasterFetchService.fetchListOfSubjects(), HttpStatus.OK);
	}

	@PostMapping("/region-station-mapping-list")
	public ResponseEntity<?> fetchRegionStationMappingList(@RequestBody RegionStationMappingSearchListReqVO reqVO,
			Pageable pageable) throws Exception {
	//	log.debug("Request received in UneecopsMasterFetchController --> fetchRegionStationMappingList()"				+ reqVO.toString());
		return new ResponseEntity<>(uneecopsMasterFetchService.findRegionStationMappingList(reqVO, pageable), HttpStatus.OK);
	}

	@PostMapping("/station-category-mapping-list")
	public ResponseEntity<?> fetchStationCategoryMappingList(@RequestBody StationCategoryMappingSearchReqVO reqVO,
			Pageable pageable) throws Exception {
	//	log.debug("Request received in UneecopsMasterFetchController --> fetchStationCategoryMappingList()"				+ reqVO.toString());
		return new ResponseEntity<>(uneecopsMasterFetchService.findStationCategoryMappingList(reqVO, pageable), HttpStatus.OK);
	}
	
	
	@PostMapping("/all-station-category-mapping-list")
	public ResponseEntity<?> fetchAllStationCategoryMappingList() throws Exception {
	//	log.debug("Request received in UneecopsMasterFetchController --> fetchStationCategoryMappingList()"				+ reqVO.toString());
		return new ResponseEntity<>(uneecopsMasterFetchService.findAllStationCategoryMappingList(), HttpStatus.OK);
	}
	
	@PostMapping("/station-category-mapping-list-by-station-code")
	public ResponseEntity<?> fetchAllStationCategoryMappingListByStationCode(@RequestBody String  data) throws Exception {
	//	log.debug("Request received in UneecopsMasterFetchController --> fetchStationCategoryMappingList()"				+ reqVO.toString());
		
		ObjectMapper mapperObj = new ObjectMapper();
		StationCategoryMappingSearchReqVO mp = new StationCategoryMappingSearchReqVO();
		Boolean checkOtp = null;
		try {
			mp = mapperObj.readValue(data, new TypeReference<StationCategoryMappingSearchReqVO>() {
			});
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return new ResponseEntity<>(uneecopsMasterFetchService.findStationCategoryMappingListByStationCode(mp), HttpStatus.OK);
	}
	
	

	@PostMapping("/school-sation-mapping-list")
	public ResponseEntity<?> fetchSchoolStationMappingList(@RequestBody SchoolStationMappingSearchReqVO reqVO,
			Pageable pageable) throws Exception {
	//	log.debug("Request received in UneecopsMasterFetchController --> fetchSchoolStationMappingList()"				+ reqVO.toString());
		return new ResponseEntity<>(uneecopsMasterFetchService.findSchoolStationMappingList(reqVO, pageable), HttpStatus.OK);
	}
	
	@PostMapping("/staff-type-post-mapping-list")
	public ResponseEntity<?> fetchStaffTypePostMappingList(@RequestBody StaffTypePostMappingSearchReqVO reqVO,
			Pageable pageable) throws Exception {
		//log.debug("Request received in UneecopsMasterFetchController --> fetchStaffTypePostMappingList()"				+ reqVO.toString());
		return new ResponseEntity<>(uneecopsMasterFetchService.findStaffTypePostMappingList(reqVO, pageable), HttpStatus.OK);
	}
	
	@PostMapping("/get-region-station-school")
	public ResponseEntity<?> fetchRegionStationSchool() throws Exception {
		return new ResponseEntity<>(uneecopsMasterFetchService.fetchRegionStationSchool(), HttpStatus.OK);
	}
	
	
	@PostMapping("/get-station-category-by-region")
	public ResponseEntity<QueryResult> getStationCategoryByRegion(@RequestBody String data) {
		System.out.println(data);
		Map<String,Object> reqObj=customObjectMapper.getMapObject(data);
		return new ResponseEntity<>(uneecopsMasterFetchService.getStationCategoryByRegion(reqObj), HttpStatus.OK);
	}
	
	@PostMapping("/get-freeze-master")
	public ResponseEntity<List<FreezMasterConfigurationEO>> getFreezeMaster(){	
		return new ResponseEntity<>(uneecopsMasterFetchService.getFreezeMaster(),HttpStatus.OK);
	}

	
	@PostMapping("/get-freeze-master-by-id")
	public ResponseEntity<Map<String,Object>> getFreezeMasterById(@RequestBody String data){	
		return new ResponseEntity<>(uneecopsMasterFetchService.getFreezeMasterById(Integer.parseInt(data)),HttpStatus.OK);
	}
	
	@PostMapping("/school-region-mapping-list")
	public ResponseEntity<?> fetchSchoolRegionMappingList(@RequestBody String data,
			Pageable pageable) throws Exception {
		Map<String,Object> reqObj=customObjectMapper.getMapObject(data);
		return new ResponseEntity<>(uneecopsMasterFetchService.fetchSchoolRegionMappingList(reqObj), HttpStatus.OK);
	}
	
	
	@PostMapping("/get-all-school-station-list")
	public ResponseEntity<?> fetchAllSchoolRegionMappingList() throws Exception {
		return new ResponseEntity<>(uneecopsMasterFetchService.fetchAllSchoolRegionMappingList(), HttpStatus.OK);
	}
	
	
	@PostMapping("/get-all-school-station-list-by-region")
	public ResponseEntity<?> fetchAllSchoolStationListByRegion(@RequestBody String data) throws Exception {
		Map<String,Object> reqObj=customObjectMapper.getMapObject(data);
		return new ResponseEntity<>(uneecopsMasterFetchService.fetchAllSchoolStationListByRegion(reqObj), HttpStatus.OK);
	}
	
	@PostMapping("/get-school-station-histor")
	public ResponseEntity<?> fetchSchoolStationHistory(@RequestBody String data) throws Exception {
		Map<String,Object> reqObj=customObjectMapper.getMapObject(data);
		return new ResponseEntity<>(uneecopsMasterFetchService.fetchSchoolStationHistory(reqObj), HttpStatus.OK);
	}
	
	
}
