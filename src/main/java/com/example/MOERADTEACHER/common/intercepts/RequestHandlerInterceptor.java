package com.example.MOERADTEACHER.common.intercepts;

import java.io.BufferedReader;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.example.MOERADTEACHER.common.exceptions.GlobalErrorHandler;
import com.example.MOERADTEACHER.common.exceptions.UserNotAuthorizedException;
import com.example.MOERADTEACHER.common.modal.TeacherAuditTray;
import com.example.MOERADTEACHER.common.repository.TeacherAuditTrayRepository;
import com.example.MOERADTEACHER.common.util.RestService;

@Component
public class RequestHandlerInterceptor extends HandlerInterceptorAdapter{
	
	@Autowired
	RestService restService;
	
	@Autowired
	TeacherAuditTrayRepository teacherAuditTrayRepository;
	

 	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		ServletContext context = ((HttpServletRequest) request).getSession().getServletContext();
////		// System.out.println("preHandle() is invoked");
//		String token= request.getHeader("Authorization");
//		String username= request.getHeader("username");
////		// System.out.println("token---->"+token);
////		
////		// System.out.println("Get user name at interceptor--->"+username);
//		
////		String jsonString = request.getInputStream().toString();
////		// System.out.println(jsonString);
//		
//		try {
//			
//			TeacherAuditTray  auditObj= new TeacherAuditTray();
//			auditObj.setApi(request.getRequestURI());
//			auditObj.setIp(request.getRemoteAddr());
//			auditObj.setUser(username);
//			
//			teacherAuditTrayRepository.save(auditObj);
//			
////			String requestBody= IOUtils.toString();
////		InputStream requestInputStream = request.getInputStream();
////		   BufferedReader reader = request.getReader();
////		    StringBuilder sb = new StringBuilder();
////		    String line = reader.readLine();
////		    while (line != null) {
////		      sb.append(line + "\n");
////		      line = reader.readLine();
////		    }
////		    
////		    // System.out.println(sb);
//		}catch(Exception ex) {
//			ex.printStackTrace();
//		}
//		
////       String abc = StreamUtils.copyToByteArray(requestInputStream);
////		  BufferedReader bufferedReader = request.getReader();
////		  
////		  // System.out.println(bufferedReader);
//		  
////		// System.out.println(restService.getPostsPlainJSON(token).getBody().getUser_name());
//		
////		 if(restService.getPostsPlainJSON(token).getBody().getUser_name() !=null) {
////		
////				 }	else if(restService.getPostsPlainJSON(token).getBody().getStatus().equalsIgnoreCase("0")) {
////					 throw new UserNotAuthorizedException("Not a valid user");
////				 }
//		
//		
//		// System.out.println("data interceptor");
		
		
		try {
		
		if(true) {
			
			
//			throw new UserNotAuthorizedException("Data Tempered");
//			return false;
//			throw new UserNotAuthorizedException("Not a valid user");
		}
		}catch(Exception ex) {
			  response.getWriter().write("something");
		        response.setStatus(11);

		        return false;
//			ex.printStackTrace();
		}
		
		
		try {
			   if(context.getAttribute("_private_key") ==null) {
				   KeyPairGenerator keyGen = null;
				try {
					keyGen = KeyPairGenerator.getInstance("RSA");
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				}
			        keyGen.initialize(1024);
			        KeyPair pair = keyGen.generateKeyPair();
			       context.setAttribute("_private_key",Base64.getEncoder().encodeToString(pair.getPrivate().getEncoded()));
			       context.setAttribute("_public_key", Base64.getEncoder().encodeToString(pair.getPublic().getEncoded()));
			   }
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
		
		
//		// System.out.println("data interceptor");
		
//		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// System.out.println("post");
//		// System.out.println("postHandle() is invoked-->"+response.getWriter());

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// System.out.println("afterCompletion() is invoked");
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// System.out.println("afterConcurrentHandlingStarted() is invoked");
	}
}