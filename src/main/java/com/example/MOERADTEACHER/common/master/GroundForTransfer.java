package com.example.MOERADTEACHER.common.master;

import java.util.HashMap;

public  class GroundForTransfer {
 public static HashMap<Object,Object> mp=new HashMap<Object,Object>();
 
	public static HashMap<Object,Object> getGroundTransfer() {
		mp.put("G1",  "Request Transfer");
		mp.put("G2",  "Request On LTR");
		mp.put("G3", "Request On MDG");
		mp.put("G4",  "Request On DFP");
		mp.put("G5", "Request On PwD");
		mp.put("G6", "Request On Spouse Ground");
		mp.put("G7", "Surplus");
		mp.put("G8", "Displacement");
		mp.put("G9", "ADMN Ground Under PARA7(E)");
		mp.put("G10", "ADMN Ground Under 40 Years Of Age");
		mp.put("G11", "Direct Recruitment");
		mp.put("G12", "Promotion");
		mp.put("G13", "Request On SP");
		mp.put("G14", "Request On Widow/Widower");
		mp.put("G15", "Mutual Transfer");
		mp.put("G16", "Request On Any Other Ground");
		mp.put("G17", "No Taker Vacancy Availed");
		mp.put("G18", "Any Other Administrative Ground");
		mp.put("G19", "Transfer Modification");
		mp.put("G20", "Public Interest");
		return mp;
 }
}
