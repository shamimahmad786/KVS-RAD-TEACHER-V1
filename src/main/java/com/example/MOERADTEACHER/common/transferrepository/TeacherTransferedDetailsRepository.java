package com.example.MOERADTEACHER.common.transferrepository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.MOERADTEACHER.common.transfermodel.TeacherTransferDetails;
import com.example.MOERADTEACHER.common.transfermodel.TeacherTransferedDetails;

public interface TeacherTransferedDetailsRepository extends JpaRepository<TeacherTransferedDetails, Long>{
	
	List<TeacherTransferedDetails>    findByEmpCode(String empCode);
	
	@Query(value="from TeacherTransferedDetails u where u.empCode =?1 and u.joinDate Is Null ")
	List<TeacherTransferedDetails>    getByEmpCode(String empCode);
	
	@Query(value="from TeacherTransferedDetails u where u.allotKvCode <> null or u.allotKvCode <> -1")
	List<TeacherTransferedDetails>   getAllTransferedList();
	
	@Modifying
	   @Transactional
	@Query(value="delete from TeacherTransferedDetails u where u.allotKvCode = ?1 and teacherId = ?2")
	void deleteByAllotKvCodeAndTeacherId(String allotKvCode, Integer teacherId);
}
