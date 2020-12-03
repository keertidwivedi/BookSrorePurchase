
package org.store.com.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.store.com.model.Role;
import org.store.com.model.User;

public class MyUserDetails implements UserDetails {
	private User user;
 
	private String userName;
	private String password; 

	private Set<? extends GrantedAuthority> authorities; // private Set<? extends GrantedAuthority>authorities;

	public MyUserDetails(String userName, String password, Set<? extends GrantedAuthority> authorities) {

		this.userName = userName;
		System.out.println(userName);
		
	
		this.password = password;
		System.out.println(password);
		this.authorities = authorities;
		System.out.println(authorities);

	}
	
	
	public MyUserDetails(User user) {
		this.user = user;

	}
	
	
	
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		
		
		
		
		System.out.println(authorities);
		return authorities;

	}

	@Override
	public String getPassword() { // TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() { // TODO Auto-generated method stub
		return userName;
	}

	@Override public boolean isAccountNonExpired() { // TODO Auto-generated
 return true; }

	@Override public boolean isAccountNonLocked() { // TODO Auto-generated method
  return true; }

	@Override public boolean isCredentialsNonExpired() { // TODO Auto-generated
   return true; }

	@Override
	public boolean isEnabled() { // TODO Auto-generated method stub
		return true;
	}

}
