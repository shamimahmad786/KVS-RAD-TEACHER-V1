package com.example.MOERADTEACHER.security;



//package com.st7.authorizationserver.authorizationserver.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

//import com.me.user.UserService.role.modal.Role;
//import com.me.user.UserService.user.modal.User;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user_details", schema="public")
@Data
@Getter
@Setter
public class User implements Serializable {
	  public User() {
	    }

	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO,generator="user_details_id")
		@SequenceGenerator(name="user_details_id",sequenceName="user_details_seq_id", allocationSize=1)
	    private Integer id;

	    @Column(name = "username")
	    private String username;
	    @Column(name = "password")
	    private String password;
	    @Column(name = "email")
	    private String email;
//	    @Column(name = "enabled")
//	    private boolean enabled;
//	    @Column(name = "accountnonexpired")
//	    private boolean accountNonExpired;
//	    @Column(name = "credentialsnonexpired")
//	    private boolean credentialsNonExpired;
//	    @Column(name = "accountnonlocked")
//	    private boolean accountNonLocked;
	    
	    
	    @Column(name = "enabled")
	    private int enabled;
	    
	    
	    @Column(name = "account_non_expired")
	    private boolean accountNonExpired;
	    @Column(name = "credentials_non_expired")
	    private boolean credentialsNonExpired;
	    @Column(name = "account_non_locked")
	    private boolean accountNonLocked;
	    
	   // Additional Add
	    @Column(name = "firstname")
	    private String firstname;
	    @Column(name = "lastname")
	    private String lastname;
	    @Column(name = "mobile",unique=true, nullable=false)
	    private String mobile;
	    @Column(name = "parentuser")
	    private String parentuser;
	    // End
	    @Column(name = "accountnonexpired")
	    private Integer accountnonexpired;
	    @Column(name = "credentialsnonexpired")
	    private Integer credentialsnonexpired;
	    @Column(name = "accountnonlocked")
	    private Integer accountnonlocked;
	    
	    @Temporal(TemporalType.TIMESTAMP)
	    @Column(name = "created_date_time")
	    private Date createdDateTime;
	    
	    
	    @Transient
	    private String userHash;
	    
	    @Transient
	    private String businessUnitTypeCode;
	    
	    @Transient
	    private Integer businessUnitTypeId;
	    
	    @Column(name = "text_password")
	    private String textPassword;
	    
	    @Transient
	    private String verifyFlag;
	    
	    @Transient
	    private String status;
	    
	    @Transient
	    private String designation;
	    @Transient
	    private String staffType;
	    

	    public User(User user) {
	        this.username = user.getUsername();
	        this.password = user.getPassword();
	        this.email = user.getEmail();
	        this.enabled = user.isEnabled();
	        this.accountNonExpired = user.getAccountNonExpired();
	        this.credentialsNonExpired = user.getCredentialsNonExpired();
	        this.accountNonLocked = user.getAccountNonLocked();
//	        this.roles = user.getRoles();
	        this.firstname=user.getFirstname();
	        this.lastname=user.getLastname();
	        this.mobile=user.getMobile();
	    }

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public void setEnabled(int enabled) {
	        this.enabled = enabled;
	    }

	    public void setAccountNonExpired(boolean accountNonExpired) {
	        this.accountNonExpired = accountNonExpired;
	    }

	    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
	        this.credentialsNonExpired = credentialsNonExpired;
	    }

	    public void setAccountNonLocked(boolean accountNonLocked) {
	        this.accountNonLocked = accountNonLocked;
	    }

//	    public void setRoles(List<Role> roles) {
//	        this.roles = roles;
//	    }

	    public String getUsername() {
	        return username;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public int isEnabled() {
	        return enabled;
	    }

	    public boolean isAccountNonExpired() {
	        return accountNonExpired;
	    }

	    public boolean isCredentialsNonExpired() {
	        return credentialsNonExpired;
	    }

	    public boolean isAccountNonLocked() {
	        return accountNonLocked;
	    }
	    
	    public int getEnabled() {
	        return enabled;
	    }

	    public boolean getAccountNonExpired() {
	        return accountNonExpired;
	    }

	    public boolean getCredentialsNonExpired() {
	        return credentialsNonExpired;
	    }

	    public boolean getAccountNonLocked() {
	        return accountNonLocked;
	    }
	    
	    

	    public List<Role> getRoles() {
//	    	return null;
	        return roles;
	    }
public Integer getAccountnonexpired() {
			return accountnonexpired;
		}

		public void setAccountnonexpired(Integer accountnonexpired) {
			this.accountnonexpired = accountnonexpired;
		}

		public Integer getCredentialsnonexpired() {
			return credentialsnonexpired;
		}

		public void setCredentialsnonexpired(Integer credentialsnonexpired) {
			this.credentialsnonexpired = credentialsnonexpired;
		}

		public Integer getAccountnonlocked() {
			return accountnonlocked;
		}

		public void setAccountnonlocked(Integer accountnonlocked) {
			this.accountnonlocked = accountnonlocked;
		}
		
		
		@PrePersist
		protected void onCreate() {
		    if (createdDateTime == null) { createdDateTime = new Date(); }
		}
		
		
		
		
		
		
		
		//	
//
      @ManyToMany(fetch = FetchType.EAGER)	 
	    @JoinTable(name = "role_user", joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
	            inverseJoinColumns = {
	                    @JoinColumn(name = "role_id", referencedColumnName = "id")})
	    private List<Role> roles;


	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getParentuser() {
		return parentuser;
	}

	public void setParentuser(String parentuser) {
		this.parentuser = parentuser;
	}

	public Date getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public String getUserHash() {
		return userHash;
	}

	public void setUserHash(String userHash) {
		this.userHash = userHash;
	}

	public String getBusinessUnitTypeCode() {
		return businessUnitTypeCode;
	}

	public void setBusinessUnitTypeCode(String businessUnitTypeCode) {
		this.businessUnitTypeCode = businessUnitTypeCode;
	}

	public String getTextPassword() {
		return textPassword;
	}

	public void setTextPassword(String textPassword) {
		this.textPassword = textPassword;
	}

	public String getVerifyFlag() {
		return verifyFlag;
	}

	public void setVerifyFlag(String verifyFlag) {
		this.verifyFlag = verifyFlag;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
	
}
