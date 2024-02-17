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

import lombok.Data;

@Entity
@Table(name="kvs_file_manage", schema = "public")
@Data
public class KvsFileManage {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="id")
public Integer id;
@Column(name="inityear")
public String  inityear;
@Column(name="transfer_order_number")
public String transferOrderNumber;
@Temporal(TemporalType.DATE)
@Column(name="transfer_order_date")
public Date transferOrderDate;
@Column(name="file_type")
public String fileType;
@Column(name="description")
public String description;
@Temporal(TemporalType.DATE)
@Column(name="created_time")
public Date createdTime;
@Column(name="created_by")
public String createdBy;
@Column(name="no_of_associated_employee")
public Integer noOfAssociatedEmployee;
@Column(name="document_title")
public String documentTitle;


@PrePersist
protected void onCreate() {
    if (createdTime == null) { createdTime = new Date(); }
}

}
