package com.example.MOERADTEACHER.common.survey.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "question_master", schema = "survey")
public class Question_Master {
	
	
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "survey.question_master_question_id_seq")
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name="question_master_question_id_seq", sequenceName="question_master_question_id_seq",schema ="survey",allocationSize = 1,initialValue =1  )
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "question_master_question_id_seq")
	@Column(name="question_id")
	private Integer  question_id	;
	
	@Column(name="question_code")
	private String question_code	;
	@Column(name="question_text")
	private String question_text	;
	@Column(name="question_type")
	private String question_type ;
	
	@Column(name="field_position_01")
	private String field_position_01	;
	@Column(name="field_position_02")
	private String field_position_02	;
	@Column(name="field_position_03")
	private String field_position_03	;
	@Column(name="field_position_04")
	private String field_position_04	;
	@Column(name="field_position_05")
	private String field_position_05	;
	
	@Column(name="field_position_06")
	private String 	field_position_06	;
	@Column(name="field_position_07")
	private String 	field_position_07	;
	@Column(name="field_position_08")
	private String 	field_position_08	;
	@Column(name="field_position_09")
	private String 	field_position_09	;
	@Column(name="field_position_10")
	private String 	field_position_10	;
	
	@Column(name="field_position_11")
	private String 	field_position_11	;
	@Column(name="field_position_12")
	private String 	field_position_12	;
	@Column(name="field_position_13")
	private String 	field_position_13	;
	@Column(name="field_position_14")
	private String 	field_position_14	;
	@Column(name="field_position_15")	
	private String 	field_position_15	;
	
	@Column(name="field_position_16")
	private String 	field_position_16	;
	@Column(name="field_position_17")
	private String 	field_position_17	;
	@Column(name="field_position_18")
	private String 	field_position_18	;
	@Column(name="field_position_19")
	private String 	field_position_19	;
	@Column(name="field_position_20")
	private String 	field_position_20	;
	
	@Column(name="field_position_21")
	private String 	field_position_21	;
	@Column(name="field_position_22")
	private String 	field_position_22	;
	@Column(name="field_position_23")
	private String 	field_position_23	;
	@Column(name="field_position_24")
	private String 	field_position_24	;
	@Column(name="field_position_25")
	private String 	field_position_25	;
	
	@Column(name="field_position_26")
	private String 	field_position_26	;
	@Column(name="field_position_27")
	private String 	field_position_27	;
	@Column(name="field_position_28")
	private String 	field_position_28	;
	@Column(name="field_position_29")
	private String 	field_position_29	;
	@Column(name="field_position_30")
	private String 	field_position_30	;
	
	@Column(name="field_position_31")
	private String 	field_position_31	;
	@Column(name="field_position_32")
	private String 	field_position_32	;
	@Column(name="field_position_33")
	private String 	field_position_33	;
	@Column(name="field_position_34")
	private String 	field_position_34	;
	@Column(name="field_position_35")
	private String 	field_position_35	;
	
	@Column(name="field_position_36")
	private String 	field_position_36	;
	@Column(name="field_position_37")
	private String 	field_position_37	;
	@Column(name="field_position_38")
	private String 	field_position_38	;
	@Column(name="field_position_39")
	private String 	field_position_39	;
	@Column(name="field_position_40")
	private String 	field_position_40	;
	
	@Column(name="field_position_41")
	private String 	field_position_41	;
	@Column(name="field_position_42")
	private String 	field_position_42	;
	@Column(name="field_position_43")
	private String 	field_position_43	;
	@Column(name="field_position_44")
	private String 	field_position_44	;
	@Column(name="field_position_45")
	private String 	field_position_45	;
	
	@Column(name="field_position_46")
	private String 	field_position_46	;
	@Column(name="field_position_47")
	private String 	field_position_47	;
	@Column(name="field_position_48")
	private String 	field_position_48	;
	@Column(name="field_position_49")
	private String 	field_position_49	;
	@Column(name="field_position_50")
	private String 	field_position_50	;
	@Column(name="field_count")
	private int field_count	;	
	@Column(name="business_unit_identity_code")
	private String 	businessUnitIdentityCode	;
	public Integer getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(Integer question_id) {
		this.question_id = question_id;
	}
	public String getQuestion_code() {
		return question_code;
	}
	public void setQuestion_code(String question_code) {
		this.question_code = question_code;
	}
	public String getQuestion_text() {
		return question_text;
	}
	public void setQuestion_text(String question_text) {
		this.question_text = question_text;
	}
	public String getQuestion_type() {
		return question_type;
	}
	public void setQuestion_type(String question_type) {
		this.question_type = question_type;
	}
	public String getField_position_01() {
		return field_position_01;
	}
	public void setField_position_01(String field_position_01) {
		this.field_position_01 = field_position_01;
	}
	public String getField_position_02() {
		return field_position_02;
	}
	public void setField_position_02(String field_position_02) {
		this.field_position_02 = field_position_02;
	}
	public String getField_position_03() {
		return field_position_03;
	}
	public void setField_position_03(String field_position_03) {
		this.field_position_03 = field_position_03;
	}
	public String getField_position_04() {
		return field_position_04;
	}
	public void setField_position_04(String field_position_04) {
		this.field_position_04 = field_position_04;
	}
	public String getField_position_05() {
		return field_position_05;
	}
	public void setField_position_05(String field_position_05) {
		this.field_position_05 = field_position_05;
	}
	public String getField_position_06() {
		return field_position_06;
	}
	public void setField_position_06(String field_position_06) {
		this.field_position_06 = field_position_06;
	}
	public String getField_position_07() {
		return field_position_07;
	}
	public void setField_position_07(String field_position_07) {
		this.field_position_07 = field_position_07;
	}
	public String getField_position_08() {
		return field_position_08;
	}
	public void setField_position_08(String field_position_08) {
		this.field_position_08 = field_position_08;
	}
	public String getField_position_09() {
		return field_position_09;
	}
	public void setField_position_09(String field_position_09) {
		this.field_position_09 = field_position_09;
	}
	public String getField_position_10() {
		return field_position_10;
	}
	public void setField_position_10(String field_position_10) {
		this.field_position_10 = field_position_10;
	}
	public String getField_position_11() {
		return field_position_11;
	}
	public void setField_position_11(String field_position_11) {
		this.field_position_11 = field_position_11;
	}
	public String getField_position_12() {
		return field_position_12;
	}
	public void setField_position_12(String field_position_12) {
		this.field_position_12 = field_position_12;
	}
	public String getField_position_13() {
		return field_position_13;
	}
	public void setField_position_13(String field_position_13) {
		this.field_position_13 = field_position_13;
	}
	public String getField_position_14() {
		return field_position_14;
	}
	public void setField_position_14(String field_position_14) {
		this.field_position_14 = field_position_14;
	}
	public String getField_position_15() {
		return field_position_15;
	}
	public void setField_position_15(String field_position_15) {
		this.field_position_15 = field_position_15;
	}
	public String getField_position_16() {
		return field_position_16;
	}
	public void setField_position_16(String field_position_16) {
		this.field_position_16 = field_position_16;
	}
	public String getField_position_17() {
		return field_position_17;
	}
	public void setField_position_17(String field_position_17) {
		this.field_position_17 = field_position_17;
	}
	public String getField_position_18() {
		return field_position_18;
	}
	public void setField_position_18(String field_position_18) {
		this.field_position_18 = field_position_18;
	}
	public String getField_position_19() {
		return field_position_19;
	}
	public void setField_position_19(String field_position_19) {
		this.field_position_19 = field_position_19;
	}
	public String getField_position_20() {
		return field_position_20;
	}
	public void setField_position_20(String field_position_20) {
		this.field_position_20 = field_position_20;
	}
	public String getField_position_21() {
		return field_position_21;
	}
	public void setField_position_21(String field_position_21) {
		this.field_position_21 = field_position_21;
	}
	public String getField_position_22() {
		return field_position_22;
	}
	public void setField_position_22(String field_position_22) {
		this.field_position_22 = field_position_22;
	}
	public String getField_position_23() {
		return field_position_23;
	}
	public void setField_position_23(String field_position_23) {
		this.field_position_23 = field_position_23;
	}
	public String getField_position_24() {
		return field_position_24;
	}
	public void setField_position_24(String field_position_24) {
		this.field_position_24 = field_position_24;
	}
	public String getField_position_25() {
		return field_position_25;
	}
	public void setField_position_25(String field_position_25) {
		this.field_position_25 = field_position_25;
	}
	public String getField_position_26() {
		return field_position_26;
	}
	public void setField_position_26(String field_position_26) {
		this.field_position_26 = field_position_26;
	}
	public String getField_position_27() {
		return field_position_27;
	}
	public void setField_position_27(String field_position_27) {
		this.field_position_27 = field_position_27;
	}
	public String getField_position_28() {
		return field_position_28;
	}
	public void setField_position_28(String field_position_28) {
		this.field_position_28 = field_position_28;
	}
	public String getField_position_29() {
		return field_position_29;
	}
	public void setField_position_29(String field_position_29) {
		this.field_position_29 = field_position_29;
	}
	public String getField_position_30() {
		return field_position_30;
	}
	public void setField_position_30(String field_position_30) {
		this.field_position_30 = field_position_30;
	}
	public String getField_position_31() {
		return field_position_31;
	}
	public void setField_position_31(String field_position_31) {
		this.field_position_31 = field_position_31;
	}
	public String getField_position_32() {
		return field_position_32;
	}
	public void setField_position_32(String field_position_32) {
		this.field_position_32 = field_position_32;
	}
	public String getField_position_33() {
		return field_position_33;
	}
	public void setField_position_33(String field_position_33) {
		this.field_position_33 = field_position_33;
	}
	public String getField_position_34() {
		return field_position_34;
	}
	public void setField_position_34(String field_position_34) {
		this.field_position_34 = field_position_34;
	}
	public String getField_position_35() {
		return field_position_35;
	}
	public void setField_position_35(String field_position_35) {
		this.field_position_35 = field_position_35;
	}
	public String getField_position_36() {
		return field_position_36;
	}
	public void setField_position_36(String field_position_36) {
		this.field_position_36 = field_position_36;
	}
	public String getField_position_37() {
		return field_position_37;
	}
	public void setField_position_37(String field_position_37) {
		this.field_position_37 = field_position_37;
	}
	public String getField_position_38() {
		return field_position_38;
	}
	public void setField_position_38(String field_position_38) {
		this.field_position_38 = field_position_38;
	}
	public String getField_position_39() {
		return field_position_39;
	}
	public void setField_position_39(String field_position_39) {
		this.field_position_39 = field_position_39;
	}
	public String getField_position_40() {
		return field_position_40;
	}
	public void setField_position_40(String field_position_40) {
		this.field_position_40 = field_position_40;
	}
	public String getField_position_41() {
		return field_position_41;
	}
	public void setField_position_41(String field_position_41) {
		this.field_position_41 = field_position_41;
	}
	public String getField_position_42() {
		return field_position_42;
	}
	public void setField_position_42(String field_position_42) {
		this.field_position_42 = field_position_42;
	}
	public String getField_position_43() {
		return field_position_43;
	}
	public void setField_position_43(String field_position_43) {
		this.field_position_43 = field_position_43;
	}
	public String getField_position_44() {
		return field_position_44;
	}
	public void setField_position_44(String field_position_44) {
		this.field_position_44 = field_position_44;
	}
	public String getField_position_45() {
		return field_position_45;
	}
	public void setField_position_45(String field_position_45) {
		this.field_position_45 = field_position_45;
	}
	public String getField_position_46() {
		return field_position_46;
	}
	public void setField_position_46(String field_position_46) {
		this.field_position_46 = field_position_46;
	}
	public String getField_position_47() {
		return field_position_47;
	}
	public void setField_position_47(String field_position_47) {
		this.field_position_47 = field_position_47;
	}
	public String getField_position_48() {
		return field_position_48;
	}
	public void setField_position_48(String field_position_48) {
		this.field_position_48 = field_position_48;
	}
	public String getField_position_49() {
		return field_position_49;
	}
	public void setField_position_49(String field_position_49) {
		this.field_position_49 = field_position_49;
	}
	public String getField_position_50() {
		return field_position_50;
	}
	public void setField_position_50(String field_position_50) {
		this.field_position_50 = field_position_50;
	}
	public int getField_count() {
		return field_count;
	}
	public void setField_count(int field_count) {
		this.field_count = field_count;
	}
	public String getBusinessUnitIdentityCode() {
		return businessUnitIdentityCode;
	}
	public void setBusinessUnitIdentityCode(String businessUnitIdentityCode) {
		this.businessUnitIdentityCode = businessUnitIdentityCode;
	}
	
	
	
	


}
