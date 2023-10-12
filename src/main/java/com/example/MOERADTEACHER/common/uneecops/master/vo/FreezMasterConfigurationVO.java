package com.example.MOERADTEACHER.common.uneecops.master.vo;

import java.time.LocalDate;

import lombok.Data;
@Data
public class FreezMasterConfigurationVO {
	private String operation;
	private LocalDate year;
	private LocalDate fromDate;
	private boolean is_allowed;

}
