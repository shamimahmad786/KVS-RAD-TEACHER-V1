package com.example.MOERADTEACHER.common.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MOERADTEACHER.common.modal.Teacher;


@Repository
public interface TeacherRepository  extends JpaRepository<Teacher, BigInteger>{
List<Teacher> findAllByUdiseSchCode(String udisecode);

}
