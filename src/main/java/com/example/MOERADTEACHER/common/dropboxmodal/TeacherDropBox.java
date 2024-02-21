package com.example.MOERADTEACHER.common.dropboxmodal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "teacher_dropbox", schema="public")
@Data
public class TeacherDropBox {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator="dropboxIdSeq")
	@SequenceGenerator(name="dropboxIdSeq",sequenceName="dropbox_id_seq", allocationSize=1)
	@Column(name="id")
	private Integer id;
	@Column(name="teacher_id")
	private Integer teacherId;
	@Column(name="teacher_name")
	private String teacherName;
	@Column(name="teacher_employee_code")
	private String teacherEmployeeCode;
	@Column(name="teacher_gender")
	private String teacherGender;
	@Column(name="teacher_dob")
	private Date teacherDob ;
	@Column(name="last_promotion_position_type")
	private String lastPromotionPositionType;
	@Column(name="teaching_nonteaching")
	private String teachingNonteaching;
	@Column(name="employeedropid")
	private Integer employeeDropId;
	@Column(name="kv_code")
	private String kvCode;
	@Column(name="drop_box_flag")
	private Integer dropBoxFlag;
	@Column(name="exported_school_by")
	private String exportedSchoolBy;
	@Column(name="action_taken_by")
	private String actionTakenBy;
	@Column(name="created_by")
	private String createdBy;
	@Column(name="created_date_time")
	private Date createdDateTime;
	@Column(name="import_date_time")
	private Date importDateTime;
	@Column(name="ipaddress")
	private String ipaddress;
	@Column(name="dropbox_id")
	private Integer dropboxId;
	@Column(name="dropbox_description")
	private String dropboxDescription;
}
