package com.example.MOERADTEACHER.common.uneecops.master.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.MOERADTEACHER.common.uneecops.master.vo.RegionStationMappingSearchListReqVO;
import com.example.MOERADTEACHER.common.uneecops.master.vo.RegionStationMappingSearchResponseVO;
import com.example.MOERADTEACHER.common.uneecops.master.vo.SchoolStationMappingSearchReqVO;
import com.example.MOERADTEACHER.common.uneecops.master.vo.SchoolStationMappingSearchResVO;
import com.example.MOERADTEACHER.common.uneecops.master.vo.StaffTypePostMappingResVO;
import com.example.MOERADTEACHER.common.uneecops.master.vo.StaffTypePostMappingSearchReqVO;
import com.example.MOERADTEACHER.common.uneecops.master.vo.StationCategoryMappingSearchReqVO;
import com.example.MOERADTEACHER.common.uneecops.master.vo.StationCategoryMappingSearchResVO;

public interface MappingRepository {

	Page<RegionStationMappingSearchResponseVO> searchRegionStationMappingList(
			RegionStationMappingSearchListReqVO reqVO, Pageable pageable) throws Exception;

	Page<StationCategoryMappingSearchResVO> searchStationCategoryMappingList(StationCategoryMappingSearchReqVO reqVO,
			Pageable pageable) throws Exception;

	Page<SchoolStationMappingSearchResVO> searchSchoolStationMappingList(SchoolStationMappingSearchReqVO reqVO,
			Pageable pageable);

	Page<StaffTypePostMappingResVO> searchStaffTypePostMappingList(StaffTypePostMappingSearchReqVO reqVO,
			Pageable pageable);

}
