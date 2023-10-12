package com.example.MOERADTEACHER.security;

//package com.mhrd.SpringAuthSecurity.userDetails;

import java.io.Serializable;
//import java.security.Permission;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

//import com.st7.authorizationserver.authorizationserver.model.Permission;
//import com.st7.authorizationserver.authorizationserver.model.Role;

import lombok.Data;

@Entity
@Table(name = "role", schema="public")
@Data
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "role_name")
    private String name;
    
    // Added by shamim for application based role
    @Column(name = "application_name")
    private String  applicationName;
    
    @Column(name = "application_id")
    private Integer applicationId;
    
    @Column(name = "application_role_id")
    private Integer applicationRoleId;
    
    
    
    
    // End

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "permission_role", joinColumns = {
            @JoinColumn(name = "role_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "permission_id", referencedColumnName = "id")})
    private List<Permission> permissions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
    
    public String getApplicationName() {
    	return applicationName;
    }
    
    public void setApplicationName(String applicationName) {
    	 this.applicationName=applicationName;
    }
    
    
    public Integer getApplicationId() {
    	return applicationId;
    }
    
    public void setApplicationId() {
    this.applicationId=applicationId;
    }
    
    
    public Integer getApplicationRoleId() {
    	return applicationRoleId;
    }
    
    
    public void setApplicationRoleId() {
    	this.applicationRoleId=applicationRoleId;
    } 
    
    
    
    
}

