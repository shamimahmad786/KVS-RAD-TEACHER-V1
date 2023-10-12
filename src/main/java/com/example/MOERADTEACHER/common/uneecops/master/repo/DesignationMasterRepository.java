package com.example.MOERADTEACHER.common.uneecops.master.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.MOERADTEACHER.common.uneecops.master.eo.DesignationMasterEO;
import com.example.MOERADTEACHER.common.uneecops.master.vo.DesignationMasterResVO;
import com.example.MOERADTEACHER.common.uneecops.master.vo.SchoolMasterResVO;

@Repository
public interface DesignationMasterRepository  extends JpaRepository<DesignationMasterEO,Integer> {

	@Query("Select new com.example.MOERADTEACHER.common.uneecops.master.vo.DesignationMasterResVO"
			+ "(d.id, d.postCode, d.postName, d.status) from DesignationMasterEO d order by d.postName ")
	List<DesignationMasterResVO> findListOfDesignation();
	
	Optional<DesignationMasterEO> findById(Integer id);

	@Query("Select new com.example.MOERADTEACHER.common.uneecops.master.vo.DesignationMasterResVO"
			+ "(d.id,d.postCode, d.postName, d.status) from DesignationMasterEO d where d.status = :status order by d.postName")
	List<DesignationMasterResVO> findActiveAndInactiveDesigantions(@Param("status") Boolean status);
}
