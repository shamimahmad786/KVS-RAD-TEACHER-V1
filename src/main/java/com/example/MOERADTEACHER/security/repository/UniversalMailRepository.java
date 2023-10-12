package com.example.MOERADTEACHER.security.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.MOERADTEACHER.security.modal.RefreshToken;
import com.example.MOERADTEACHER.security.modal.UniversalMail;

@Repository
@Transactional
public interface UniversalMailRepository extends JpaRepository<UniversalMail, Long> {

	UniversalMail findBySessionId(String sessionId);

	@Modifying
	@Query("update UniversalMail um set um.status ='S' where um.sessionId=:sessionId")
	public void updateStatusBySessionId(@Param("sessionId") String sessionId);
}
