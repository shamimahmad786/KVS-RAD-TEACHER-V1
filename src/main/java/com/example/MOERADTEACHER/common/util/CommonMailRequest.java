package com.example.MOERADTEACHER.common.util;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;




@Component
public class CommonMailRequest {

	private final RestTemplate restTemplate;

	public CommonMailRequest(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	public ResponseEntity<Map> teacherConfirmationData(String data) {
		
		System.out.println("restTemplate---->"+restTemplate);
		
		HttpHeaders headers = new HttpHeaders();
//		String requestJson = "{ \"applicationName\":\"Kvs Teacher\",\"attachmentYn\":\"\" ,\"attachmentPath\":\"\",\"applicationId\":\"1\", \"emailTemplateId\": \"MSG-5837\", \"emailTo\": '"
//				+ data.getEmailTo()
//				+ "', \"emailCc\": \"shamim.ahmad586@gmail.com\", \"subject\": \"Teacher Confiration Profile Data \", \"signature\": '"
//				+ data.getSignature() + "', \"content\": '" + data.getContent() + "', \"closing\":'" + data.getClosing()
//				+ "' }".replaceAll("'", "\"");
		
//		  String json = mapper.writeValueAsString(cat);
		
		try {
			HttpEntity<String> request = new HttpEntity<String>(data, headers);
//			String url="https://demo.udiseplus.gov.in/ME-RAD-MESSAGE/api/sendMessage";
			String url = "http://10.247.141.227:8080/ME-RAD-MESSAGE/api/sendMessage";
			return this.restTemplate.exchange(url, HttpMethod.POST, request, Map.class, 1);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
