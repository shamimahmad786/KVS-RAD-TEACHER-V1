package com.example.MOERADTEACHER.common.masterservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.MOERADTEACHER.common.masterbean.RegionMaster;
import com.example.MOERADTEACHER.common.masterbean.StationManagementMaster;
import com.example.MOERADTEACHER.common.masterbean.StationMaster;
import com.example.MOERADTEACHER.common.masterrepository.RegionMasterRepository;
import com.example.MOERADTEACHER.common.masterrepository.StationManagementMasterRepository;
import com.example.MOERADTEACHER.common.util.CustomResponse;

@Service
public class MasterManagementImpl {

	@Autowired
	StationManagementMasterRepository stationManagementMasterRepository;
	
	@Autowired
	RegionMasterRepository regionMasterRepository;
	
	@RequestMapping(value = "/saveStationMaster", method = RequestMethod.POST)
	public StationMaster saveStationMaster(StationMaster data) throws Exception {
		return stationManagementMasterRepository.save(data);
//		return null;
	}
	
	public List<RegionMaster> getRegionMaster() throws Exception {
		return regionMasterRepository.findAll();
	}
	
	public RegionMaster saveRegionMaster(RegionMaster rdata) throws Exception {
		return regionMasterRepository.save(rdata);
	}
	
	public void deleteRegionMaster(Integer id) throws Exception {
		 regionMasterRepository.deleteById(id);
	}
	
	
	public  List<StationMaster> getStationMaster() throws Exception {
		return stationManagementMasterRepository.findAllByOrderByStationNameAsc();
	}
//	getStationMaster
	
	public void deleteStationMaster(String id) throws Exception {
		stationManagementMasterRepository.deleteByStatinCode(id);
	}
	
	
	
	
	
}
