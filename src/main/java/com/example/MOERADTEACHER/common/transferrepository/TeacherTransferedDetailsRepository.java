package com.example.MOERADTEACHER.common.transferrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MOERADTEACHER.common.transfermodel.TeacherTransferDetails;
import com.example.MOERADTEACHER.common.transfermodel.TeacherTransferedDetails;

public interface TeacherTransferedDetailsRepository extends JpaRepository<TeacherTransferedDetails, Long>{
	TeacherTransferedDetails    findAllByEmpCode(String empCode);
}
