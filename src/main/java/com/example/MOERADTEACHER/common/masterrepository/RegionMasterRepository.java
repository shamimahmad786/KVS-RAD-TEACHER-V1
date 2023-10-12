package com.example.MOERADTEACHER.common.masterrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MOERADTEACHER.common.masterbean.RegionMaster;
import com.example.MOERADTEACHER.common.masterbean.TeacherAwardsMaster;

@Repository
public interface RegionMasterRepository  extends JpaRepository<RegionMaster, Integer> {
List<RegionMaster> findByOrderByRegionNameAsc();
}
