package com.example.MOERADTEACHER.common.transfermodel;

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

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Table(name = "z_emp_details_3107", schema="public")
//@Data
public class TeacherTransferedDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator="teacher_transfered_details_id")
	@SequenceGenerator(name="teacher_transfered_details_id",sequenceName="teacher_transfered_details_seq_id", allocationSize=1)
    @Column(name="id")
    public Long id; 
    @Column(name="teacher_id")
	public Integer teacherId;
    @Column(name="emp_code")
    public String empCode;
    @Column(name="emp_name")
	public String empName;
    @Column(name="gender")
	public Integer gender;
    @Column(name="dob")
	public Date dob;
    @Column(name="post_id")
	public Integer postId;
    @Column(name="subject_id")
	public Integer subjectId;
    @Column(name="region_code")
	public Integer regionCode;
    @Column(name="present_station_code")
	public Integer presentStationCode;
    @Column(name="present_kv_code")
	public String presentKvCode;
    @Column(name="present_kv_master_code")
	public String presentKvMasterCode;
    @Column(name="shift")
	public Integer shift;
    @Column(name="doj_in_present_stn_irrespective_of_cadre")
	public Date dojInPresentStnIrrespectiveOfCadre;
    @Column(name="is_ner_recruited")
	public Integer isNerRecruited;
    @Column(name="isjcm_rjcm")
	public Integer isjcmRjcm;
    @Column(name="is_pwd")
	public Integer isPwd;
    @Column(name="is_hard_served")
	public Integer isHardServed;
    @Column(name="is_currently_in_hard")
	public Integer isCurrentlyInHard;
    @Column(name="station_code_1")
	public Integer stationCode_1;
    @Column(name="station_code_2")
	public Integer stationCode_2;
    @Column(name="station_code_3")
	public Integer stationCode_3;
    @Column(name="station_code_4")
	public Integer stationCode_4;
    @Column(name="station_code_5")
	public Integer stationCode_5;
    @Column(name="tot_tc")
	public Integer totTc;
    @Column(name="tot_tc2")
	public Integer totTc2;
    @Column(name="tot_dc")
	public Integer totDc;
    @Column(name="transfer_applied_for")
	public Integer transferAppliedFor;
    @Column(name="dc_applied_for")
	public Integer dcAppliedFor;
    @Column(name="is_trasnfer_applied")
	public Integer isTrasnferApplied;
    @Column(name="allot_stn_code")
	public Integer allotStnCode;
    @Column(name="allot_kv_code")
	public String allotKvCode;
    @Column(name="allot_shift")
	public Integer allotShift;
    @Column(name="transferred_under_cat")
	public Integer transferredUnderCat;
    @Column(name="emp_transfer_status")
	public Integer empTransferStatus;
    @Column(name="is_displaced")
	public Integer isDisplaced;
    @Column(name="elgible_yn")
	public Integer elgibleYn;
    @Column(name="is_ner")
	public Integer isNer;
    @Column(name="apply_transfer_yn")
	public Integer applyTransferYn;
    @Column(name="ground_level")
	public Integer groundLevel;
    @Column(name="print_order")
	public Integer printOrder;
    @Column(name="kv_name_present")
	public String kvNamePresent;
    @Column(name="kv_name_alloted")
	public String kvNameAlloted;
    @Column(name="station_name1")
	public String stationName1;
    @Column(name="station_name2")
	public String stationName2;
    @Column(name="station_name3")
	public String stationName3;
    @Column(name="station_name4")
	public String stationName4;
    @Column(name="station_name5")
	public String stationName5;
    @Column(name="region_name_present")
	public String regionNamePresent;
    @Column(name="region_code_alloted")
	public String regionCodeAlloted;
    @Column(name="region_name_alloted")
	public String regionNameAlloted;
    @Column(name="station_name_present")
	public String stationNamePresent;
    @Column(name="station_name_alloted")
	public String stationNameAlloted;
    @Column(name="post_name")
	public String postName;
    @Column(name="subject_name")
	public String subjectName;
    @DateTimeFormat(pattern="dd-MM-yyyy")
    @Column(name="join_date")
	public Date joinDate;
    @DateTimeFormat(pattern="dd-MM-yyyy")
    @Column(name="relieve_date")
	public Date relieveDate;
    @Column(name="join_relieve_flag")
	public String joinRelieveFlag;
    @Column(name="transfer_type")
	public String transferType;
    @Column(name="modified_date_time")
    public Date modifiedDateTime;
    @Column(name="transferred_under_cat_id")
    public Integer transferredUnderCatId;
    @Column(name="transfer_query_type")
    public Integer transferQueryType;  //1-National,2 -presant school,3- allocated school
    @Column(name="is_admin_transfer")
    public Boolean isAdminTransfer;
    @Column(name="is_automated_transfer")
    public Boolean isAutomatedTransfer;
    @Column(name="transfer_order_number")
    public String transferOrderNumber;
    @Column(name="cancel_order_number")
    public String cancelOrderNumber;
    @Column(name="is_joined_allocated_school")
    public Boolean isJoinedAllocatedSchool;

    @PrePersist
    void updatedAt() {
      this.modifiedDateTime = new Date();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public Integer getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(Integer regionCode) {
		this.regionCode = regionCode;
	}

	public Integer getPresentStationCode() {
		return presentStationCode;
	}

	public void setPresentStationCode(Integer presentStationCode) {
		this.presentStationCode = presentStationCode;
	}

	public String getPresentKvCode() {
		return presentKvCode;
	}

	public void setPresentKvCode(String presentKvCode) {
		this.presentKvCode = presentKvCode;
	}

	public String getPresentKvMasterCode() {
		return presentKvMasterCode;
	}

	public void setPresentKvMasterCode(String presentKvMasterCode) {
		this.presentKvMasterCode = presentKvMasterCode;
	}

	public Integer getShift() {
		return shift;
	}

	public void setShift(Integer shift) {
		this.shift = shift;
	}

	public Date getDojInPresentStnIrrespectiveOfCadre() {
		return dojInPresentStnIrrespectiveOfCadre;
	}

	public void setDojInPresentStnIrrespectiveOfCadre(Date dojInPresentStnIrrespectiveOfCadre) {
		this.dojInPresentStnIrrespectiveOfCadre = dojInPresentStnIrrespectiveOfCadre;
	}

	public Integer getIsNerRecruited() {
		return isNerRecruited;
	}

	public void setIsNerRecruited(Integer isNerRecruited) {
		this.isNerRecruited = isNerRecruited;
	}

	public Integer getIsjcmRjcm() {
		return isjcmRjcm;
	}

	public void setIsjcmRjcm(Integer isjcmRjcm) {
		this.isjcmRjcm = isjcmRjcm;
	}

	public Integer getIsPwd() {
		return isPwd;
	}

	public void setIsPwd(Integer isPwd) {
		this.isPwd = isPwd;
	}

	public Integer getIsHardServed() {
		return isHardServed;
	}

	public void setIsHardServed(Integer isHardServed) {
		this.isHardServed = isHardServed;
	}

	public Integer getIsCurrentlyInHard() {
		return isCurrentlyInHard;
	}

	public void setIsCurrentlyInHard(Integer isCurrentlyInHard) {
		this.isCurrentlyInHard = isCurrentlyInHard;
	}

	public Integer getStationCode_1() {
		return stationCode_1;
	}

	public void setStationCode_1(Integer stationCode_1) {
		this.stationCode_1 = stationCode_1;
	}

	public Integer getStationCode_2() {
		return stationCode_2;
	}

	public void setStationCode_2(Integer stationCode_2) {
		this.stationCode_2 = stationCode_2;
	}

	public Integer getStationCode_3() {
		return stationCode_3;
	}

	public void setStationCode_3(Integer stationCode_3) {
		this.stationCode_3 = stationCode_3;
	}

	public Integer getStationCode_4() {
		return stationCode_4;
	}

	public void setStationCode_4(Integer stationCode_4) {
		this.stationCode_4 = stationCode_4;
	}

	public Integer getStationCode_5() {
		return stationCode_5;
	}

	public void setStationCode_5(Integer stationCode_5) {
		this.stationCode_5 = stationCode_5;
	}

	public Integer getTotTc() {
		return totTc;
	}

	public void setTotTc(Integer totTc) {
		this.totTc = totTc;
	}

	public Integer getTotTc2() {
		return totTc2;
	}

	public void setTotTc2(Integer totTc2) {
		this.totTc2 = totTc2;
	}

	public Integer getTotDc() {
		return totDc;
	}

	public void setTotDc(Integer totDc) {
		this.totDc = totDc;
	}

	public Integer getTransferAppliedFor() {
		return transferAppliedFor;
	}

	public void setTransferAppliedFor(Integer transferAppliedFor) {
		this.transferAppliedFor = transferAppliedFor;
	}

	public Integer getDcAppliedFor() {
		return dcAppliedFor;
	}

	public void setDcAppliedFor(Integer dcAppliedFor) {
		this.dcAppliedFor = dcAppliedFor;
	}

	public Integer getIsTrasnferApplied() {
		return isTrasnferApplied;
	}

	public void setIsTrasnferApplied(Integer isTrasnferApplied) {
		this.isTrasnferApplied = isTrasnferApplied;
	}

	public Integer getAllotStnCode() {
		return allotStnCode;
	}

	public void setAllotStnCode(Integer allotStnCode) {
		this.allotStnCode = allotStnCode;
	}

	public String getAllotKvCode() {
		return allotKvCode;
	}

	public void setAllotKvCode(String allotKvCode) {
		this.allotKvCode = allotKvCode;
	}

	public Integer getAllotShift() {
		return allotShift;
	}

	public void setAllotShift(Integer allotShift) {
		this.allotShift = allotShift;
	}

	public Integer getTransferredUnderCat() {
		return transferredUnderCat;
	}

	public void setTransferredUnderCat(Integer transferredUnderCat) {
		this.transferredUnderCat = transferredUnderCat;
	}

	public Integer getEmpTransferStatus() {
		return empTransferStatus;
	}

	public void setEmpTransferStatus(Integer empTransferStatus) {
		this.empTransferStatus = empTransferStatus;
	}

	public Integer getIsDisplaced() {
		return isDisplaced;
	}

	public void setIsDisplaced(Integer isDisplaced) {
		this.isDisplaced = isDisplaced;
	}

	public Integer getElgibleYn() {
		return elgibleYn;
	}

	public void setElgibleYn(Integer elgibleYn) {
		this.elgibleYn = elgibleYn;
	}

	public Integer getIsNer() {
		return isNer;
	}

	public void setIsNer(Integer isNer) {
		this.isNer = isNer;
	}

	public Integer getApplyTransferYn() {
		return applyTransferYn;
	}

	public void setApplyTransferYn(Integer applyTransferYn) {
		this.applyTransferYn = applyTransferYn;
	}

	public Integer getGroundLevel() {
		return groundLevel;
	}

	public void setGroundLevel(Integer groundLevel) {
		this.groundLevel = groundLevel;
	}

	public Integer getPrintOrder() {
		return printOrder;
	}

	public void setPrintOrder(Integer printOrder) {
		this.printOrder = printOrder;
	}

	public String getKvNamePresent() {
		return kvNamePresent;
	}

	public void setKvNamePresent(String kvNamePresent) {
		this.kvNamePresent = kvNamePresent;
	}

	public String getKvNameAlloted() {
		return kvNameAlloted;
	}

	public void setKvNameAlloted(String kvNameAlloted) {
		this.kvNameAlloted = kvNameAlloted;
	}

	public String getStationName1() {
		return stationName1;
	}

	public void setStationName1(String stationName1) {
		this.stationName1 = stationName1;
	}

	public String getStationName2() {
		return stationName2;
	}

	public void setStationName2(String stationName2) {
		this.stationName2 = stationName2;
	}

	public String getStationName3() {
		return stationName3;
	}

	public void setStationName3(String stationName3) {
		this.stationName3 = stationName3;
	}

	public String getStationName4() {
		return stationName4;
	}

	public void setStationName4(String stationName4) {
		this.stationName4 = stationName4;
	}

	public String getStationName5() {
		return stationName5;
	}

	public void setStationName5(String stationName5) {
		this.stationName5 = stationName5;
	}

	public String getRegionNamePresent() {
		return regionNamePresent;
	}

	public void setRegionNamePresent(String regionNamePresent) {
		this.regionNamePresent = regionNamePresent;
	}

	public String getRegionCodeAlloted() {
		return regionCodeAlloted;
	}

	public void setRegionCodeAlloted(String regionCodeAlloted) {
		this.regionCodeAlloted = regionCodeAlloted;
	}

	public String getRegionNameAlloted() {
		return regionNameAlloted;
	}

	public void setRegionNameAlloted(String regionNameAlloted) {
		this.regionNameAlloted = regionNameAlloted;
	}

	public String getStationNamePresent() {
		return stationNamePresent;
	}

	public void setStationNamePresent(String stationNamePresent) {
		this.stationNamePresent = stationNamePresent;
	}

	public String getStationNameAlloted() {
		return stationNameAlloted;
	}

	public void setStationNameAlloted(String stationNameAlloted) {
		this.stationNameAlloted = stationNameAlloted;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public Date getRelieveDate() {
		return relieveDate;
	}

	public void setRelieveDate(Date relieveDate) {
		this.relieveDate = relieveDate;
	}

	public String getJoinRelieveFlag() {
		return joinRelieveFlag;
	}

	public void setJoinRelieveFlag(String joinRelieveFlag) {
		this.joinRelieveFlag = joinRelieveFlag;
	}

	public String getTransferType() {
		return transferType;
	}

	public void setTransferType(String transferType) {
		this.transferType = transferType;
	}

	public Date getModifiedDateTime() {
		return modifiedDateTime;
	}

	public void setModifiedDateTime(Date modifiedDateTime) {
		this.modifiedDateTime = modifiedDateTime;
	}

	public Integer getTransferredUnderCatId() {
		return transferredUnderCatId;
	}

	public void setTransferredUnderCatId(Integer transferredUnderCatId) {
		this.transferredUnderCatId = transferredUnderCatId;
	}

	public Integer getTransferQueryType() {
		return transferQueryType;
	}

	public void setTransferQueryType(Integer transferQueryType) {
		this.transferQueryType = transferQueryType;
	}

	public Boolean getIsAdminTransfer() {
		return isAdminTransfer;
	}

	public void setIsAdminTransfer(Boolean isAdminTransfer) {
		this.isAdminTransfer = isAdminTransfer;
	}

	public Boolean getIsAutomatedTransfer() {
		return isAutomatedTransfer;
	}

	public void setIsAutomatedTransfer(Boolean isAutomatedTransfer) {
		this.isAutomatedTransfer = isAutomatedTransfer;
	}

	public String getTransferOrderNumber() {
		return transferOrderNumber;
	}

	public void setTransferOrderNumber(String transferOrderNumber) {
		this.transferOrderNumber = transferOrderNumber;
	}

	public String getCancelOrderNumber() {
		return cancelOrderNumber;
	}

	public void setCancelOrderNumber(String cancelOrderNumber) {
		this.cancelOrderNumber = cancelOrderNumber;
	}

	public Boolean getIsJoinedAllocatedSchool() {
		return isJoinedAllocatedSchool;
	}

	public void setIsJoinedAllocatedSchool(Boolean isJoinedAllocatedSchool) {
		this.isJoinedAllocatedSchool = isJoinedAllocatedSchool;
	}
    
    
    
    
}
