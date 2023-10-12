package com.example.MOERADTEACHER.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//
@Entity
@Table(name="kvs_login_permission", schema = "public")
public class LoginPermision {
	

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
public Integer id;
    @Column(name = "teacher_employee_code")
public String teacherEmployeeCode;
    @Column(name = "station_code")
public String stationCode;
    @Column(name = "region_code")
public String regionCode;
    public String status;

public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getTeacherEmployeeCode() {
	return teacherEmployeeCode;
}
public void setTeacherEmployeeCode(String teacherEmployeeCode) {
	this.teacherEmployeeCode = teacherEmployeeCode;
}
public String getStationCode() {
	return stationCode;
}
public void setStationCode(String stationCode) {
	this.stationCode = stationCode;
}
public String getRegionCode() {
	return regionCode;
}
public void setRegionCode(String regionCode) {
	this.regionCode = regionCode;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}





}

