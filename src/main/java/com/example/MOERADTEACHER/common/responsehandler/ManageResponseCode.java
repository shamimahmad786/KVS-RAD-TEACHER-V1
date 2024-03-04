package com.example.MOERADTEACHER.common.responsehandler;

public enum ManageResponseCode {
	RES0001("RES0001","Duplicate Mobile Number"),
	RES0002("RES0002","Duplicate User Name"),
	RES0003("RES0003","User Create Successfully"),
	RES0004("RES0004","Invalid Mobile Number"),
	RES0005("RES0005","Mobile Number Updated Successfully"),
	RES0006("RES0006","Email Updated Successfully"),
	RES0007("RES0007","Invalid Email Id"),
	RES0008("RES0008","User is not created"),
	RES0009("RES0009","Password Updated Sucessfully"),
	RES0010("RES0010","Error occured during password generation"),
	RES0011("RES0011","User update sucessfully"),
	RES0012("RES0012","Error in User Update"),
	RES0013("RES0013","User is not active"),
	RES0014("RES0014","User Mapping Successfully"),
	RES0015("RES0015","Get User Mapping Successfully"),
	RES0016("RES0016","Duplicate Mobile Number"),
	RES0017("RES0017","Duplicate Email Id"),
	RES0018("RES0018","Session Exipred"),
	RES0019("RES0019","Error in employee move to dropbox"),
	RES0020("RES0020","Employee Successfully move to dropbox"),
	RES0021("RES0021","Employee Successfully Imported"),
	RES0022("RES0022","Error in employee Import"),
	RES0023("RES0023","Error in update employee name"),
	RES0024("RES0024","Employee name updated Successfully"),
	RES0026("RES0026","Employee revoked Successfully"),
	RES0027("RES0027","Getting error in Employee revoke"),
	;
	
	
 private ManageResponseCode(String statusCode, String statusDesc) {
		this.statusCode = statusCode;
		this.statusDesc = statusDesc;
	}
 
String statusCode;
String statusDesc;

public String getStatusCode() {
	return statusCode;
}
public void setStatusCode(String statusCode) {
	this.statusCode = statusCode;
}
public String getStatusDesc() {
	return statusDesc;
}
public void setStatusDesc(String statusDesc) {
	this.statusDesc = statusDesc;
}




}
