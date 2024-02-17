package com.example.MOERADTEACHER.common.modal;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "user_auth_logs",schema="audit_tray")
@Data
public class UserActivityLogs {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String ipAddress;
	private String activity;
	private Date loginDateTime;
	private String username;
	
	@PrePersist
	protected void onLoginDateTime() {
	    if (loginDateTime == null) { loginDateTime = new Date(); }
	}
}
