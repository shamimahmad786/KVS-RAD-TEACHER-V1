package com.example.MOERADTEACHER.common.uneecops.master.eo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="m_station", schema = "uneecops")
public class StationEo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="station_code")
	private Integer stationCode;
	@Column(name="station_name")
	private String stationName;
	
	@Column(name="created_by")
	private String createdBy;
	@Column(name="created_on")
	private Timestamp createdDate;
	@Column(name="updated_by")
	private String updatedBy;
	@Column(name="updated_on")
	private Timestamp updatedDate;
	@Column(name="is_active")
	private boolean isActive;
	
	
	public Integer getStationCode() {
		return stationCode;
	}
	public void setStationCode(Integer stationCode) {
		this.stationCode = stationCode;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Timestamp getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
	
	
	
	
	
}
