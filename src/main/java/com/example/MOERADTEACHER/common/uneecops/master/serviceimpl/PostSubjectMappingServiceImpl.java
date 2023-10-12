package com.example.MOERADTEACHER.common.uneecops.master.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.MOERADTEACHER.common.uneecops.master.eo.PostSubjectMappingEo;
import com.example.MOERADTEACHER.common.uneecops.master.repo.PostSubjectMappingRepo;
import com.example.MOERADTEACHER.common.uneecops.master.repo.PostSubjectMappingRepository;
import com.example.MOERADTEACHER.common.uneecops.master.service.PostSubjectMappingService;
import com.example.MOERADTEACHER.common.uneecops.master.utils.UneecopsDateUtils;
import com.example.MOERADTEACHER.common.uneecops.master.vo.PostSubjectMappingReqVo;
import com.example.MOERADTEACHER.common.uneecops.master.vo.PostSubjectMappingSearchListReqVO;
import com.example.MOERADTEACHER.common.uneecops.master.vo.PostSubjectMappingSearchResponseVO;

//import com.example.MOERADTEACHER.common.uneecops.master.eo.PostSubjectMappingEo;
//import com.example.MOERADTEACHER.common.uneecops.master.repo.PostSubjectMappingRepo;
//import com.example.MOERADTEACHER.common.uneecops.master.repo.PostSubjectMappingRepository;
//import com.example.MOERADTEACHER.common.uneecops.master.service.PostSubjectMappingService;
//import com.example.MOERADTEACHER.common.uneecops.master.utils.UneecopsDateUtils;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.PostSubjectMappingReqVo;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.PostSubjectMappingSearchListReqVO;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.PostSubjectMappingSearchResponseVO;
@Service
public class PostSubjectMappingServiceImpl implements PostSubjectMappingService {
	@Autowired
	private PostSubjectMappingRepository postSubjectMappingRepository;
	@Autowired
	private PostSubjectMappingRepo postSubjectMappingRepo;
	@Override
	public void savePostSubjectMapping(PostSubjectMappingReqVo postSubjectMappingReqVo) {
		PostSubjectMappingEo postSubjectMappingEo = new PostSubjectMappingEo();
		postSubjectMappingEo.setPostId(postSubjectMappingReqVo.getPostId());
		postSubjectMappingEo.setSubjectId(postSubjectMappingReqVo.getSubjectId());
		postSubjectMappingEo.setStatus(Boolean.TRUE);
		postSubjectMappingEo.setCreatedDate(UneecopsDateUtils.getCurrentTimeStamp());
		postSubjectMappingRepository.save(postSubjectMappingEo);
	}
	@Override
	public Page<PostSubjectMappingSearchResponseVO> fetchPostSubjectMappingList(PostSubjectMappingSearchListReqVO postSubjectMappingSearchListReqVO, Pageable pageable) throws Exception {
		return postSubjectMappingRepo.searchPostSubjectMappingList(postSubjectMappingSearchListReqVO, pageable);
	}
	@Override
	public Page<PostSubjectMappingSearchResponseVO> fetchPostSubjectMappingListWithStaffDetails(
			PostSubjectMappingSearchListReqVO postSubjectMappingSearchListReqVO, Pageable pageable) throws Exception {
		return postSubjectMappingRepo.fetchPostSubjectMappingListWithStaffDetails(postSubjectMappingSearchListReqVO, pageable);
	}

}
