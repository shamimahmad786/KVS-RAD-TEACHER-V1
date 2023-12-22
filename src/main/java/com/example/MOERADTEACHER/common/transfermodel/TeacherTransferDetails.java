package com.example.MOERADTEACHER.common.transfermodel;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;


@Entity
@Table(name = "teacher_transfer_details", schema="transfer")
public class TeacherTransferDetails {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "kv_code")
	public String kvCode;
	@Column(name = "teacher_id")
	public Integer teacherId;
	@Column(name = "transfer_id")
	public String transferId;
	@Column(name = "teacher_employee_code")
	public String teacherEmployeeCode;
	@Column(name = "dc_stay_at_station")
	public Integer dcStayAtStation;
	@Column(name = "dc_period_absence")
	public Integer dcPeriodAbsence;
	@Column(name = "dc_return_station")
	public Integer dcReturnStation;
	@Column(name = "dc_stay_station_point")
	public Integer dcStayStationPoint;
	@Column(name = "dc_tenure_hard_point")
	public String dcTenureHardPoint;
	@Column(name = "dc_physical_challenged_point")
	public Integer dcPhysicalChallengedPoint;
	@Column(name = "dc_md_df_groung_point")
	public Integer dcMdDfGroungPoint;
	@Column(name = "dc_ltr_point")
	public Integer dcLtrPoint;
	@Column(name = "dc_spouse_point")
	public Integer dcSpousePoint;
	@Column(name = "dc_single_point")
	public Integer dcSinglePoint;
	@Column(name = "dc_non_sopouse_single_point")
	public Integer dcNonSopouseSinglePoint;
	@Column(name = "dc_rjcm_njcm_point")
	public Integer dcRjcmNjcmPoint;
	@Column(name = "dc_total_point")
	public Integer dcTotalPoint;
	@Column(name = "dc_save_yn")
	public Integer dcSaveYn;
	@Column(name = "tc_save_yn")
	public Integer tcSaveYn;
	
	
	@Column(name = "tc_stay_at_station")
	public Integer tcStayAtStation;
	@Column(name = "tc_period_absence")
	public Integer tcPeriodAbsence;
	@Column(name = "tc_stay_station_point")
	public Integer tcStayStationPoint;
	@Column(name = "tc_tenure_hard_point")
	public Integer tcTenureHardPoint;
	@Column(name = "tc_physical_challenged_point")
	public Integer tcPhysicalChallengedPoint;
	@Column(name = "tc_md_df_groung_point")
	public Integer tcMdDfGroungPoint;
	@Column(name = "tc_ltr_point")
	public Integer tcLtrPoint;
	@Column(name = "tc_spouse_point")
	public Integer tcSpousePoint;
	@Column(name = "tc_single_point")
	public Integer tcSinglePoint;
	@Column(name = "tc_non_sopouse_single_point")
	public Integer tcNonSopouseSinglePoint;
	@Column(name = "tc_rjcm_njcm_point")
	public Integer tcRjcmNjcmPoint;
	@Column(name = "tc_total_point")
	public Integer tcTotalPoint;
	@Column(name = "final_status")
	public Integer finalStatus;
	
	
	
	
	@Column(name = "created_by")
	public String createdBy;
	@Column(name = "created_date_time")
	public Date createdDateTime;
	@Column(name = "updated_by")
	public String updatedBy;
	@Column(name = "update_date_time")
	public Date updateDateTime;
	
	public String inityear;
	
	
	
	
	public Integer getDcSaveYn() {
		return dcSaveYn;
	}


	public void setDcSaveYn(Integer dcSaveYn) {
		this.dcSaveYn = dcSaveYn;
	}


	public Integer getTcSaveYn() {
		return tcSaveYn;
	}


	public void setTcSaveYn(Integer tcSaveYn) {
		this.tcSaveYn = tcSaveYn;
	}


	@PrePersist
	protected void onCreate() {
		createdDateTime =  new Timestamp(new Date().getTime());
		updateDateTime=  new Timestamp(new Date().getTime());
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getKvCode() {
		return kvCode;
	}


	public void setKvCode(String kvCode) {
		this.kvCode = kvCode;
	}


	public Integer getTeacherId() {
		return teacherId;
	}


	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}


	public String getTransferId() {
		return transferId;
	}


	public void setTransferId(String transferId) {
		this.transferId = transferId;
	}


	public String getTeacherEmployeeCode() {
		return teacherEmployeeCode;
	}


	public void setTeacherEmployeeCode(String teacherEmployeeCode) {
		this.teacherEmployeeCode = teacherEmployeeCode;
	}


	public Integer getDcStayAtStation() {
		return dcStayAtStation;
	}


	public void setDcStayAtStation(Integer dcStayAtStation) {
		this.dcStayAtStation = dcStayAtStation;
	}


	public Integer getDcPeriodAbsence() {
		return dcPeriodAbsence;
	}


	public void setDcPeriodAbsence(Integer dcPeriodAbsence) {
		this.dcPeriodAbsence = dcPeriodAbsence;
	}


	public Integer getDcReturnStation() {
		return dcReturnStation;
	}


	public void setDcReturnStation(Integer dcReturnStation) {
		this.dcReturnStation = dcReturnStation;
	}


	public Integer getDcStayStationPoint() {
		return dcStayStationPoint;
	}


	public void setDcStayStationPoint(Integer dcStayStationPoint) {
		this.dcStayStationPoint = dcStayStationPoint;
	}


	public String getDcTenureHardPoint() {
		return dcTenureHardPoint;
	}


	public void setDcTenureHardPoint(String dcTenureHardPoint) {
		this.dcTenureHardPoint = dcTenureHardPoint;
	}


	public Integer getDcPhysicalChallengedPoint() {
		return dcPhysicalChallengedPoint;
	}


	public void setDcPhysicalChallengedPoint(Integer dcPhysicalChallengedPoint) {
		this.dcPhysicalChallengedPoint = dcPhysicalChallengedPoint;
	}


	public Integer getDcMdDfGroungPoint() {
		return dcMdDfGroungPoint;
	}


	public void setDcMdDfGroungPoint(Integer dcMdDfGroungPoint) {
		this.dcMdDfGroungPoint = dcMdDfGroungPoint;
	}


	public Integer getDcLtrPoint() {
		return dcLtrPoint;
	}


	public void setDcLtrPoint(Integer dcLtrPoint) {
		this.dcLtrPoint = dcLtrPoint;
	}


	public Integer getDcSpousePoint() {
		return dcSpousePoint;
	}


	public void setDcSpousePoint(Integer dcSpousePoint) {
		this.dcSpousePoint = dcSpousePoint;
	}


	public Integer getDcSinglePoint() {
		return dcSinglePoint;
	}


	public void setDcSinglePoint(Integer dcSinglePoint) {
		this.dcSinglePoint = dcSinglePoint;
	}


	public Integer getDcNonSopouseSinglePoint() {
		return dcNonSopouseSinglePoint;
	}


	public void setDcNonSopouseSinglePoint(Integer dcNonSopouseSinglePoint) {
		this.dcNonSopouseSinglePoint = dcNonSopouseSinglePoint;
	}


	public Integer getDcRjcmNjcmPoint() {
		return dcRjcmNjcmPoint;
	}


	public void setDcRjcmNjcmPoint(Integer dcRjcmNjcmPoint) {
		this.dcRjcmNjcmPoint = dcRjcmNjcmPoint;
	}


	public Integer getDcTotalPoint() {
		return dcTotalPoint;
	}


	public void setDcTotalPoint(Integer dcTotalPoint) {
		this.dcTotalPoint = dcTotalPoint;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public Date getCreatedDateTime() {
		return createdDateTime;
	}


	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}


	public String getUpdatedBy() {
		return updatedBy;
	}


	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}


	public Date getUpdateDateTime() {
		return updateDateTime;
	}


	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}


	public Integer getTcStayAtStation() {
		return tcStayAtStation;
	}


	public void setTcStayAtStation(Integer tcStayAtStation) {
		this.tcStayAtStation = tcStayAtStation;
	}


	public Integer getTcPeriodAbsence() {
		return tcPeriodAbsence;
	}


	public void setTcPeriodAbsence(Integer tcPeriodAbsence) {
		this.tcPeriodAbsence = tcPeriodAbsence;
	}


	public Integer getTcStayStationPoint() {
		return tcStayStationPoint;
	}


	public void setTcStayStationPoint(Integer tcStayStationPoint) {
		this.tcStayStationPoint = tcStayStationPoint;
	}


	public Integer getTcTenureHardPoint() {
		return tcTenureHardPoint;
	}


	public void setTcTenureHardPoint(Integer tcTenureHardPoint) {
		this.tcTenureHardPoint = tcTenureHardPoint;
	}


	public Integer getTcPhysicalChallengedPoint() {
		return tcPhysicalChallengedPoint;
	}


	public void setTcPhysicalChallengedPoint(Integer tcPhysicalChallengedPoint) {
		this.tcPhysicalChallengedPoint = tcPhysicalChallengedPoint;
	}


	public Integer getTcMdDfGroungPoint() {
		return tcMdDfGroungPoint;
	}


	public void setTcMdDfGroungPoint(Integer tcMdDfGroungPoint) {
		this.tcMdDfGroungPoint = tcMdDfGroungPoint;
	}


	public Integer getTcLtrPoint() {
		return tcLtrPoint;
	}


	public void setTcLtrPoint(Integer tcLtrPoint) {
		this.tcLtrPoint = tcLtrPoint;
	}


	public Integer getTcSpousePoint() {
		return tcSpousePoint;
	}


	public void setTcSpousePoint(Integer tcSpousePoint) {
		this.tcSpousePoint = tcSpousePoint;
	}


	public Integer getTcSinglePoint() {
		return tcSinglePoint;
	}


	public void setTcSinglePoint(Integer tcSinglePoint) {
		this.tcSinglePoint = tcSinglePoint;
	}


	public Integer getTcNonSopouseSinglePoint() {
		return tcNonSopouseSinglePoint;
	}


	public void setTcNonSopouseSinglePoint(Integer tcNonSopouseSinglePoint) {
		this.tcNonSopouseSinglePoint = tcNonSopouseSinglePoint;
	}


	public Integer getTcRjcmNjcmPoint() {
		return tcRjcmNjcmPoint;
	}


	public void setTcRjcmNjcmPoint(Integer tcRjcmNjcmPoint) {
		this.tcRjcmNjcmPoint = tcRjcmNjcmPoint;
	}


	public Integer getTcTotalPoint() {
		return tcTotalPoint;
	}


	public void setTcTotalPoint(Integer tcTotalPoint) {
		this.tcTotalPoint = tcTotalPoint;
	}


	public Integer getFinalStatus() {
		return finalStatus;
	}


	public void setFinalStatus(Integer finalStatus) {
		this.finalStatus = finalStatus;
	}


	public String getInityear() {
		return inityear;
	}


	public void setInityear(String inityear) {
		this.inityear = inityear;
	}
	
	
	
	

}
