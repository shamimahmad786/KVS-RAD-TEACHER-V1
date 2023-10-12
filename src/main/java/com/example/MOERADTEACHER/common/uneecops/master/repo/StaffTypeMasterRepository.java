package com.example.MOERADTEACHER.common.uneecops.master.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.MOERADTEACHER.common.uneecops.master.eo.StaffTypeMasterEO;
import com.example.MOERADTEACHER.common.uneecops.master.vo.DesignationMasterResVO;
import com.example.MOERADTEACHER.common.uneecops.master.vo.StaffTypeMasterResVO;

@Repository
public interface StaffTypeMasterRepository extends JpaRepository<StaffTypeMasterEO, Integer> {

	@Query("Select new com.example.MOERADTEACHER.common.uneecops.master.vo.StaffTypeMasterResVO"
			+ "(st.id, st.staffType, st.status) from StaffTypeMasterEO st order by st.createdDate desc")
	List<StaffTypeMasterResVO> findListOfStaffType();

	Optional<StaffTypeMasterEO> findById(Integer id);

	@Query("Select new com.example.MOERADTEACHER.common.uneecops.master.vo.StaffTypeMasterResVO"
			+ "(s.id, s.staffType, s.status) from StaffTypeMasterEO s where s.status = :status order by s.staffType")
	
	List<StaffTypeMasterResVO> findActiveAndInactiveStaffType(@Param("status") Boolean status);

}
