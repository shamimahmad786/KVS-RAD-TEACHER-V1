package com.example.MOERADTEACHER.common.util;

import org.springframework.stereotype.Component;

@Component
public  class CustomValidator {
	static String  numberRegex = "^[0-9]{0,12}$";
	static String alphanumericRegax = "^[\\-,-./a-zA-Z0-9 ]+$";
	static String jsonValidation = "\"([^\"]+)\":[\"]*([^,^\\}^\"]+)";
	static String stringNonSpecialRegax = "^([A-Za-z]+)(\\s[A-Za-z]+)*\\s?$";
	static String mobileRegax = "^[6789]\\d{9}$";
	static String emaiRegax = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
	static String adharRegex = "^[2-9]{1}[0-9]{3}[0-9]{4}[0-9]{4}$";
	static String dateRegax = "(0[1-9]|1[0-9]|2[0-9]|3[0-1]|[1-9])-(0[1-9]|1[0-2]|[1-9])-([0-9]{4})";
	static String pinregex = "^[1-9][0-9]{5}$";
	static String admisionnumericRegax = "^[\\-/a-zA-Z0-9 ]+$";
	static Integer validationFlag = null;
	public static String getNumberRegex() {
		return numberRegex;
	}
	public static void setNumberRegex(String numberRegex) {
		CustomValidator.numberRegex = numberRegex;
	}
	public static String getAlphanumericRegax() {
		return alphanumericRegax;
	}
	public static void setAlphanumericRegax(String alphanumericRegax) {
		CustomValidator.alphanumericRegax = alphanumericRegax;
	}
	public static String getJsonValidation() {
		return jsonValidation;
	}
	public static void setJsonValidation(String jsonValidation) {
		CustomValidator.jsonValidation = jsonValidation;
	}
	public static String getStringNonSpecialRegax() {
		return stringNonSpecialRegax;
	}
	public static void setStringNonSpecialRegax(String stringNonSpecialRegax) {
		CustomValidator.stringNonSpecialRegax = stringNonSpecialRegax;
	}
	public static String getMobileRegax() {
		return mobileRegax;
	}
	public static void setMobileRegax(String mobileRegax) {
		CustomValidator.mobileRegax = mobileRegax;
	}
	public static String getEmaiRegax() {
		return emaiRegax;
	}
	public static void setEmaiRegax(String emaiRegax) {
		CustomValidator.emaiRegax = emaiRegax;
	}
	public static String getAdharRegex() {
		return adharRegex;
	}
	public static void setAdharRegex(String adharRegex) {
		CustomValidator.adharRegex = adharRegex;
	}
	public static String getDateRegax() {
		return dateRegax;
	}
	public static void setDateRegax(String dateRegax) {
		CustomValidator.dateRegax = dateRegax;
	}
	public static String getPinregex() {
		return pinregex;
	}
	public static void setPinregex(String pinregex) {
		CustomValidator.pinregex = pinregex;
	}
	public static String getAdmisionnumericRegax() {
		return admisionnumericRegax;
	}
	public static void setAdmisionnumericRegax(String admisionnumericRegax) {
		CustomValidator.admisionnumericRegax = admisionnumericRegax;
	}
	public static Integer getValidationFlag() {
		return validationFlag;
	}
	public static void setValidationFlag(Integer validationFlag) {
		CustomValidator.validationFlag = validationFlag;
	}
	
	

}
