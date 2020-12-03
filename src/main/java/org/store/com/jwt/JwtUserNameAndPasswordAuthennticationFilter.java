package org.store.com.jwt;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.store.com.model.User;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;



public class JwtUserNameAndPasswordAuthennticationFilter extends UsernamePasswordAuthenticationFilter {

	private final AuthenticationManager authenticationManager;
	
	
	
	

	public JwtUserNameAndPasswordAuthennticationFilter(AuthenticationManager authenticationManager) {
		
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		// TODO Auto-generated method stub

		try {
			UerNamePasswordAuthenticationRequest authenticationRequest = new ObjectMapper()
					.readValue(request.getInputStream(), UerNamePasswordAuthenticationRequest.class);
			Authentication authentication = new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(),
					authenticationRequest.getPassword());
			Authentication authenticate = authenticationManager.authenticate(authentication);
			
			return authenticate;
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return super.attemptAuthentication(request, response);
	}

	@Override
	public void afterPropertiesSet() {
		// TODO Auto-generated method stub
		super.afterPropertiesSet();
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		/*
		 * User user=(User)authResult.getPrincipal(); List<String> roles=new
		 * ArrayList<>(); authResult.getAuthorities().forEach(a->{
		 * roles.add(a.getAuthority()); System.out.println(roles); });
		 */
	      
		String key = "securesecuresecuresecuresecuresecuresecuresecuresecure";
	String token =	Jwts.builder()
		.setSubject(authResult.getName())
		.claim("authorities", authResult.getAuthorities())
		
		.setIssuedAt(new Date())
		.setExpiration(java.sql.Date.valueOf(LocalDate.now().plusWeeks(2)))
		.signWith(Keys.hmacShaKeyFor(key.getBytes()))
		.compact();
		response.addHeader("Authorization", "Bearer  "  +token);
	
	}
	
}
