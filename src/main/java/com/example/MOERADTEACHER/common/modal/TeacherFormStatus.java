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
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "form_status_id_seq")
	@SequenceGenerator(name = "form_status_id_seq", sequenceName = "form_status_id_seq", allocationSize=1)
	@Column(name = "id")
	private Integer id;
	@Column(name = "profile1_form_status")
	private String profile1FormStatus;
	@Column(name = "profile2_form_status")
	private String profile2FormStatus;
	@Column(name = "profile3_form_status")
	private String profile3FormStatus;
	@Column(name = "form1_status")
	private String form1Status;
	@Column(name = "form2_status")
	private String form2Status;
	@Column(name = "form3_status")
	private String form3Status;
	@Column(name = "form4_status")
	private String form4Status;
	@Column(name = "final_status")
	private String finalStatus;
	@Column(name = "profile_final_status")
	private String profileFinalStatus;
	@Column(name = "transfer_final_status")
	private String transferFinalStatus;
	@Column(name = "teacher_id")
	private Integer teacherId;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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

	public String getFinalStatus() {
		return finalStatus;
	}
	public void setFinalStatus(String finalStatus) {
		this.finalStatus = finalStatus;
	}
	public Integer getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	public String getProfileFinalStatus() {
		return profileFinalStatus;
	}
	public void setProfileFinalStatus(String profileFinalStatus) {
		this.profileFinalStatus = profileFinalStatus;
	}
	public String getTransferFinalStatus() {
		return transferFinalStatus;
	}
	public void setTransferFinalStatus(String transferFinalStatus) {
		this.transferFinalStatus = transferFinalStatus;
	}
	public String getProfile1FormStatus() {
		return profile1FormStatus;
	}
	public void setProfile1FormStatus(String profile1FormStatus) {
		this.profile1FormStatus = profile1FormStatus;
	}
	public String getProfile2FormStatus() {
		return profile2FormStatus;
	}
	public void setProfile2FormStatus(String profile2FormStatus) {
		this.profile2FormStatus = profile2FormStatus;
	}
	public String getProfile3FormStatus() {
		return profile3FormStatus;
	}
	public void setProfile3FormStatus(String profile3FormStatus) {
		this.profile3FormStatus = profile3FormStatus;
	}
	
	
	
	
	
}
