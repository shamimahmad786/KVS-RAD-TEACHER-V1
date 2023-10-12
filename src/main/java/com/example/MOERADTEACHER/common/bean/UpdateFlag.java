package com.example.MOERADTEACHER.common.bean;

import java.io.Serializable;

public class UpdateFlag implements Serializable{
public String updateType;
public String status;
public String getUpdateType() {
	return updateType;
}
public void setUpdateType(String updateType) {
	this.updateType = updateType;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}




}
