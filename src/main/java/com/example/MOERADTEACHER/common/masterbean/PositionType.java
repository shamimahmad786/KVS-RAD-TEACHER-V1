package com.example.MOERADTEACHER.common.masterbean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mst_teacher_position_type", schema = "master")
public class PositionType {

	@Id
	@Column(name = "teacher_type_id")
	public Integer teacherTypeId;

	@Column(name = "udise_teacher_type_id")
	public Integer udiseTeacherTypeId;

	@Column(name = "teacher_type_name")
	public String teacherTypeName;
	@Column(name = "organization_teacher_type_id")
	public Integer organizationTeacherTypeId;
	@Column(name = "organization_teacher_type_name")
	public String organizationTeacherTypeName;
	@Column(name = "configured_business_unit_type_id")
	public Integer configuredBusinessUnitTypeId;
	@Column(name = "configured_business_unit_identity_code")
	public String configuredBusinessUnitIdentityCode;
	@Column(name = "active_status")
	public String activeStatus;
	@Column(name = "start_date")
	public String startDate;
	@Column(name = "end_date")
	public String endDate;
	@Column(name = "org_teacher_type_code")
	public String orgTeacherTypeCode;
	@Column(name = "application_id")
	public String applicationId;
	public Integer getTeacherTypeId() {
		return teacherTypeId;
	}
	public void setTeacherTypeId(Integer teacherTypeId) {
		this.teacherTypeId = teacherTypeId;
	}
	public Integer getUdiseTeacherTypeId() {
		return udiseTeacherTypeId;
	}
	public void setUdiseTeacherTypeId(Integer udiseTeacherTypeId) {
		this.udiseTeacherTypeId = udiseTeacherTypeId;
	}
	public String getTeacherTypeName() {
		return teacherTypeName;
	}
	public void setTeacherTypeName(String teacherTypeName) {
		this.teacherTypeName = teacherTypeName;
	}
	public Integer getOrganizationTeacherTypeId() {
		return organizationTeacherTypeId;
	}
	public void setOrganizationTeacherTypeId(Integer organizationTeacherTypeId) {
		this.organizationTeacherTypeId = organizationTeacherTypeId;
	}
	public String getOrganizationTeacherTypeName() {
		return organizationTeacherTypeName;
	}
	public void setOrganizationTeacherTypeName(String organizationTeacherTypeName) {
		this.organizationTeacherTypeName = organizationTeacherTypeName;
	}
	public Integer getConfiguredBusinessUnitTypeId() {
		return configuredBusinessUnitTypeId;
	}
	public void setConfiguredBusinessUnitTypeId(Integer configuredBusinessUnitTypeId) {
		this.configuredBusinessUnitTypeId = configuredBusinessUnitTypeId;
	}
	public String getConfiguredBusinessUnitIdentityCode() {
		return configuredBusinessUnitIdentityCode;
	}
	public void setConfiguredBusinessUnitIdentityCode(String configuredBusinessUnitIdentityCode) {
		this.configuredBusinessUnitIdentityCode = configuredBusinessUnitIdentityCode;
	}
	public String getActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getOrgTeacherTypeCode() {
		return orgTeacherTypeCode;
	}
	public void setOrgTeacherTypeCode(String orgTeacherTypeCode) {
		this.orgTeacherTypeCode = orgTeacherTypeCode;
	}
	public String getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	
	
	

}
