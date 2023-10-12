package com.example.MOERADTEACHER.common.uneecops.master.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.MOERADTEACHER.common.uneecops.master.eo.SubjectMasterEO;
import com.example.MOERADTEACHER.common.uneecops.master.vo.SubjectMasterResVO;

@Repository
public interface SubjectMasterRepository extends JpaRepository<SubjectMasterEO,Integer>{

	@Query("Select new com.example.MOERADTEACHER.common.uneecops.master.vo.SubjectMasterResVO(s.id,s.subjectCode, s.subjectName, s.status, s.description) from SubjectMasterEO s order by s.subjectName,s.subjectCode")
	List<SubjectMasterResVO> findListOfSubjects();
	
	Optional<SubjectMasterEO> findById(Integer id);

	@Query("Select new com.example.MOERADTEACHER.common.uneecops.master.vo.SubjectMasterResVO"
			+ "(s.id,s.subjectCode, s.subjectName, s.status, s.description) from SubjectMasterEO s where s.status = :status order by s.subjectName")
	List<SubjectMasterResVO> findActiveAndInactiveSubject(@Param ("status") Boolean status);
}
