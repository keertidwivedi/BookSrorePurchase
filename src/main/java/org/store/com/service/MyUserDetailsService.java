package org.store.com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.store.com.model.Role;
import org.store.com.model.User;
import org.store.com.repo.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		/*
		 * Optional<User> optionalUser = userRepository.findByUserName(userName); if
		 * (optionalUser.isPresent()) { User user = optionalUser.get();
		 * System.out.println(user); return new UserDetails(user.getUserName(),
		 * user.getPassword(), null); } else { throw new
		 * UsernameNotFoundException("could not found user"); }
		 */
		
		
		User user = userRepository.findByUserName(userName);
		// List<SimpleGrantedAuthority> grantedAuthorities = user.getAuthorities().map(authority -> new SimpleGrantedAuthority(authority)).collect(Collectors.toList());
		if(user == null)
		
			throw new
			  UsernameNotFoundException("could not found user");
		

		Set<GrantedAuthority> grantedAuthorities = user.getRole().stream()
				.map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName().toString().toUpperCase()))
				.collect(Collectors.toSet());
		System.out.println(user.getUserName());
		System.out.println(user.getPassword());
		System.out.println(grantedAuthorities);
		return new MyUserDetails(user.getUserName(),user.getPassword(),grantedAuthorities);
	}

}
