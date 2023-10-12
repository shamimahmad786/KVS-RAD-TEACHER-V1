package com.example.MOERADTEACHER.common.transferservice;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MOERADTEACHER.common.transferinterface.SanctionInterface;
import com.example.MOERADTEACHER.common.transfermodel.SanctionDetails;
import com.example.MOERADTEACHER.common.transferrepository.SanctionDetailsRepository;

@Service
@Transactional
public class SanctionImpl implements SanctionInterface{
	
	@Autowired
	SanctionDetailsRepository sanctionDetailsRepository;

	@Override
	public List<SanctionDetails> getSanctionData(String udiseCode) {
		// TODO Auto-generated method stub
		return sanctionDetailsRepository.getAllByUdiseSchCodeOrderByShiftYn(udiseCode);
	}

	@Override
	public List<SanctionDetails> saveSanctionData(List<SanctionDetails> data) {
		// TODO Auto-generated method stub
		return sanctionDetailsRepository.saveAll(data);
	}

}
