
package org.store.com.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.store.com.RequestDto.UserRequestDto;
import org.store.com.ResponseDto.UserResponseDto;
import org.store.com.Util.Constants;
import org.store.com.model.User;
import org.store.com.repo.UserRepository;
import org.store.com.service.UserService;

@RestController
public class UserController {

	private final Logger mLogger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	
	//private UserRepository userRepository;

	UserResponseDto dto;

	public UserController(UserService userService)//, UserRepository userRepository) 
	{
		this.userService = userService;
		//this.userRepository = userRepository;
	}

	@PostMapping(path = Constants.CREATE_A_ROLE_ADMIN_CONTROLLER_ENDPOINT)
	public ResponseEntity<UserResponseDto> createRoleAdmin(@RequestBody UserRequestDto userDto) {
		mLogger.info("createRoleAdmin Controller createRoleAdmin Start() ");
		mLogger.debug("Recived User:" + userDto);
		UserResponseDto user = userService.createRoleAdmin(userDto);
		mLogger.debug("adminrole created: " + user);
		mLogger.info("createRoleAdmin Controller End() ");
		return ResponseEntity.ok().body(user);
	}

	@GetMapping(path = Constants.LIST_OF_USERS_CONTROLLER_ENDPOINT)
	public ResponseEntity<List<UserResponseDto>> listAllUsers() {
		mLogger.info("view all users controller getUser Strat()");
		List<UserResponseDto> listOfUser = userService.listAllUsers();
		return ResponseEntity.ok().body(listOfUser);
	}

	@PostMapping(path = Constants.CREATE_A_ROLE_USER_CONTROLLER_ENDPOINT)
	public ResponseEntity<UserResponseDto> createUserRoleUser(@RequestBody UserRequestDto userDto) {
		mLogger.info("user role ccontroller createUSerRoleUSer() Strat()");
		mLogger.debug("Recived User:" + userDto);
		UserResponseDto user = userService.createUserRoleUser(userDto);
		mLogger.debug("user role created: " + user);
		mLogger.info("user role ccontroller End()");
		return ResponseEntity.ok().body(user);
	}

	@GetMapping(path = Constants.LIST_OF_ADMINS_CONTROLLER_ENDPOINT)
	public ResponseEntity<List<UserResponseDto>> getAdmin() {
		mLogger.info("view all admin role list controller getAdmin() Strat()");

		List<UserResponseDto> adminUser = userService.getAdmin();
		mLogger.debug("Recived admin users :" + adminUser);
		System.out.println(adminUser);
		mLogger.info("view all admin role list controller End()");
		return ResponseEntity.ok().body(adminUser);
	}

	@GetMapping(path = Constants.LIST_OF_USER_ROLE_CONTROLLER_ENDPOINT)
	public ResponseEntity<List<UserResponseDto>> getUser() {
		mLogger.info("view all user role list controller getUser() Strat()");
		List<UserResponseDto> userRoleUser = userService.getUser();
		mLogger.debug("Recived user role  users :" + userRoleUser);
		mLogger.info("view all user role list controller End()");
		return ResponseEntity.ok().body(userRoleUser);
	}

	/*
	 * @GetMapping("/user/details/{id}") public ResponseEntity<Optional<User>>
	 * getUserById(@PathVariable long id) {
	 * mLogger.info("view user details based on ID controller getUser() Strat()");
	 * List<User> user = userService.getUserById(id); if (user == null) { throw new
	 * StoreException("no ser based on id"); } return
	 * ResponseEntity.ok().body(user); }
	 */

	@DeleteMapping(path = Constants.DELETE_CONTROLLER_ENDPOINT)
	public ResponseEntity<User> deleteById(@PathVariable("id") long id) {
		mLogger.info("delete user based on id deleteByID() Strat()");
		User user = userService.deleteById(id);

		return ResponseEntity.ok().body(user);
	}

	@PutMapping(path = Constants.UPDATE_CONTROLLER_ENDPOINT)
	public ResponseEntity<User> updateUser(@PathVariable("id") long id, UserRequestDto requestDto) {

		User UpdateUser = userService.updateUser(id, requestDto);
		mLogger.debug("Recived updated user based on id updateUSer() :" + UpdateUser);
		return ResponseEntity.ok().body(UpdateUser);

	}

}
