
package org.store.com.security;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.store.com.jwt.*;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
	UserDetailsService userDetailsService;
	
	
	  @Bean public BCryptPasswordEncoder passwordEncoder() { return new
	  BCryptPasswordEncoder() ; }
	 
	
	  @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        auth
	            .userDetailsService(userDetailsService)
	            .passwordEncoder(passwordEncoder());
	    }
	
	 @Bean
	 public DaoAuthenticationProvider authenticationProvider() {
	      DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
	      authenticationProvider.setUserDetailsService(userDetailsService);
	     authenticationProvider.setPasswordEncoder(passwordEncoder());
	      return authenticationProvider;
	 }

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
				.authorizeRequests()
				.antMatchers("/user/**").hasAuthority("ROLE_ADMIN")
				.antMatchers(HttpMethod.GET,"/book/**").hasAuthority("ROLE_ADMIN");
	
		http .csrf().disable() .authorizeRequests() .anyRequest().permitAll() 
		.and()
		.addFilter(new JwtUserNameAndPasswordAuthennticationFilter(authenticationManager()))
		.addFilterAfter(new JwtTokenVerify(),JwtUserNameAndPasswordAuthennticationFilter.class);
	
	

	}

}
