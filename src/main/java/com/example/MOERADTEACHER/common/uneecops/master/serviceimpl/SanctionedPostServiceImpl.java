package com.example.MOERADTEACHER.common.uneecops.master.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.MOERADTEACHER.common.uneecops.master.eo.SanctionedPostEo;
import com.example.MOERADTEACHER.common.uneecops.master.repo.SanctionedPostFetchListRepository;
import com.example.MOERADTEACHER.common.uneecops.master.repo.SanctionedPostRepository;
import com.example.MOERADTEACHER.common.uneecops.master.service.SanctionedPostService;
import com.example.MOERADTEACHER.common.uneecops.master.utils.UneecopsDateUtils;
import com.example.MOERADTEACHER.common.uneecops.master.vo.DesiginationMasterRequestVo;
import com.example.MOERADTEACHER.common.uneecops.master.vo.SanctionedPostFechListRequestVo;
import com.example.MOERADTEACHER.common.uneecops.master.vo.SanctionedPostListRequestVo2;
import com.example.MOERADTEACHER.common.uneecops.master.vo.SanctionedPostRequestVo;
import com.example.MOERADTEACHER.common.uneecops.master.vo.SanctionedPostRequestVo2;
import com.example.MOERADTEACHER.common.uneecops.master.vo.SanctionedPostResponseVo;
import com.example.MOERADTEACHER.common.uneecops.master.vo.SanctionedPostSchoolCodeCheckRequestVo;
import com.example.MOERADTEACHER.common.uneecops.master.vo.SanctionedPostSchoolCodeCheckResponeseVo;
import com.example.MOERADTEACHER.common.uneecops.master.vo.SanctionedPostUpdateListRequestVo;
import com.example.MOERADTEACHER.common.uneecops.master.vo.SanctionedPostUpdateRequestVo;
import com.example.MOERADTEACHER.common.uneecops.master.vo.StaffTypeMasterRequestVo;
import com.example.MOERADTEACHER.common.uneecops.master.vo.SubjectMasterRequestVo;
import com.example.MOERADTEACHER.common.util.NativeRepository;
import com.example.MOERADTEACHER.common.util.QueryResult;

//import com.example.MOERADTEACHER.common.uneecops.master.eo.SanctionedPostEo;
//import com.example.MOERADTEACHER.common.uneecops.master.repo.SanctionedPostFetchListRepository;
//import com.example.MOERADTEACHER.common.uneecops.master.repo.SanctionedPostRepository;
//import com.example.MOERADTEACHER.common.uneecops.master.service.SanctionedPostService;
//import com.example.MOERADTEACHER.common.uneecops.master.utils.UneecopsDateUtils;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.DesiginationMasterRequestVo;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.SanctionedPostFechListRequestVo;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.SanctionedPostListRequestVo2;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.SanctionedPostRequestVo;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.SanctionedPostRequestVo2;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.SanctionedPostResponseVo;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.SanctionedPostSchoolCodeCheckRequestVo;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.SanctionedPostSchoolCodeCheckResponeseVo;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.SanctionedPostUpdateListRequestVo;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.SanctionedPostUpdateRequestVo;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.StaffTypeMasterRequestVo;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.SubjectMasterReqVO;
//import com.example.MOERADTEACHER.common.uneecops.master.vo.SubjectMasterRequestVo;

@Service
public class SanctionedPostServiceImpl implements SanctionedPostService {

	@Autowired
	private SanctionedPostRepository sanctinedPostRepository;
	
	
	@Autowired
	private SanctionedPostFetchListRepository sanctionedPostFetchListRepository;
	
	@Autowired
	NativeRepository nativeRepository;

	@Override
	public void saveSchoolSanctionedPostDetail(SanctionedPostRequestVo sanctionedPostRequestVo) {

		List<StaffTypeMasterRequestVo> listOfStaffTypeMasterRequestVo = sanctionedPostRequestVo
				.getListOfStaffTypeMasterRequestVo();
		for (StaffTypeMasterRequestVo staffTypeMasterRequestVo : listOfStaffTypeMasterRequestVo) {
			SanctionedPostEo sactionedPostEo = new SanctionedPostEo();
			sactionedPostEo.setSchoolCode(sanctionedPostRequestVo.getSchoolCode());
			sactionedPostEo.setStaffTypeId(staffTypeMasterRequestVo.getStaffTypeId());
			List<DesiginationMasterRequestVo> listdesigineDesiginationMasterRequestVo = staffTypeMasterRequestVo
					.getListOfDesiginationMasterRequestVo();
			for (DesiginationMasterRequestVo desiginationMasterRequestVo : listdesigineDesiginationMasterRequestVo) {
				sactionedPostEo.setPostId(desiginationMasterRequestVo.getPostId());

				List<SubjectMasterRequestVo> listOfSubjectMasterRequestVo = desiginationMasterRequestVo
						.getListOfSubjectMasterRequestVo();
				for (SubjectMasterRequestVo subjectMasterReqVO : listOfSubjectMasterRequestVo) {
					sactionedPostEo.setSubjectId(subjectMasterReqVO.getSubjectId());
					sactionedPostEo.setSanctionedPost(subjectMasterReqVO.getSanctionedPost());
					sactionedPostEo.setOccupiedPost(subjectMasterReqVO.getOccupiedPost());
					sactionedPostEo.setSurplus(subjectMasterReqVO.getSurplus());
					sactionedPostEo.setVacant(subjectMasterReqVO.getVacant());
				}
			}
			;
			sactionedPostEo.setActive(true);
			
			sactionedPostEo.setCreatedDate(UneecopsDateUtils.getCurrentTimeStamp());
			sanctinedPostRepository.save(sactionedPostEo);
		}

	}

	@Override
	public Page<SanctionedPostResponseVo> fetchlistOfSchoolSanctionedPostDetail(SanctionedPostFechListRequestVo sanctionedPostFechListRequestVo,Pageable pageable) throws Exception {
		
		return sanctionedPostFetchListRepository.fetchListOfSanctionedPostResponseVo(sanctionedPostFechListRequestVo,pageable);
	}

	@Override
	public SanctionedPostSchoolCodeCheckResponeseVo CheckSanctionedPostSchoolCodeExistOrNot(SanctionedPostSchoolCodeCheckRequestVo sanctionedPostSchoolCodeCheckRequestVo)
	{
		SanctionedPostSchoolCodeCheckResponeseVo sanctionedPostSchoolCodeCheckResponeseVo = new SanctionedPostSchoolCodeCheckResponeseVo();
	List<SanctionedPostEo> list = sanctinedPostRepository.findBySchoolCode(sanctionedPostSchoolCodeCheckRequestVo.getSchoolCode());
		System.out.println(list+"list data");
		if(list.isEmpty())
		{
			sanctionedPostSchoolCodeCheckResponeseVo.setMessage("ENTRY-NOT-FOUND");
			return sanctionedPostSchoolCodeCheckResponeseVo;
		}
		else
			sanctionedPostSchoolCodeCheckResponeseVo.setMessage("ENTRY-FOUND");
		
	return sanctionedPostSchoolCodeCheckResponeseVo;
	
	}

	@Override
	public void saveSchoolSanctionedPostDetailV2(SanctionedPostListRequestVo2 sanctionedPostListRequestVo2) {
		
		
		List<SanctionedPostRequestVo2> list =sanctionedPostListRequestVo2.getSanctionedPostRequestVo2();
		for(SanctionedPostRequestVo2 listReq:list)
		{
			SanctionedPostEo sactionedPostEo = new SanctionedPostEo();
			
			sactionedPostEo.setSchoolCode(listReq.getSchoolCode());
			sactionedPostEo.setPostId(listReq.getPostId());
			sactionedPostEo.setStaffTypeId(listReq.getStaffTypeId());
			sactionedPostEo.setSubjectId(listReq.getSubjectId());
			sactionedPostEo.setOccupiedPost(listReq.getOccupiedPost());
			sactionedPostEo.setSanctionedPost(listReq.getSanctionedPost());
			sactionedPostEo.setSurplus(listReq.getSurplus());
			sactionedPostEo.setVacant(listReq.getVacant());
			sactionedPostEo.setCreatedDate(UneecopsDateUtils.getCurrentTimeStamp());
			sactionedPostEo.setActive(true);
			sanctinedPostRepository.save(sactionedPostEo);
			

		}
		
		
	}

	@Override
	public void updateSchoolSanctionedPostDetail(SanctionedPostUpdateListRequestVo sanctionedPostUpdateListRequestVo) {
		
		System.out.println("called");
		
	List<SanctionedPostUpdateRequestVo> list=	sanctionedPostUpdateListRequestVo.getListOfSanctionedPostUpdateRequestVo();
//	
	System.out.println(list.size());
	
	for(SanctionedPostUpdateRequestVo data:list)
	{
		try {
//			System.out.println("data--->"+data.getSurplus());
			SanctionedPostEo sanctionedPostEo=new SanctionedPostEo();
			nativeRepository.updateQueries("update uneecops.sanctioned_post_mapping set occupied_post="+data.getOccupiedPost()+",surplus="+data.getSurplus()+",sanctioned_post="+data.getSanctionedPost()+",vacant="+data.getVacant()+" where id="+data.getSactionedPostId());
			
//		QueryResult obj=	nativeRepository.executeQueries("select * from uneecops.sanctioned_post_mapping where id="+data.getSactionedPostId());
//		System.out.println("data.getSactionedPostId()---->"+data.getSactionedPostId());
//			sanctinedPostRepository.findById(16600);
//	SanctionedPostEo sanctionedPostEo= 	sanctinedPostRepository.findById(data.getSactionedPostId());
//	sanctionedPostEo.setId(Integer.parseInt(String.valueOf(obj.getRowValue().get(0).get("id"))));
//	sanctionedPostEo.setActive(true);
////	sanctionedPostEo.setCreatedDate(new Date());
////	sanctionedPostEo.setCreatedBy(createdBy);
//	sanctionedPostEo.setPostId(Integer.parseInt(String.valueOf(obj.getRowValue().get(0).get("post_id"))));
//	sanctionedPostEo.setSchoolCode(Integer.parseInt(String.valueOf(obj.getRowValue().get(0).get("school_code"))));
//	sanctionedPostEo.setStaffTypeId(1);
//	sanctionedPostEo.setSubjectId(Integer.parseInt(String.valueOf(obj.getRowValue().get(0).get("subject_id"))));
////	sanctionedPostEo.setUpdatedBy(updatedBy);
//	
//	
//	sanctionedPostEo.setOccupiedPost(data.getOccupiedPost());
//	sanctionedPostEo.setVacant(data.getVacant());
//	sanctionedPostEo.setSurplus(0);
//
//	sanctionedPostEo.setSanctionedPost(data.getSanctionedPost());
//
//	
//	sanctinedPostRepository.save(sanctionedPostEo);
	}catch(Exception ex) {
		ex.printStackTrace();
	}
	}
	}

	@Override
	public Map<String,Object> freezeSanctionPost(Map<String,Object> data){
		Map<String,Object> res=new HashMap<String,Object>();
		try {
			nativeRepository.updateQueries("update uneecops.sanctioned_post_mapping set freezed_sanction_post=1 where school_code="+data.get("schoolCode") +" and shift="+data.get("shift"));
			res.put("status", "1");
		}catch(Exception ex) {
			res.put("status", "0");
			ex.printStackTrace();
		}
		
		return res;
		
	}
	
	}

