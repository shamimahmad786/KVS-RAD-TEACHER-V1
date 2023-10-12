package com.example.MOERADTEACHER.common.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

//import com.example.MOERADTEACHER.common.modal.TeacherTraining;
import com.example.MOERADTEACHER.common.modal.TeacherTransferGround;

public interface TeacherTransferGroundRepository extends JpaRepository<TeacherTransferGround, Integer>{
	
     	 @Modifying
     	   @Transactional
	    @Query("delete from TeacherTransferGround u where u.teacherId = ?1")
	    void deleteAllByTeacherId(Integer teacherId);
}
