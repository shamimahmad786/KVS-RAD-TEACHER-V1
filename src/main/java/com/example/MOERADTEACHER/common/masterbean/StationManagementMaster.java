package com.example.MOERADTEACHER.common.masterbean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "kv_station_management_master", schema = "kv")
public class StationManagementMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	@Column(name = "stationName")
	private String stationName;
	@Column(name = "stationCode")
	private Integer stationCode;
	@Column(name = "isCurrentlyActive")
	private Integer isCurrentlyActive;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public Integer getStationCode() {
		return stationCode;
	}
	public void setStationCode(Integer stationCode) {
		this.stationCode = stationCode;
	}
	public Integer getIsCurrentlyActive() {
		return isCurrentlyActive;
	}
	public void setIsCurrentlyActive(Integer isCurrentlyActive) {
		this.isCurrentlyActive = isCurrentlyActive;
	}

	
	
}
