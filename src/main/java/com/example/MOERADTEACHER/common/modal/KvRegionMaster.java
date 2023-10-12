package com.example.MOERADTEACHER.common.modal;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="kv_mst_region", schema = "kv")
public class KvRegionMaster implements Serializable{
	
	@Id
	@Column(name="region_code")
	private String regionCode;
	
	@Column(name="region_name")
	private String regionName;
	
	@Column(name="region_id")
	private Integer regionId;
	
	
	public String getRegionCode() {
		return regionCode;
	}
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public Integer getRegionId() {
		return regionId;
	}
	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}
	
	

}
