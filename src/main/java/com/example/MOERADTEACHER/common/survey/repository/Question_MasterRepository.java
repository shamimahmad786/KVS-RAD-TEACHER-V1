package com.example.MOERADTEACHER.common.survey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MOERADTEACHER.common.survey.model.Question_Master;

@Repository
public interface Question_MasterRepository extends JpaRepository<Question_Master, Integer> {

//public List<Question_Master> getAllQuestionByBusinessUnit(String business_unit_identity_code);

 List<Question_Master> findAllByBusinessUnitIdentityCode(String business_unit_identity_code);
}
