package com.example.MOERADTEACHER.common.masterrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MOERADTEACHER.common.masterbean.PositionType;
import com.example.MOERADTEACHER.common.survey.model.Question_Master;

@Repository
public interface PositionTypeRepository  extends JpaRepository<PositionType, Integer>{
List<PositionType> findAllByConfiguredBusinessUnitTypeId(Integer configuredBusinessUnitTypeId);
List<PositionType> findByConfiguredBusinessUnitTypeIdAndActiveStatusOrderByOrganizationTeacherTypeNameAsc(Integer configuredBusinessUnitTypeId,String activeStatus);
List<PositionType> findByConfiguredBusinessUnitTypeIdOrderByOrganizationTeacherTypeNameAsc(Integer configuredBusinessUnitTypeId);
}
