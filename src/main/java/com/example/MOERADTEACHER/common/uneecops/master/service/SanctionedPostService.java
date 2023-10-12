package com.example.MOERADTEACHER.common.uneecops.master.service;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.MOERADTEACHER.common.uneecops.master.vo.SanctionedPostFechListRequestVo;
import com.example.MOERADTEACHER.common.uneecops.master.vo.SanctionedPostListRequestVo2;
import com.example.MOERADTEACHER.common.uneecops.master.vo.SanctionedPostRequestVo;
import com.example.MOERADTEACHER.common.uneecops.master.vo.SanctionedPostResponseVo;
import com.example.MOERADTEACHER.common.uneecops.master.vo.SanctionedPostSchoolCodeCheckRequestVo;
import com.example.MOERADTEACHER.common.uneecops.master.vo.SanctionedPostSchoolCodeCheckResponeseVo;
import com.example.MOERADTEACHER.common.uneecops.master.vo.SanctionedPostUpdateListRequestVo;

//import com.example.MOERADTEACHER.common.uneecops.master.vo.SanctionedPostFechListRequestVo;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.SanctionedPostListRequestVo2;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.SanctionedPostRequestVo;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.SanctionedPostRequestVo2;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.SanctionedPostResponseVo;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.SanctionedPostSchoolCodeCheckRequestVo;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.SanctionedPostSchoolCodeCheckResponeseVo;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.SanctionedPostUpdateListRequestVo;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.SanctionedPostUpdateRequestVo;

public interface SanctionedPostService {
	
	
	public void  saveSchoolSanctionedPostDetail(SanctionedPostRequestVo sanctionedPostRequestVo);

	public Page<SanctionedPostResponseVo> fetchlistOfSchoolSanctionedPostDetail(SanctionedPostFechListRequestVo sanctionedPostFechListRequestVo, Pageable pageable) throws Exception;


	public void saveSchoolSanctionedPostDetailV2(SanctionedPostListRequestVo2 SanctionedPostListRequestVo2);

	public void updateSchoolSanctionedPostDetail(SanctionedPostUpdateListRequestVo sanctionedPostUpdateListRequestVo);

	SanctionedPostSchoolCodeCheckResponeseVo CheckSanctionedPostSchoolCodeExistOrNot(
			SanctionedPostSchoolCodeCheckRequestVo sanctionedPostSchoolCodeCheckRequestVo);
	
	public Map<String,Object> freezeSanctionPost(Map<String,Object> data);
}
