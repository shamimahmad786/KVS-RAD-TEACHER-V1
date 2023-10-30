package com.example.MOERADTEACHER.common.uneecops.master.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.MOERADTEACHER.common.uneecops.master.eo.FreezMasterConfigurationEO;
import com.example.MOERADTEACHER.common.uneecops.master.eo.RegionStationMappingEo;
import com.example.MOERADTEACHER.common.uneecops.master.vo.ActiveOrInactiveReqVO;
import com.example.MOERADTEACHER.common.uneecops.master.vo.CategoryMasterResVo;
import com.example.MOERADTEACHER.common.uneecops.master.vo.DesignationMasterResVO;
import com.example.MOERADTEACHER.common.uneecops.master.vo.RegionMasterResVo;
import com.example.MOERADTEACHER.common.uneecops.master.vo.RegionStationMappingSearchListReqVO;
import com.example.MOERADTEACHER.common.uneecops.master.vo.RegionStationMappingSearchResponseVO;
import com.example.MOERADTEACHER.common.uneecops.master.vo.SchoolMasterResVO;
import com.example.MOERADTEACHER.common.uneecops.master.vo.SchoolStationMappingSearchReqVO;
import com.example.MOERADTEACHER.common.uneecops.master.vo.SchoolStationMappingSearchResVO;
import com.example.MOERADTEACHER.common.uneecops.master.vo.StaffTypeMasterResVO;
import com.example.MOERADTEACHER.common.uneecops.master.vo.StaffTypePostMappingResVO;
import com.example.MOERADTEACHER.common.uneecops.master.vo.StaffTypePostMappingSearchReqVO;
import com.example.MOERADTEACHER.common.uneecops.master.vo.StationCategoryMappingSearchReqVO;
import com.example.MOERADTEACHER.common.uneecops.master.vo.StationCategoryMappingSearchResVO;
import com.example.MOERADTEACHER.common.uneecops.master.vo.StationMasterResVo;
import com.example.MOERADTEACHER.common.uneecops.master.vo.SubjectMasterResVO;
import com.example.MOERADTEACHER.common.util.QueryResult;

//import com.example.MOERADTEACHER.common.uneecops.master.vo.ActiveOrInactiveReqVO;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.CategoryMasterResVo;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.DesignationMasterResVO;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.RegionMasterResVo;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.RegionStationMappingSearchListReqVO;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.RegionStationMappingSearchResponseVO;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.SchoolMasterResVO;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.SchoolStationMappingSearchReqVO;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.SchoolStationMappingSearchResVO;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.StaffTypeMasterResVO;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.StaffTypePostMappingResVO;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.StaffTypePostMappingSearchReqVO;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.StationCategoryMappingSearchReqVO;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.StationCategoryMappingSearchResVO;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.StationMasterResVo;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.SubjectMasterResVO;

public interface UneecopsMasterFetchService {

	public List<StationMasterResVo> fetchListOfActiveInactiveStation(ActiveOrInactiveReqVO reqVO);

	public List<RegionMasterResVo> findListOfActiveInactiveRegion(ActiveOrInactiveReqVO reqVO);

	public List<CategoryMasterResVo> findListOfActiveInactiveCategory(ActiveOrInactiveReqVO reqVO);

	public List<SchoolMasterResVO> findListOfActiveInactiveSchools(ActiveOrInactiveReqVO reqVO);
	
	public List<DesignationMasterResVO> findListOfActiveInactiveDesignations(ActiveOrInactiveReqVO reqVO);

	public List<StaffTypeMasterResVO> findListOfActiveInactiveStaffType(ActiveOrInactiveReqVO reqVO);

	public List<SubjectMasterResVO> findListOfActiveInactiveSubject(ActiveOrInactiveReqVO reqVO);

	public List<StationMasterResVo> fetchListOfAllStation();
	
	public QueryResult findListOfAllUnmapedStations();

	public List<RegionMasterResVo> fetchListOfAllRegion();

	public List<CategoryMasterResVo> fetchListOfAllCategory();

	public List<SchoolMasterResVO> fetchListOfAllSchools();
	
	public QueryResult findListOfAllUnmappedSchools();

	public Page<RegionStationMappingSearchResponseVO> findRegionStationMappingList(RegionStationMappingSearchListReqVO reqVO, Pageable pageable) throws Exception;

	public Page<StationCategoryMappingSearchResVO>findStationCategoryMappingList(StationCategoryMappingSearchReqVO reqVO, Pageable pageable) throws Exception;

	public Page<SchoolStationMappingSearchResVO>findSchoolStationMappingList(SchoolStationMappingSearchReqVO reqVO, Pageable pageable);

	public List<StaffTypeMasterResVO> fetchListOfAllStaffType();

	public List<DesignationMasterResVO> fetchListOfDesignations();

	public List<SubjectMasterResVO> fetchListOfSubjects();

	public Page<StaffTypePostMappingResVO> findStaffTypePostMappingList(StaffTypePostMappingSearchReqVO reqVO, Pageable pageable);
	
	public QueryResult fetchStationListByRegion(RegionStationMappingSearchResponseVO reqVo);
	
	public QueryResult getSubjectByPost(Map<String,Object> data);
	
	public QueryResult fetchRegionStationSchool();
	
	public QueryResult fetchSanctionPost(Map<String,Object> data);
	
	public QueryResult getStationCategoryByRegion(Map<String,Object> data);
	
	public List<FreezMasterConfigurationEO>  getFreezeMaster();
	
	public Map<String,Object>  getFreezeMasterById(Integer id);
	
	public QueryResult  fetchSchoolRegionMappingList(Map<String,Object> data);
	
	public QueryResult findAllStationCategoryMappingList();
	
	public QueryResult findStationCategoryMappingListByStationCode(StationCategoryMappingSearchReqVO data);
	
	public QueryResult fetchAllSchoolRegionMappingList();
	
	public QueryResult fetchAllSchoolStationListByRegion(Map<String,Object> data);
	
	
	public QueryResult fetchSchoolStationHistory(Map<String,Object> data);

	
}
