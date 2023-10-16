package com.example.MOERADTEACHER.common.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MOERADTEACHER.common.modal.KvStationMaster;
import com.example.MOERADTEACHER.common.modal.KvsControllerOffice;

public interface KvsControllerOfficeRepository extends JpaRepository<KvsControllerOffice, String>{
	List<KvsControllerOffice>  findAllByControllerTypeAndIsActive(String controllerType,String isActive);
}
