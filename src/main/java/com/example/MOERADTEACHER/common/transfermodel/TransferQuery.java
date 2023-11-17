package com.example.MOERADTEACHER.common.transfermodel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="teacher_transfer_query", schema = "transfer")
public class TransferQuery {
@Id	
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="id")
public Long id;
@Column(name="teacher_id")
public Integer teacherId;
@Column(name="teacher_employee_code")
public String teacherEmployeeCode;
@Column(name="query_description")
public String queryDescription;
@Column(name="query_raised_by")
public String queryRaisedBy;
@Column(name="status")
public String status;
@Column(name="query_raised_for")
public String queryRaisedFor;
@Column(name="institution_code")
public String institutionCode;
@Column(name="query_date_time")
public Date queryDateTime;

@PrePersist
void updatedAt() {
  this.queryDateTime = new Date();
}

}
