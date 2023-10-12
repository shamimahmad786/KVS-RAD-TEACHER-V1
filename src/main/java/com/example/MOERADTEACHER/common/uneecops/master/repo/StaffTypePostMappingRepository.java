package com.example.MOERADTEACHER.common.uneecops.master.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MOERADTEACHER.common.uneecops.master.eo.StaffTypePostMappingEO;
@Repository
public interface StaffTypePostMappingRepository extends JpaRepository<StaffTypePostMappingEO, Integer>{

}
