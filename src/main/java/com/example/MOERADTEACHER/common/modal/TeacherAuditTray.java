package com.example.MOERADTEACHER.common.modal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "teacher_audit_tray",schema="history")
public class TeacherAuditTray {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="id")
private Integer id;
@Column(name="username")
private String username;
@Column(name="api")
private String api;
@Column(name="ip")
private String ip;
@Temporal(TemporalType.TIMESTAMP)
@Column(name="dateTime")
private Date dateTime;

@PrePersist
protected void onCreate() {
    if (dateTime == null) { dateTime = new Date(); }
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getUser() {
	return username;
}

public void setUser(String user) {
	this.username = user;
}

public String getApi() {
	return api;
}

public void setApi(String api) {
	this.api = api;
}

public String getIp() {
	return ip;
}

public void setIp(String ip) {
	this.ip = ip;
}

public Date getDateTime() {
	return dateTime;
}

public void setDateTime(Date dateTime) {
	this.dateTime = dateTime;
}


}
