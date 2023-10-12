package com.example.MOERADTEACHER.common.transferrepository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.MOERADTEACHER.common.transfermodel.TeacherKVTransferGround;
import com.example.MOERADTEACHER.common.transfermodel.TransferHistory;

public interface TeacherKVTransferGroundRepository extends JpaRepository<TeacherKVTransferGround, Integer>{
	
	 @Modifying
	   @Transactional
  @Query("delete from TeacherKVTransferGround u where u.teacherId = ?1")
  void deleteByTeacherId(Integer teacherId);
	
}
