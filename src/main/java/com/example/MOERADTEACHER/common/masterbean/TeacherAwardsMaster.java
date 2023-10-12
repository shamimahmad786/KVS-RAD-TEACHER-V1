package com.example.MOERADTEACHER.common.masterbean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mst_teacher_award", schema = "master")
public class TeacherAwardsMaster {

	@Id
	@Column(name = "award_id")
	private Integer awardId;
	@Column(name = "award_name")
	private String awardName;
	public Integer getAwardId() {
		return awardId;
	}
	public void setAwardId(Integer awardId) {
		this.awardId = awardId;
	}
	public String getAwardName() {
		return awardName;
	}
	public void setAwardName(String awardName) {
		this.awardName = awardName;
	}
	
	
	
}
