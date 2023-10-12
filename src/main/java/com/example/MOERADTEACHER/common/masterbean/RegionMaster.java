package com.example.MOERADTEACHER.common.masterbean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "kv_mst_region", schema = "kv")
public class RegionMaster {
	@Id
	@Column(name = "region_code")
	private Integer regionCode;
	@Column(name = "region_name")
	private String regionName;
	@Column(name = "region_id")
	private Integer regionId;
	public Integer getRegionCode() {
		return regionCode;
	}
	public void setRegionCode(Integer regionCode) {
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
