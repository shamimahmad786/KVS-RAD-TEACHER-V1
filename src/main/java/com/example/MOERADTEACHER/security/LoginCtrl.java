package com.example.MOERADTEACHER.security;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.MOERADTEACHER.common.bean.TeacherProfileBean;
import com.example.MOERADTEACHER.common.intercepts.RSAUtil;
import com.example.MOERADTEACHER.common.modal.TeacherFormStatus;
import com.example.MOERADTEACHER.common.modal.TeacherProfile;
import com.example.MOERADTEACHER.common.responsehandler.ErrorResponse;
import com.example.MOERADTEACHER.common.responsehandler.ManageResponseCode;
import com.example.MOERADTEACHER.common.util.CustomResponse;
import com.example.MOERADTEACHER.common.util.FixHashing;
import com.example.MOERADTEACHER.common.util.NativeRepository;
import com.example.MOERADTEACHER.common.util.QueryResult;
import com.example.MOERADTEACHER.common.util.StaticReportBean;
import com.example.MOERADTEACHER.security.modal.RefreshToken;
import com.example.MOERADTEACHER.security.repository.UniversalMailRepository;
import com.example.MOERADTEACHER.security.service.RefreshTokenService;
import com.example.MOERADTEACHER.security.service.UserAuthServiceImpl;
import com.example.MOERADTEACHER.security.util.CustomEncryption;
import com.example.MOERADTEACHER.security.util.GenericUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.me.user.UserService.user.modal.User;

//import com.example.MOERADTEACHER.common.util.ApiPaths;

@RestController
//@RequestMapping(ApiPaths.LoginCtrl.CTRL)
@RequestMapping("/api/login")
@CrossOrigin(origins = "*", allowedHeaders = "*")
//@CrossOrigin(origins = {"http://10.25.26.251:4200/","https://kvsdemo.udiseplus.gov.in/","https://kvsonlinetransfer.kvs.gov.in","http://10.25.26.251:4200","http://10.25.26.10:4200","http://10.25.26.10:6200","http://demo.sdmis.gov.in","http://pgi.seshagun.gov.in","https://pgi.udiseplus.gov.in","http://pgi.udiseplus.gov.in","https://demopgi.udiseplus.gov.in","https://dashboard.seshagun.gov.in/","https://dashboard.udiseplus.gov.in"}, allowedHeaders = "*",allowCredentials = "true")
public class LoginCtrl {

	private final AuthenticationManager authenticationManager;

	private final UserRepository userRepository;

//	private final UserServiceImp userServiceImp;

	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	private final ModelMapper modelMapper;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private LoginNativeRepository loginNativeRepository;

	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;

	@Autowired
	NativeRepository nativeRepository;

	@Autowired
	UserAuthServiceImpl userAuthServiceImpl;

	@Autowired
	RefreshTokenService refreshTokenService;

//	@Bean("jdbc2")
//	public JdbcTemplate createJdbcTemplate2(@Autowired @Qualifier("loginDataSource") DataSource dataSource2){
//	    return new JdbcTemplate(dataSource2);
//	}

	public LoginCtrl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder,
			AuthenticationManager authenticationManager, ModelMapper modelMapper) {
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.modelMapper = modelMapper;
		this.authenticationManager = authenticationManager;
//		this.userServiceImp = userServiceImp;
	}

	@RequestMapping(value = "/sign-in", method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody String data, @RequestHeader("username") String username,
			HttpServletRequest request) throws Exception {
		String userId = null;
		String password = null;
		String newPassword = null;
		ObjectMapper mapperObj = new ObjectMapper();
		LoginRequest requests = new LoginRequest();
		try {
			requests = mapperObj.readValue(data, new TypeReference<LoginRequest>() {
			});
		} catch (Exception ex) {
//			LOGGER.warn("--message--",ex);
		}

		try {
			ServletContext context = ((HttpServletRequest) request).getSession().getServletContext();
			String privateKeys = (String) context.getAttribute("_private_key");
			userId = RSAUtil.decrypt(String.valueOf(requests.getUsername()), privateKeys);
			password = RSAUtil.decrypt(String.valueOf(requests.getPassword()), privateKeys);
//			userId = requests.getUsername();
//			password = requests.getPassword();

			System.out.println("userId--->" + userId);
			System.out.println("password--->" + password);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userId, password));
		} catch (Exception ex) {

			System.out.println("unauthorized");

			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid userId and password");
		}

		final User user = userRepository.findByUsername(userId);
		final String token = jwtTokenUtil.generateToken(user);

		// Check user is active
		
		if(user.getEnabled()==0) {
			return ResponseEntity.ok(new ErrorResponse(false, ManageResponseCode.RES0013.getStatusCode(),
					ManageResponseCode.RES0013.getStatusDesc()));
		}

		System.out.println("called--->" + Long.valueOf(user.getId()));
		RefreshToken refreshToken = null;
		try {
			refreshToken = refreshTokenService.createRefreshToken(Long.valueOf(user.getId()));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		List<Map<String, Object>> appDetails = getApplicationDetails(user.getUsername(), map);
		return ResponseEntity
				.ok(new TokenResponse(user.getUsername(), token, appDetails, String.valueOf(map.get("firstname")),
						String.valueOf(map.get("lastname")), String.valueOf(map.get("mobile")),
						String.valueOf(map.get("email")), String.valueOf(map.get("hashId")), refreshToken.getToken()));
	}

	@RequestMapping(value = "/otpSignin", method = RequestMethod.POST)
	public ResponseEntity<?> otpSignin(@RequestBody String data, HttpServletRequest request) throws Exception {
		System.out.println("In otpSignin");
		ObjectMapper mapperObj = new ObjectMapper();
		Map<String, Object> mp = new HashMap<String, Object>();
		Boolean checkOtp = null;
		try {
			mp = mapperObj.readValue(data, new TypeReference<HashMap<String, Object>>() {
			});
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println(mp);
		final List<User> user = userRepository.findByMobile(String.valueOf(mp.get("mobile")));
		System.out.println(user);
		if (user.size() > 0) {
			try {
				checkOtp = userAuthServiceImpl.checkOTP(mp);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid userId and password");
		}
		System.out.println(checkOtp);
		if (!checkOtp) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid userId and password");
		}
		final String token = jwtTokenUtil.generateToken(user.get(0));
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(user.get(0).getUsername());
		List<Map<String, Object>> appDetails = getApplicationDetails(user.get(0).getUsername(), map);
		System.out.println("appDetails--->" + appDetails);
//		List<Map<String, Object>> appDetails=getApplicationDetails(user.getUsername(),map);
		return ResponseEntity.ok(
				new TokenResponse(user.get(0).getUsername(), token, appDetails, String.valueOf(map.get("firstname")),
						String.valueOf(map.get("lastname")), String.valueOf(map.get("mobile")),
						String.valueOf(map.get("email")), String.valueOf(map.get("hashId")), null));
	}

	@RequestMapping(value = "/getOtpForAuthentication", method = RequestMethod.POST)
	public ResponseEntity<?> getOtpForAuthentication(@RequestBody String data, HttpServletRequest request)
			throws Exception {
		ObjectMapper mapperObj = new ObjectMapper();
		Map<String, Object> mp = new HashMap<String, Object>();
		try {
			mp = mapperObj.readValue(data, new TypeReference<HashMap<String, Object>>() {
			});
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		int random_int = (int) (Math.random() * (999999 - 100000 + 1) + 100000);
		userAuthServiceImpl.getOtpForAuthentication(mp, random_int);
		return null;
	}

	@RequestMapping(value = "/forgetPasswordMail", method = RequestMethod.POST)
	public ResponseEntity<?> forgetPasswordMail(@RequestBody String data, HttpServletRequest request) throws Exception {
		HttpServletRequest req = (HttpServletRequest) request;
		String ipAddress = req.getHeader("X-FORWARDED-FOR");
		System.out.println("Request Ip Address--->" + ipAddress);
		Map<String, Object> mObj = new GenericUtil().getGenericMap(data);
		Map<String, Object> usrObject = userAuthServiceImpl.forgetPasswordMail(mObj, ipAddress);
		return ResponseEntity.ok(usrObject);
	}

	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public ResponseEntity<?> changePassword(@RequestBody String data,
			@RequestParam(name = "sessionId") String sessionId, HttpServletRequest request) throws Exception {
		CustomEncryption fObj = new CustomEncryption();
//		data = fObj.decrypt(data, "1111111111111111");
		System.out.println("data--->"+data);
		Map<String, Object> mObj = new GenericUtil().getGenericMap(data);
		HttpServletRequest req = (HttpServletRequest) request;
		String ipAddress = req.getHeader("X-FORWARDED-FOR");
		return ResponseEntity.ok(userAuthServiceImpl.changePassword(mObj, sessionId, ipAddress));
	}

	@RequestMapping(value = "/generatePassword", method = RequestMethod.POST)
	public ResponseEntity<?> generatePassword(@RequestBody String data,
			@RequestParam(name = "sessionId") String sessionId, HttpServletRequest request) throws Exception {
		CustomEncryption fObj = new CustomEncryption();
//		data = fObj.decrypt(data, "1111111111111111");
		Map<String, Object> mObj = new GenericUtil().getGenericMap(data);
		HttpServletRequest req = (HttpServletRequest) request;
		String ipAddress = req.getHeader("X-FORWARDED-FOR");
		return ResponseEntity.ok(userAuthServiceImpl.generatePassword(mObj, sessionId, ipAddress));
	}

	@RequestMapping(value = "/refreshtoken", method = RequestMethod.POST)
	public ResponseEntity<?> refreshtoken(@Valid @RequestBody TokenRefreshRequest request) {
		String requestRefreshToken = request.getRefreshToken();

		return refreshTokenService.findByToken(requestRefreshToken).map(refreshTokenService::verifyExpiration)
				.map(RefreshToken::getUser).map(user -> {
					final User user1 = userRepository.findByUsername(user.getUsername());
					final String token = jwtTokenUtil.generateToken(user1);
					return ResponseEntity.ok(new TokenRefreshResponse(token, requestRefreshToken));
				})
				.orElseThrow(() -> new TokenRefreshException(requestRefreshToken, "Refresh token is not in database!"));
	}

	public List<Map<String, Object>> getApplicationDetails(String userName, Map<String, Object> map) throws Exception {
		System.out.println("Get Application1");
//		StaticReportBean sobj = new StaticReportBean();
		FixHashing hashObj = new FixHashing();
		QueryResult qrObj = null;
		System.out.println("Get Application");
		try {
			System.out.println("Get Application");
			if (userName.equalsIgnoreCase("sysadmin")) {
				System.out.println("Get Application");
				qrObj = loginNativeRepository.executeQueries("select * from iamuser.application_master");
			} else {
				System.out.println("get user details");
				qrObj = loginNativeRepository.executeQueries(
						"select * from public.role_user ru,user_details ud where ud.id= ru.user_id and ud.username='"
								+ userName + "'");
			}
			System.out.println("qrObj---?" + qrObj);
			if (!userName.equalsIgnoreCase("sysadmin")) {
				map.put("firstname", qrObj.getRowValue().get(0).get("firstname"));
				map.put("lastname", qrObj.getRowValue().get(0).get("lastname"));
				map.put("mobile", qrObj.getRowValue().get(0).get("mobile"));
				map.put("email", qrObj.getRowValue().get(0).get("email"));
				map.put("hashId", hashObj.encrypt(String.valueOf(qrObj.getRowValue().get(0).get("user_id"))));
			} else if (userName.equalsIgnoreCase("sysadmin")) {
				map.put("firstname", "sysadmin");
				qrObj.getRowValue().get(0).put("role_id", "99");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println(qrObj.getRowValue());
		return qrObj.getRowValue();
	}

	@RequestMapping(value = "/getKey", method = RequestMethod.POST)
	public ResponseEntity<?> getKey(HttpServletRequest req) {
		Map<String, Object> mp = new HashMap<String, Object>();
		ServletContext context = ((HttpServletRequest) req).getSession().getServletContext();
		System.out.println("req--->" + context.getAttribute("_public_key"));
		mp.put("key", context.getAttribute("_public_key"));
		return ResponseEntity.ok(mp);
	}

	@RequestMapping(value = "/checkPasswordChanged", method = RequestMethod.POST)
	public ResponseEntity<?> checkPasswordChanged(@RequestBody String userId) {
		System.out.println("userId---->" + userId);
		Map<String, Object> mp = new HashMap<String, Object>();
		try {
			ObjectMapper mapperObj = new ObjectMapper();
			mp = mapperObj.readValue(userId, Map.class);
		} catch (Exception ex) {
//				LOGGER.warn("--message--",ex);
		}

		return ResponseEntity.ok(userDetailsServiceImpl.checkPasswordChanged(String.valueOf(mp.get("userId"))));
	}

	@RequestMapping(value = "/createKvUser", method = RequestMethod.POST)
	public User createUser(@RequestBody String data) throws Exception {
		ObjectMapper mapperObj = new ObjectMapper();

		System.out.println("data--->" + data);

		User userdata = new User();
		try {
			userdata = mapperObj.readValue(data, new TypeReference<User>() {
			});
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return userDetailsServiceImpl.createKVUser(userdata);
	}

//	@Transactional
	@RequestMapping(value = "/createUsers", method = RequestMethod.POST)
	public ResponseEntity<?> createUsers(@RequestBody String data) throws Exception {
		System.out.println("Create User Ctrl");
		ObjectMapper mapperObj = new ObjectMapper();
		CustomEncryption fObj = new CustomEncryption();
//		data = fObj.decrypt(data, "1111111111111111");
		User userdata = new User();
		try {
			userdata = mapperObj.readValue(data, new TypeReference<User>() {
			});
		} catch (Exception ex) {
			ex.printStackTrace();
		}
//		HttpServletRequest req = (HttpServletRequest) request;
//		String ipAddress = req.getHeader("X-FORWARDED-FOR");
		return ResponseEntity.ok(userDetailsServiceImpl.createUsers(userdata));
	}

	@RequestMapping(value = "/renamePassword", method = RequestMethod.POST)
	public Map<String, Object> renamePassword(@RequestBody String data, HttpServletRequest request) throws Exception {
		ServletContext context = ((HttpServletRequest) request).getSession().getServletContext();
		String privateKeys = (String) context.getAttribute("_private_key");
		String userId = null;
		String password = null;
		String newPassword = null;
		// System.out.println(data);
		ObjectMapper mapperObj = new ObjectMapper();
		RenamePassword tdata = new RenamePassword();
		try {
			tdata = mapperObj.readValue(data, new TypeReference<RenamePassword>() {
			});
		} catch (Exception ex) {
			ex.printStackTrace();
//					LOGGER.warn("--message--",ex);
		}

		System.out.println("userId---->" + tdata.getUserId());

		try {
			userId = RSAUtil.decrypt(String.valueOf(tdata.getUserId()), privateKeys);
			password = RSAUtil.decrypt(String.valueOf(tdata.getOldPassword()), privateKeys);
			newPassword = RSAUtil.decrypt(String.valueOf(tdata.getNewPassword()), privateKeys);

			System.out.println("userId--->" + userId);
			System.out.println("password--->" + password);
			System.out.println("newPassword--->" + newPassword);
//					 System.out.println("matched1--->"+matched1);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

//				return null;
		return userDetailsServiceImpl.renamePassword(userId, password, newPassword);
//				// System.out.println("userId---->"+userId);
//				return userService.resetPassword(userId);
	}

	@RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
	public Map<String, Object> resetPassword(@RequestBody String userId) throws Exception {
		System.out.println("userId---->" + userId);
		return userDetailsServiceImpl.resetPassword(userId);
	}

	@RequestMapping(value = "/schoolResetPassword", method = RequestMethod.POST)
	public Map<String, Object> schoolResetPassword(@RequestBody String userId) throws Exception {
		System.out.println("userId---->" + userId);
		return userDetailsServiceImpl.resetPassword(userId);
	}

	@RequestMapping(value = "/correctPassword", method = RequestMethod.POST)
	public Map<String, Object> correctPassword(@RequestBody String empcode) {
//			  System.out.println("data--->"+data);
////			  System.out.println(empcode);
		Map<String, Object> mp = new HashMap<String, Object>();
//			  
//			  
//			  try {
//				  QueryResult qruser=  loginNativeRepository.executeQueries("select teacher_employee_code,teacher_id from public.userlist3");
//				 
//				  for(int i=0;i<qruser.getRowValue().size();i++) {
//			
//					  
//					  QueryResult qr1=  loginNativeRepository.executeQueries("select id,username from public.user_details where username='"+qruser.getRowValue().get(i).get("teacher_employee_code")+"'");
//					  
//					  ObjectMapper mapperObj = new ObjectMapper();
//					  try {
//						  
//						  
//							 System.out.println(qr1.getRowValue().size());
//							 Logis mp1=new Logis();
//							 if(qr1.getRowValue().size()>0) {
//								 
//								 
//								 mp1 = mapperObj.convertValue(qr1.getRowValue().get(0), Logis.class);
//								 String query1="update public.teacher_profile set teacher_account_id='"+mp1.getId()+"' , teacher_system_generated_code='"+qruser.getRowValue().get(i).get("teacher_employee_code")+"', verify_flag='SI' where teacher_employee_code='"+qruser.getRowValue().get(i).get("teacher_employee_code")+"'";
////									
//									  nativeRepository.updateQueries(query1);
//									  nativeRepository.updateQueries("update public.teacher_form_status set final_status='SI', form5_status='EC'  where teacher_id='"+qruser.getRowValue().get(i).get("teacher_employee_code")+"'"); 
//									  System.out.println(qruser.getRowValue().get(i).get("teacher_employee_code"));
//							 }
//							 
////							 System.out.println("aaa->"+qr1.getRowValue().get(i));
//			
//							}catch(Exception ex) {
//								ex.printStackTrace();
////								LOGGER.warn("--message--",ex);
//							}
//					  
//					  
//					  
//					  
//					  
//				  }
////				  System.out.println(qr.getRowValue().get(0).get("teacher_employee_code"));
//				  
////				  System.out.println();
//				  
////	  for(int i=0;i<qr.getRowValue().size();i++) {
////		  QueryResult qr1=  loginNativeRepository.executeQueries("select id,username from public.user_details where username='"+qr.getRowValue().get(i).get("teacher_employee_code")+"'");  
////		 System.out.println(qr1.getRowValue().size());
////		 System.out.println(qr1.getRowValue());
////			ObjectMapper mapperObj = new ObjectMapper();
////			ArrayList<Map<String,Integer>> mp=new ArrayList<Map<String,Integer>>();
//			Logis mp1=new Logis();
////			for()
////		 try {
////			 System.out.println(qr1.getRowValue());
////			 System.out.println("aaa->"+qr1.getRowValue().get(i));
////			 mp1 = mapperObj.convertValue(qr1.getRowValue().get(i), Logis.class);
////			}catch(Exception ex) {
////				ex.printStackTrace();
//////				LOGGER.warn("--message--",ex);
////			}
////		 System.out.println(mp1.getTeacher_employee_code());
////		  if(qr1.getRowValue().size()>0) {
////		  String query1="update public.teacher_profile set teacher_account_id='"+mp1.getTeacher_id()+"' , teacher_system_generated_code='"+mp1.getTeacher_employee_code()+"', verify_flag='SI' where teacher_employee_code='"+mp1.getTeacher_employee_code()+"'";
////		
////		  nativeRepository.updateQueries(query1);
////		  nativeRepository.updateQueries("update public.teacher_form_status set final_status='SI', form5_status='EC'  where teacher_id='"+String.valueOf(qr.getRowValue().get(0).get("teacher_id"))+"'");
////		  }
//	  }
//			  catch(Exception ex) {
//				  ex.printStackTrace();
//			  }

		ArrayList<String> ar = new ArrayList<String>();
		ar.add("71145");
		ar.add("13334");
		ar.add("13911");
		ar.add("14754");
		ar.add("15038");
		ar.add("17803");
		ar.add("38048");
		ar.add("38418");
		ar.add("39404");
		ar.add("39541");
		ar.add("40096");
		ar.add("43071");
		ar.add("45792");
		ar.add("47922");
		ar.add("49478");
		ar.add("53672");
		ar.add("68574");
		ar.add("69845");
		ar.add("70198");
		ar.add("73412");
		ar.add("80826");
		ar.add("80901");
		ar.add("80902");
		ar.add("82476");
		ar.add("17778");
		ar.add("18322");
		ar.add("19416");
		ar.add("24646");
		ar.add("45047");
		ar.add("19620");
		ar.add("33312");
		ar.add("8486");
		ar.add("19293");
		ar.add("33956");
		ar.add("52504");
		ar.add("68607");
		ar.add("34799");
		ar.add("18403");
		ar.add("18613");
		ar.add("20121");
		ar.add("53519");
		ar.add("4209");
		ar.add("5076");
		ar.add("20893");
		ar.add("21019");
		ar.add("21034");
		ar.add("29181");
		ar.add("43330");
		ar.add("76469");
		ar.add("10013");
		ar.add("22635");
		ar.add("47141");
		ar.add("57436");
		ar.add("62066");
		ar.add("8465");
		ar.add("5806");
		ar.add("73082");
		ar.add("42366");
		ar.add("26367");
		ar.add("55336");
		ar.add("54867");
		ar.add("43292");
		ar.add("43292");
		ar.add("14735");
		ar.add("14735");
		ar.add("15218");
		ar.add("21157");
		ar.add("45252");
		ar.add("45252");
		ar.add("5172");
		ar.add("5203");
		ar.add("5207");
		ar.add("5208");
		ar.add("20690");
		ar.add("38481");
		ar.add("70218");
		ar.add("70218");
		ar.add("44168");
		ar.add("8901");
		ar.add("48952");
		ar.add("48952");
		ar.add("51328");
		ar.add("80961");
		ar.add("55117");
		ar.add("8516");
		ar.add("7963");
		ar.add("51344");
		ar.add("19397");
		ar.add("53921");
		ar.add("27956");
		ar.add("29576");
		ar.add("61131");
		ar.add("29087");
		ar.add("29095");
		ar.add("27458");
		ar.add("29166");
		ar.add("29179");
		ar.add("29180");
		ar.add("14909");
		ar.add("45377");
		ar.add("27747");
		ar.add("29559");
		ar.add("29610");
		ar.add("29477");
		ar.add("29544");
		ar.add("29821");
		ar.add("29698");
		ar.add("2983");
		ar.add("22471");
		ar.add("30229");
		ar.add("37813");
		ar.add("16103");
		ar.add("5664");
		ar.add("9535");
		ar.add("70540");
		ar.add("70642");
		ar.add("34645");
		ar.add("14540");
		ar.add("29884");
		ar.add("30658");
		ar.add("6170");
		ar.add("30183");
		ar.add("31346");
		ar.add("51082");
		ar.add("34263");
		ar.add("71092");
		ar.add("34331");
		ar.add("8775");
		ar.add("33652");
		ar.add("33942");
		ar.add("34345");
		ar.add("34435");
		ar.add("34441");
		ar.add("34482");
		ar.add("34508");
		ar.add("35064");
		ar.add("44782");
		ar.add("54725");
		ar.add("58131");
		ar.add("58132");
		ar.add("58535");
		ar.add("92954");
		ar.add("33668");
		ar.add("78393");
		ar.add("33741");
		ar.add("35312");
		ar.add("35317");
		ar.add("57348");
		ar.add("69152");
		ar.add("74781");
		ar.add("75780");
		ar.add("77490");
		ar.add("77492");
		ar.add("78961");
		ar.add("79181");
		ar.add("2508");
		ar.add("27469");
		ar.add("78278");
		ar.add("78278");
		ar.add("50840");
		ar.add("50840");
		ar.add("17101");
		ar.add("17102");
		ar.add("17105");
		ar.add("17122");
		ar.add("17482");
		ar.add("17809");
		ar.add("37953");
		ar.add("68008");
		ar.add("80721");
		ar.add("79072");
		ar.add("15590");
		ar.add("37718");
		ar.add("37725");
		ar.add("37906");
		ar.add("37906");
		ar.add("39840");
		ar.add("39840");
		ar.add("69470");
		ar.add("44735");
		ar.add("45669");
		ar.add("45819");
		ar.add("17644");
		ar.add("13480");
		ar.add("41042");
		ar.add("38309");
		ar.add("38309");
		ar.add("39111");
		ar.add("46212");
		ar.add("16994");
		ar.add("16994");
		ar.add("39436");
		ar.add("39436");
		ar.add("39436");
		ar.add("39436");
		ar.add("511992");
		ar.add("35679");
		ar.add("52105");
		ar.add("50857");
		ar.add("12396");
		ar.add("34725");
		ar.add("41857");
		ar.add("42170");
		ar.add("48829");
		ar.add("52487");
		ar.add("54509");
		ar.add("55310");
		ar.add("49834");
		ar.add("49546");
		ar.add("47271");
		ar.add("32099");
		ar.add("46285");
		ar.add("51023");
		ar.add("31850");

//			  
		for (int i = 0; i < ar.size(); i++) {

			try {
				QueryResult q2 = nativeRepository.executeQueries(
						"select teacher_id from teacher_profile where teacher_employee_code='" + ar.get(i) + "'");

				String query1 = "update public.teacher_profile set  verify_flag='TA' where teacher_employee_code='"
						+ ar.get(i) + "'";

				nativeRepository.updateQueries(query1);
				nativeRepository.updateQueries(
						"update public.teacher_form_status set final_status='TA', form5_status='EC'  where teacher_id='"
								+ String.valueOf(q2.getRowValue().get(0).get("teacher_id")) + "'");
				nativeRepository
						.updateQueries("update transfer.transfer_teacher_check set unfrez_flag='Y'  where teacher_id='"
								+ String.valueOf(q2.getRowValue().get(0).get("teacher_id")) + "'");
//				
//				System.out.println("teacherId--->"+String.valueOf(q2.getRowValue().get(0).get("teacher_id")));
				mp.put("status", 1);

			} catch (Exception ex) {
				System.out.println(ar.get(i));
				mp.put("status", 0);
				ex.printStackTrace();
			}
		}
//			return mp;

//			  try {
//					FileWriter writer = new FileWriter("E:/input.txt");
//					QueryResult rs=loginNativeRepository.executeQueries("select id,username from public.user_details limit 300");
//					
//					QueryResult rs1=nativeRepository.executeQueries("select teacher_employee_code,teacher_system_generated_code,teacher_account_id from public.teacher_profile limit 3000");
//					
//					ArrayList<HashMap<String,String>> lt=new ArrayList<HashMap<String,String>>();
//					
//					for(int i=0;i<rs.getRowValue().size();i++) {
//						HashMap<String,String> hs=new HashMap<String,String>();
//						for(int j=0;j<rs1.getRowValue().size();j++) {
//						if(String.valueOf(rs.getRowValue().get(i).get("username")).equalsIgnoreCase(String.valueOf(rs1.getRowValue().get(i).get("teacher_employee_code"))) && ((rs1.getRowValue().get(i).get("teacher_system_generated_code") ==null || String.valueOf(rs1.getRowValue().get(i).get("teacher_system_generated_code")).equalsIgnoreCase("") || rs1.getRowValue().get(i).get("teacher_account_id")==null ||  String.valueOf(rs1.getRowValue().get(i).get("teacher_account_id")).equalsIgnoreCase("")   ))){
//							hs.put(String.valueOf(rs1.getRowValue().get(i).get("teacher_employee_code")), String.valueOf(rs.getRowValue().get(i).get("id")));
////							lt.add(hs);
//							System.out.println(hs);
//							 writer.write(hs + "\n"+ "");
//				
//						}
//								
//						}
//					}
//					
//					writer.close();
//					
//				}catch(Exception ex) {
//					ex.printStackTrace();
//				}
//			  

		return mp;
	}

	
	@RequestMapping(value = "/updateUsers", method = RequestMethod.POST)
	public ResponseEntity<CustomResponse> updateUsers() throws Exception {
		
		QueryResult qs=loginNativeRepository.executeQueries("select ud.username,ru.business_unit_type_code from user_details ud left join role_user ru on ud.username=ru.user_name where  left(ud.username,3) not in ('ro_','kv_','nat','zie')");
		
		for(int i=0;i<qs.getRowValue().size();i++) {
			String username1=String.valueOf(qs.getRowValue().get(i).get("username"));
			String businessUnitCode=String.valueOf(qs.getRowValue().get(i).get("business_unit_type_code"));
			System.out.println("businessUnitCode---->"+businessUnitCode);
			loginNativeRepository.updateQueries("update user_details ud set parentuser='"+"kv_"+businessUnitCode+"' where ud.username='"+username1+"'");
		}
		
		return null;
		
	}
	
	
//	map.put("ApplicationDetails",getApplicationDetails(map.get("user_name").toString(),map));

}
