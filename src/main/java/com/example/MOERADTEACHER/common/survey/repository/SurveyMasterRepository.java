package com.example.MOERADTEACHER.common.survey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MOERADTEACHER.common.survey.model.SurveyMaster;

@Repository
public interface SurveyMasterRepository extends JpaRepository<SurveyMaster, Integer> {

	List<SurveyMaster> findAllByCreatedByUser(String udisecode);
}
