package com.example.MOERADTEACHER.common.uneecops.master.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.example.MOERADTEACHER.common.uneecops.master.vo.SanctionedPostFechListRequestVo;
import com.example.MOERADTEACHER.common.uneecops.master.vo.SanctionedPostResponseVo;
@Repository
public class SanctionedPostFetchListRepositoryImpl implements SanctionedPostFetchListRepository {
	
	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public Page<SanctionedPostResponseVo> fetchListOfSanctionedPostResponseVo(
			SanctionedPostFechListRequestVo sanctionedPostFechListRequestVo, Pageable pageable) throws Exception {
		
		
		
		int startIndex = pageable.getPageNumber() * pageable.getPageSize();
		StringBuilder select = new StringBuilder(
				"SELECT new com.example.MOERADTEACHER.common.uneecops.master.vo.SanctionedPostResponseVo(");
		select.append("sp.id, ");
		select.append("d.postName, ");
		select.append("d.postCode, ");
		select.append("s.subjectCode, ");
		select.append("s.subjectName, ");
		select.append("st.staffType, ");
		select.append("sp.sanctionedPost, ");
		select.append("sp.occupiedPost, ");
		select.append("sp.vacant, ");
		select.append("sp.surplus) ");
		
	
		

		StringBuilder from = new StringBuilder();
		from.append(" from SanctionedPostEo sp inner join DesignationMasterEO d on sp.postId=d.id inner join SubjectMasterEO s on sp.subjectId=s.id inner join StaffTypeMasterEO st on st.id=sp.staffTypeId");

		String where = "";
		if (sanctionedPostFechListRequestVo.getSchoolCode() != null) {
			where += " where sp.schoolCode = :schoolCode ";

		}
		select.append(from);
		select.append(where);
		
		select.append(" Order By sp.createdDate desc ");
		
		
		 Query query = entityManager.createQuery(select.toString(), SanctionedPostResponseVo.class)
				.setFirstResult(startIndex).setMaxResults(pageable.getPageSize());
		System.out.println("query");
		String countStr = "Select count (sp.id) As count ";
		String qry = countStr + from + where;
     
		Query query1 = entityManager.createQuery(qry);

		if (sanctionedPostFechListRequestVo.getSchoolCode() != null) {
			query.setParameter("schoolCode", sanctionedPostFechListRequestVo.getSchoolCode());
			query1.setParameter("schoolCode", sanctionedPostFechListRequestVo.getSchoolCode());
			System.out.println("schoolcode");
		}
		System.out.println("list");
		
		List<SanctionedPostResponseVo> list=query.getResultList();
		System.out.println("where->"+select);
		List<Long> list2 = query1.getResultList();
		long count = list2.isEmpty() ? 0 : list2.get(0);
		return new PageImpl<SanctionedPostResponseVo>(list, pageable, count);
		
}


	
	
}

