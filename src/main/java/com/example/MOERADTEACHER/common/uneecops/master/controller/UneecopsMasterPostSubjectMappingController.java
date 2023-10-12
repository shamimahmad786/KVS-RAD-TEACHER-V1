package com.example.MOERADTEACHER.common.uneecops.master.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MOERADTEACHER.common.uneecops.master.service.PostSubjectMappingService;
import com.example.MOERADTEACHER.common.uneecops.master.utils.UneeApiResMsgEnum;
import com.example.MOERADTEACHER.common.uneecops.master.vo.PostSubjectMappingReqVo;
import com.example.MOERADTEACHER.common.uneecops.master.vo.PostSubjectMappingSearchListReqVO;

//import com.example.MOERADTEACHER.common.uneecops.master.service.PostSubjectMappingService;
//import com.example.MOERADTEACHER.common.uneecops.master.utils.UneeApiResMsgEnum;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.PostSubjectMappingReqVo;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.PostSubjectMappingSearchListReqVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/unee-api/v1/mapping/master")
public class UneecopsMasterPostSubjectMappingController {
	@Autowired
	private PostSubjectMappingService postSubjectMappingService;

	@PostMapping("/save-post-subject")
	public ResponseEntity<?> saveStationSchoolsMapping(@Valid @RequestBody PostSubjectMappingReqVo postSubjectMappingReqVo) {
		postSubjectMappingService.savePostSubjectMapping(postSubjectMappingReqVo);
		return new ResponseEntity<>(UneeApiResMsgEnum.SUCCESS, HttpStatus.OK);
	}
	@PostMapping("/fetch-post-subject-mapping-list")
	public ResponseEntity<?> fetchPostSubjectMappingList(@RequestBody PostSubjectMappingSearchListReqVO postSubjectMappingSearchListReqVO, Pageable pageable)throws Exception{
		//log.debug("Request received in PostSubjectMappingController --> fetchPostSubjectMappingList()"+ postSubjectMappingSearchListReqVO.toString());
		return new ResponseEntity<>(postSubjectMappingService.fetchPostSubjectMappingList(postSubjectMappingSearchListReqVO, pageable),HttpStatus.OK);
	}
	@PostMapping("/fetch-post-subject-mapping-list-with-staff-details")
	public ResponseEntity<?> fetchPostSubjectMappingListWithStaffDetails(@RequestBody PostSubjectMappingSearchListReqVO postSubjectMappingSearchListReqVO, Pageable pageable)throws Exception{
	//	log.debug("Request received in PostSubjectMappingController --> fetchPostSubjectMappingList()"+ postSubjectMappingSearchListReqVO.toString());
		return new ResponseEntity<>(postSubjectMappingService.fetchPostSubjectMappingListWithStaffDetails(postSubjectMappingSearchListReqVO, pageable),HttpStatus.OK);
	}
	

	
	
	

}
