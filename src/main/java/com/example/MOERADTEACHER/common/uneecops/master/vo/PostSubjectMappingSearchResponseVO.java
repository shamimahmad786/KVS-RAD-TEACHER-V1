package com.example.MOERADTEACHER.common.uneecops.master.vo;
import lombok.Data;
@Data
public class PostSubjectMappingSearchResponseVO {
	private Integer staffTypeId;
	private Integer postId;
	private Integer subjectId;
	private String staffType;
	private String postCode;
	private String postName;
	private String subjectCode;
	private String subjectName;
//	public PostSubjectMappingSearchResponseVO(Integer staffTypeId, Integer postId, Integer subjectId, String staffType,
//			String postCode, String postName, String subjectCode, String subjectName) {
		public PostSubjectMappingSearchResponseVO(Integer postId, Integer subjectId, 
				String postCode, String postName, String subjectCode, String subjectName) {
		super();
//		this.staffTypeId = staffTypeId;
		this.postId = postId;
		this.subjectId = subjectId;
//		this.staffType = staffType;
		this.postCode = postCode;
		this.postName = postName;
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
	}
	public PostSubjectMappingSearchResponseVO(String postCode, String postName, String subjectCode, String subjectName) {
		super();
		this.postCode = postCode;
		this.postName = postName;
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
	}
	
	
	

}
