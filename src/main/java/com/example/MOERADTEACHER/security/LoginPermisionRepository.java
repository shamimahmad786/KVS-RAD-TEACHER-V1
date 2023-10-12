package com.example.MOERADTEACHER.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginPermisionRepository extends JpaRepository<LoginPermision, Integer>{
	LoginPermision	findAllByTeacherEmployeeCode(String teacherEmployeeCode);
}