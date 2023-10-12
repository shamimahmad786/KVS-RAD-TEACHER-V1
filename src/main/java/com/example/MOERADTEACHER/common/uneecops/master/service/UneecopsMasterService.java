package com.example.MOERADTEACHER.common.uneecops.master.service;

import java.util.Map;

import javax.validation.Valid;

import com.example.MOERADTEACHER.common.uneecops.master.eo.FreezMasterConfigurationEO;
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

//import com.example.MOERADTEACHER.common.uneecops.master.vo.CategoryMasterVo;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.DesignationMasterReqVO;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.DesignationUpdateMasterReqVO;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.RegionStationsMappingReqVo;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.RegionMasterVo;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.SchoolMasterReqVO;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.SchoolMasterUpdateReqVO;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.StaffTypeMasterReqVO;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.StaffTypeUpdateMasterReqVO;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.StationMasterVo;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.SubjectMasterReqVO;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.SubjectMasterUpdateReqVO;

public interface UneecopsMasterService {

	public void saveStationMaster(StationMasterVo req);

	public void saveRegionMaster(RegionMasterVo req);

	public void saveStationCategoryMaster(CategoryMasterVo req);

	public void saveSchoolMaster(@Valid SchoolMasterReqVO reqVO);

	public void updateRegionMaster(@Valid RegionMasterVo regionVo);

	public void updateStationMaster(@Valid StationMasterVo stationVo);

	public void updateStationCategoryMaster(@Valid CategoryMasterVo categoryVo);

	public void updateSchoolMaster(@Valid SchoolMasterUpdateReqVO reqVO);

	public void saveStaffTypeMaster(@Valid StaffTypeMasterReqVO staffTypeMasterReqVO);

	public void updateStaffTypeMaster(@Valid StaffTypeUpdateMasterReqVO staffTypeUpdateReqVO);

	public void saveDesignationMaster(@Valid DesignationMasterReqVO designationMasterReqVO);

	public void updateDesignationMaster(@Valid DesignationUpdateMasterReqVO designationUpdateReqVO);

	public void saveSubjectMaster(@Valid SubjectMasterReqVO subjectMasterReqVO);

	public void updateSubjectMaster(@Valid SubjectMasterUpdateReqVO subUpdateReqVO);
	
	public Map<String,Object> freezeMaster(FreezMasterConfigurationEO data);
	
	

}
