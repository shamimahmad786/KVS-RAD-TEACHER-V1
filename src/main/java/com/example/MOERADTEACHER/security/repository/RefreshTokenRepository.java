package com.example.MOERADTEACHER.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import com.example.MOERADTEACHER.security.User;
import com.example.MOERADTEACHER.security.modal.RefreshToken;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long>{
	Optional<RefreshToken> findByToken(String token);

	  @Modifying
	  int deleteByUser(User user);
}
