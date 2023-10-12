package com.example.MOERADTEACHER.common.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KVSchoolBean {
private String stationName;
private String stationCode;
private String kvName;
private String kvCode;
@JsonProperty(value="stationName", access=JsonProperty.Access.READ_ONLY)
public String getStationName() {
	return stationName;
}
@JsonProperty(value="station_name", access=JsonProperty.Access.WRITE_ONLY)
public void setStationName(String stationName) {
	this.stationName = stationName;
}
@JsonProperty(value="stationCode", access=JsonProperty.Access.READ_ONLY)
public String getStationCode() {
	return stationCode;
}
@JsonProperty(value="station_code", access=JsonProperty.Access.WRITE_ONLY)
public void setStationCode(String stationCode) {
	this.stationCode = stationCode;
}
@JsonProperty(value="kvName", access=JsonProperty.Access.READ_ONLY)
public String getKvName() {
	return kvName;
}
@JsonProperty(value="kv_name", access=JsonProperty.Access.WRITE_ONLY)
public void setKvName(String kvName) {
	this.kvName = kvName;
}
@JsonProperty(value="kvCode", access=JsonProperty.Access.READ_ONLY)
public String getKvCode() {
	return kvCode;
}
@JsonProperty(value="kv_code", access=JsonProperty.Access.WRITE_ONLY)
public void setKvCode(String kvCode) {
	this.kvCode = kvCode;
}




}
