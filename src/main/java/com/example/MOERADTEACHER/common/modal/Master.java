package com.example.MOERADTEACHER.common.modal;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "moe_ms_extmaster", schema="public")
public class Master implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	@Column(name="extcall")
	private String extcall;
	@Column(name="columnname")
	private String columnname;
	@Column(name="tablename")
	private String tablename;
	@Column(name="conditions")
	private String conditions;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getExtcall() {
		return extcall;
	}
	public void setExtcall(String extcall) {
		this.extcall = extcall;
	}
	public String getColumnname() {
		return columnname;
	}
	public void setColumnname(String columnname) {
		this.columnname = columnname;
	}
	public String getTablename() {
		return tablename;
	}
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	public String getConditions() {
		return conditions;
	}
	public void setConditions(String conditions) {
		this.conditions = conditions;
	}
	
	
	
}
