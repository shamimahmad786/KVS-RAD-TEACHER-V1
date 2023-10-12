package com.example.MOERADTEACHER.common.uneecops.master.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MOERADTEACHER.common.uneecops.master.eo.PostSubjectMappingEo;
@Repository
public interface PostSubjectMappingRepository extends JpaRepository<PostSubjectMappingEo, Integer>{

}
