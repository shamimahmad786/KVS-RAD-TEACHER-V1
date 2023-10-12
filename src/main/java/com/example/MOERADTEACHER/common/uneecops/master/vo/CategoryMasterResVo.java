package com.example.MOERADTEACHER.common.uneecops.master.vo;

public class CategoryMasterResVo {

	private Integer id;
		private String category;
		private Boolean isActive;
		public CategoryMasterResVo(Integer id, String category, Boolean isActive) {
			super();
			this.id = id;
			this.category = category;
			this.isActive = isActive;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public Boolean getIsActive() {
			return isActive;
		}
		public void setIsActive(Boolean isActive) {
			this.isActive = isActive;
		}
		
		
}