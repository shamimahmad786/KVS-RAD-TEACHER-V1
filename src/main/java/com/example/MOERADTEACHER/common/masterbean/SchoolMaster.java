package com.example.MOERADTEACHER.common.masterbean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "kv_school_master", schema = "kv")
//@Table(name = "kvschool", schema = "kv")
public class SchoolMaster {
	@Id
	@Column(name = "id")
private Integer	id;
	@Column(name = "region_code")
private String	regionCode;
	@Column(name = "region_name")
private String	regionName;
	@Column(name = "station_code")
private String	stationCode;
	@Column(name = "station_name")
private String	stationName;
	@Column(name = "kv_code")
private String	kvCode;
	@Column(name = "kv_name")
private String	kvName;
	@Column(name = "state_name")
private String	stateName;
	@Column(name = "district_name")
private String	districtName;
	@Column(name = "udise_sch_code")
private String	udiseSchCode;
	@Column(name = "station_type")
private String	stationType;
	@Column(name = "remarks")
private String	remarks;
	
	@Column(name = "shift_yn")
	private Integer shiftYn;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	public String getStationCode() {
		return stationCode;
	}
	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public String getKvCode() {
		return kvCode;
	}
	public void setKvCode(String kvCode) {
		this.kvCode = kvCode;
	}
	public String getKvName() {
		return kvName;
	}
	public void setKvName(String kvName) {
		this.kvName = kvName;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public String getUdiseSchCode() {
		return udiseSchCode;
	}
	public void setUdiseSchCode(String udiseSchCode) {
		this.udiseSchCode = udiseSchCode;
	}
	public String getStationType() {
		return stationType;
	}
	public void setStationType(String stationType) {
		this.stationType = stationType;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Integer getShiftYn() {
		return shiftYn;
	}
	public void setShiftYn(Integer shiftYn) {
		this.shiftYn = shiftYn;
	}
	
	
	

}
