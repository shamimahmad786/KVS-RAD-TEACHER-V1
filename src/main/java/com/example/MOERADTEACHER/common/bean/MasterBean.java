package com.example.MOERADTEACHER.common.bean;

import java.io.Serializable;
import java.util.List;

public class MasterBean implements Serializable{
private String extcall;
private List conditionvalue;
public String getExtcall() {
	return extcall;
}
public void setExtcall(String extcall) {
	this.extcall = extcall;
}
public List getConditionvalue() {
	return conditionvalue;
}
public void setConditionvalue(List conditionvalue) {
	this.conditionvalue = conditionvalue;
}


}
