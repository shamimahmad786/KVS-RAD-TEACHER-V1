package com.example.MOERADTEACHER.security.pojo;

public class ChildUser {

	private String username;
	private String email;
	private Integer enabled;
	private String firstname;
	private String mobile;
	private String parentuser;
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}



	public ChildUser(String username, String email, Integer enabled, String firstname, String mobile,
			String parentuser) {
		super();
		this.username = username;
		this.email = email;
		this.enabled = enabled;
		this.firstname = firstname;
		this.mobile = mobile;
		this.parentuser = parentuser;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
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
	
	
}
