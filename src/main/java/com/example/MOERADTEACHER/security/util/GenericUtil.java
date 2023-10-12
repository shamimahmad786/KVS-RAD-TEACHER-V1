package com.example.MOERADTEACHER.security.util;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GenericUtil {

	
	public Map<String,Object> getGenericMap(String data){
		ObjectMapper mapperObj = new ObjectMapper();
		Map<String,Object> mp=new HashMap<String,Object>();
		try {
			mp = mapperObj.readValue(data, new TypeReference<HashMap<String,Object>>() {
			}
			);
		}catch(Exception ex) {
		ex.printStackTrace();
		}
		return mp;
	}
	
	
	public static Map<String,Object> responseMessage(String status,String message,Object response){
		Map<String,Object> mp=new HashMap<String,Object>();
		mp.put("status", status);
		mp.put("message", message);
		mp.put("res", response);
		return mp;
	}
	
}
