package com.example.MOERADTEACHER.common.uneecops.master.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MOERADTEACHER.common.uneecops.master.eo.FreezMasterConfigurationEO;
import com.example.MOERADTEACHER.common.uneecops.master.service.UneecopsMasterService;
import com.example.MOERADTEACHER.common.uneecops.master.utils.UneeApiResMsgEnum;
import com.example.MOERADTEACHER.common.uneecops.master.vo.CategoryMasterVo;
import com.example.MOERADTEACHER.common.uneecops.master.vo.DesignationMasterReqVO;
import com.example.MOERADTEACHER.common.uneecops.master.vo.DesignationUpdateMasterReqVO;
import com.example.MOERADTEACHER.common.uneecops.master.vo.RegionMasterVo;
import com.example.MOERADTEACHER.common.uneecops.master.vo.SchoolMasterReqVO;
import com.example.MOERADTEACHER.common.uneecops.master.vo.SchoolMasterUpdateReqVO;
import com.example.MOERADTEACHER.common.uneecops.master.vo.StaffTypeMasterReqVO;
import com.example.MOERADTEACHER.common.uneecops.master.vo.StaffTypeUpdateMasterReqVO;
import com.example.MOERADTEACHER.common.uneecops.master.vo.StationMasterVo;
import com.example.MOERADTEACHER.common.uneecops.master.vo.SubjectMasterReqVO;
import com.example.MOERADTEACHER.common.uneecops.master.vo.SubjectMasterUpdateReqVO;
import com.example.MOERADTEACHER.common.util.CustomObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

//import com.example.MOERADTEACHER.common.uneecops.master.service.UneecopsMasterService;
//import com.example.MOERADTEACHER.common.uneecops.master.utils.UneeApiResMsgEnum;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.CategoryMasterVo;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.DesignationMasterReqVO;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.DesignationUpdateMasterReqVO;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.RegionMasterVo;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.SchoolMasterReqVO;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.SchoolMasterUpdateReqVO;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.StaffTypeMasterReqVO;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.StaffTypeUpdateMasterReqVO;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.StationMasterVo;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.SubjectMasterReqVO;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.SubjectMasterUpdateReqVO;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/unee-api/v1/master")
public class UneecopsMasterSaveController {
	@Autowired
	private UneecopsMasterService uneecopsMasterService;
	
	@Autowired
	CustomObjectMapper customObjectMapper;
	
	@PostMapping("/save-station")
	public ResponseEntity<?> saveStationMaster(@Valid @RequestBody StationMasterVo stationMasterVo){
		//log.debug("Request received in UneecopsMasterSaveController --> saveStationMaster" + stationMasterVo.toString());
		uneecopsMasterService.saveStationMaster(stationMasterVo);
		return new ResponseEntity<>(UneeApiResMsgEnum.SUCCESS,HttpStatus.OK);
	}
	
	@PostMapping("/update-station")
	public ResponseEntity<?> updateStationMaster(@Valid @RequestBody StationMasterVo stationMasterVo){
		//log.debug("Request received in UneecopsMasterSaveController --> updateStationMaster" + stationMasterVo.toString());
		uneecopsMasterService.updateStationMaster(stationMasterVo);
		return new ResponseEntity<>(UneeApiResMsgEnum.SUCCESS,HttpStatus.OK);
	}
	
	@PostMapping("/save-region")
	public ResponseEntity<?> saveRegionMaster(@Valid @RequestBody RegionMasterVo regionMasterVo){
		//log.debug("Request received in UneecopsMasterSaveController --> saveRegionMaster" + regionMasterVo.toString());	
		uneecopsMasterService.saveRegionMaster(regionMasterVo);
		return new ResponseEntity<>(UneeApiResMsgEnum.SUCCESS,HttpStatus.OK);
	}
	
	@PostMapping("/update-region")
	public ResponseEntity<?> updateRegion(@Valid @RequestBody RegionMasterVo regionMasterVo){
		//log.debug("Request received in UneecopsMasterSaveController --> updateRegionMaster" + regionMasterVo.toString());
		uneecopsMasterService.updateRegionMaster(regionMasterVo);
		return new ResponseEntity<>(UneeApiResMsgEnum.SUCCESS,HttpStatus.OK);
	}
	
	@PostMapping("/save-school")
	public ResponseEntity<?> saveSchoolInfo(@Valid @RequestBody SchoolMasterReqVO schoolMasterReqVO){
		//log.debug("Request received in UneecopsMasterSaveController --> saveSchoolInfo" + schoolMasterReqVO.toString());
		uneecopsMasterService.saveSchoolMaster(schoolMasterReqVO);
		return new ResponseEntity<>(UneeApiResMsgEnum.SUCCESS,HttpStatus.OK);
	}
	
	@PostMapping("/update-school")
	public ResponseEntity<?> updateSchoolInfo(@Valid @RequestBody SchoolMasterUpdateReqVO schoolMasterUpdateReqVO){
	//	log.debug("Request received in UneecopsMasterSaveController --> updateSchoolInfo" + schoolMasterReqVO.toString());	
		uneecopsMasterService.updateSchoolMaster(schoolMasterUpdateReqVO);
		return new ResponseEntity<>(UneeApiResMsgEnum.SUCCESS,HttpStatus.OK);
	}
	
	@PostMapping("/save-station-category")
	public ResponseEntity<?> saveStationCategoryMaster(@Valid @RequestBody CategoryMasterVo categoryMasterVo){
		//log.debug("Request received in UneecopsMasterSaveController --> saveStationCategoryMaster" + categoryMasterVo.toString());		
		uneecopsMasterService.saveStationCategoryMaster(categoryMasterVo);
		return new ResponseEntity<>( UneeApiResMsgEnum.SUCCESS,HttpStatus.OK);
	}
	
	@PostMapping("/update-station-category")
	public ResponseEntity<?> updateStationCategory(@Valid @RequestBody CategoryMasterVo categoryMasterVo){
		//log.debug("Request received in UneecopsMasterSaveController --> updateStationCategory" + categoryMasterVo.toString());			
		uneecopsMasterService.updateStationCategoryMaster(categoryMasterVo);
		return new ResponseEntity<>( UneeApiResMsgEnum.SUCCESS,HttpStatus.OK);
	}
	
	@PostMapping("/save-staff-type")
	public ResponseEntity<?> saveStaffTypeMaster(@Valid @RequestBody StaffTypeMasterReqVO staffTypeMasterReqVO){
		//log.debug("Request received in UneecopsMasterSaveController --> saveStaffTypeMaster" + staffTypeMasterReqVO.toString());			
		uneecopsMasterService.saveStaffTypeMaster(staffTypeMasterReqVO);
		return new ResponseEntity<>(UneeApiResMsgEnum.SUCCESS,HttpStatus.OK);
	}

	@PostMapping("/update-staff-type")
	public ResponseEntity<?> updateStaffType(@Valid @RequestBody StaffTypeUpdateMasterReqVO staffTypeUpdateReqVO){
	//	log.debug("Request received in UneecopsMasterSaveController --> updateStaffType" + staffTypeUpdateReqVO.toString());			
		uneecopsMasterService.updateStaffTypeMaster(staffTypeUpdateReqVO);
		return new ResponseEntity<>(UneeApiResMsgEnum.SUCCESS,HttpStatus.OK);
	}
	
	@PostMapping("/save-designation")
	public ResponseEntity<?> saveDesignationMaster(@Valid @RequestBody DesignationMasterReqVO designationMasterReqVO){
	//	log.debug("Request received in UneecopsMasterSaveController --> saveDesignationMaster" + designationMasterReqVO.toString());				
		uneecopsMasterService.saveDesignationMaster(designationMasterReqVO);
		return new ResponseEntity<>(UneeApiResMsgEnum.SUCCESS,HttpStatus.OK);
	}
	
	@PostMapping("/update-designation")
	public ResponseEntity<?> updateDesignationMaster(@Valid @RequestBody DesignationUpdateMasterReqVO designationUpdateReqVO){
	//	log.debug("Request received in UneecopsMasterSaveController --> updateDesignationMaster" + designationUpdateReqVO.toString());				
		uneecopsMasterService.updateDesignationMaster(designationUpdateReqVO);
		return new ResponseEntity<>(UneeApiResMsgEnum.SUCCESS,HttpStatus.OK);
	}
	
	@PostMapping("/save-subject")
	public ResponseEntity<?> saveSubjectMaster(@Valid @RequestBody SubjectMasterReqVO subjectMasterReqVO){
	//	log.debug("Request received in UneecopsMasterSaveController --> saveSubjectMaster" + subjectMasterReqVO.toString());				
		uneecopsMasterService.saveSubjectMaster(subjectMasterReqVO);
		return new ResponseEntity<>(UneeApiResMsgEnum.SUCCESS,HttpStatus.OK);
	}
	
	@PostMapping("/update-subject")
	public ResponseEntity<?> updateSubjectMaster(@Valid @RequestBody SubjectMasterUpdateReqVO subUpdateReqVO){
	//	log.debug("Request received in UneecopsMasterSaveController --> updateSubjectMaster" + subUpdateReqVO.toString());				
		uneecopsMasterService.updateSubjectMaster(subUpdateReqVO);
		return new ResponseEntity<>(UneeApiResMsgEnum.SUCCESS,HttpStatus.OK);
	}
	
	@PostMapping("/freeze-master")
	public ResponseEntity<?> freezeMaster(@Valid @RequestBody String data){
		
		FreezMasterConfigurationEO mObj=null;
		try {
			ObjectMapper mapperObj = new ObjectMapper();
			try {
				mObj = mapperObj.readValue(data, new TypeReference<FreezMasterConfigurationEO>() {
				});
			} catch (Exception ex) {
			ex.printStackTrace();
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return new ResponseEntity<>(uneecopsMasterService.freezeMaster(mObj),HttpStatus.OK);
	}
	
	
	

	
	
	
	
	
	
	
}