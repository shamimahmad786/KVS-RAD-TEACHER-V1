package com.example.MOERADTEACHER.common.modal;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="kv_moe_report", schema = "public")
@Data
public class KvsReport implements Serializable{

	@Id
	@Column(name="id")
	private String id;
	private Integer reportId;
	private String reportName;
	private String reportType;
	private String reportDescription;
	private Integer status;
	
	
}
