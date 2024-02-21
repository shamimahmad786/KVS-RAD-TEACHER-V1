package com.example.MOERADTEACHER.security;

//package com.example.demo.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.MOERADTEACHER.security.pojo.ChildUser;


@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findByEmail(String email);

  @Query("select u from User u where u.username like %:username%")
	//@Query("select u from User u where u.username = :usernam")
	List<User> getByUsername(@Param("username") String username);

	User findByUsername(String username);

	public User findByUsernameAndPassword(String username, String password);

//	public List<User> getUserList(String search);s
//		public List<User> findByStateId(String stateId);		// Commented by Shamim 27-04-2023								 
	public Optional<User> findById(Integer id);
	
	@Query("select u from User u where u.username =:username  and (text_password is NULL or text_password ='system123#')")
	public User checkPasswordChanged(@Param("username") String username);
	
	List<User> findByMobile(String mobile);
	
	
	@Query("select new com.example.MOERADTEACHER.security.pojo.ChildUser(u.username,u.email,u.enabled,u.firstname,u.mobile,u.parentuser) from User u where u.parentuser=:parentuser order by username")
	List<ChildUser> getByParentuser(String parentuser);
	
    @Modifying
	@Query("update User usr set usr.mobile =:mobile where usr.username =:username")
	public void updateUserMobile(@Param("mobile") String mobiles,@Param("username") String usernames);
    
    @Modifying
   	@Query("update User usr set usr.email =:email where usr.username =:username")
   	public void updateUserEmail(@Param("email") String email,@Param("username") String usernames);
    
   
    
    @Modifying
   	@Query("update User usr set usr.enabled =:enabled where usr.username =:username")
   	public void updateUserActivate(@Param("enabled") Integer enabled,@Param("username") String usernames);
    
    @Modifying
   	@Query("update User usr set usr.firstname =:firstname where usr.username =:username")
   	public void updateFirstName(@Param("firstname") String firstname,@Param("username") String usernames);

}
