package com.example.MOERADTEACHER.common.uneecops.master.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.MOERADTEACHER.common.uneecops.master.vo.PostSubjectMappingSearchListReqVO;
import com.example.MOERADTEACHER.common.uneecops.master.vo.PostSubjectMappingSearchResponseVO;

public interface PostSubjectMappingRepo {
	Page<PostSubjectMappingSearchResponseVO> searchPostSubjectMappingList(
			PostSubjectMappingSearchListReqVO reqVO, Pageable pageable) throws Exception;
	Page<PostSubjectMappingSearchResponseVO> fetchPostSubjectMappingListWithStaffDetails(
			PostSubjectMappingSearchListReqVO reqVO, Pageable pageable) throws Exception;

}
