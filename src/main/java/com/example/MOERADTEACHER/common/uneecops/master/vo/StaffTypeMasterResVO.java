package com.example.MOERADTEACHER.common.uneecops.master.vo;

import lombok.Data;

@Data
public class StaffTypeMasterResVO {
	private Integer id;
	private String staffType;
	private Boolean status;
	public StaffTypeMasterResVO(Integer id, String staffType, Boolean status) {
		super();
		this.id = id;
		this.staffType = staffType;
		this.status = status;
	}

}
