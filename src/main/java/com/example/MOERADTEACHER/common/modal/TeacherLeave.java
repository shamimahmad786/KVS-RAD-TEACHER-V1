package com.example.MOERADTEACHER.common.modal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "kvs_teacher_leave", schema="public")
public class TeacherLeave {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "kvsTeacherLeaveIdSeq")
	@SequenceGenerator(name = "kvsTeacherLeaveIdSeq", sequenceName = "kvs_teacher_leave_id_seq", allocationSize=1)
	@Column(name = "id")
	public Long id;
	@Column(name = "teacher_id")
	public Integer teacherId;
	@Column(name = "is_continious_leave")
	public Integer isContiniousLeave;
	@Column(name = "no_of_leave")
	public Integer noOfLeave;
	@Column(name = "start_date")
	public Date startDate;
	@Column(name = "end_date")
	public Date endDate;
	@Column(name = "created_date_time")
	public Date createdDateTime;
	
	@PrePersist
	public void createdDate() {
		if(this.createdDateTime==null) {
			this.createdDateTime=new Date();
		}
	}
	
	@PreUpdate
	public void updateCreatedDate() {
		if(this.createdDateTime==null) {
			this.createdDateTime=new Date();
		}
	}

}
