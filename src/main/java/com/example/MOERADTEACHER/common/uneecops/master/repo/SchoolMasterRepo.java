package com.example.MOERADTEACHER.common.uneecops.master.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.MOERADTEACHER.common.uneecops.master.eo.SchoolMasterEO;
import com.example.MOERADTEACHER.common.uneecops.master.vo.SchoolMasterResVO;

@Repository
public interface SchoolMasterRepo extends JpaRepository<SchoolMasterEO, Integer> {

	@Query("Select new com.example.MOERADTEACHER.common.uneecops.master.vo.SchoolMasterResVO"
			+ "(s.id, s.schoolCode, s.schoolName, s.schoolStatus, s.shift,s.schoolType,s.schoolAddress) from SchoolMasterEO s where s.schoolStatus = :status order by s.schoolName ")
	List<SchoolMasterResVO> findSchoolCodeAndSchoolName(@Param("status") Boolean status);

	@Query("Select new com.example.MOERADTEACHER.common.uneecops.master.vo.SchoolMasterResVO"
			+ "(s.id, s.schoolCode, s.schoolName, s.schoolStatus, s.shift,s.schoolType,s.schoolAddress) from SchoolMasterEO s order by s.createdDate desc")
	List<SchoolMasterResVO> findListOfSchools();


	Optional<SchoolMasterEO> findById(Integer id);
	//List<SchoolMasterEO> findAllBySchoolCode(Integer schoolCode);

	List<SchoolMasterEO> findAllBySchoolCode(Integer schoolCode);

	SchoolMasterEO findSchoolNameBySchoolCode(Integer scCode);
	

	

}
