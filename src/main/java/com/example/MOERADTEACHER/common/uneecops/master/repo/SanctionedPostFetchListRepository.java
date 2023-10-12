package com.example.MOERADTEACHER.common.uneecops.master.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.MOERADTEACHER.common.uneecops.master.vo.SanctionedPostFechListRequestVo;
import com.example.MOERADTEACHER.common.uneecops.master.vo.SanctionedPostResponseVo;

public interface SanctionedPostFetchListRepository {
	

	
	
	Page<SanctionedPostResponseVo> fetchListOfSanctionedPostResponseVo(
			SanctionedPostFechListRequestVo sanctionedPostFechListRequestVo, Pageable pageable) throws Exception;
}
