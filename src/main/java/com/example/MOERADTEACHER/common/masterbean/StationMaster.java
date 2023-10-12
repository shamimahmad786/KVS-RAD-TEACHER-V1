package com.example.MOERADTEACHER.common.masterbean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "kv_station_master", schema = "kv")
public class StationMaster {

	
	@Column(name = "station_id")	
	private Integer	stationId;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	
	@Column(name = "statin_code")	
private String	statinCode;
	@Column(name = "station_name")	
private String	stationName;
	@Column(name = "region_code")	
private String	regionCode;
	
	@Column(name = "region_name")
	private String regionName;
	@Column(name = "station_type")
	private String stationType;
	@Column(name = "very_hard_start_date")
	private Date veryHardStartDate;
	@Column(name = "hard_start_date")
	private Date hardStartDate;
	@Column(name = "hard_end_date")
	private Date hardEndDate;
	@Column(name = "very_hard_flag")
	private Integer veryHardFlag;
	@Column(name = "ever_been_hard")
	private Integer everBeenHard;
	@Column(name = "very_hard_end_date")
	private Date veryHardEndDate;
	
	@Column(name = "normal_start_date")
	private Date normalStartDate;
	@Column(name = "normal_end_date")
	private Date normalEndDate;
	@Column(name = "ever_Been_NER")
	private Integer everBeenNER;

	

	
	
	public Integer getStationId() {
		return stationId;
	}
	public void setStationId(Integer stationId) {
		this.stationId = stationId;
	}
	public String getStatinCode() {
		return statinCode;
	}
	public void setStatinCode(String statinCode) {
		this.statinCode = statinCode;
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
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public String getStationType() {
		return stationType;
	}
	public void setStationType(String stationType) {
		this.stationType = stationType;
	}
	public Date getVeryHardStartDate() {
		return veryHardStartDate;
	}
	public void setVeryHardStartDate(Date veryHardStartDate) {
		this.veryHardStartDate = veryHardStartDate;
	}
	public Date getHardStartDate() {
		return hardStartDate;
	}
	public void setHardStartDate(Date hardStartDate) {
		this.hardStartDate = hardStartDate;
	}
	public Date getHardEndDate() {
		return hardEndDate;
	}
	public void setHardEndDate(Date hardEndDate) {
		this.hardEndDate = hardEndDate;
	}
	public Integer getVeryHardFlag() {
		return veryHardFlag;
	}
	public void setVeryHardFlag(Integer veryHardFlag) {
		this.veryHardFlag = veryHardFlag;
	}
	public Integer getEverBeenHard() {
		return everBeenHard;
	}
	public void setEverBeenHard(Integer everBeenHard) {
		this.everBeenHard = everBeenHard;
	}
	public Date getVeryHardEndDate() {
		return veryHardEndDate;
	}
	public void setVeryHardEndDate(Date veryHardEndDate) {
		this.veryHardEndDate = veryHardEndDate;
	}
	public Date getNormalStartDate() {
		return normalStartDate;
	}
	public void setNormalStartDate(Date normalStartDate) {
		this.normalStartDate = normalStartDate;
	}
	public Date getNormalEndDate() {
		return normalEndDate;
	}
	public void setNormalEndDate(Date normalEndDate) {
		this.normalEndDate = normalEndDate;
	}
	public Integer getEverBeenNER() {
		return everBeenNER;
	}
	public void setEverBeenNER(Integer everBeenNER) {
		this.everBeenNER = everBeenNER;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	
	
	
}
