package com.example.MOERADTEACHER.common.uneecops.master.serviceimpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.MOERADTEACHER.common.uneecops.master.eo.FreezMasterConfigurationEO;
import com.example.MOERADTEACHER.common.uneecops.master.eo.RegionStationMappingEo;
import com.example.MOERADTEACHER.common.uneecops.master.repo.CategoryMasterRepository;
import com.example.MOERADTEACHER.common.uneecops.master.repo.DesignationMasterRepository;
import com.example.MOERADTEACHER.common.uneecops.master.repo.FreezMasterConfigurationRepository;
import com.example.MOERADTEACHER.common.uneecops.master.repo.MappingRepository;
import com.example.MOERADTEACHER.common.uneecops.master.repo.RegionMasterRepo;
import com.example.MOERADTEACHER.common.uneecops.master.repo.RegionStationMappingRepository;
import com.example.MOERADTEACHER.common.uneecops.master.repo.SchoolMasterRepo;
import com.example.MOERADTEACHER.common.uneecops.master.repo.StaffTypeMasterRepository;
import com.example.MOERADTEACHER.common.uneecops.master.repo.StationMasterRepo;
import com.example.MOERADTEACHER.common.uneecops.master.repo.SubjectMasterRepository;
import com.example.MOERADTEACHER.common.uneecops.master.service.UneecopsMasterFetchService;
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
import com.example.MOERADTEACHER.common.util.NativeRepository;
import com.example.MOERADTEACHER.common.util.QueryResult;

//import com.example.MOERADTEACHER.common.uneecops.master.repo.CategoryMasterRepository;
//import com.example.MOERADTEACHER.common.uneecops.master.repo.DesignationMasterRepository;
//import com.example.MOERADTEACHER.common.uneecops.master.repo.MappingRepository;
//import com.example.MOERADTEACHER.common.uneecops.master.repo.RegionMasterRepo;
//import com.example.MOERADTEACHER.common.uneecops.master.repo.SchoolMasterRepo;
//import com.example.MOERADTEACHER.common.uneecops.master.repo.StaffTypeMasterRepository;
//import com.example.MOERADTEACHER.common.uneecops.master.repo.StationMasterRepo;
//import com.example.MOERADTEACHER.common.uneecops.master.repo.SubjectMasterRepository;
//import com.example.MOERADTEACHER.common.uneecops.master.service.UneecopsMasterFetchService;
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

@Service
public class UneecopsMasterFetchServiceIMPL implements UneecopsMasterFetchService {

	@Autowired
	private StationMasterRepo stationMasterRepo;
	@Autowired
	private RegionMasterRepo  regionMasterRepo;
	@Autowired
	private CategoryMasterRepository categoryMasterRepository; 

	@Autowired
	private MappingRepository mappingRepository;

	@Autowired
	private SchoolMasterRepo schoolMasterRepo;
	@Autowired
	private StaffTypeMasterRepository staffTypeMasterRepository;
	@Autowired
	private DesignationMasterRepository designationMasterRepository;
	@Autowired
	private SubjectMasterRepository subjectMasterRepository;
	@Autowired
	private RegionStationMappingRepository  regionStationMappingRepository;

	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	NativeRepository nativeRepository;
	
	@Autowired
	FreezMasterConfigurationRepository   freezMasterConfigurationRepository;
	

	@Override
	public List<StationMasterResVo> fetchListOfActiveInactiveStation(ActiveOrInactiveReqVO reqVO) {
		
		if(reqVO.getStatus()==null)
		{
		return stationMasterRepo.findStationCodeAndStationName(true);
		}
		else 
			return stationMasterRepo.findStationCodeAndStationName(reqVO.isStatus());
	}

	@Override
	public List<RegionMasterResVo> findListOfActiveInactiveRegion(ActiveOrInactiveReqVO reqVO) {
		
		if(reqVO.getStatus()==null)
		{
		return regionMasterRepo.findRegionCodeAndRegionName(true);
		}
		else
			return regionMasterRepo.findRegionCodeAndRegionName(reqVO.isStatus());
	}

	@Override
	public List<CategoryMasterResVo> findListOfActiveInactiveCategory(ActiveOrInactiveReqVO reqVO) {
		
		if(reqVO.getStatus()==null)
		{
		return categoryMasterRepository.findCategoryNameAndId(true);
		}
		else
			return categoryMasterRepository.findCategoryNameAndId(reqVO.isStatus());
	}

	@Override
	public List<SchoolMasterResVO> findListOfActiveInactiveSchools(ActiveOrInactiveReqVO reqVO) {
		
		if(reqVO.getStatus()==null)
		{
			return null;
//		return schoolMasterRepo.findSchoolCodeAndSchoolName(true);
		}
		else
//			return schoolMasterRepo.findSchoolCodeAndSchoolName(reqVO.isStatus());
			return null;
	}
	
	@Override
	public List<DesignationMasterResVO> findListOfActiveInactiveDesignations(ActiveOrInactiveReqVO reqVO) {	
		return designationMasterRepository.findActiveAndInactiveDesigantions(reqVO.isStatus());
	}

	@Override
	public List<StaffTypeMasterResVO> findListOfActiveInactiveStaffType(ActiveOrInactiveReqVO reqVO) {
		return staffTypeMasterRepository.findActiveAndInactiveStaffType(reqVO.isStatus());
	}
	
	@Override
	public List<SubjectMasterResVO> findListOfActiveInactiveSubject(ActiveOrInactiveReqVO reqVO) {
		return subjectMasterRepository.findActiveAndInactiveSubject(reqVO.isStatus());
	}
	
	@Override
	public List<StationMasterResVo> fetchListOfAllStation() {
		return stationMasterRepo.findListOfStationCodeAndStationName();
		
	}

	@Override
	public List<RegionMasterResVo> fetchListOfAllRegion() {
		return regionMasterRepo.findListOfRegionCodeAndRegionName();
	}

	@Override
	public List<CategoryMasterResVo> fetchListOfAllCategory() {
		return categoryMasterRepository.findListOfCategories();
	}

	@Override

	public List<SchoolMasterResVO> fetchListOfAllSchools() {
		return schoolMasterRepo.findListOfSchools();
	}

	@Override
	public List<StaffTypeMasterResVO> fetchListOfAllStaffType() {	
		return staffTypeMasterRepository.findListOfStaffType();
	}
	
	@Override
	public List<DesignationMasterResVO> fetchListOfDesignations() {		
		return designationMasterRepository.findListOfDesignation();
	}
	@Override
	public List<SubjectMasterResVO> fetchListOfSubjects() {		
		return subjectMasterRepository.findListOfSubjects();
	}


	
	@Override
	public Page<RegionStationMappingSearchResponseVO> findRegionStationMappingList(RegionStationMappingSearchListReqVO reqVO, Pageable pageable) throws Exception {
		return mappingRepository.searchRegionStationMappingList(reqVO, pageable);
	}


	@Override
	public Page<StationCategoryMappingSearchResVO> findStationCategoryMappingList(
			StationCategoryMappingSearchReqVO reqVO, Pageable pageable)throws Exception {
		return mappingRepository.searchStationCategoryMappingList(reqVO, pageable);
	}

	@Override
	public Page<SchoolStationMappingSearchResVO> findSchoolStationMappingList(
			SchoolStationMappingSearchReqVO reqVO, Pageable pageable) {
	    	QueryResult queryResult = null;
	    	List<SchoolStationMappingSearchResVO> ssList=new ArrayList<SchoolStationMappingSearchResVO>();
	    	
	    	System.out.println("Region code--->"+reqVO.getRegionCode());
	    	
		if(reqVO.getRegionCode() !=null) {
			
			String query="select ssm.is_active, ms.shift,rsm.region_code , rsm.station_code, ms2.station_name  , ms.kv_code  , ms.school_name , ms.school_type \r\n"
					+ "from uneecops.region_station_mapping rsm , uneecops.school_station_mapping ssm , uneecops.m_schools ms , uneecops.m_station ms2 \r\n"
					+ "where rsm.station_code = ssm.station_code \r\n"
					+ "and ms.kv_code = ssm.kv_code \r\n"
					+ "and ssm.station_code = ms2.station_code \r\n"
					+ "and rsm.region_code ='"+reqVO.getRegionCode()+"' and ms.school_type in (1,3)  order by ms2.station_name  ";
			
			System.out.println(query);
			
			 try {
				 queryResult= nativeRepository.executeQueries(query);
				 for(int i=0;i<queryResult.getRowValue().size();i++) {
					 SchoolStationMappingSearchResVO ssObj=new SchoolStationMappingSearchResVO(String.valueOf(queryResult.getRowValue().get(i).get("school_name")),String.valueOf(queryResult.getRowValue().get(i).get("shift")),String.valueOf(queryResult.getRowValue().get(i).get("station_name")),Integer.parseInt(String.valueOf(queryResult.getRowValue().get(i).get("station_code"))),Integer.parseInt(String.valueOf(queryResult.getRowValue().get(i).get("kv_code"))),null,null,Boolean.parseBoolean(String.valueOf(queryResult.getRowValue().get(i).get("is_active"))));
					 ssList.add(ssObj);
				 }
				 
				 
			 }catch(Exception ex) {
				 ex.printStackTrace();
			 }
			return new PageImpl<SchoolStationMappingSearchResVO>(ssList);
		}else {
			return mappingRepository.searchSchoolStationMappingList(reqVO, pageable);	
		}

		
		
	
	}

	@Override
	public Page<StaffTypePostMappingResVO> findStaffTypePostMappingList(StaffTypePostMappingSearchReqVO reqVO,
			Pageable pageable) {
		
		return mappingRepository.searchStaffTypePostMappingList(reqVO, pageable);
	}
	
	@Override
	public QueryResult fetchStationListByRegion(RegionStationMappingSearchResponseVO reqVO) {
		System.out.println("Region Code--->"+reqVO.getRegionCode());
		QueryResult queryResult = null;
		String query="select * from uneecops.m_station ms, uneecops.region_station_mapping rsm where ms.station_code=rsm.station_code and rsm.region_code='"+reqVO.getRegionCode() +"' order by ms.station_name";
		 try {
			 
			 System.out.println(query);
			 
			 queryResult= nativeRepository.executeQueries(query);
		 }catch(Exception ex) {
			 ex.printStackTrace();
		 }
		
		 return queryResult;
//		return regionStationMappingRepository.findByRegionCode(reqVO.getRegionCode());
	}
	
	@Override
	public QueryResult findListOfAllUnmapedStations(){	
		QueryResult queryResult = null;
		String query="select * from uneecops.m_station ms where ms.station_code not in (select station_code from uneecops.region_station_mapping)";
		 try {
			 queryResult= nativeRepository.executeQueries(query);
		 }catch(Exception ex) {
			 ex.printStackTrace();
		 }
		 return queryResult;		
	}
	
//	@Override
//	public QueryResult findListOfAllUnmappedSchools(){	
//		QueryResult queryResult = null;
//		String query="select * from uneecops.m_schools ms where ms.kv_code  not in (select kv_code from uneecops.school_station_mapping ssm)";
//		 try {
//			 queryResult= nativeRepository.executeQueries(query);
//		 }catch(Exception ex) {
//			 ex.printStackTrace();
//		 }
//		 return queryResult;		
//	}
	
	@Override
	public QueryResult findListOfAllUnmappedSchools(){	
		QueryResult queryResult = null;
		String query="select * from uneecops.m_schools ms ";
		 try {
			 queryResult= nativeRepository.executeQueries(query);
//			 System.out.println(queryResult);
		 }catch(Exception ex) {
			 ex.printStackTrace();
		 }
		 return queryResult;		
	}
	
	@Override
	public QueryResult getSubjectByPost(Map<String,Object> data){
		QueryResult queryResult = null;
		String query="select * from uneecops.m_subject ms where ms.id  not in (select psm.subject_id  from uneecops.post_subject_mapping psm  where psm.post_id = "+data.get("postId")+")";
		 try {
			 queryResult= nativeRepository.executeQueries(query);
		 }catch(Exception ex) {
			 ex.printStackTrace();
		 }
		 return queryResult;
	}
	
	@Override
	public QueryResult fetchRegionStationSchool(){
		return null;
	}
	
	@Override
	public QueryResult fetchSanctionPost(Map<String,Object> data){
		QueryResult queryResult = null;
		String query=null;
		if(data.get("type") !=null && String.valueOf(data.get("type")).equalsIgnoreCase("0")  && String.valueOf(data.get("value")).equalsIgnoreCase("0")) {
		query="select stpm.stafftype_id ,md.post_code , md.post_name ,ms.subject_code , ms.subject_name ,     sum(spm.sanctioned_post ) as sanctioned_post,     sum( spm.occupied_post) as occupied_post,     sum(spm.vacant) as vacant,     sum( spm.surplus  ) as surplus from uneecops.sanctioned_post_mapping spm ,uneecops.m_designation md , uneecops.m_subject ms  , uneecops.staff_type_post_mapping stpm , uneecops.m_schools ms2 ,kv.kv_school_master ksm where spm.post_id = md.id      and  spm.subject_id = ms.id      and stpm.designation_id = md.id      and spm.post_id = stpm.designation_id      and spm.school_code = ms2.kv_code      and spm.shift::numeric = ms2.shift::numeric      and ksm.kv_code = ms2.kv_master_kv_code          and (spm.sanctioned_post > 0  or spm.occupied_post > 0)      group by stpm.stafftype_id ,md.post_code , md.post_name ,ms.subject_code , ms.subject_name order by stpm.stafftype_id ,md.post_code , md.post_name ,ms.subject_code , ms.subject_name";		
		}else if(data.get("type") !=null && String.valueOf(data.get("type")).equalsIgnoreCase("0")  && !String.valueOf(data.get("value")).equalsIgnoreCase("0")) {
			query="select stpm.stafftype_id ,md.post_code , md.post_name ,ms.subject_code , ms.subject_name ,     sum(spm.sanctioned_post ) as sanctioned_post,     sum( spm.occupied_post) as occupied_post,     sum(spm.vacant) as vacant,     sum( spm.surplus  ) as surplus from uneecops.sanctioned_post_mapping spm ,uneecops.m_designation md , uneecops.m_subject ms  , uneecops.staff_type_post_mapping stpm , uneecops.m_schools ms2 ,kv.kv_school_master ksm where spm.post_id = md.id      and  spm.subject_id = ms.id      and stpm.designation_id = md.id      and spm.post_id = stpm.designation_id      and spm.school_code = ms2.kv_code      and spm.shift::numeric = ms2.shift::numeric      and ksm.kv_code = ms2.kv_master_kv_code      and ksm.region_code = '"+String.valueOf(data.get("value"))+"'      and (spm.sanctioned_post > 0  or spm.occupied_post > 0)      group by stpm.stafftype_id ,md.post_code , md.post_name ,ms.subject_code , ms.subject_name order by stpm.stafftype_id ,md.post_code , md.post_name ,ms.subject_code , ms.subject_name";
		}else if(data.get("type") !=null && String.valueOf(data.get("type")).equalsIgnoreCase("1")  && String.valueOf(data.get("value")).equalsIgnoreCase("0")) {
			query=" select stpm.stafftype_id ,md.post_code , md.post_name ,ms.subject_code , ms.subject_name , spm.shift ,\r\n"
					+ "    sum(spm.sanctioned_post ) as sanctioned_post,\r\n"
					+ "    sum( spm.occupied_post) as occupied_post,\r\n"
					+ "    sum(spm.vacant) as vacant,\r\n"
					+ "    sum( spm.surplus  ) as surplus,\r\n"
					+ "    ksm.station_code , ksm.station_name\r\n"
					+ "from uneecops.sanctioned_post_mapping spm ,uneecops.m_designation md , uneecops.m_subject ms  ,\r\n"
					+ "uneecops.staff_type_post_mapping stpm , uneecops.m_schools ms2 ,kv.kv_school_master ksm\r\n"
					+ "where spm.post_id = md.id\r\n"
					+ "     and  spm.subject_id = ms.id\r\n"
					+ "     and stpm.designation_id = md.id\r\n"
					+ "     and spm.post_id = stpm.designation_id\r\n"
					+ "     and spm.school_code = ms2.kv_code\r\n"
					+ "     and spm.shift::numeric = ms2.shift::numeric\r\n"
					+ "     and ksm.kv_code = ms2.kv_master_kv_code\r\n"
					+ "     and ksm.region_code = '"+String.valueOf(data.get("depValue"))+"'\r\n"
					+ "     and (spm.sanctioned_post > 0  or spm.occupied_post > 0)\r\n"
					+ "     group by stpm.stafftype_id ,md.post_code , md.post_name ,ms.subject_code , ms.subject_name , spm.shift ,  ksm.station_code , ksm.station_name  order by  stpm.stafftype_id ,md.post_code , md.post_name ,ms.subject_code , ms.subject_name\r\n";
					
		}else if(data.get("type") !=null && String.valueOf(data.get("type")).equalsIgnoreCase("1")  && !String.valueOf(data.get("value")).equalsIgnoreCase("0")) {
			
			query="\r\n"
					+ " select stpm.stafftype_id ,md.post_code , md.post_name ,ms.subject_code , ms.subject_name ,\r\n"
					+ "    sum(spm.sanctioned_post ) as sanctioned_post,\r\n"
					+ "    sum( spm.occupied_post) as occupied_post,\r\n"
					+ "    sum(spm.vacant) as vacant,\r\n"
					+ "    sum( spm.surplus  ) as surplus,\r\n"
					+ "    ksm.station_code , ksm.station_name\r\n"
					+ "from uneecops.sanctioned_post_mapping spm ,uneecops.m_designation md , uneecops.m_subject ms  ,\r\n"
					+ "uneecops.staff_type_post_mapping stpm , uneecops.m_schools ms2 ,kv.kv_school_master ksm\r\n"
					+ "where spm.post_id = md.id\r\n"
					+ "     and  spm.subject_id = ms.id\r\n"
					+ "     and stpm.designation_id = md.id\r\n"
					+ "     and spm.post_id = stpm.designation_id\r\n"
					+ "     and spm.school_code = ms2.kv_code\r\n"
					+ "     and spm.shift::numeric = ms2.shift::numeric\r\n"
					+ "     and ksm.kv_code = ms2.kv_master_kv_code\r\n"
					+ "     and  ksm.station_code='"+String.valueOf(data.get("value"))+"'\r\n"
					+ "     and (spm.sanctioned_post > 0  or spm.occupied_post > 0)\r\n"
					+ "     group by stpm.stafftype_id ,md.post_code , md.post_name ,ms.subject_code , ms.subject_name  ,  ksm.station_code , ksm.station_name  order by  stpm.stafftype_id ,md.post_code , md.post_name ,ms.subject_code , ms.subject_name\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "";
			
		}else if(data.get("type") !=null && String.valueOf(data.get("type")).equalsIgnoreCase("2")) {
//			query="select stpm.stafftype_id ,md.post_code , md.post_name ,ms.subject_code , ms.subject_name , spm.shift ,\r\n"
////					+ "    sum(spm.sanctioned_post ) as sanctioned_post,\r\n"
////					+ "    sum( spm.occupied_post) as occupied_post,\r\n"
////					+ "    sum(spm.vacant) as vacant,\r\n"
////					+ "    sum( spm.surplus  ) as surplus\r\n"
//					+ "from uneecops.sanctioned_post_mapping spm ,uneecops.m_designation md , uneecops.m_subject ms  ,\r\n"
//					+ "uneecops.staff_type_post_mapping stpm , uneecops.m_schools ms2 ,kv.kv_school_master ksm\r\n"
//					+ "where spm.post_id = md.id\r\n"
//					+ "     and  spm.subject_id = ms.id\r\n"
//					+ "     and stpm.designation_id = md.id\r\n"
//					+ "     and spm.post_id = stpm.designation_id\r\n"
//					+ "     and spm.school_code = ms2.kv_code\r\n"
//					+ "     and spm.shift::numeric = ms2.shift::numeric\r\n"
//					+ "     and ksm.kv_code = ms2.kv_master_kv_code\r\n"
//					+ "     and ksm.kv_code = '"+String.valueOf(data.get("value"))+"'\r\n";
////					+ "     and (spm.sanctioned_post > 0  or spm.occupied_post > 0)\r\n"
////					+ "     group by stpm.stafftype_id ,md.post_code , md.post_name ,ms.subject_code , ms.subject_name , spm.shift";
		
			
			// Working on V1 phase
//		query="select spm.freezed_sanction_post,spm.id,spm.occupied_post ,spm.sanctioned_post ,spm.vacant ,spm.surplus ,stpm.stafftype_id ,md.post_code , md.post_name ,ms.subject_code , ms.subject_name , spm.shift \r\n"
//				+ "from uneecops.sanctioned_post_mapping spm ,uneecops.m_designation md , uneecops.m_subject ms  ,\r\n"
//				+ "uneecops.staff_type_post_mapping stpm , uneecops.m_schools ms2 \r\n"
//				+ "where spm.post_id = md.id\r\n"
//				+ "     and  spm.subject_id = ms.id\r\n"
//				+ "     and stpm.designation_id = md.id\r\n"
//				+ "     and spm.post_id = stpm.designation_id\r\n"
//				+ "     and spm.school_code = ms2.kv_code\r\n"
//				+ "     and spm.shift::numeric = ms2.shift::numeric\r\n"
////				+ "   --  and ksm.kv_code = ms2.kv_master_kv_code\r\n"
//				+ "     and spm.school_code = '"+String.valueOf(data.get("value"))+"'\r\n"
//				+ "     and spm.shift = "+String.valueOf(data.get("shift"));
		
		query="select spm.freezed_sanction_post,spm.id,spm.occupied_post ,coalesce( tch_prof.tot_tch,0) post_system,spm.sanctioned_post ,spm.vacant ,spm.surplus ,stpm.stafftype_id ,\r\n"
				+ "md.post_code , md.post_name ,ms.subject_code , ms.subject_name , spm.shift \r\n"
				+ "from uneecops.sanctioned_post_mapping spm \r\n"
				+ "inner join uneecops.m_designation md  \r\n"
				+ "on spm.post_id = md.id\r\n"
				+ "inner join uneecops.m_subject ms  \r\n"
				+ "on  spm.subject_id = ms.id\r\n"
				+ "inner join uneecops.staff_type_post_mapping stpm \r\n"
				+ "on stpm.designation_id = md.id\r\n"
				+ "and spm.post_id = stpm.designation_id\r\n"
				+ "inner join uneecops.m_schools ms2 \r\n"
				+ "on  spm.school_code = ms2.kv_code\r\n"
				+ "and  spm.shift::numeric = ms2.shift::numeric\r\n"
				+ "left join \r\n"
				+ "(\r\n"
				+ "select kv_code,work_experience_appointed_for_subject subject_id ,last_promotion_position_type post_id,teaching_nonteaching emp_type, count(1) tot_tch \r\n"
				+ "from public.teacher_profile tp where tp.kv_code ='"+String.valueOf(data.get("value"))+"'\r\n"
				+ "group by  kv_code,work_experience_appointed_for_subject ,last_promotion_position_type ,teaching_nonteaching\r\n"
				+ ") tch_prof\r\n"
				+ "on tch_prof.kv_code::numeric=ms2.kv_code::numeric \r\n"
				+ "and tch_prof.subject_id::numeric=ms.id::numeric\r\n"
				+ "and tch_prof.post_id::numeric=md.id::numeric \r\n"
				+ "and tch_prof.emp_type::numeric=stpm.stafftype_id::numeric \r\n"
				+ "where \r\n"
				+ "     spm.school_code = '"+String.valueOf(data.get("value"))+"'\r\n"
				+ "     and spm.shift = "+String.valueOf(data.get("shift"));
		

		
		}
	
		
		System.out.println("quert-"+query);
		 try {
			 queryResult= nativeRepository.executeQueries(query);
		 }catch(Exception ex) {
			 ex.printStackTrace();
		 }
		 return queryResult;
	}
	
	
	@Override
	public QueryResult getStationCategoryByRegion(Map<String,Object> data){
		
		QueryResult queryResult = null;
		String query="select * from uneecops.station_category_mapping scm inner join uneecops.m_category mc on scm.category_id =mc.id inner join uneecops.m_station ms on ms.station_code =scm.station_code \r\n"
//		 		+ "where ms.station_code  in (select distinct  station_code from uneecops.region_station_mapping rsm where rsm.region_code='"+data.get("regionCode")+"')";
				+ "where ms.station_code  in (select distinct  station_code from uneecops.region_station_mapping rsm where rsm.region_code='"+data.get("regionCode")+"')";
		
		 try {
			 queryResult= nativeRepository.executeQueries(query);
		 }catch(Exception ex) {
			 ex.printStackTrace();
		 }
		 return queryResult;
		
	}
	
	@Override
	public    List<FreezMasterConfigurationEO>  getFreezeMaster(){
		return freezMasterConfigurationRepository.findAll();
	}

	@Override
	public Map<String, Object> getFreezeMasterById(Integer id) {
		// TODO Auto-generated method stub
		Map<String,Object> rObj=new HashMap<String,Object>();
		try {
		FreezMasterConfigurationEO	 obj=freezMasterConfigurationRepository.getById(id);
		System.out.println(obj.getOperation());
		
		System.out.println(obj.isStatus());
           rObj.put("status", obj.isStatus());		
		
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return rObj;
	}
	
	@Override
	public QueryResult fetchSchoolRegionMappingList(Map<String, Object> data){
		QueryResult queryResult = null;
		String query="";
		 try {			 
			 if(String.valueOf(data.get("businessUnitTypeId")).equalsIgnoreCase("2")) {
				 query="select distinct ksm.region_code,  spm.shift ,ksm.region_name , ksm.station_code ,ksm.station_name ,spm.school_code ,ksm.kv_name , spm.freezed_sanction_post \r\n"
				 		+ "from  uneecops.sanctioned_post_mapping spm  , uneecops.m_schools ms , kv.kv_school_master ksm\r\n"
				 		+ "where spm.school_code = ms.kv_code\r\n"
				 		+ "and spm.shift::varchar = ms.shift::varchar\r\n"
				 		+ "and ms.kv_master_kv_code = ksm.kv_code and ksm.school_status ='1' and ksm.region_code='"+data.get("regionCode")+"' order by ksm.station_name, ksm.kv_name ";
			 }else {
			 query="select distinct ksm.region_code,  spm.shift ,ksm.region_name , ksm.station_code ,ksm.station_name ,spm.school_code ,ksm.kv_name , spm.freezed_sanction_post \r\n"
					 		+ "from  uneecops.sanctioned_post_mapping spm  , uneecops.m_schools ms , kv.kv_school_master ksm\r\n"
					 		+ "where spm.school_code = ms.kv_code\r\n"
					 		+ "and spm.shift::varchar = ms.shift::varchar\r\n"
					 		+ "and ms.kv_master_kv_code = ksm.kv_code and ksm.school_type in ('1','3') and ksm.school_status ='1' and ksm.region_code='"+data.get("regionCode")+"' order by ksm.station_name,ksm.kv_name";
			 }
			 
			 queryResult= nativeRepository.executeQueries(query);
		 }catch(Exception ex) {
			 ex.printStackTrace();
		 }
		 return queryResult;
	}
	
	@Override
	public QueryResult findAllStationCategoryMappingList(){
		QueryResult queryResult = null;
		String query="";
		 try {			 
			query="select  distinct on (station_name) station_name,scm.from_date ,scm.id as mid,* from uneecops.m_station ms left join uneecops.station_category_mapping scm on ms.station_code =scm.station_code  left join uneecops.m_category mc on mc.id=scm.category_id  order by station_name,ms.is_active,scm.from_date desc";		 
			queryResult= nativeRepository.executeQueries(query);
		 }catch(Exception ex) {
			 ex.printStackTrace();
		 }
		 return queryResult;
	}
	
	@Override
	public QueryResult findStationCategoryMappingListByStationCode(StationCategoryMappingSearchReqVO data) {
		QueryResult queryResult = null;
		String query="";
		 try {			 
			query="select  * from uneecops.m_station ms left join uneecops.station_category_mapping scm on ms.station_code =scm.station_code  left join uneecops.m_category mc on mc.id=scm.category_id where ms.station_code ='"+data.getStationCode()+"' order by station_name,ms.is_active,scm.from_date desc";		 
			 queryResult= nativeRepository.executeQueries(query);
		 }catch(Exception ex) {
			 ex.printStackTrace();
		 }
		 return queryResult;
	}
	
	@Override
	public QueryResult fetchAllSchoolRegionMappingList() {
		QueryResult queryResult = null;
		String query="";
		 try {			 
			query="select distinct  on (ms.school_name) school_name, ssm.id as mid ,* from uneecops.m_schools ms left join uneecops.school_station_mapping ssm on ms.kv_code =ssm.kv_code left join uneecops.m_station mst on ssm.station_code::numeric =mst.station_code  where school_type ='1' order by ms.school_name, ssm.from_date ";		 
			queryResult= nativeRepository.executeQueries(query);
		 }catch(Exception ex) {
			 ex.printStackTrace();
		 }
		 return queryResult;	
	}
	
	
	@Override
	public QueryResult fetchSchoolStationHistory(Map<String,Object> mObj){
		QueryResult queryResult = null;
		String query="";
		 try {			 
			query="select * from uneecops.m_schools ms left join uneecops.school_station_mapping ssm on ms.kv_code =ssm.kv_code left join uneecops.m_station mst on ssm.station_code::numeric =mst.station_code  where school_type ='1' and ms.kv_code ='"+mObj.get("kvCode")+"' order by ms.school_name";		 
		System.out.println(query);
			queryResult= nativeRepository.executeQueries(query);
		 }catch(Exception ex) {
			 ex.printStackTrace();
		 }
		 return queryResult;
	}
	
	
	
	
}
