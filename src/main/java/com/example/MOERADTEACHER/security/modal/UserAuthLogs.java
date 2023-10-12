package com.example.MOERADTEACHER.security.modal;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

@Entity(name = "user_auth_logs")
public class UserAuthLogs {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String ipAddress;
	private String activity;
	private Date loginDateTime;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public Date getLoginDateTime() {
		return loginDateTime;
	}
	public void setLoginDateTime(Date loginDateTime) {
		this.loginDateTime = loginDateTime;
	}
	
	@PrePersist
	protected void onLoginDateTime() {
	    if (loginDateTime == null) { loginDateTime = new Date(); }
	}
	
}
