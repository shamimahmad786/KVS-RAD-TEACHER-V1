package com.example.MOERADTEACHER.common.transfermodel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "teacher_transfer_confirmation", schema="audit_tray")
@Data
public class TeacherTransferConfirmation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Long id;
	@Column(name = "teacher_id")
	public Integer teacherId;
	@Column(name = "teacher_employee_code")
	public String teacherEmployeeCode;
	@Column(name = "total_tc_count")
	public Integer totalTcCount;
	@Column(name = "total_dc_count")
	public Integer totalDcCount;
	@Column(name = "station_name_choice1")
	public String stationNameChoice1;
	@Column(name = "station_name_choice2")
	public String stationNameChoice2;
	@Column(name = "station_name_choice3")
	public String stationNameChoice3;
	@Column(name = "station_name_choice4")
	public String stationNameChoice4;
	@Column(name = "station_name_choice5")
	public String stationNameChoice5;
	@Column(name = "station_code_choice1")
	public String stationCodeChoice1;
	@Column(name = "station_code_choice2")
	public String stationCodeChoice2;
	@Column(name = "station_code_choice3")
	public String stationCodeChoice3;
	@Column(name = "station_code_choice4")
	public String stationCodeChoice4;
	@Column(name = "station_code_choice5")
	public String stationCodeChoice5;
	@Column(name = "created_date_time")
	public Date createdDateTime;
	@Column(name = "confirm_by")
	public String confirmBy;
	
	@PrePersist
	 void updatedAt() {
	      this.createdDateTime = new Date();
	    }
	
	
}
