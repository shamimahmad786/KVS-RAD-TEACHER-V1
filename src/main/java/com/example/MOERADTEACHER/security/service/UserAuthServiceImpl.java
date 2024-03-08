package com.example.MOERADTEACHER.security.service;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.valves.ErrorReportValve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.example.MOERADTEACHER.common.intercepts.RSAUtil;
import com.example.MOERADTEACHER.common.modal.TeacherProfile;
import com.example.MOERADTEACHER.common.repository.TeacherProfileRepository;
import com.example.MOERADTEACHER.common.responsehandler.ErrorResponse;
import com.example.MOERADTEACHER.common.responsehandler.ManageResponseCode;
import com.example.MOERADTEACHER.common.responsehandler.SucessReponse;
import com.example.MOERADTEACHER.common.util.CustomValidator;
import com.example.MOERADTEACHER.security.LoginNativeRepository;
import com.example.MOERADTEACHER.security.User;
import com.example.MOERADTEACHER.security.UserRepository;
import com.example.MOERADTEACHER.security.modal.UniversalMail;
import com.example.MOERADTEACHER.security.modal.UserAuthOtp;
import com.example.MOERADTEACHER.security.modal.UserForgetPassword;
import com.example.MOERADTEACHER.security.pojo.ChildUser;
import com.example.MOERADTEACHER.security.repository.UniversalMailRepository;
import com.example.MOERADTEACHER.security.repository.UserAuthOtpRepository;
import com.example.MOERADTEACHER.security.repository.UserForgetPasswordRepository;
import com.example.MOERADTEACHER.security.util.GenericUtil;

@Service
public class UserAuthServiceImpl {

	@Autowired
	UserAuthOtpRepository userAuthOtpRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserForgetPasswordRepository userForgetPasswordRepository;

	@Autowired
	CustomValidator customValidator;

	@Autowired
	UniversalMailRepository universalMailRepository;
	
	@Autowired
	LoginNativeRepository loginNativeRepository;
	
	@Autowired
	TeacherProfileRepository teacherProfileRepository;

	public void getOtpForAuthentication(Map<String, Object> mp, int otp) {
		UserAuthOtp usrObj = new UserAuthOtp();
		usrObj.setMobile(String.valueOf(mp.get("mobile")));
		usrObj.setOtp(otp);
		System.out.println("Save otp");
		userAuthOtpRepository.save(usrObj);
	}

	public Boolean checkOTP(Map<String, Object> mp) {
		UserAuthOtp userObj = userAuthOtpRepository.findByMobileAndOtp(String.valueOf(mp.get("mobile")),
				Integer.parseInt(String.valueOf(mp.get("otp"))));
		if (userObj != null && userObj.getMobile() != null) {
			return true;
		} else {
			return false;
		}
	}

	public Map<String, Object> forgetPasswordMail(Map<String, Object> mp, String ipAddress) {
		List<User> usrObj = userRepository.findByEmail(String.valueOf(mp.get("email")));
		if (usrObj.size() > 0) {
			UserForgetPassword forgetObj = new UserForgetPassword();
			int random_int = (int) (Math.random() * (999999 - 100000 + 1) + 100000);
			forgetObj.setMail(usrObj.get(0).getEmail());
			forgetObj.setSessionId(random_int);
			forgetObj.setUsername(usrObj.get(0).getUsername());
			forgetObj.setClientIp(ipAddress);

			System.out.println("Client Ip---->" + ipAddress);

			userForgetPasswordRepository.save(forgetObj);
			return GenericUtil.responseMessage("1", "Please check mail for reset password", null);
		} else {
			return GenericUtil.responseMessage("0", "Mail id doesn't registered with user", null);
		}
	}

	public Map<String, Object> changePassword(Map<String, Object> data, String sessionId, String ipAddres,HttpServletRequest request) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
		
		ServletContext context = ((HttpServletRequest) request).getSession().getServletContext();
		String privateKeys = (String) context.getAttribute("_private_key");
		
		System.out.println("Decripted passowrd--->"+RSAUtil.decrypt(String.valueOf(data.get("password")), privateKeys));
		
		UserForgetPassword ufpObj = userForgetPasswordRepository.findBySessionId(Integer.parseInt(sessionId));
//		UniversalMail ufpObj = universalMailRepository.findBySessionId(sessionId);
	
		
		if (ufpObj == null) {
			return GenericUtil.responseMessage("0",
					"Session expire for change password. Please proceed forget password option once again", null);
		} else {
			try {
				User userObj = userRepository.findByUsername(ufpObj.getUsername());
				System.out.println("New Password for change--->"+String.valueOf(data.get("password")));
//				String generatedSecuredPasswordHash = BCrypt.hashpw(String.valueOf(data.get("password")),
//						BCrypt.gensalt(10));
				
				String generatedSecuredPasswordHash = BCrypt.hashpw(RSAUtil.decrypt(String.valueOf(data.get("password")), privateKeys),
						BCrypt.gensalt(10));
				
				
				userObj.setPassword("{bcrypt}" + generatedSecuredPasswordHash);
				userRepository.save(userObj);
				insertForgetPasswordHistory(ufpObj.getId());
				userForgetPasswordRepository.deleteById(ufpObj.getId());
				
				return GenericUtil.responseMessage("1", "Password Changed Successfully", null);
			} catch (Exception ex) {
				ex.printStackTrace();
				return GenericUtil.responseMessage("0", "Error occure during change password", null);
			}
		}
	}

	public Object generatePassword(Map<String, Object> data, String sessionId, String ipAddres,HttpServletRequest request) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
		ServletContext context = ((HttpServletRequest) request).getSession().getServletContext();
		String privateKeys = (String) context.getAttribute("_private_key");
		System.out.println("Decripted passowrd--->"+RSAUtil.decrypt(String.valueOf(data.get("password")), privateKeys));
		UniversalMail ufpObj = universalMailRepository.findBySessionId(sessionId);
		
		
		if (ufpObj == null) {
			return new ErrorResponse(false, ManageResponseCode.RES0018.getStatusCode(),
					ManageResponseCode.RES0018.getStatusDesc());
		} else {
			try {
				User userObj = userRepository.findByUsername(ufpObj.getUserName());
				if (userObj == null) {
					return new ErrorResponse(false, ManageResponseCode.RES0008.getStatusCode(),
							ManageResponseCode.RES0008.getStatusDesc());
				} else {
//					String generatedSecuredPasswordHash = BCrypt.hashpw(String.valueOf(data.get("password")),
//							BCrypt.gensalt(10));
					
					String generatedSecuredPasswordHash = BCrypt.hashpw(RSAUtil.decrypt(String.valueOf(data.get("password")), privateKeys),
							BCrypt.gensalt(10));
					
					userObj.setPassword("{bcrypt}" + generatedSecuredPasswordHash);
					userObj.setEnabled(1);
					userRepository.save(userObj);
					universalMailRepository.updateStatusBySessionId(sessionId);
					return new SucessReponse(true, ManageResponseCode.RES0009.getStatusCode(),
							ManageResponseCode.RES0009.getStatusDesc());
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				return new SucessReponse(false, ManageResponseCode.RES0010.getStatusCode(),
						ManageResponseCode.RES0010.getStatusDesc());
			}
		}
	}

	public List<ChildUser> getChildUser(String username) {
		return userRepository.getByParentuser(username);
	}

	public Object updateUser(Map<String, Object> data) {
		if (String.valueOf(data.get("updateType")).equalsIgnoreCase("M")) {
			
			if ((data.get("value") != null
					&& String.valueOf(data.get("value")).matches(customValidator.getMobileRegax())
					&& data.get("value") != "")) {
				List<User> userObj=userRepository.findByMobile(String.valueOf(data.get("value")));
				if(userObj.size()>1 || (userObj.size()==1 && !userObj.get(0).getUsername().equalsIgnoreCase(String.valueOf(data.get("username"))))) {
					return new ErrorResponse(false, ManageResponseCode.RES0016.getStatusCode(),
							ManageResponseCode.RES0016.getStatusDesc());
				}else {
				userRepository.updateUserMobile(String.valueOf(data.get("value")),
						String.valueOf(data.get("username")));
				
			TeacherProfile tp=	teacherProfileRepository.findAllByTeacherEmployeeCode(String.valueOf(data.get("username")));
			
			if(tp !=null) {
				tp.setTeacherMobile(String.valueOf(data.get("value")));
				teacherProfileRepository.save(tp);
			}
				
				return new SucessReponse(true, ManageResponseCode.RES0005.getStatusCode(),
						ManageResponseCode.RES0005.getStatusDesc());
				}
			} else {
				return new ErrorResponse(false, ManageResponseCode.RES0004.getStatusCode(),
						ManageResponseCode.RES0004.getStatusDesc());
			}
		} else if (String.valueOf(data.get("updateType")).equalsIgnoreCase("E")) {
			if ((data.get("value") != null && String.valueOf(data.get("value")).matches(customValidator.getEmaiRegax())
					&& data.get("value") != "")) {
				List<User> userObj=userRepository.findByEmail(String.valueOf(data.get("value")));
				if(userObj.size()>1 || (userObj.size()==1 && !userObj.get(0).getUsername().equalsIgnoreCase(String.valueOf(data.get("username"))))) {
					return new ErrorResponse(false, ManageResponseCode.RES0017.getStatusCode(),
							ManageResponseCode.RES0017.getStatusDesc());
				}else {
				userRepository.updateUserEmail(String.valueOf(data.get("value")), String.valueOf(data.get("username")));
				
				TeacherProfile tp=	teacherProfileRepository.findAllByTeacherEmployeeCode(String.valueOf(data.get("username")));
				
				if(tp !=null) {
					tp.setTeacherEmail(String.valueOf(data.get("value")));
					teacherProfileRepository.save(tp);
				}
				
				return new SucessReponse(true, ManageResponseCode.RES0006.getStatusCode(),
						ManageResponseCode.RES0006.getStatusDesc());
				}
			} else {
				return new ErrorResponse(false, ManageResponseCode.RES0007.getStatusCode(),
						ManageResponseCode.RES0007.getStatusDesc());
			}
		}else if(String.valueOf(data.get("updateType")).equalsIgnoreCase("AD")) {
			if ((data.get("value") != null && data.get("value") != "")) {
				userRepository.updateUserActivate(Integer.parseInt(String.valueOf(data.get("value"))), String.valueOf(data.get("username")));
				return new SucessReponse(true, ManageResponseCode.RES0011.getStatusCode(),
						ManageResponseCode.RES0011.getStatusDesc());
			} else {
				return new ErrorResponse(false, ManageResponseCode.RES0012.getStatusCode(),
						ManageResponseCode.RES0012.getStatusDesc());
			}
		}else if(String.valueOf(data.get("updateType")).equalsIgnoreCase("N")) {
			if ((data.get("value") != null)) {
				User userObj=userRepository.findByUsername(String.valueOf(data.get("username")));
				if(userObj ==null) {
					return new ErrorResponse(false, ManageResponseCode.RES0023.getStatusCode(),
							ManageResponseCode.RES0023.getStatusDesc());
				}else {
				userRepository.updateFirstName(String.valueOf(data.get("value")), String.valueOf(data.get("username")));
				
				TeacherProfile tp=	teacherProfileRepository.findAllByTeacherEmployeeCode(String.valueOf(data.get("username")));
				
				if(tp !=null) {
					tp.setTeacherName(String.valueOf(data.get("value")));
					teacherProfileRepository.save(tp);
				}
				
				return new SucessReponse(true, ManageResponseCode.RES0024.getStatusCode(),
						ManageResponseCode.RES0024.getStatusDesc());
				}
			} else {
				return new ErrorResponse(false, ManageResponseCode.RES0023.getStatusCode(),
						ManageResponseCode.RES0023.getStatusDesc());
			}
		}
		return data;
	}
	
	
	public void insertForgetPasswordHistory(Long id) {
		loginNativeRepository.insertQueries("insert into oauth_forget_password_history (id,clientip,createddate,mail,sessionid,status,username) select id,clientip,createddate,mail,sessionid,status,username from oauth_forget_password where id="+id);
	}

}
