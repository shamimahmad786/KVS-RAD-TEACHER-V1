package com.example.MOERADTEACHER.common.transferrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MOERADTEACHER.common.transfermodel.TeacherKVTransferGround;
import com.example.MOERADTEACHER.common.transfermodel.TeacherTransferConfirmation;

public interface TeacherTransferConfirmationRepository extends JpaRepository<TeacherTransferConfirmation, Long>{

}
