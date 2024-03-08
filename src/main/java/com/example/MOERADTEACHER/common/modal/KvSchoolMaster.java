package com.example.MOERADTEACHER.common.modal;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
//@Table(name="kvschool", schema = "kv")
@Table(name = "kv_school_master", schema = "kv")
public class KvSchoolMaster implements Serializable{
			
		@Id
		@Column(name="kv_code")
		private String kvCode;
		
		@Column(name="region_code")
		private String regionCode;
		
		@Column(name="region_name")
		private String regionName;
		
		@Column(name="station_code")
		private String stationCode;
		
		@Column(name="station_name")
		private String stationName;		
		
		@Column(name="kv_name")
		private String kvName;
		
		@Column(name="state_name")
		private String stateName;
		
		@Column(name="district_name")
		private String districtName;
		
		@Column(name="udise_sch_code")
		private String udiseSchCode;
		
		@Column(name="station_type")
		private String stationType;
		
		@Column(name="remarks")
		private String remarks;
		
		@Column(name="id")
		private String id;
		
		@Column(name="school_type")
		private String schoolType;
		
		@Column(name="shift_type")
		private String shiftType; 


		@JsonProperty(value="regionName", access=JsonProperty.Access.READ_ONLY)
		public String getRegionName() {
			return regionName;
		}
		@JsonProperty(value="region_name", access=JsonProperty.Access.WRITE_ONLY)
		public void setRegionName(String regionName) {
			this.regionName = regionName;
		}

		@JsonProperty(value="stationCode", access=JsonProperty.Access.READ_ONLY)
		public String getStationCode() {
			return stationCode;
		}
		@JsonProperty(value="station_code", access=JsonProperty.Access.WRITE_ONLY)
		public void setStationCode(String stationCode) {
			this.stationCode = stationCode;
		}
		@JsonProperty(value="stationName", access=JsonProperty.Access.READ_ONLY)
		public String getStationName() {
			return stationName;
		}
		@JsonProperty(value="station_name", access=JsonProperty.Access.WRITE_ONLY)
		public void setStationName(String stationName) {
			this.stationName = stationName;
		}
		@JsonProperty(value="kvCode", access=JsonProperty.Access.READ_ONLY)
		public String getKvCode() {
			return kvCode;
		}
		@JsonProperty(value="kv_code", access=JsonProperty.Access.WRITE_ONLY)
		public void setKvCode(String kvCode) {
			this.kvCode = kvCode;
		}
		@JsonProperty(value="kvName", access=JsonProperty.Access.READ_ONLY)
		public String getKvName() {
			return kvName;
		}
		@JsonProperty(value="kv_name", access=JsonProperty.Access.WRITE_ONLY)
		public void setKvName(String kvName) {
			this.kvName = kvName;
		}
		@JsonProperty(value="stateName", access=JsonProperty.Access.READ_ONLY)
		public String getStateName() {
			return stateName;
		}
		@JsonProperty(value="state_name", access=JsonProperty.Access.WRITE_ONLY)
		public void setStateName(String stateName) {
			this.stateName = stateName;
		}
		@JsonProperty(value="districtName", access=JsonProperty.Access.READ_ONLY)
		public String getDistrictName() {
			return districtName;
		}
		@JsonProperty(value="district_name", access=JsonProperty.Access.WRITE_ONLY)
		public void setDistrictName(String districtName) {
			this.districtName = districtName;
		}
		@JsonProperty(value="udiseSchCode", access=JsonProperty.Access.READ_ONLY)
		public String getUdiseSchCode() {
			return udiseSchCode;
		}
		@JsonProperty(value="udise_sch_code", access=JsonProperty.Access.WRITE_ONLY)
		public void setUdiseSchCode(String udiseSchCode) {
			this.udiseSchCode = udiseSchCode;
		}
		@JsonProperty(value="stationType", access=JsonProperty.Access.READ_ONLY)
		public String getStationType() {
			return stationType;
		}
		@JsonProperty(value="station_type", access=JsonProperty.Access.WRITE_ONLY)
		public void setStationType(String stationType) {
			this.stationType = stationType;
		}
		@JsonProperty(value="remarks", access=JsonProperty.Access.READ_ONLY)
		public String getRemarks() {
			return remarks;
		}
		@JsonProperty(value="remarks", access=JsonProperty.Access.WRITE_ONLY)
		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}
		@JsonProperty(value="id", access=JsonProperty.Access.READ_ONLY)
		public String getId() {
			return id;
		}
		@JsonProperty(value="id", access=JsonProperty.Access.WRITE_ONLY)
		public void setId(String id) {
			this.id = id;
		}
		@JsonProperty(value="regionCode", access=JsonProperty.Access.READ_ONLY)
		public String getRegionCode() {
			return regionCode;
		}
		@JsonProperty(value="region_code", access=JsonProperty.Access.WRITE_ONLY)
		public void setRegionCode(String regionCode) {
			this.regionCode = regionCode;
		}
		@JsonProperty(value="schoolType", access=JsonProperty.Access.READ_ONLY)
		public String getSchoolType() {
			return schoolType;
		}
		@JsonProperty(value="school_type", access=JsonProperty.Access.WRITE_ONLY)
		public void setSchoolType(String schoolType) {
			this.schoolType = schoolType;
		}
		@JsonProperty(value="shiftType", access=JsonProperty.Access.READ_ONLY)
		public String getShiftType() {
			return shiftType;
		}
		@JsonProperty(value="shift_type", access=JsonProperty.Access.WRITE_ONLY)
		public void setShiftType(String shiftType) {
			this.shiftType = shiftType;
		}
		
		
		

		
		
		

}
