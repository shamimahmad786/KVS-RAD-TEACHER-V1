package com.example.MOERADTEACHER.common.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransferSpouseBean implements Serializable{

	private Integer teacherid;
	private String work_experience_position_type_present_kv;
	private String station_name;
	private String station_code;

	@JsonProperty(value="teacherId", access=JsonProperty.Access.READ_ONLY)
	public Integer getTeacherid() {
		return teacherid;
	}

	@JsonProperty(value="teacher_id", access=JsonProperty.Access.WRITE_ONLY)
	public void setTeacherid(Integer teacherid) {
		this.teacherid = teacherid;
	}

	@JsonProperty(value="workExperiencePositionTypePresentKv", access=JsonProperty.Access.READ_ONLY)
	public String getWork_experience_position_type_present_kv() {
		return work_experience_position_type_present_kv;
	}

	@JsonProperty(value="work_experience_position_type_present_kv", access=JsonProperty.Access.WRITE_ONLY)
	public void setWork_experience_position_type_present_kv(String work_experience_position_type_present_kv) {
		this.work_experience_position_type_present_kv = work_experience_position_type_present_kv;
	}

	@JsonProperty(value="stationName", access=JsonProperty.Access.READ_ONLY)
	public String getPresent_station_name() {
		return station_name;
	}

	@JsonProperty(value="station_name", access=JsonProperty.Access.WRITE_ONLY)
	public void setPresent_station_name(String present_station_name) {
		this.station_name = present_station_name;
	}

	@JsonProperty(value="stationCode", access=JsonProperty.Access.READ_ONLY)
	public String getPresent_station_code() {
		return station_code;
	}

	@JsonProperty(value="station_code", access=JsonProperty.Access.WRITE_ONLY)
	public void setPresent_station_code(String present_station_code) {
		this.station_code = present_station_code;
	}
	
	

	
	
}
