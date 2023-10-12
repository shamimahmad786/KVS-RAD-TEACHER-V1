package com.example.MOERADTEACHER.common.uneecops.master.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MOERADTEACHER.common.uneecops.master.eo.FreezMasterConfigurationEO;

@Repository
public interface FreezMasterConfigurationRepository extends JpaRepository<FreezMasterConfigurationEO, Integer> {

}
