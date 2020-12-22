
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
	
	
	UserResponseDto dto;

	public UserController(UserService userService) 
	{
		this.userService = userService;
		
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
		mLogger.debug("recieved losy of users"+listOfUser);
		mLogger.info("view all users controller getUser ended()");
		return ResponseEntity.ok().body(listOfUser);
	}

	@PostMapping(path = Constants.CREATE_A_ROLE_USER_CONTROLLER_ENDPOINT)
	public ResponseEntity<UserResponseDto> createUserRoleUser(@RequestBody UserRequestDto userDto) {
		mLogger.info("user role ccontroller createUSerRoleUSer() Strat()");
		mLogger.debug("Recived User:" + userDto);
		UserResponseDto newUserResponseDto = userService.createUserRoleUser(userDto);
		mLogger.debug("user role created: " + newUserResponseDto);
		mLogger.info("user role ccontroller End()");
		return ResponseEntity.ok().body(newUserResponseDto);
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
		List<UserResponseDto> allRoleUser = userService.getUser();
		mLogger.debug("Recived user role  users :" + allRoleUser);
		mLogger.info("view all user role list controller End()");
		return ResponseEntity.ok().body(allRoleUser);
	}


	@DeleteMapping(path = Constants.DELETE_CONTROLLER_ENDPOINT)
	public ResponseEntity<UserResponseDto> deleteById(@PathVariable("userid") long userId) {
		mLogger.info("delete user based on id deleteByID() Strat()");
		UserResponseDto userResponseDto = userService.deleteById(userId);
		mLogger.info("delete user based on id deleteByID() has ended");
		return ResponseEntity.ok().body(userResponseDto);
	}

	@PutMapping(path = Constants.UPDATE_CONTROLLER_ENDPOINT)
	public ResponseEntity<UserResponseDto> updateUser(@PathVariable("userId") long userId, UserRequestDto requestDto) {
		mLogger.info("updateUser  based on id  updateUser Strat()");
		UserResponseDto UpdateUser = userService.updateUser(userId, requestDto);
		mLogger.debug("Recived updated user based on id updateUSer() :" + UpdateUser);
		return ResponseEntity.ok().body(UpdateUser);

	}

}
