package com.example.MOERADTEACHER.common.uneecops.master.eo;

import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="staff_type_post_mapping", schema = "uneecops")
public class StaffTypePostMappingEO {
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="id")
		private Integer id;
		@Column(name="stafftype_id")
		private Integer staffTypeId;
		@Column(name="designation_id")
		private Integer designationId;
		@Column(name="from_date")
		private LocalDate fromDate;
		@Column(name="to_date")
		private LocalDate toDate;
		@Column(name="status")
		private boolean status;
		@Column(name="created_by")
		private String createdBy;
		@Column(name="created_date")
		private Timestamp createdDate;
		@Column(name="updated_by")
		private String updatedBy;
		@Column(name="updated_date")
		private Timestamp updatedDate;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Integer getStaffTypeId() {
			return staffTypeId;
		}
		public void setStaffTypeId(Integer staffTypeId) {
			this.staffTypeId = staffTypeId;
		}
		public Integer getDesignationId() {
			return designationId;
		}
		public void setDesignationId(Integer designationId) {
			this.designationId = designationId;
		}
		public LocalDate getFromDate() {
			return fromDate;
		}
		public void setFromDate(LocalDate fromDate) {
			this.fromDate = fromDate;
		}
		public LocalDate getToDate() {
			return toDate;
		}
		public void setToDate(LocalDate toDate) {
			this.toDate = toDate;
		}
		public boolean isStatus() {
			return status;
		}
		public void setStatus(boolean status) {
			this.status = status;
		}
		public String getCreatedBy() {
			return createdBy;
		}
		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}
		public Timestamp getCreatedDate() {
			return createdDate;
		}
		public void setCreatedDate(Timestamp createdDate) {
			this.createdDate = createdDate;
		}
		public String getUpdatedBy() {
			return updatedBy;
		}
		public void setUpdatedBy(String updatedBy) {
			this.updatedBy = updatedBy;
		}
		public Timestamp getUpdatedDate() {
			return updatedDate;
		}
		public void setUpdatedDate(Timestamp updatedDate) {
			this.updatedDate = updatedDate;
		}
		
		
		

}
