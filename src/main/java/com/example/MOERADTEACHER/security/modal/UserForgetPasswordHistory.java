//package com.example.MOERADTEACHER.security.modal;
//
//import java.util.Date;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.PrePersist;
//import javax.persistence.Table;
//
//@Entity
//@Table(name="oauth_forget_password_history")
//public class UserForgetPasswordHistory {
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Long id;
//	private String username;
//	private String mail;
//	private Integer sessionId;
//	private String clientIp;
//	private Date createdDate;
//	private String status;
//	
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public String getUsername() {
//		return username;
//	}
//	public void setUsername(String username) {
//		this.username = username;
//	}
//	public String getMail() {
//		return mail;
//	}
//	public void setMail(String mail) {
//		this.mail = mail;
//	}
//	public Integer getSessionId() {
//		return sessionId;
//	}
//	public void setSessionId(Integer sessionId) {
//		this.sessionId = sessionId;
//	}
//	public String getClientIp() {
//		return clientIp;
//	}
//	public void setClientIp(String clientIp) {
//		this.clientIp = clientIp;
//	}
//	public Date getCreatedDate() {
//		return createdDate;
//	}
//	public void setCreatedDate(Date createdDate) {
//		this.createdDate = createdDate;
//	}
//	
//	
//	
//	@PrePersist
//	protected void onCreate() {
//	    if (createdDate == null) { createdDate = new Date(); }
//	}
//	public String getStatus() {
//		return status;
//	}
//	public void setStatus(String status) {
//		this.status = status;
//	}
//	
//}
