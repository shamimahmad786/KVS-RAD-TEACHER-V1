package com.example.MOERADTEACHER.common.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


@Data
public class TransferDcBeans {

	public String kvCode;

	public Integer teacherId;

	public String teacherEmployeeCode;

	public Integer dcStayAtStation;

	public Integer dcPeriodAbsence;

	public Integer dcReturnStation;

	public Integer dcStayStationPoint;

	public String dcTenureHardPoint;
	
	public Integer dcPhysicalChallengedPoint;

	public Integer dcMdDfGroungPoint;

	public Integer dcLtrPoint;

	public Integer dcSpousePoint;

	public Integer dcSinglePoint;

	public Integer dcNonSopouseSinglePoint;

	public Integer dcRjcmNjcmPoint;
	
	public Integer dcTotalPoint;
	
	public Integer tcStayAtStation;
	public Integer tcPeriodAbsence;



	public Integer tcStayStationPoint;

	public Integer tcTenureHardPoint;

	public Integer tcPhysicalChallengedPoint;

	public Integer tcMdDfGroungPoint;

	public Integer tcLtrPoint;

	public Integer tcSpousePoint;

	public Integer tcSinglePoint;

	public Integer tcNonSopouseSinglePoint;

	public Integer tcRjcmNjcmPoint;
	
	public Integer tcTotalPoint;

	public String createdBy;

	public Date createdDateTime;

	public String updatedBy;

	public Date updateDateTime;

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
	
	
	
}
