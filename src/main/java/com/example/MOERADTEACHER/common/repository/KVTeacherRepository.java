package com.example.MOERADTEACHER.common.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MOERADTEACHER.common.modal.KVTeacher;

@Repository
public interface KVTeacherRepository extends JpaRepository<KVTeacher, Integer> {
	
	List<KVTeacher> findByPresentKvCode(String presentKvCode);
	
	List<KVTeacher> findAllByEmail(String email);
	List<KVTeacher> findAllByMobile(String moble);

}
