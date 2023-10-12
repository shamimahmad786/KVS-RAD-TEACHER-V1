package com.example.MOERADTEACHER.common.modal;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "teacher_form_status", schema="public")
public class TeacherFormStatus implements Serializable{
	
	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "form_status_id_seq")
	
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "form_status_id_seq")
	@SequenceGenerator(name = "form_status_id_seq", sequenceName = "form_status_id_seq")
	
	@Column(name = "id")
	private Integer id;
//	@Column(name = "teacher_id")
//	private Integer teacherId;
	@Column(name = "form1_status")
	private String form1Status;
	@Column(name = "form2_status")
	private String form2Status;
	@Column(name = "form3_status")
	private String form3Status;
	@Column(name = "form4_status")
	private String form4Status;
	@Column(name = "form5_status")
	private String form5Status;
	@Column(name = "form6_status")
	private String form6Status;
	@Column(name = "form7_status")
	private String form7Status;
	@Column(name = "final_status")
	private String finalStatus;
	
	@Column(name = "teacher_id")
	private Integer teacherId;
	
//	 @OneToOne(mappedBy = "teacherFormStatus")
//	private TeacherProfile teacherProfile;
//	 
	 
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
//	public Integer getTeacherId() {
//		return teacherId;
//	}
//	public void setTeacherId(Integer teacherId) {
//		this.teacherId = teacherId;
//	}
	public String getForm1Status() {
		return form1Status;
	}
	public void setForm1Status(String form1Status) {
		this.form1Status = form1Status;
	}
	public String getForm2Status() {
		return form2Status;
	}
	public void setForm2Status(String form2Status) {
		this.form2Status = form2Status;
	}
	public String getForm3Status() {
		return form3Status;
	}
	public void setForm3Status(String form3Status) {
		this.form3Status = form3Status;
	}
	public String getForm4Status() {
		return form4Status;
	}
	public void setForm4Status(String form4Status) {
		this.form4Status = form4Status;
	}
	public String getForm5Status() {
		return form5Status;
	}
	public void setForm5Status(String form5Status) {
		this.form5Status = form5Status;
	}
	public String getForm6Status() {
		return form6Status;
	}
	public void setForm6Status(String form6Status) {
		this.form6Status = form6Status;
	}
	public String getForm7Status() {
		return form7Status;
	}
	public void setForm7Status(String form7Status) {
		this.form7Status = form7Status;
	}
	public String getFinalStatus() {
		return finalStatus;
	}
	public void setFinalStatus(String finalStatus) {
		this.finalStatus = finalStatus;
	}
//	public TeacherProfile getTeacherProfile() {
//		return teacherProfile;
//	}
//	public void setTeacherProfile(TeacherProfile teacherProfile) {
//		this.teacherProfile = teacherProfile;
//	}
	public Integer getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	
	
	
	
	
}
