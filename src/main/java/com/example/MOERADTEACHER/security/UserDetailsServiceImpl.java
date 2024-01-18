package com.example.MOERADTEACHER.security;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.example.MOERADTEACHER.common.exceptions.UserNotAuthorizedException;
import com.example.MOERADTEACHER.common.modal.TeacherFormStatus;
import com.example.MOERADTEACHER.common.modal.TeacherProfile;
import com.example.MOERADTEACHER.common.repository.TeacherFormStatusRepository;
import com.example.MOERADTEACHER.common.repository.TeacherProfileRepository;
import com.example.MOERADTEACHER.common.repository.TeacherRepository;
import com.example.MOERADTEACHER.common.responsehandler.ErrorResponse;
import com.example.MOERADTEACHER.common.responsehandler.ManageResponseCode;
import com.example.MOERADTEACHER.common.responsehandler.SucessReponse;
import com.example.MOERADTEACHER.common.util.NativeRepository;
import com.example.MOERADTEACHER.common.util.QueryResult;
import com.example.MOERADTEACHER.security.modal.UniversalMail;
//import com.me.user.UserService.user.modal.User;
import com.example.MOERADTEACHER.security.repository.UniversalMailRepository;

//import com.me.user.UserService.user.modal.UserRoleMapping;

//import com.me.user.UserService.bean.MailBean;
//import com.me.user.UserService.db.QueryResult;
//import com.me.user.UserService.user.modal.User;
//import com.me.user.UserService.user.modal.UserRoleMapping;
//import com.me.util.FixHashing;

//import com.example.demo.model.User;
//import com.example.demo.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	UserRoleMappingRepository userRoleMappingRepository;

	@Autowired
	RestMailService restMailService;

	@Autowired
	private LoginNativeRepository loginNativeRepository;

	@Autowired
	private QueryResult queryResult;

	@Autowired
	UniversalMailRepository universalMailRepository;
	
	@Autowired
	NativeRepository nativeRepository;
	
	@Autowired
	TeacherProfileRepository teacherProfileRepository;
	
	@Autowired
	TeacherFormStatusRepository teacherFormStatusRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		System.out.println("Called load user by username--->" + username);

		User user = userRepository.findByUsername(username.trim());
		System.out.println(user);
		if (user == null) {
			return null;
			// commented by shamim
//			throw new UsernameNotFoundException("Invalid username or password.");
		}

		// Custom to remove {bcrypt}
		user.setPassword(user.getPassword().replace("{bcrypt}", ""));
		System.out.println("After remove bcrypt password--->" + user.getPassword());

		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				Arrays.asList(new SimpleGrantedAuthority("USER")));
	}

//	private UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//    	// System.out.println(username);
//        User developer = userRepository.findByUsername(username);
//        if (developer == null) {
//            throw new UsernameNotFoundException(username);
//        }
//        return new org.springframework.security.core.userdetails.User(
//        		developer.getUsername(), 
//        		developer.getPassword(), 
//        		Arrays.asList(new SimpleGrantedAuthority("USER")));
//    }

	public Map<String, Object> checkPasswordChanged(String userId) {
		System.out.println("userId--->" + userId);
		User usrObj = userRepository.checkPasswordChanged(userId);
		Map<String, Object> hs = new HashMap<String, Object>();
		System.out.println("usrObj--->" + usrObj);

		if (usrObj != null) {
			hs.put("status", 1);
		} else {
			hs.put("status", 0);
		}

		return hs;

	}

	public User createKVUser(User data) throws Exception {

//		String id = null;
//		try {
//			QueryResult qrObj = null;
//
//			qrObj = nativeRepository.executeQueries(" select max(id) as id from user_details ");
//			System.out.println(qrObj.getRowValue().size());
//			if (qrObj.getRowValue().size() > 0) {
//				id = String.valueOf(qrObj.getRowValue().get(0).get("id"));
//			}
//			
//			System.out.println("max id--->"+id);
//			
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}

		data.setPassword("{bcrypt}" + data.getPassword());
		User userObj = new User();
//		data.setBusinessUnitTypeCode("null");
		if (!(data.getBusinessUnitTypeCode() == "null") && data.getBusinessUnitTypeCode() != null) {

			User findUserObj = userRepository.findByUsername(data.getUsername());
			// System.out.println("findUserObj---->"+findUserObj);
			FixHashing hashObj = new FixHashing();
			if (findUserObj != null) {
				data.setId(findUserObj.getId());
				userObj = userRepository.save(data);
				List<UserRoleMapping> map = userRoleMappingRepository.findAllByUserName(findUserObj.getUsername());
				if (map.size() == 0) {
					UserRoleMapping mapObj = new UserRoleMapping();
					mapObj.setApplicationId(2);
					mapObj.setApplicationName("Teacher");
					mapObj.setUserId(findUserObj.getId());
					mapObj.setUserName(data.getUsername());
					mapObj.setRoleType("1");
					mapObj.setUserLevelId(6);
					mapObj.setRoleId(16);
					mapObj.setUserLevelName(data.getBusinessUnitTypeCode());
					userRole(mapObj);
				} else {
					UserRoleMapping mapObj = new UserRoleMapping();

					// System.out.println("role id--->"+map.get(0).getId());

//				 mapObj.setId(map.get(0).getId());
					mapObj.setRoleId(map.get(0).getRoleId());
					mapObj.setApplicationId(2);
					mapObj.setApplicationName("Teacher");
					mapObj.setUserId(findUserObj.getId());
					mapObj.setUserName(data.getUsername());
					mapObj.setRoleType("1");
					mapObj.setUserLevelId(6);
					mapObj.setRoleId(16);
					mapObj.setUserLevelName(data.getBusinessUnitTypeCode());
					userRole(mapObj);
				}

				if (findUserObj.getUsername() != null) {
					String encrypted = hashObj.encrypt(String.valueOf(findUserObj.getId()));
					findUserObj.setUserHash(String.valueOf(findUserObj.getId()));
					findUserObj.setId(null);
					findUserObj.setPassword(null);
					findUserObj.setBusinessUnitTypeCode(data.getBusinessUnitTypeCode());
					findUserObj.setStatus("1");
					return findUserObj;
				}

				findUserObj.setStatus("1");

				return findUserObj;
			} else {
				// System.out.println("in else condition");
				String id = null;
				try {
					QueryResult qrObj = null;
//					qrObj = loginNativeRepository.executeQueries(" select max(id) as id from user_details");
					if (qrObj.getRowValue().size() > 0) {
						id = String.valueOf(qrObj.getRowValue().get(0).get("id"));
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}

				try {
					if (id != null) {
						data.setId(Integer.parseInt(id + 1));
					}
					userObj = userRepository.save(data);
					UserRoleMapping mapObj = new UserRoleMapping();
					mapObj.setApplicationId(2);
					mapObj.setApplicationName("Teacher");
					mapObj.setUserId(userObj.getId());
					mapObj.setUserName(data.getUsername());
					mapObj.setRoleType("1");
					mapObj.setUserLevelId(6);
					mapObj.setRoleId(16);
					mapObj.setUserLevelName(data.getBusinessUnitTypeCode());
					userRole(mapObj);
					String encrypted = hashObj.encrypt(String.valueOf(userObj.getId()));
					userObj.setUserHash(String.valueOf(userObj.getId()));
					userObj.setId(null);
					userObj.setPassword(null);

				} catch (Exception ex) {
					ex.printStackTrace();
				}

				try {
// System.out.println("Before message send");
					MailBean obj = new MailBean();
					obj.setApplicationName("Kvs Teacher");
					obj.setApplicationId("1");
					obj.setEmailTemplateId("MSG-5836");
					obj.setEmailTo(userObj.getEmail());
					obj.setSubject("Teacher Module Credential");
					obj.setSignature("Dear " + userObj.getFirstname());
					obj.setContent(
							"Your login account has been created successfully for KV Annual Transfer Process. \\n You are requested to update your profile on the portal https://kvsonlinetransfer.kvs.gov.in by using the UID: "
									+ userObj.getUsername()
									+ " and Password: system123# - Team NIC -Ministry of Education, Government of India");
					obj.setClosing("KVS Headquarter");
					obj.setMobile(userObj.getMobile());
					obj.setUserid(userObj.getUsername());
					obj.setName(userObj.getFirstname());
					obj.setAttachmentYn(null);
					obj.setAttachmentPath(null);

					restMailService.getPostsPlainJSON(obj); // temporary commented for local only

				} catch (Exception ex) {
					ex.printStackTrace();
				}
				userObj.setStatus("1");
				return userObj;
			}

		} else {
			System.out.println("Business unit code null and user id--->" + userObj.getUsername());
			userObj.setStatus("0");
			return userObj;
		}

	}

	public Object createUsers(User userObj) {
		System.out.println("users---->" + userObj.getUsername());
		Map<String,Object> result=new HashMap<String,Object>();
		User findUserObj = userRepository.findByUsername(userObj.getUsername());
		if (findUserObj != null) {
//		throw new UserNotAuthorizedException("Duplicate User id");
			return new ErrorResponse(false, ManageResponseCode.RES0002.getStatusCode(),
					ManageResponseCode.RES0002.getStatusDesc());
		} else {
			userObj.setPassword("");
			userObj.setEnabled(1);
			User newUserObj = null;
			try {
				 newUserObj = userRepository.save(userObj);
//				userObj.setPassword("{bcrypt}" + userObj.getPassword());
//				{bcrypt}$2a$10$xRoEcGw9rTUrhvC7EDsVS.Hu1df3mfW.mMkeJ03AlCFvX5goIj9R6
				
//		Set User Roll
				UserRoleMapping mapObj = new UserRoleMapping();
				mapObj.setApplicationId(2);
				mapObj.setApplicationName("Teacher");
				mapObj.setUserId(userObj.getId());
				mapObj.setUserName(userObj.getUsername());
				mapObj.setRoleType("1");
				mapObj.setUserLevelId(userObj.getBusinessUnitTypeId());
				mapObj.setRoleId(16);
				mapObj.setUserLevelName(userObj.getBusinessUnitTypeCode());
				userRole(mapObj);
				System.out.println(userObj.getBusinessUnitTypeId());
				if(userObj.getBusinessUnitTypeId() !=null && String.valueOf(userObj.getBusinessUnitTypeId()).equalsIgnoreCase("6")) {
					System.out.println("called");
					
					TeacherProfile teacherObj=	teacherProfileRepository.findAllByTeacherEmployeeCode(userObj.getUsername());
					if(teacherObj ==null) {
					TeacherProfile tp=new TeacherProfile();
					tp.setTeacherName(newUserObj.getFirstname());
					tp.setTeacherAccountId(String.valueOf(newUserObj.getId()));
					tp.setTeacherMobile(newUserObj.getMobile());
					tp.setTeacherEmail(newUserObj.getEmail());
					tp.setKvCode(userObj.getBusinessUnitTypeCode());
					tp.setCurrentUdiseSchCode(userObj.getBusinessUnitTypeCode());
					tp.setTeacherEmployeeCode(newUserObj.getUsername());
					TeacherProfile saveTeacher =teacherProfileRepository.save(tp);
					
					TeacherFormStatus tsObj=new TeacherFormStatus();
					tsObj.setFinalStatus("SE");
					tsObj.setTeacherId(saveTeacher.getTeacherId());
					teacherFormStatusRepository.save(tsObj);
					}
				}
				UniversalMail obj = new UniversalMail();
				int random_int = (int) (Math.random() * (999999 - 100000 + 1) + 100000);
				obj.setUserName(newUserObj.getUsername());
				obj.setMail(newUserObj.getEmail());
				obj.setMailType("CA");
				obj.setSessionId(String.valueOf(random_int));
				obj.setClientIp("");
				obj.setExpiryTimeInSecond(600000000);
				universalMailRepository.save(obj);
				
				
			} catch (Exception ex) {
				if (ex.getMessage().contains("user_details_mobile_unique")) {
					System.out.println("Duplicate mobile exception");
					return new ErrorResponse(false, ManageResponseCode.RES0001.getStatusCode(),
							ManageResponseCode.RES0001.getStatusDesc());
				}else if(ex.getMessage().contains("user_details_email_unique")) {
					return new ErrorResponse(false, ManageResponseCode.RES0017.getStatusCode(),
							ManageResponseCode.RES0017.getStatusDesc());
				}
				ex.printStackTrace();
			}
			return new SucessReponse(true, ManageResponseCode.RES0003.getStatusDesc(), newUserObj);
		}
		
	}

	public UserRoleMapping userRole(UserRoleMapping data) throws Exception {

		return userRoleMappingRepository.save(data);
	}

	public Map<String, Object> resetPassword(String userName) {
		User findUserObj = userRepository.findByUsername(userName);
		Map<String, Object> mp = new HashMap<String, Object>();

		System.out.println("findUserObj--->" + findUserObj);

		try {
			if (findUserObj != null) {

				try {
					findUserObj.setPassword("{bcrypt}$2a$10$xRoEcGw9rTUrhvC7EDsVS.Hu1df3mfW.mMkeJ03AlCFvX5goIj9R6");
					findUserObj.setTextPassword("system123#");
					userRepository.save(findUserObj);
//				MailBean obj = new MailBean();
//				obj.setApplicationName("Kvs Teacher");
//				obj.setApplicationId("1");
//				obj.setEmailTemplateId("MSG-5836");
//				obj.setEmailTo(findUserObj.getEmail());
//				obj.setSubject("Teacher Module Credential");
//				obj.setSignature("Dear " + findUserObj.getFirstname());
//				obj.setContent(
//						"Your Password has been reset successfully. You are requested to update your update on the portal https://kvsoninetransfer.kvs.gov.in by using the UID: "
//								+ findUserObj.getUsername()
//								+ " and Password: system123# - Team NIC -Ministry of Education, Government of India");
//				obj.setClosing("KVS Headquarter");
//				obj.setMobile(findUserObj.getMobile());
//				obj.setUserid(findUserObj.getUsername());
//				obj.setName(findUserObj.getFirstname());
//				restMailService.getPostsPlainJSON(obj);
					mp.put("status", 1);
					mp.put("message", "Passowrd reset successfully");
				} catch (Exception ex) {
					mp.put("status", 0);
					mp.put("message", "Error in password reset or message delivery");
					ex.printStackTrace();
				}
			} else {
				mp.put("status", 0);
				mp.put("message", "User Don't Exist");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return mp;
	}

	public Map<String, Object> schoolResetPassword(String userName) {
		User findUserObj = userRepository.findByUsername(userName);
		Map<String, Object> mp = new HashMap<String, Object>();

		System.out.println("findUserObj--->" + findUserObj);

		try {
			if (findUserObj != null) {

				try {
					findUserObj.setPassword("{bcrypt}$2a$10$xRoEcGw9rTUrhvC7EDsVS.Hu1df3mfW.mMkeJ03AlCFvX5goIj9R6");
					findUserObj.setTextPassword("system123#");
					userRepository.save(findUserObj);
					mp.put("status", 1);
					mp.put("message", "Passowrd reset successfully");
				} catch (Exception ex) {
					mp.put("status", 0);
					mp.put("message", "Error in password reset or message delivery");
					ex.printStackTrace();
				}
			} else {
				mp.put("status", 0);
				mp.put("message", "User Don't Exist");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return mp;
	}

	public Map<String, Object> renamePassword(String userId, String password, String newPassword) {

//	// System.out.println("userId--->"+userId);
		Map<String, Object> mp = new HashMap<String, Object>();

		User userObj = userRepository.findByUsername(userId);
		String exsitingPassword;
		String generatedSecuredPasswordHash;
		if (userObj != null) {
			exsitingPassword = userObj.getPassword().replace("{bcrypt}", "");
			boolean matched1 = BCrypt.checkpw(password, exsitingPassword);
//		
			System.out.println("userId--->" + userId);
			System.out.println("password--->" + password);
			System.out.println("newPassword--->" + newPassword);
			System.out.println("matched1--->" + matched1);

			if (matched1) {
				generatedSecuredPasswordHash = BCrypt.hashpw(newPassword, BCrypt.gensalt(10));
				userObj.setPassword("{bcrypt}" + generatedSecuredPasswordHash);
				userObj.setTextPassword(newPassword);
				userObj.setParentuser("admin");

				// System.out.println("userObj--->"+userObj.getTextPassword());
				userRepository.save(userObj);
				mp.put("status", 1);
				mp.put("message", "Password Changed successfully");
//			 // System.out.println("final password-->"+userObj.getPassword());
			} else {
				mp.put("status", 0);
				mp.put("message", "Old password didn't match");
				// System.out.println("not updated");
			}
		} else {
			mp.put("status", 0);
			mp.put("message", "Old password didn't match");
		}

//	// System.out.println("Role data--->"+userObj.getRoles());
		return mp;
	}

	public Map<String, Object> otpSignin(String mobile) {
		return null;
	}

}
