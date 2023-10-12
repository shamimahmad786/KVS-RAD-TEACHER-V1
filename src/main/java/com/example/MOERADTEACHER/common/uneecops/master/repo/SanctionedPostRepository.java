package com.example.MOERADTEACHER.common.uneecops.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MOERADTEACHER.common.uneecops.master.eo.SanctionedPostEo;

public interface SanctionedPostRepository extends JpaRepository<SanctionedPostEo, Integer> {

	List<SanctionedPostEo> findBySchoolCode(int schoolCode);
	SanctionedPostEo findById(int id);
	

	
	}
