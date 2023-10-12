package com.example.MOERADTEACHER.common.transferinterface;

import java.util.List;
import java.util.Map;

import com.example.MOERADTEACHER.common.transfermodel.SanctionDetails;

public interface SanctionInterface {
	 List<SanctionDetails>	getSanctionData(String udiseCode);
	 List<SanctionDetails> saveSanctionData(List<SanctionDetails> data);
 }
