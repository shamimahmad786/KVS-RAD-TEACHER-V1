package com.example.MOERADTEACHER.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import com.me.user.UserService.user.modal.UserRoleMapping;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "role_user", schema="public")
@Data
@Getter
@Setter
public class UserRoleMapping {
	  @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
  	@Column(name = "id")
	    private Integer id;
	   @Column(name = "user_id")
	   private Integer userId;
	    @Column(name = "role_id")
	   private Integer roleId;
	    @Column(name = "application_id") 
	   private Integer applicationId;
	    @Column(name = "application_name") 
	   private String applicationName;
	    @Column(name = "application_role_id")
	    private Integer applicationRoleId;
	    @Column(name = "business_unit_type_id") 
	   private Integer userLevelId;
	    @Column(name = "business_unit_type_code") 
	   private String userLevelName;
//	    @Column(name = "state_id") 
//	   private Integer stateId;
//	    @Column(name = "state_name") 
//	   private String  stateName;
//	    @Column(name = "district_id") 
//	   private Integer  districtId;
//	    @Column(name = "district_name") 
//	   private String  districtName;
//	    @Column(name = "block_id") 
//	   private Integer  blockId;
//	    @Column(name = "block_name") 
//	   private String   blockName;
	    @Column(name = "role_name") 
	   private String  roleName;
	    @Column(name = "permision") 
	   private String permision;
	    @Column(name = "context") 
	    private String context;
	    @Column(name = "organization_hierarchy_master_id")
	    private Integer organizationHierarchyMasterId;
	    @Column(name = "user_name")
	    private String userName;
	    
	    @Column(name = "role_type")
	    private String roleType;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Integer getUserId() {
			return userId;
		}

		public void setUserId(Integer userId) {
			this.userId = userId;
		}

		public Integer getRoleId() {
			return roleId;
		}

		public void setRoleId(Integer roleId) {
			this.roleId = roleId;
		}

		public Integer getApplicationId() {
			return applicationId;
		}

		public void setApplicationId(Integer applicationId) {
			this.applicationId = applicationId;
		}

		public String getApplicationName() {
			return applicationName;
		}

		public void setApplicationName(String applicationName) {
			this.applicationName = applicationName;
		}

		public Integer getApplicationRoleId() {
			return applicationRoleId;
		}

		public void setApplicationRoleId(Integer applicationRoleId) {
			this.applicationRoleId = applicationRoleId;
		}

		public Integer getUserLevelId() {
			return userLevelId;
		}

		public void setUserLevelId(Integer userLevelId) {
			this.userLevelId = userLevelId;
		}

		public String getUserLevelName() {
			return userLevelName;
		}

		public void setUserLevelName(String userLevelName) {
			this.userLevelName = userLevelName;
		}

		public String getRoleName() {
			return roleName;
		}

		public void setRoleName(String roleName) {
			this.roleName = roleName;
		}

		public String getPermision() {
			return permision;
		}

		public void setPermision(String permision) {
			this.permision = permision;
		}

		public String getContext() {
			return context;
		}

		public void setContext(String context) {
			this.context = context;
		}

		public Integer getOrganizationHierarchyMasterId() {
			return organizationHierarchyMasterId;
		}

		public void setOrganizationHierarchyMasterId(Integer organizationHierarchyMasterId) {
			this.organizationHierarchyMasterId = organizationHierarchyMasterId;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getRoleType() {
			return roleType;
		}

		public void setRoleType(String roleType) {
			this.roleType = roleType;
		}
	   
}
