package com.example.MOERADTEACHER.common.transfermodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;





@Entity
@Table(name = "teacher_kvtransfer_ground", schema="transfer")
public class TeacherKVTransferGround {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	@Column(name = "work_experienceid")
	private Integer workExperienceId;
	@Column(name = "teacher_id")
	private Integer teacherId;
	@Column(name = "transferGround_id")
	private Integer transferGroundId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getWorkExperienceId() {
		return workExperienceId;
	}

	public void setWorkExperienceId(Integer workExperienceId) {
		this.workExperienceId = workExperienceId;
	}

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public Integer getTransferGroundId() {
		return transferGroundId;
	}

	public void setTransferGroundId(Integer transferGroundId) {
		this.transferGroundId = transferGroundId;
	}

}
