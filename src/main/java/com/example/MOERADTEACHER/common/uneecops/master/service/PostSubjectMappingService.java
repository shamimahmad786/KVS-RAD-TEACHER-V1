package com.example.MOERADTEACHER.common.uneecops.master.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.MOERADTEACHER.common.uneecops.master.vo.PostSubjectMappingReqVo;
import com.example.MOERADTEACHER.common.uneecops.master.vo.PostSubjectMappingSearchListReqVO;
import com.example.MOERADTEACHER.common.uneecops.master.vo.PostSubjectMappingSearchResponseVO;

//import com.example.MOERADTEACHER.common.uneecops.master.vo.PostSubjectMappingReqVo;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.PostSubjectMappingSearchListReqVO;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.PostSubjectMappingSearchResponseVO;

public interface PostSubjectMappingService {
	

	public void savePostSubjectMapping(PostSubjectMappingReqVo postSubjectMappingReqVo);

	public Page<PostSubjectMappingSearchResponseVO> fetchPostSubjectMappingList(PostSubjectMappingSearchListReqVO postSubjectMappingSearchListReqVO, Pageable pageable) throws Exception;
	public Page<PostSubjectMappingSearchResponseVO> fetchPostSubjectMappingListWithStaffDetails(PostSubjectMappingSearchListReqVO postSubjectMappingSearchListReqVO, Pageable pageable) throws Exception;

}
