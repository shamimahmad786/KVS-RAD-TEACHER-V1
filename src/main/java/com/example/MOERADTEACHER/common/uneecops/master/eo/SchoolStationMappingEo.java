package com.example.MOERADTEACHER.common.uneecops.master.eo;

import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="school_station_mapping" ,schema="uneecops")
public class SchoolStationMappingEo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="kv_code")
	private Integer schoolCode;
	@Column(name="station_code")
	private Integer stationCode;
	
	
	//private String shift;
	@Column(name="from_date")
	private LocalDate fromDate;
	@Column(name="to_date")
	private LocalDate toDate;
	@Column(name="is_active")
	private boolean isActive;
	
	@Column(name="created_by")
	private String createdBy;
	@Column(name="created_on")
	private Timestamp createdDate;
	@Column(name="updated_by")
	private String updatedBy;
	@Column(name="updated_on")
	private Timestamp updatedDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getSchoolCode() {
		return schoolCode;
	}
	public void setSchoolCode(Integer schoolCode) {
		this.schoolCode = schoolCode;
	}
	public Integer getStationCode() {
		return stationCode;
	}
	public void setStationCode(Integer stationCode) {
		this.stationCode = stationCode;
	}
	public LocalDate getFromDate() {

		return fromDate;
	}
	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}
	public LocalDate getToDate() {
		return toDate;
	}
	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}
	
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
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
	@Override
	public String toString() {
		return "SchoolStationMappingEo [id=" + id + ", schoolCode=" + schoolCode + ", stationCode=" + stationCode
				+ ", fromDate=" + fromDate + ", toDate=" + toDate + ", isActive=" + isActive + ", createdBy="
				+ createdBy + ", createdDate=" + createdDate + ", updatedBy=" + updatedBy + ", updatedDate="
				+ updatedDate + "]";
	}
	
	
	
}
