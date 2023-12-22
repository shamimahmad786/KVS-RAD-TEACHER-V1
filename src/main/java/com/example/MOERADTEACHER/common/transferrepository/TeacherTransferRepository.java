package com.example.MOERADTEACHER.common.transferrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MOERADTEACHER.common.transfermodel.TeacherTransferDetails;
import com.example.MOERADTEACHER.common.transfermodel.TransferHistory;

public interface TeacherTransferRepository extends JpaRepository<TeacherTransferDetails, Integer>{
	TeacherTransferDetails findAllByTeacherId(Integer teacherId);
	TeacherTransferDetails findAllByTeacherIdAndInityear(Integer teacherId,String inityear);
}
