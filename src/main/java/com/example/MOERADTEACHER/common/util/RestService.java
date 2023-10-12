package com.example.MOERADTEACHER.common.util;

import java.util.Collections;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.MOERADTEACHER.common.exceptions.UserNotAuthorizedException;

//@Service
@Controller
public class RestService {
	    final RestTemplate restTemplate;
	   private static final Logger LOGGER = LoggerFactory.getLogger(CustomFilter.class);
	    public RestService(RestTemplateBuilder restTemplateBuilder) {
	        this.restTemplate = restTemplateBuilder.build();
	    }

	    public ResponseEntity<TemplateBean> getPostsPlainJSON(String token) {
//	    	public ResponseEntity<?> getPostsPlainJSON(String token) {
	    	TemplateBean tb=new TemplateBean();
	    	try {
	    		tb.setStatus("1");
	         	HttpHeaders headers = new HttpHeaders();
	    	    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
	    	    headers.set("Authorization", "Basic YXBpYXV0aDpwaW4=");
//	    	    headers.set("Authorization", "Basic dGVhY2hlcmF1ZGl0OnBpbg==");
	    	    HttpEntity request = new HttpEntity(headers);
//	         String url = "http://10.25.26.251:8385/meauth/oauth/check_token?token="+token;
	        
//	    	    String url="http://10.247.141.239:8080/SpringAuthSecurity/oauth/check_token?token="+token;
	        String url="http://10.247.141.216:8080/SpringAuthSecurity/oauth/check_token?token="+token;
	        return this.restTemplate.exchange(url, HttpMethod.GET, request,TemplateBean.class,1);
	        
	    	}catch(Exception ex) {
	    		
	    		ex.printStackTrace();
	    		
	    		LOGGER.error("message", ex);
	    		tb.setStatus("0");
	    		
	    		// System.out.println("before exception");
	    		
//	    		throw new UserNotAuthorizedException("User Unauthenticated");
//	    	return ResponseEntity.ok(tb);	
	    	}
			return null;
	    	
//	    	if(tb.getStatus().equalsIgnoreCase("0")) {
//	    		throw new UserNotAuthorizedException("User Unauthenticated");
//	    	}
//			return null;
	    	
	    	
	    }
	    

	    
	    public ResponseEntity<Map> updateRole(String requestJson) {
//	    	public ResponseEntity<?> getPostsPlainJSON(String token) {
	    	TemplateBean tb=new TemplateBean();
	    	try {
	    	 	HttpHeaders headers = new HttpHeaders();
	    	    headers.setAccept(Collections.singletonList(MediaType.TEXT_PLAIN));
//                requestJson=requestJson.replaceAll("'", "\"");
                // System.out.println("requestJson--->"+requestJson);
               
	    	    HttpEntity<String> request = new HttpEntity<String>(requestJson,headers);
	            String url = "http://10.247.141.216:8080/UserService/api/user/updateRoleOnDropbox";
	            
//	            String url = "http://10.25.26.251:8090/meuser/api/user/updateRoleOnDropbox";
	            
	            return this.restTemplate.exchange(url, HttpMethod.POST, request,Map.class,1);
	    	}catch(Exception ex) {
	    		
	    		ex.printStackTrace();
	    		
	    		LOGGER.error("message", ex);
	    		tb.setStatus("0");
	    		
	    		// System.out.println("before exception");
	    		
//	    		throw new UserNotAuthorizedException("User Unauthenticated");
//	    	return ResponseEntity.ok(tb);	
	    	}
	    	
			return null;
	    	
	    }

//	    	if(tb.getStatus().equalsIgnoreCase("0")) {
//	    		throw new UserNotAuthorizedException("User Unauthenticated");
//	    	}
//			return null;
	    	
	    	
	    
	    
	    
}

