package com.example.MOERADTEACHER.common.uneecops.master.repo;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.example.MOERADTEACHER.common.uneecops.master.vo.PostSubjectMappingSearchListReqVO;
import com.example.MOERADTEACHER.common.uneecops.master.vo.PostSubjectMappingSearchResponseVO;
@Repository
public class PostSubjectMappingRepoImpl implements  PostSubjectMappingRepo{
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public Page<PostSubjectMappingSearchResponseVO> fetchPostSubjectMappingListWithStaffDetails(
			PostSubjectMappingSearchListReqVO reqVO, Pageable pageable) throws Exception {
		int startIndex = pageable.getPageNumber() * pageable.getPageSize();
		StringBuilder select = new StringBuilder(
		
				"SELECT new com.example.MOERADTEACHER.common.uneecops.master.vo.PostSubjectMappingSearchResponseVO(");
//		select.append("st.id, ");
		select.append("dm.id, ");
		select.append("sm.id, ");
//		select.append("st.staffType, ");
		select.append("dm.postCode, ");
		select.append("dm.postName, ");
		select.append("sm.subjectCode, ");
		select.append("sm.subjectName)");
		
		StringBuilder from = new StringBuilder();
//		from.append(" from PostSubjectMappingEo psm inner join DesignationMasterEO dm on psm.postId=dm.id inner join SubjectMasterEO sm on sm.id=psm.subjectId inner join StaffTypePostMappingEO stpm on stpm.designationId=psm.postId ,StaffTypeMasterEO st");
		from.append(" from PostSubjectMappingEo psm , SubjectMasterEO sm, DesignationMasterEO dm  ");
		
		String where = " where psm.subjectId=sm.id and dm.id= psm.postId  Order by dm.postName  ";
//		if (reqVO.getPostName() != null) {
//			where += " where dm.postName =:postName ";
//
//		}
//		if (reqVO.getSubjectName()!= null) {
//			where += where.isEmpty() ? " where sm.subjectName =:subjectName "
//					: " and sm.subjectName =:subjectName";
//		}

		
		select.append(from);
		
//		select.append(" where ");
		select.append(where);
		
//		select.append(" Order By psm.createdDate desc ");
		
		System.out.println(select.toString());
		
		 Query query = entityManager.createQuery(select.toString(), PostSubjectMappingSearchResponseVO.class);
//				.setFirstResult(startIndex).setMaxResults(pageable.getPageSize());
		
//		String countStr = "Select count (psm.id) As count ";
//		String qry = countStr + from + where;
//
//		Query query1 = entityManager.createQuery(qry);
//
//		if (reqVO.getPostName() != null) {
//			query.setParameter("postName", reqVO.getPostName());
//			query1.setParameter("postName", reqVO.getPostName());
//		}
//		if (reqVO.getSubjectName() != null) {
//			query.setParameter("subjectName", reqVO.getSubjectName());
//			query1.setParameter("subjectName", reqVO.getSubjectName());
//		}
		
		List<PostSubjectMappingSearchResponseVO> list = query.getResultList();
//		List<Long> list2 = query1.getResultList();
//		long count = list2.isEmpty() ? 0 : list2.get(0);
		
		
		return new PageImpl<PostSubjectMappingSearchResponseVO>(list);

	}

	@Override
	public Page<PostSubjectMappingSearchResponseVO> searchPostSubjectMappingList(
			PostSubjectMappingSearchListReqVO reqVO, Pageable pageable) throws Exception {
		int startIndex = pageable.getPageNumber() * pageable.getPageSize();
		StringBuilder select = new StringBuilder(
		
				"SELECT new com.example.MOERADTEACHER.common.uneecops.master.vo.PostSubjectMappingSearchResponseVO(");
		select.append("dm.postCode, ");
		select.append("dm.postName, ");
		select.append("sm.subjectCode, ");
		select.append("sm.subjectName)");
		
		StringBuilder from = new StringBuilder();
		from.append(" from PostSubjectMappingEo psm inner join DesignationMasterEO dm on psm.postId=dm.id inner join SubjectMasterEO sm on sm.id=psm.subjectId inner join StaffTypePostMappingEO stpm on stpm.designationId=psm.postId");
		String where = "";
		if (reqVO.getPostName() != null) {
			where += " where dm.postName =:postName ";

		}
		if (reqVO.getSubjectName()!= null) {
			where += where.isEmpty() ? " where sm.subjectName =:subjectName "
					: " and sm.subjectName =:subjectName";
		}

		
		select.append(from);
		select.append(where);
		
		select.append(" Order By psm.createdDate desc ");
		
		
		 Query query = entityManager.createQuery(select.toString(), PostSubjectMappingSearchResponseVO.class)
				.setFirstResult(startIndex).setMaxResults(pageable.getPageSize());
		
		String countStr = "Select count (psm.id) As count ";
		String qry = countStr + from + where;

		Query query1 = entityManager.createQuery(qry);

		if (reqVO.getPostName() != null) {
			query.setParameter("postName", reqVO.getPostName());
			query1.setParameter("postName", reqVO.getPostName());
		}
		if (reqVO.getSubjectName() != null) {
			query.setParameter("subjectName", reqVO.getSubjectName());
			query1.setParameter("subjectName", reqVO.getSubjectName());
		}
		
		List<PostSubjectMappingSearchResponseVO> list = query.getResultList();
		List<Long> list2 = query1.getResultList();
		long count = list2.isEmpty() ? 0 : list2.get(0);
		
		
		return new PageImpl<PostSubjectMappingSearchResponseVO>(list, pageable, count);

	}
}
