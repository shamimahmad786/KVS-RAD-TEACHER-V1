package com.example.MOERADTEACHER.common.uneecops.master.vo;

import lombok.Data;

import lombok.Data;

@Data
public class SanctionedPostUpdateRequestVo {
	
	
	private int sactionedPostId;
	private int sanctionedPost;
	private int occupiedPost;
	private int vacant;
	private int surplus;
	public int getSactionedPostId() {
		return sactionedPostId;
	}
	public void setSactionedPostId(int sactionedPostId) {
		this.sactionedPostId = sactionedPostId;
	}
	public int getSanctionedPost() {
		return sanctionedPost;
	}
	public void setSanctionedPost(int sanctionedPost) {
		this.sanctionedPost = sanctionedPost;
	}
	public int getOccupiedPost() {
		return occupiedPost;
	}
	public void setOccupiedPost(int occupiedPost) {
		this.occupiedPost = occupiedPost;
	}
	public int getVacant() {
		return vacant;
	}
	public void setVacant(int vacant) {
		this.vacant = vacant;
	}
	public int getSurplus() {
		return surplus;
	}
	public void setSurplus(int surplus) {
		this.surplus = surplus;
	}
	
	
	
	
	
	

}
