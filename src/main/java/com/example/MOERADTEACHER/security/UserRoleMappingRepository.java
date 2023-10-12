package com.example.MOERADTEACHER.security;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

//import com.me.user.UserService.user.modal.UserRoleMapping;

public interface UserRoleMappingRepository extends JpaRepository<UserRoleMapping, Integer>{
	List<UserRoleMapping> findByUserId(Integer userId);
	List<UserRoleMapping> findAllByUserId(Integer userId);
	List<UserRoleMapping> findAllByUserName(String username);

}
