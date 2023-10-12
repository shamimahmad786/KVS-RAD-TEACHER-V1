package com.example.MOERADTEACHER.security;



import java.io.IOException;
import java.util.Arrays;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

//import com.example.demo.model.User;
//import com.example.demo.repository.UserRepository;
//import com.example.demo.service.UserDetailsServiceImpl;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	private UserRepository userRepository;
	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		String header = req.getHeader(HEADER_STRING);
		// System.out.println("called filter first--->" + header);
		// System.out.println("get request url--->" + req.getRequestURI());
		String username = null;
		String authToken = null;
		if (header != null && header.startsWith(TOKEN_PREFIX)) {
			authToken = header.replace(TOKEN_PREFIX, "");
			try {
				// System.out.println("ready to get user");
//				UserDetails userDetails = userDetailsService.loadUserByUsername(req.getHeader("userName"));
				// System.out.println("user name--->" + userDetails);
				// // System.out.println("validate
				// ---->"+jwtTokenUtil.validateToken(authToken,userDetails));
				// System.out.println("request url--->"+req.getRequestURI());
//				if (req.getRequestURI().contains("/school/") && !req.getRequestURI().contains("school/downloadDocument")) {
//					if (!jwtTokenUtil.validateToken(authToken, userDetails)
//							|| jwtTokenUtil.validateToken(authToken, userDetails) == null) {
//						res.sendError(HttpServletResponse.SC_UNAUTHORIZED);
//					}
//				}
//				username = jwtTokenUtil.getUsernameFromToken(authToken);
			} catch (IllegalArgumentException e) {
				// log.error("an error occured during getting username from token", e);
				// System.out.println("an error occured during getting username from token");
			} catch (ExpiredJwtException e) {
				// log.warn("the token is expired and not valid anymore", e);
				// System.out.println("the token is expired and not valid anymore");
			} catch (SignatureException e) {
				// log.error("Authentication Failed. Username or Password not valid.");
				// System.out.println("Authentication Failed. Username or Password not valid.");
			} catch (Exception ex) {
				// System.out.println("in my exception");
				ex.printStackTrace();
			}
		} else {
			// System.out.println("In else condition-->" + header);

//			try {
//				// System.out.println("Else in user details1");
//				UserDetails userDetails = userDetailsService.loadUserByUsername(req.getHeader("userName"));
//				// System.out.println("Else in user details1");
//				if (req.getRequestURI().contains("school") &&  !req.getRequestURI().contains("school/downloadDocument")) {
//
//					if (header == null) {
//						res.sendError(HttpServletResponse.SC_UNAUTHORIZED);
//					} else {
//						authToken = header.replace(TOKEN_PREFIX, "");
//					}
//					// System.out.println("Else in user details2");
//					if (!jwtTokenUtil.validateToken(authToken, userDetails)
//							|| jwtTokenUtil.validateToken(authToken, userDetails) == null) {
//						// System.out.println("Else in user details3");
//						res.sendError(HttpServletResponse.SC_UNAUTHORIZED);
//						// System.out.println("Else in user details4");
//					}
//				}
//				username = jwtTokenUtil.getUsernameFromToken(authToken);
//			} catch (IllegalArgumentException e) {
//				// System.out.println("an error occured during getting username from token");
//			} catch (ExpiredJwtException e) {
//				// System.out.println("the token is expired and not valid anymore");
//			} catch (SignatureException e) {
//				// System.out.println("Authentication Failed. Username or Password not valid.");
//			} catch (Exception ex) {
//				// System.out.println("in my exception");
//				ex.printStackTrace();
//			}
//		}
//		
//		try {
//		
//		// System.out.println("get authentication--->" + SecurityContextHolder.getContext().getAuthentication());
//		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//
//			UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//			// System.out.println("userDetails--->" + username);
//			if (jwtTokenUtil.validateToken(authToken, userDetails)) {
//				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
//						userDetails, null, Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")));
//				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
//				// log.info("authenticated user " + username + ", setting security context");
//				SecurityContextHolder.getContext().setAuthentication(authentication);
//			}
//		}
//		}catch(Exception ex) {
//			ex.printStackTrace();
//		}
		}
		// System.out.println("at chain filter");
		
		chain.doFilter(req, res);
	}
}
