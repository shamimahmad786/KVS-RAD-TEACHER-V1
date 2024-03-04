package com.example.MOERADTEACHER.security.modal;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.example.MOERADTEACHER.security.User;

@Entity(name = "refreshtoken")
public class RefreshToken {

	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private long id;

	  @OneToOne
	  @JoinColumn(name = "user_id", referencedColumnName = "id")
	  private User user;

	  @Column(nullable = false, unique = true)
	  private String token;

	  @Column(nullable = false)
	  private Instant expiryDate;
	  
//	  @Column(nullable = false, unique = true)
//	  private String accesstoken;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Instant getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Instant expiryDate) {
		this.expiryDate = expiryDate;
	}
	  
	  
	  
	  
}
