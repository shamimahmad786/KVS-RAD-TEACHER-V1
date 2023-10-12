package com.example.MOERADTEACHER.security;

import java.util.Map;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//import com.me.user.UserService.bean.MailBean;

@Service
public class RestMailService {
	  private final RestTemplate restTemplate;

	    public RestMailService(RestTemplateBuilder restTemplateBuilder) {
	        this.restTemplate = restTemplateBuilder.build();
	    }

	    @Async
	    public ResponseEntity<Map> getPostsPlainJSON(MailBean data) {
	    	
	    	
	    	
	         	HttpHeaders headers = new HttpHeaders();
//	    	    headers.setAccept(Collections.singletonList(MediaType.TEXT_PLAIN));
	    	    
	    	    String requestJson="{ \"applicationName\":\"Kvs Teacher\",\"attachmentYn\":\"0\" ,\"attachmentPath\":\"\",\"applicationId\":\"1\", \"emailTemplateId\": \"MSG-5836\", \"emailTo\": '"+data.getEmailTo()+"', \"emailCc\": \"shamim.ahmad586@gmail.com\", \"subject\": \"Teacher Module Credential \", \"signature\": '"+data.getSignature()+"', \"content\": '"+data.getContent()+"', \"closing\":'"+data.getClosing()+"' }".replaceAll("'", "\"");
              String smsJSON="{ \"mobile\":'"+data.getMobile()+"', \"otpId\":\"OTP-2\", \"applicationId\":1, \"dynamicData\":['"+data.getName()+"',\"https://kvsonlinetransfer.kvs.gov.in\",'"+data.getUserid()+"',\"system123#\"] }".replaceAll("'", "\"");
	    	    //	    	    headers.set("Authorization", "Basic YXBpYXV0aDpwaW4=");
//	    	    HttpEntity request = new HttpEntity(headers);
//	    	    HttpEntity<MailBean> request = new HttpEntity<>(data, headers);
              requestJson=requestJson.replaceAll("'", "\"");
              smsJSON=smsJSON.replaceAll("'", "\"");
              
              // System.out.println("requestJson--->"+requestJson);
              // System.out.println("smsJSON--->"+smsJSON);
              
              try {           
              	
              	System.out.println("In otp section----->"+smsJSON);
              	HttpEntity<String> request = new HttpEntity<String>(smsJSON,headers);
//              	String url = "http://10.25.26.251:8686/api/sendOTP";
      	        String url = "http://10.247.141.227:8080/ME-RAD-MESSAGE/api/sendOTP";
      	        this.restTemplate.exchange(url, HttpMethod.POST, request,Map.class,1);	
              }catch(Exception ex) {              
              	ex.printStackTrace();
              }
              
              //Mail closed
              try {
              	// System.out.println("In sms section--->"+requestJson);
	    	    HttpEntity<String> request = new HttpEntity<String>(requestJson,headers);
	        String url = "http://10.247.141.227:8080/ME-RAD-MESSAGE/api/sendMessage";
	        return this.restTemplate.exchange(url, HttpMethod.POST, request,Map.class,1);
              }catch(Exception ex) {
              	ex.printStackTrace();
              }
              
              return null;
	    }
}
