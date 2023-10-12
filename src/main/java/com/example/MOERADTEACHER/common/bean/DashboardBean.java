package com.example.MOERADTEACHER.common.bean;

import java.io.Serializable;

public class DashboardBean implements Serializable{
private String businessUnitTypeId;
private String businessUnitTypeCode;
public String getBusinessUnitTypeId() {
	return businessUnitTypeId;
}
public void setBusinessUnitTypeId(String businessUnitTypeId) {
	this.businessUnitTypeId = businessUnitTypeId;
}
public String getBusinessUnitTypeCode() {
	return businessUnitTypeCode;
}
public void setBusinessUnitTypeCode(String businessUnitTypeCode) {
	this.businessUnitTypeCode = businessUnitTypeCode;
}



}
