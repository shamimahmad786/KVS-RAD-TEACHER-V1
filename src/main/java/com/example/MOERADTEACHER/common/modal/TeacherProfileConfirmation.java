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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Table(name = "teacher_profile_confirmation", schema="audit_tray")

public class TeacherProfileConfirmation {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO,generator="teacher_profile_confirmation_id")
	 @SequenceGenerator(name="teacher_profile_confirmation_id",sequenceName="teacher_profile_confirmation_seq_id", allocationSize=1)
	 @Column(name="id")
	 public Long id;
	 @Column(name="teacher_name")
	public String teacherName;
	 @Column(name="teacher_id")
	 public Integer teacherId;
	 @Column(name="teacher_gender")
	 public String teacherGender;
	 @Temporal(TemporalType.DATE)
	 @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	 @Column(name="teacher_dob")
	 public Date teacherDob;
	 @Column(name="teacher_employee_code")
	 public String teacherEmployeeCode;
	 @Column(name="teacher_disability_yn")
	public String teacherDisabilityYn;
	 @Column(name="work_experience_work_start_date_present_kv")
	public String workExperienceWorkStartDatePresentKv;
	 @Column(name="work_experience_appointed_for_subject")
	public String workExperienceAppointedForSubject;
	 @Column(name="last_promotion_position_type")
	public String lastPromotionPositionType;
	 @Column(name="ip")
	 public String ip;
	 @Column(name="created_date_time")
	 public Date createdDateTime;
	 
	  @PrePersist
	    void updatedAt() {
	      this.createdDateTime = new Date();
	    }
	    
	    @PreUpdate
	    void updatAt() {
	      this.createdDateTime = new Date();
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTeacherName() {
			return teacherName;
		}

		public void setTeacherName(String teacherName) {
			this.teacherName = teacherName;
		}

		public Integer getTeacherId() {
			return teacherId;
		}

		public void setTeacherId(Integer teacherId) {
			this.teacherId = teacherId;
		}

		public String getTeacherGender() {
			return teacherGender;
		}

		public void setTeacherGender(String teacherGender) {
			this.teacherGender = teacherGender;
		}

		public Date getTeacherDob() {
			return teacherDob;
		}

		public void setTeacherDob(Date teacherDob) {
			this.teacherDob = teacherDob;
		}

		public String getTeacherEmployeeCode() {
			return teacherEmployeeCode;
		}

		public void setTeacherEmployeeCode(String teacherEmployeeCode) {
			this.teacherEmployeeCode = teacherEmployeeCode;
		}

		public String getTeacherDisabilityYn() {
			return teacherDisabilityYn;
		}

		public void setTeacherDisabilityYn(String teacherDisabilityYn) {
			this.teacherDisabilityYn = teacherDisabilityYn;
		}

		public String getWorkExperienceWorkStartDatePresentKv() {
			return workExperienceWorkStartDatePresentKv;
		}

		public void setWorkExperienceWorkStartDatePresentKv(String workExperienceWorkStartDatePresentKv) {
			this.workExperienceWorkStartDatePresentKv = workExperienceWorkStartDatePresentKv;
		}

		public String getWorkExperienceAppointedForSubject() {
			return workExperienceAppointedForSubject;
		}

		public void setWorkExperienceAppointedForSubject(String workExperienceAppointedForSubject) {
			this.workExperienceAppointedForSubject = workExperienceAppointedForSubject;
		}

		public String getLastPromotionPositionType() {
			return lastPromotionPositionType;
		}

		public void setLastPromotionPositionType(String lastPromotionPositionType) {
			this.lastPromotionPositionType = lastPromotionPositionType;
		}

		public String getIp() {
			return ip;
		}

		public void setIp(String ip) {
			this.ip = ip;
		}

		public Date getCreatedDateTime() {
			return createdDateTime;
		}

		public void setCreatedDateTime(Date createdDateTime) {
			this.createdDateTime = createdDateTime;
		}
	 
	    
	    
}
