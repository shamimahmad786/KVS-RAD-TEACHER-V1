package com.example.MOERADTEACHER.common.transferbean;

import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
public class SearchBeans {
public List<String> teacherEmployeeCode;
public String teacherName;
public String teacherEmail;
public String teacherMobile;
@Temporal(TemporalType.DATE)
public Date teacherDob;
}
