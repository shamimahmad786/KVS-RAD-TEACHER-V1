package com.example.MOERADTEACHER.security.modal;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name="oauth_user_otp_history")
public class UserAuthOtpHistory {
	@Id
	private Long id;
	private Integer otp;
	private String mobile;
	private Date createdBy;
	private String status;
	


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getOtp() {
		return otp;
	}
	public void setOtp(Integer otp) {
		this.otp = otp;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Date getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Date createdBy) {
		this.createdBy = createdBy;
	}

	
	
	@PrePersist
	protected void onCreate() {
	    if (createdBy == null) { createdBy = new Date(); }
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
