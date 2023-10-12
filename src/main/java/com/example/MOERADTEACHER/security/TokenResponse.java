package com.example.MOERADTEACHER.security;

import java.util.List;
import java.util.Map;

//package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class TokenResponse {
	
	private String user_name;
	
	private String token;
	
	private String paramName;

	private String paramValue;
	private String roleId;
	private String schema_name;
	private String stateId;
	private String stateName;
	private String districtName;
	private String groupId;
	
	private String firstname;
	private String lastname;
	private String mobile;
	private String email;
	private String hashId;
	private String refreshToken;
	
//	map.put("firstname", qrObj.getRowValue().get(0).get("firstname"));
//	map.put("lastname", qrObj.getRowValue().get(0).get("lastname"));
//	map.put("mobile", qrObj.getRowValue().get(0).get("mobile"));
//	map.put("email", qrObj.getRowValue().get(0).get("email"));
//	map.put("hashId",hashObj.encrypt(String.valueOf(qrObj.getRowValue().get(0).get("user_id"))));
	
	
	private List<Map<String, Object>> ApplicationDetails;
	
	
	
	public TokenResponse(String username, String token, String paramName, String paramValue, String roleId,
			String schema_name, String stateId, String stateName, String districtName, String groupId, String refreshToken) {
		super();
		this.user_name = username;
		this.token = token;
		this.paramName = paramName;
		this.paramValue = paramValue;
		this.roleId = roleId;
		this.schema_name = schema_name;
		this.stateId = stateId;
		this.stateName = stateName;
		this.districtName = districtName;
		this.groupId = groupId;
		this.refreshToken=refreshToken;
	}
	
	public TokenResponse(String username, String token,List<Map<String, Object>> applicationDetails, String firstname, String lastname, String mobile, String email,String hashId , String refreshToken) {
		super();
		this.user_name = username;
		this.token = token;
		this.paramName = paramName;
		this.paramValue = paramValue;
		this.roleId = roleId;
		this.schema_name = schema_name;
		this.stateId = stateId;
		this.stateName = stateName;
		this.districtName = districtName;
		this.groupId = groupId;
		this.ApplicationDetails=applicationDetails;
	    this.firstname=firstname;
	    this.lastname=lastname;
	    this.mobile=mobile;
	    this.email=email;
	    this.hashId=hashId;
	    this.refreshToken=refreshToken;
	}
	
//	public String getUsername() {
//		return username;
//	}
//	public void setUsername(String username) {
//		this.username = username;
//	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getParamName() {
		return paramName;
	}
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
	public String getParamValue() {
		return paramValue;
	}
	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getSchema_name() {
		return schema_name;
	}
	public void setSchema_name(String schema_name) {
		this.schema_name = schema_name;
	}
	public String getStateId() {
		return stateId;
	}
	public void setStateId(String stateId) {
		this.stateId = stateId;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public List<Map<String, Object>> getApplicationDetails() {
		return ApplicationDetails;
	}

	public void setApplicationDetails(List<Map<String, Object>> applicationDetails) {
		ApplicationDetails = applicationDetails;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHashId() {
		return hashId;
	}

	public void setHashId(String hashId) {
		this.hashId = hashId;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	
	
	

}
