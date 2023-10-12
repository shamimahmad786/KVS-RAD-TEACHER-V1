package com.example.MOERADTEACHER.common.transferrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MOERADTEACHER.common.transfermodel.SanctionDetails;
import com.example.MOERADTEACHER.common.transfermodel.TeacherKVTransferGround;

public interface SanctionDetailsRepository  extends JpaRepository<SanctionDetails, Integer>{
	List<SanctionDetails>  getAllByUdiseSchCodeOrderByShiftYn(String udiseSchCode);
}
