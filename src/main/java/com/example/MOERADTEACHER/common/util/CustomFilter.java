package com.example.MOERADTEACHER.common.util;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
//import org.springframework.core.annotation.Order;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import com.example.MOERADTEACHER.common.exceptions.UserNotAuthorizedException;
import com.example.MOERADTEACHER.common.modal.TeacherFormStatus;
import com.example.MOERADTEACHER.common.modal.TeacherProfile;
import com.example.MOERADTEACHER.common.modal.UserActivityLogs;
import com.example.MOERADTEACHER.common.repository.TeacherFormStatusRepository;
import com.example.MOERADTEACHER.common.repository.TeacherProfileRepository;
import com.example.MOERADTEACHER.common.repository.UserActivityLogsRepository;
import com.example.MOERADTEACHER.security.JwtTokenUtil;
import com.example.MOERADTEACHER.security.LoginPermision;
import com.example.MOERADTEACHER.security.LoginPermisionRepository;
import com.example.MOERADTEACHER.security.TokenRefreshException;
import com.example.MOERADTEACHER.security.TokenRefreshResponse;
import com.example.MOERADTEACHER.security.User;
import com.example.MOERADTEACHER.security.UserDetailsServiceImpl;
import com.example.MOERADTEACHER.security.UserRepository;
import com.example.MOERADTEACHER.security.modal.RefreshToken;
import com.example.MOERADTEACHER.security.modal.UserAuthLogs;
import com.example.MOERADTEACHER.security.repository.UserAuthLogsRepository;
import com.example.MOERADTEACHER.security.service.RefreshTokenService;

//@Configuration
//@Service

@Controller
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CustomFilter implements Filter {

	
	

	@Autowired
	RestService restService;

	@Autowired
	TeacherProfileRepository teacherProfileRepository;
	@Autowired
	TeacherFormStatusRepository teacherFormStatusRepository;

	@Autowired
	LoginPermisionRepository loginPermisionRepository;

	@Autowired
	JwtTokenUtil jwtTokenUtil;

	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;

	@Autowired
	RefreshTokenService refreshTokenService;

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserAuthLogsRepository userAuthLogsRepository;
	
	@Autowired
	UserActivityLogsRepository userActivityLogsRepository;
	
	@Autowired
	NativeRepository nativeRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		LOGGER.info("########## Initiating Custom filter ##########");
	}

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		try {
		
		HttpServletRequest req = (HttpServletRequest) request;

		HttpServletResponse res = (HttpServletResponse) response;
		String ipAddress = req.getHeader("X-FORWARDED-FOR");
		if (ipAddress == null) {
			ipAddress = request.getRemoteAddr();
		}
		String userName;
		String token = null;
		String username = null;
		username = req.getHeader("username");
		token = req.getHeader("authorization");
		System.out.println("Auth--->" + req.getRequestURI());
		
		
		if(token ==null) {
			token = req.getHeader("Authorization");
		}

		Enumeration<String> headerNames = req.getHeaderNames();
//
		    if (headerNames != null) {
		            while (headerNames.hasMoreElements()) {
		                    System.out.println("Header: " + req.getHeader(headerNames.nextElement()));
		            }
		    }

		if (req.getRequestURI().contains("downloadDocument") || req.getRequestURI().contains("downloadUploadDocumentById")) {
			token = req.getParameter("docId");
			username = req.getParameter("username");
		}

		if (!req.getRequestURI().contains("uploadDoc") && !req.getMethod().equalsIgnoreCase("OPTIONS")
				&& (!req.getRequestURI().contains("sign-in")) && (!req.getRequestURI().contains("generatePassword"))
				&& (!req.getRequestURI().contains("refreshtoken")) && (!req.getRequestURI().contains("changePassword"))
				&& (!req.getRequestURI().contains("forgetPasswordMail"))
				&& (!req.getRequestURI().contains("searchEmployeeForImport"))
				&& (!req.getRequestURI().contains("renamePassword"))
				&& (!req.getRequestURI().contains("getTeacherLeaveMaster"))
				&& (!req.getRequestURI().contains("getOtpForAuthentication"))
				&& (!req.getRequestURI().contains("downloadUploadDocumentById"))
				&& (!req.getRequestURI().contains("searchEmployeeForImport"))
				&& (!req.getRequestURI().contains("saveTeacherLeave"))
				&& (!req.getRequestURI().contains("getTeacherLeave"))
				&& (!req.getRequestURI().contains("deleteTeacherLeave"))
				&& (!req.getRequestURI().contains("getkvsDashboardReport")) && !req.getRequestURI().contains("getKey")  
				&& !req.getRequestURI().contains("createUsers") && !req.getRequestURI().contains("otpSignin") && !req.getRequestURI().contains("generatePassword")) {
			if (token == null) {
				throw new UserNotAuthorizedException("User not authenticate");
			} else {
				UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(username);
				if (!jwtTokenUtil.validateToken(token, userDetails)) {
					throw new UserNotAuthorizedException("User unauthenticated");
				}
			}
		} 

		try {
			if(req.getRequestURI().contains("sign-in")) {
			UserAuthLogs obj = new UserAuthLogs();
			obj.setActivity(req.getRequestURI());
			obj.setIpAddress(ipAddress);
			obj.setUsername(username);
			userAuthLogsRepository.save(obj);
			}else {
				UserActivityLogs obj = new UserActivityLogs();
				obj.setActivity(req.getRequestURI());
				obj.setIpAddress(ipAddress);
				obj.setUsername(username);
				userActivityLogsRepository.save(obj);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}


//		res.setHeader("Access-Control-Allow-Origin",req.getHeader("Origin"));
		res.setHeader("Access-Control-Allow-Origin", "*");
		res.setHeader("Access-Control-Allow-Methods", "GET,POST,DELETE,PUT,OPTIONS");
		res.setHeader("Access-Control-Allow-Headers", "*");
		res.setHeader("Access-Control-Max-Age", "180");

		// System.out.println("request url--->"+req.getRemoteHost());

		HeaderMapRequestWrapper requestWrapper = null;

		try {
//			throw new UserNotAuthorizedException("Data Tempered");
		} catch (Exception ex) {
//			throw new UserNotAuthorizedException("Data Tempered");
		} finally {
//			throw new UserNotAuthorizedException("Data Tempered");
		}
//		System.out.println("username--->"+req.getHeader("username"));
//		System.out.println("loginType--->"+req.getHeader("loginType"));
		String loginType = req.getHeader("loginType");
		String systemTeacherCode = req.getHeader("Systemteachercode");
//		System.out.println("systemTeacherCode---->"+systemTeacherCode);

//		if(!req.getMethod().equalsIgnoreCase("OPTIONS") &&  req.getRequestURI().contains("sign-in")) {
//			System.out.println("usernameForLogin-->"+username);
//			LoginPermision	loginObj= loginPermisionRepository.findAllByTeacherEmployeeCode(username);
//			System.out.println(loginObj.getStatus());
//			if(!req.getMethod().equalsIgnoreCase("OPTIONS") &&  !req.getRequestURI().contains("getkvsDashboardReport") &&  !req.getRequestURI().contains("getKey") &&  (loginObj ==null || loginObj.getStatus()==null || loginObj.getStatus().equalsIgnoreCase("0"))) {
//				throw new UserNotAuthorizedException("Unauthorized to login");	
//			}else {
//				System.out.println("in else condition");
//			}
//		}  for restricted user only

//		if(!username.contains("kv_") && !req.getRequestURI().contains("national_") && !req.getRequestURI().contains("ro_")) {
//			
//		}

		System.out.println("pass----->");

		if (!req.getMethod().equalsIgnoreCase("OPTIONS") && (
				 req.getRequestURI().contains("saveProfileV2")
				|| req.getRequestURI().contains("saveWorkExperienceV2") || req.getRequestURI().contains("deleteByWorkExperienceId")
				|| req.getRequestURI().contains("saveTeacherConfirmationV2") )) {
			if (!username.contains("kv_") && !username.contains("ziet_") && !req.getRequestURI().contains("national_")) {
				throw new UserNotAuthorizedException("Data Tempered");
			} else if(username.contains("kv_") || username.contains("ziet_")) {
					TeacherProfile tp = teacherProfileRepository.findAllByTeacherEmployeeCode(systemTeacherCode);
					if (tp != null) {
						TeacherFormStatus tfs = teacherFormStatusRepository.findAllByTeacherId(tp.getTeacherId());
						if ((tfs.getProfileFinalStatus().equalsIgnoreCase("SA")
										|| tfs.getTransferFinalStatus().equalsIgnoreCase("TS")
										|| tfs.getTransferFinalStatus().equalsIgnoreCase("TE")
										|| tfs.getProfileFinalStatus().equalsIgnoreCase("TA"))) {
							throw new UserNotAuthorizedException("Data Tempered");
						}
					}
			}
		}
		
		
		
		String body=null;
		if (req.getHeader("access-control-request-headers") == null || true) {
			if (!req.getMethod().equalsIgnoreCase("OPTIONS") &&  !req.getRequestURI().contains("uploadDoc") && !req.getRequestURI().contains("createKvUser")
					&& !req.getRequestURI().contains("getMaster") && !req.getRequestURI().contains("uploadDocument") && !req.getRequestURI().contains("fileUpload")
					&& !req.getRequestURI().contains("uploadProfileImage")
					&& !req.getRequestURI().contains("fileUpload")
					&& !req.getRequestURI().contains("getKey")
					&& !req.getRequestURI().contains("getkvsDashboardReport")
					&& !req.getRequestURI().contains("getOtpForAuthentication")
					&& !req.getRequestURI().contains("otpSignin")
					&& (!req.getRequestURI().contains("searchEmployeeForImport"))
					&& !req.getRequestURI().contains("downloadUploadDocumentById")
					&& !req.getRequestURI().contains("resetPassword")
					&& !req.getRequestURI().contains("refreshtoken")
					&& !req.getRequestURI().contains("changePassword")
					&& (!req.getRequestURI().contains("getTeacherLeaveMaster"))
					&& (!req.getRequestURI().contains("saveTeacherLeave"))
					&& (!req.getRequestURI().contains("getTeacherLeave"))
					&& (!req.getRequestURI().contains("deleteTeacherLeave"))
					&& !req.getRequestURI().contains("generatePassword")
					&& !req.getRequestURI().contains("downloadDocument")
					&& (!req.getRequestURI().contains("forgetPasswordMail"))
					&& !req.getRequestURI().contains("getDocumentByTeacherId")
					&& !req.getRequestURI().contains("getProfileImage") && !req.getRequestURI().contains("sign-in") && !req.getRequestURI().contains("getKVRegions")) {
				XSSRequestWrapper wrappedRequest1 = new XSSRequestWrapper(req);
				 body = wrappedRequest1.getBody();
				String clientIP = wrappedRequest1.getRemoteHost();
				int clientPort = request.getRemotePort();
				String uri = wrappedRequest1.getRequestURI();
				String x_headers = req.getHeader("X-HEADERS");
				String typeCheck = req.getHeader("TYPE-CHECK");
				System.out.println(req.getRequestURI()+"--------"+body+"----"+x_headers);
				System.out.println("body--->"+body+"------TypeCheck-----"+typeCheck);
				if (body != null && body != "" && typeCheck !=null && typeCheck.equalsIgnoreCase("1")) {
					StringBuilder sb = new StringBuilder();
					try {
						MessageDigest md = MessageDigest.getInstance("MD5");
						md.update(body.getBytes());
						byte[] bytes = md.digest();
						for (int i = 0; i < bytes.length; i++) {
							sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					if (sb.toString().equalsIgnoreCase(x_headers)) {
						System.out.println("Match hashing");

					} else {
						System.out.println("Not match hashing");
						nativeRepository.updateQueries("insert into hash_table_test values ('"+body+"','"+req.getRequestURI()+"')");
				throw new UserNotAuthorizedException("Data Tempered");
					}
					requestWrapper = new HeaderMapRequestWrapper(wrappedRequest1);
				}else if(body != null && body != "" && typeCheck !=null && typeCheck.equalsIgnoreCase("0")){
					requestWrapper = new HeaderMapRequestWrapper(wrappedRequest1);
				}else if(typeCheck.equalsIgnoreCase("99")){
					requestWrapper = new HeaderMapRequestWrapper(wrappedRequest1);
				}else {
					System.out.println("data tempared--->"+req.getRequestURI());
					throw new UserNotAuthorizedException("Data Tempered");
				}

			} else {

				requestWrapper = new HeaderMapRequestWrapper(req);
			}
			
		if(body !=null && (body.toLowerCase().contains("delete") )) {
			throw new UserNotAuthorizedException("Data Tempered");
		}
			
//			Enumeration headerNames = req.getHeaderNames();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

//		  while (headerNames.hasMoreElements()) {
//	            String key = (String) headerNames.nextElement();
//	            String value = req.getHeader(key);
//	           // System.out.println(key+"-----"+value);
//	        }

//		LOGGER.info("::::::::::::::::::::::::::::" + req.getRequestURI() + ":::::::::::::::::::::::::::::::::::");

			try {
				if (!req.getRequestURI().contains("getDocumentByTeacherId")
						&& !req.getRequestURI().contains("getProfileImage")
						&& !req.getRequestURI().contains("uploadProfileImage")
						&& !req.getRequestURI().contains("deleteDocumentByTeacherIdAndName")
						&& !req.getRequestURI().contains("getDocumentByTeacherId")
						&& !req.getRequestURI().contains("uploadDocument")
						&& !req.getRequestURI().contains("fileUpload")
						&& !req.getRequestURI().contains("createKvUser")
						&& !req.getRequestURI().contains("get-usercradential")
						&& !req.getRequestURI().contains("downloadDocument")
						&& !req.getRequestURI().contains("createUsers")) {
					if (token != null) {
						UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(username);
						if (true) {
							requestWrapper.addHeader("username", username);
							requestWrapper.addHeader("ipaddress", ipAddress);
						} else {
							throw new UserNotAuthorizedException("User unauthenticated");
						}
					} else {
						requestWrapper.addHeader("username", "XYZ");
						
					}
				} else if (req.getRequestURI().contains("downloadDocument")) {

				} else {
					requestWrapper.addHeader("username", username);
					requestWrapper.addHeader("ipaddress", ipAddress);
				}

			} catch (Exception ex) {

				requestWrapper.addHeader("username", "tokenFail");
				LOGGER.error(":::::::::::Error in check token:::::::::::::::::");
				LOGGER.error("message", ex);
				ex.printStackTrace();
			}

			System.out.println("End of the interceptor");

//		response.setHeader("Access-Control-Allow-Origin", "http://10.25.26.251:4200,https://demopgi.udiseplus.gov.in,https://pgi.udiseplus.gov.in");
			res.setHeader("Access-Control-Allow-Origin", req.getHeader("Origin"));
//	        response.setHeader("Access-Control-Allow-Origin", "*");
			res.setHeader("Access-Control-Allow-Methods", "GET,POST,DELETE,PUT,OPTIONS");
			res.setHeader("Access-Control-Allow-Headers", "*");
			res.setHeader("Access-Control-Max-Age", "180");
			System.out.println("Move");
			chain.doFilter(requestWrapper, res);
		} else {
			chain.doFilter(req, res);
		}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
//		 return;
	}

	public class HeaderMapRequestWrapper extends HttpServletRequestWrapper {

		public HeaderMapRequestWrapper(HttpServletRequest request) {
			super(request);
		}

		private Map<String, String> headerMap = new HashMap<String, String>();

		public void addHeader(String name, String value) {
			headerMap.put(name, value);
		}

		@Override
		public String getHeader(String name) {
			String headerValue = super.getHeader(name);
			if (headerMap.containsKey(name)) {
				headerValue = headerMap.get(name);
			}
			return headerValue;
		}

		@Override
		public Enumeration<String> getHeaderNames() {
			List<String> names = Collections.list(super.getHeaderNames());
			for (String name : headerMap.keySet()) {
				names.add(name);
			}
			return Collections.enumeration(names);
		}

		@Override
		public Enumeration<String> getHeaders(String name) {
			List<String> values = Collections.list(super.getHeaders(name));
			if (headerMap.containsKey(name)) {
				values.add(headerMap.get(name));
			}
			return Collections.enumeration(values);
		}

	}

	private void logPostOrPutRequestBody(HttpServletRequest httpRequest) throws IOException {
		if (Arrays.asList("POST", "PUT").contains(httpRequest.getMethod())) {

			try {

				String characterEncoding = httpRequest.getCharacterEncoding();
				Charset charset = Charset.forName(characterEncoding);
				String bodyInStringFormat = readInputStreamInStringFormat(httpRequest.getInputStream(), charset);

//				// System.out.println("bodyInStringFormat---->" + bodyInStringFormat);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	private String readInputStreamInStringFormat(InputStream stream, Charset charset) throws IOException {
		final StringBuilder bodyStringBuilder = new StringBuilder();
		try {
			final int MAX_BODY_SIZE = 1024;

			if (!stream.markSupported()) {
				stream = new BufferedInputStream(stream);
			}

			stream.mark(MAX_BODY_SIZE + 1);
			final byte[] entity = new byte[MAX_BODY_SIZE + 1];
			final int bytesRead = stream.read(entity);

			if (bytesRead != -1) {
				bodyStringBuilder.append(new String(entity, 0, Math.min(bytesRead, MAX_BODY_SIZE), charset));
				if (bytesRead > MAX_BODY_SIZE) {
					bodyStringBuilder.append("...");
				}
			}
			stream.reset();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bodyStringBuilder.toString();
	}

}