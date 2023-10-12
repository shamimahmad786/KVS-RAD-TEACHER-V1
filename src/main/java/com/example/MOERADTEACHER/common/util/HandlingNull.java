package com.example.MOERADTEACHER.common.util;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HandlingNull {
public Map<Object,Object> handling(Map<Object,Object> mp) {
//	LOGGER.warn("map--->");
	
	try {
	
	 for (Object key : mp.keySet()) {
	        
	        if(String.valueOf(mp.get(key))==null || String.valueOf(mp.get(key)).equalsIgnoreCase("null")) {
	        	mp.put(key, "");
	        }
	        
	        
	        
	    }
	}catch(Exception ex) {
		ex.printStackTrace();
	}
	return mp;
	
}


public List<Map<Object,Object>> Listhandling(List<Map<Object,Object>> ltmp) {
	
	List<Map<Object,Object>> lt=new LinkedList<Map<Object,Object>>();
	for(int i=0;i<ltmp.size();i++) {
		Map<Object,Object> mp=ltmp.get(i);
	 for (Object key : mp.keySet()) {
	        
	        if(String.valueOf(mp.get(key))==null || String.valueOf(mp.get(key)).equalsIgnoreCase("null")) {
	        	mp.put(key, "");
	        }
	        
	        
	        
	    }
	 lt.add(mp);
	}
	
	return lt;
	
}

}
