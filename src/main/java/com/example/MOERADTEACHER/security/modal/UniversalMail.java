package com.example.MOERADTEACHER.security.modal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;



@Entity
@Table(name = "auth_universal_mail", schema="public")
public class UniversalMail {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    @Column(name = "clientip")
	private String clientIp;
    @Column(name = "mail")
	private String mail;
    @Column(name = "sessionid")
	private String sessionId;
    @Column(name = "mailtype")
	private String mailType;
    @Column(name = "username")
	private String userName;
    @Column(name = "status")
	private String status;
    @Column(name = "createddate")
	private Date createdDate;
    @Column(name = "expirytimeinsecond")
	private Integer expiryTimeInSecond; 
	
	
	@PrePersist
	protected void onCreate() {
	    if (createdDate == null) { createdDate = new Date(); }
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getClientIp() {
		return clientIp;
	}


	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getSessionId() {
		return sessionId;
	}


	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}


	public String getMailType() {
		return mailType;
	}


	public void setMailType(String mailType) {
		this.mailType = mailType;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public Integer getExpiryTimeInSecond() {
		return expiryTimeInSecond;
	}


	public void setExpiryTimeInSecond(Integer expiryTimeInSecond) {
		this.expiryTimeInSecond = expiryTimeInSecond;
	}


	
}
