
  package org.store.com.controller;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.authentication.UserServiceBeanDefinitionParser;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.store.com.ResponseDto.UserResponseDto;
import org.store.com.model.User;
import org.store.com.repo.UserRepository;
import org.store.com.service.UserService;

@RestController
  public class UserController {
	  @Autowired
	 private UserService userService;
	  @Autowired
	    private UserRepository userRepository;

	  UserResponseDto dto;
	  
	    public UserController(UserService userService, UserRepository userRepository) {
	        this.userService = userService;
	        this.userRepository = userRepository;
	    }
	    
	    @PostMapping("/user/create/admin")
	    public ResponseEntity<UserResponseDto> createRoleAdmin(@RequestBody User userDto) {
	    	UserResponseDto user = userService.createRoleAdmin(userDto);
			return ResponseEntity.ok().body(user);
	    }
	    
	     
	   
		@PostMapping("/user/create/user")
	    public ResponseEntity<UserResponseDto> createUserRoleUser(@RequestBody User userDto) {
	    	UserResponseDto user = userService.createUserRoleUser(userDto);
	    	return ResponseEntity.ok().body(user);
	    }
	    
		
		
		
		@GetMapping("/all/admin")
		public ResponseEntity<List<UserResponseDto>> viewAllAdminUsers( ){
			List<UserResponseDto> user =  userService.viewAllAdminUsers();
			System.out.println(user);
			return  ResponseEntity.ok().body(user);
		}
		
		
		
		
	    
	    
	    
	    
	    @GetMapping("/user/details/{id}")
	    public User getUser(@PathVariable Long id) {
	        if(userRepository.findById(id).isPresent())
	            return userRepository.findById(id).get();
	        else return  null;
	    }
	    @GetMapping("/user/all")
	    public List<User> getUsers() {
	        return userRepository.findAll();
	    }
		/*
		 * @PutMapping("/user/update/{id}") public ResponseEntity<Object>
		 * updateUser(@PathVariable Long id, @RequestBody User user) { return
		 * userService.updateUser(user, id); }
		 * 
		 * @DeleteMapping("user/delete/{id}") public ResponseEntity<Object>
		 * deleteUser(@PathVariable Long id) { return userService.deleteUser(id); }
		 */



  }
  