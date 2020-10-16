
package org.store.com.controller;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.authentication.UserServiceBeanDefinitionParser;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.store.com.Exception.StoreException;
import org.store.com.RequestDto.UserRequestDto;
import org.store.com.ResponseDto.UserResponseDto;
import org.store.com.model.User;
import org.store.com.repo.UserRepository;
import org.store.com.service.UserService;



@RestController
public class UserController {

	private final Logger mLogger = LoggerFactory.getLogger(UserController.class);
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
	public ResponseEntity<UserResponseDto> createRoleAdmin(@RequestBody UserRequestDto userDto) {
		mLogger.info("createRoleAdmin Controller createRoleAdmin Start() ");
		mLogger.debug("Recived User:"+userDto);
		UserResponseDto user = userService.createRoleAdmin(userDto);
		mLogger.debug("adminrole created: "+user);
		mLogger.info("createRoleAdmin Controller End() ");
		return ResponseEntity.ok().body(user);
	}

	@PostMapping("/user/create/user")
	public ResponseEntity<UserResponseDto> createUserRoleUser(@RequestBody UserRequestDto userDto) {
		mLogger.info("user role ccontroller createUSerRoleUSer() Strat()");
		mLogger.debug("Recived User:"+userDto);
		UserResponseDto user = userService.createUserRoleUser(userDto);
		mLogger.debug("user role created: "+user);
		mLogger.info("user role ccontroller End()");
		return ResponseEntity.ok().body(user);
	}






	@GetMapping("/all/admin/role")
	public ResponseEntity<List<UserResponseDto>> getAdmin() {
		mLogger.info("view all admin role list controller getAdmin() Strat()");
		
		List<UserResponseDto> adminUser = userService.getAdmin();
		mLogger.debug("Recived admin users :"+adminUser);
		System.out.println(adminUser);
		mLogger.info("view all admin role list controller End()");
		return ResponseEntity.ok().body(adminUser);
	}

	@GetMapping("/all/user/role")
	public ResponseEntity<List<UserResponseDto>> getUser() {
		mLogger.info("view all user role list controller getUser() Strat()");
		List<UserResponseDto> userRoleUser = userService.getUser();
		mLogger.debug("Recived user role  users :"+userRoleUser);
		mLogger.info("view all user role list controller End()");
		return ResponseEntity.ok().body(userRoleUser);
	}

	@GetMapping("/user/details/{id}")
	public User getUser(@PathVariable Long id) {
		mLogger.info("view user details based on ID controller getUser() Strat()");
		if (userRepository.findById(id).isPresent())
		{
			mLogger.info("view user details based on ID controller End()");
			return userRepository.findById(id).get();
		}
		else
			throw new StoreException("USEr Not Found EXception");
	}

	@GetMapping("/user/all")
	public List<User> getUsers() {
		mLogger.info("view all users controller getUser Strat()");
		return userRepository.findAll();
	}

	@DeleteMapping(value = "user/delete/{id}")
	public ResponseEntity<User> deleteById(@PathVariable("id") long id) {
		mLogger.info("delete user based on id deleteByID() Strat()");
		User user = userService.deleteById(id);
		

		return ResponseEntity.ok().body(user);
	}


	@PutMapping("user/{id}") 
	public ResponseEntity<User> updateUser(@PathVariable("id") long id,UserRequestDto requestDto) {

	User UpdateUser = userService.updateUser(id, requestDto);
	mLogger.debug("Recived updated user based on id updateUSer() :"+UpdateUser);
	return ResponseEntity.ok().body(UpdateUser);

}

}
