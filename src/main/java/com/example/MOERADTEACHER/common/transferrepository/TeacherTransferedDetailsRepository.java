package com.example.MOERADTEACHER.common.transferrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.MOERADTEACHER.common.transfermodel.TeacherTransferDetails;
import com.example.MOERADTEACHER.common.transfermodel.TeacherTransferedDetails;

public interface TeacherTransferedDetailsRepository extends JpaRepository<TeacherTransferedDetails, Long>{
	TeacherTransferedDetails    findAllByEmpCode(String empCode);
	@Query(value="from TeacherTransferedDetails u where u.allotKvCode <> null or u.allotKvCode <> -1")
	List<TeacherTransferedDetails>   getAllTransferedList();
}
