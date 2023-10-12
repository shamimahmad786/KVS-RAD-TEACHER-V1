package com.example.MOERADTEACHER.common.transferrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MOERADTEACHER.common.transfermodel.TeacherTransferDeclaration;
import com.example.MOERADTEACHER.common.transfermodel.TeacherTransferDetails;

public interface TeacherTransferDeclarationRepository extends JpaRepository<TeacherTransferDeclaration, Long> {
	TeacherTransferDeclaration findByTeacherId(Integer teacherId);
}
