package com.example.MOERADTEACHER.common.util;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.MOERADTEACHER.common.transferbean.DocumentBean;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class CustomObjectMapper {

	
public Map<String,Object> getMapObject(String data){
	Map<String,Object> mObj=null;
	try {
		ObjectMapper mapperObj = new ObjectMapper();
		try {
			mObj = mapperObj.readValue(data, new TypeReference<Map<String,Object>>() {
			});
		} catch (Exception ex) {
		ex.printStackTrace();
		}
	}catch(Exception ex) {
		ex.printStackTrace();
	}
	return mObj;
}



	
	
}
