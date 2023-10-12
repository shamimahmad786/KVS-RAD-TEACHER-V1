package com.example.MOERADTEACHER.common.transfermodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="teacher_sanction_master", schema = "kv")
public class SanctionDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	@Column(name = "udise_sch_code")
	private String udiseSchCode;
	@Column(name = "kv_code")
	private String kvCode;
	@Column(name = "kv_name")
	private String kvName;
	@Column(name = "shift_yn")
	private Integer shiftYn;
	@Column(name = "station_code")
	private String stationCode;
	@Column(name = "station_name")
	private String stationName;
	@Column(name = "region_code")
	private String regionCode;
	@Column(name = "region_name")
	private String regionName;
	@Column(name = "position_subject_map_id")
	private Integer positionSubjectMapId;
	@Column(name = "teacher_type_id")
	private Integer teacherTypeId;
	@Column(name = "teacher_type_name")
	private String teacherTypeName;
	@Column(name = "organization_teacher_type_name")
	private String organizationTeacherTypeName;
	@Column(name = "org_teacher_type_code")
	private String orgTeacherTypeCode;
	@Column(name = "subject_id")
	private Integer subjectId;
	@Column(name = "subject_name")
	private String subjectName;
	@Column(name = "subject_code")
	private String subjectCode;
	@Column(name = "sanctioned_post")
	private Integer sanctionedPost;
	@Column(name = "occupied_post")
	private Integer occupiedPost;
	@Column(name = "vacant_post")
	private Integer vacantPost;
	@Column(name = "surplus_post")
	private Integer surplusPost;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUdiseSchCode() {
		return udiseSchCode;
	}
	public void setUdiseSchCode(String udiseSchCode) {
		this.udiseSchCode = udiseSchCode;
	}
	public String getKvCode() {
		return kvCode;
	}
	public void setKvCode(String kvCode) {
		this.kvCode = kvCode;
	}
	public String getKvName() {
		return kvName;
	}
	public void setKvName(String kvName) {
		this.kvName = kvName;
	}
	public Integer getShiftYn() {
		return shiftYn;
	}
	public void setShiftYn(Integer shiftYn) {
		this.shiftYn = shiftYn;
	}
	public String getStationCode() {
		return stationCode;
	}
	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public String getRegionCode() {
		return regionCode;
	}
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public Integer getPositionSubjectMapId() {
		return positionSubjectMapId;
	}
	public void setPositionSubjectMapId(Integer positionSubjectMapId) {
		this.positionSubjectMapId = positionSubjectMapId;
	}
	public Integer getTeacherTypeId() {
		return teacherTypeId;
	}
	public void setTeacherTypeId(Integer teacherTypeId) {
		this.teacherTypeId = teacherTypeId;
	}
	public String getTeacherTypeName() {
		return teacherTypeName;
	}
	public void setTeacherTypeName(String teacherTypeName) {
		this.teacherTypeName = teacherTypeName;
	}
	public String getOrganizationTeacherTypeName() {
		return organizationTeacherTypeName;
	}
	public void setOrganizationTeacherTypeName(String organizationTeacherTypeName) {
		this.organizationTeacherTypeName = organizationTeacherTypeName;
	}
	public String getOrgTeacherTypeCode() {
		return orgTeacherTypeCode;
	}
	public void setOrgTeacherTypeCode(String orgTeacherTypeCode) {
		this.orgTeacherTypeCode = orgTeacherTypeCode;
	}
	public Integer getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getSubjectCode() {
		return subjectCode;
	}
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
	public Integer getSanctionedPost() {
		return sanctionedPost;
	}
	public void setSanctionedPost(Integer sanctionedPost) {
		this.sanctionedPost = sanctionedPost;
	}
	public Integer getOccupiedPost() {
		return occupiedPost;
	}
	public void setOccupiedPost(Integer occupiedPost) {
		this.occupiedPost = occupiedPost;
	}
	public Integer getVacantPost() {
		return vacantPost;
	}
	public void setVacantPost(Integer vacantPost) {
		this.vacantPost = vacantPost;
	}
	public Integer getSurplusPost() {
		return surplusPost;
	}
	public void setSurplusPost(Integer surplusPost) {
		this.surplusPost = surplusPost;
	}
	
	
	
	
}
