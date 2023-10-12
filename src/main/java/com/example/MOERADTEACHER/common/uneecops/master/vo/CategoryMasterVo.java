package com.example.MOERADTEACHER.common.uneecops.master.vo;

import javax.validation.constraints.NotNull;

public class CategoryMasterVo {
	private Integer id;
	@NotNull(message = "please enter categoryName")
	private String categoryName;
	private Boolean status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
