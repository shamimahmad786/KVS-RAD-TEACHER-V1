package com.example.MOERADTEACHER.common.modal;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="kv_station_master", schema = "kv")
public class KvStationMaster implements Serializable{
	
	@Id
	@Column(name="statin_code")
	private String statinCode;
	
	@Column(name="station_id")
	private Integer stationId;
	
	@Column(name="station_name")
	private String stationName;
	
	@Column(name="region_code")
	private String regionCode;

	public String getStatinCode() {
		return statinCode;
	}

	public void setStatinCode(String statinCode) {
		this.statinCode = statinCode;
	}

	public Integer getStationId() {
		return stationId;
	}

	public void setStationId(Integer stationId) {
		this.stationId = stationId;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}
	
	

}
