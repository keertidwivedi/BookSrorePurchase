package org.store.com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.store.com.Exception.BookNotFoundException;
import org.store.com.Exception.StoreException;
import org.store.com.RequestDto.UserRequestDto;
import org.store.com.ResponseDto.UserResponseDto;
import org.store.com.controller.UserController;
import org.store.com.model.Role;
import org.store.com.model.User;
import org.store.com.repo.RoleRepository;
import org.store.com.repo.UserRepository;

@Service
public class UserServiceImp implements UserService {

	private final Logger mLogger = LoggerFactory.getLogger(UserServiceImp.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	public UserServiceImp(UserRepository userRepository, RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}

	public UserServiceImp() {

	}

	@Override
	public UserResponseDto createRoleAdmin(UserRequestDto userRequestDto) {
		mLogger.info("createRoleAdmin service implementation has started , recieved" + userRequestDto);
		UserResponseDto userResponseDto = new UserResponseDto();
		mLogger.debug("UserResponseDto object is created");
		User user = new User();
		mLogger.debug("User object is created");
		if (userRepository.findByEmail(userRequestDto.getEmail()).isPresent()) {
			throw new BookNotFoundException("Email alreay presnt");

		} else {
			user.setEmail(userRequestDto.getEmail());
			user.setPassword(userRequestDto.getPassword());
			user.setUserName(userRequestDto.getUserName());

			Optional<Role> roleOpt = roleRepository.findByName("admin");
			mLogger.debug(" found with role admin " + roleOpt);
			if (roleOpt.isPresent()) {
				mLogger.debug(" admin is presnt in DB ");
				user.getRole().add(roleOpt.get());

			} else {
				Role role = new Role();
				mLogger.debug("  Role object has been created" + role);
				role.setName("admin");
				mLogger.debug("  setting value tp admin");
				Role savedRole = roleRepository.save(role);
				System.out.println(savedRole.toString());
				user.getRole().add(savedRole);
				System.out.println(user);

			}

			String encodedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
			user.setPassword(encodedPassword);

			User AdminRoleSaved = userRepository.save(user);
			mLogger.debug(" saving the record " + AdminRoleSaved);
			userResponseDto.setUserId(AdminRoleSaved.getUserId());
			userResponseDto.setEmail(AdminRoleSaved.getEmail());
			userResponseDto.setName(AdminRoleSaved.getUserName());
			mLogger.debug("setting the values to userResponseDto" + userResponseDto);

			if (userRepository.findById(AdminRoleSaved.getUserId()).isPresent()) {
				mLogger.debug(" usere with role  admin has been create sucessfully");
			} else {
				throw new UsernameNotFoundException("user Not created");
			}
			mLogger.info("createRoleAdmin serviceImp has ended() ");
			return userResponseDto;
		}

	}

	@Override
	public UserResponseDto createUserRoleUser(UserRequestDto userRequestDto) {
		mLogger.info("createUserRoleUser serviceImp has Start() , recieved  " + userRequestDto);
		UserResponseDto responseDto = new UserResponseDto();
		mLogger.debug("object of  UserResponseDto has created" + responseDto);
		List<String> userNames = new ArrayList<>();
		mLogger.debug(" list has create" + userNames);
		userNames.add("user");

		User userNewObject = new User();
		mLogger.debug("new user object created" + userNewObject);
		if (userRepository.findByEmail(userRequestDto.getEmail()).isPresent()) {
			mLogger.debug("Email is not presnt ");
			throw new UsernameNotFoundException("the email  already present");

		} else {
			userNewObject.setEmail(userRequestDto.getEmail());
			userNewObject.setPassword(userRequestDto.getPassword());
			userNewObject.setUserName(userRequestDto.getUserName());

			mLogger.debug("finding with name user ");
			Optional<Role> roleOpt = roleRepository.findByName("user");
			mLogger.debug("found with role user" + roleOpt);

			if (roleOpt.isPresent()) {
				mLogger.debug("role with user is present");
				userNewObject.getRole().add(roleOpt.get());

			} else {
				mLogger.debug("role with user nor presnt creating one");
				Role role = new Role();
				mLogger.debug("new role object created" + role);
				role.setName("user");
				Role saveRole = roleRepository.save(role);
				mLogger.debug("savinf with role after creating it" + saveRole);
				userNewObject.getRole().add(saveRole);

			}
		}

		User userRoleSaved = userRepository.save(userNewObject);
		responseDto.setUserId(userRoleSaved.getUserId());
		responseDto.setName(userRoleSaved.getUserName());
		responseDto.setPassword(userRoleSaved.getPassword());
		responseDto.setEmail(userRoleSaved.getEmail());

		if (userRepository.findById(userRoleSaved.getUserId()).isPresent())
			mLogger.debug(" usere with role has been create sucessfully");

		else {
			throw new UsernameNotFoundException("cannot create a user");
		}
		mLogger.info("createUserRoleUser serviceImp has ended() ");
		return responseDto;

	}

	@Override
	public List<UserResponseDto> getAdmin() {
		{
			mLogger.info("getAdmin serviceImp has Start()  ");
			List<UserResponseDto> userResponseDtoList = new ArrayList<UserResponseDto>();
			mLogger.debug("List<UserResponseDto object has been created" + userResponseDtoList);
			Optional<Role> adminRole = roleRepository.findByName("admin");
			mLogger.debug(" found by name admin in rolerepository" + adminRole);
			ArrayList<User> adminUsersList = userRepository.findByRole(adminRole);
			System.out.println(adminUsersList + "-------------");
			UserResponseDto newUserResponseDto;
			for (User user : adminUsersList)

			{
				mLogger.debug(" loop started for users");
				newUserResponseDto = new UserResponseDto();

				newUserResponseDto.setUserId(user.getUserId());
				newUserResponseDto.setName(user.getUserName());

				newUserResponseDto.setEmail(user.getEmail());

				userResponseDtoList.add(newUserResponseDto);

				System.out.println(userResponseDtoList);
				mLogger.info(" getAdmin service implementation has eneded");
			}
			return userResponseDtoList;
		}
	}

	@Override
	public List<UserResponseDto> getUser() {
		mLogger.info("getUser serviceImp has Start()  ");
		List<UserResponseDto> userREsponseDtoListOfUserRole = new ArrayList<>();
		mLogger.debug("List<UserResponseDto object has been created");
		Optional<Role> userRole = roleRepository.findByName("user");
		mLogger.debug("found user in db" + userRole);
		ArrayList<User> adminUsersList = userRepository.findByRole(userRole);
		UserResponseDto newUSerREsponseDto;

		for (User user : adminUsersList) {
			newUSerREsponseDto = new UserResponseDto();
			newUSerREsponseDto.setUserId(user.getUserId());
			newUSerREsponseDto.setEmail(user.getEmail());
			newUSerREsponseDto.setName(user.getUserName());
			userREsponseDtoListOfUserRole.add(newUSerREsponseDto);

		}
		mLogger.debug("getUser serviceImp has ended()  ");
		return userREsponseDtoListOfUserRole;

	}

	@Override
	public UserResponseDto deleteById(long userId) {
		mLogger.debug("deleteById serviceImp has Start() ,  recieved " + userId);
		UserResponseDto responseDto = new UserResponseDto();

		

		User userById = userRepository.deleteById(userId);
		
		responseDto.setName(userById.getUserName());
		responseDto.setUserId(userById.getUserId());
		responseDto.setEmail(userById.getEmail());
		mLogger.info("deleteById serviceImp has ended() ,  recieved " + userId);
		return responseDto;

	}

	@Override
	public UserResponseDto updateUser(long userId, UserRequestDto requestDto) {
		mLogger.info("updateUser serviceImp has Start() ,  recieved " + userId, requestDto);
		User userFromDBOpt = userRepository.findById(userId);
		mLogger.debug("findbyId from DB" + userFromDBOpt);
		if (userFromDBOpt == null) {
			throw new UsernameNotFoundException("User no found");
		}

		mLogger.debug("set the values to userResponseDto" + userFromDBOpt);
		User updatedUser = userRepository.save(userFromDBOpt);

		UserResponseDto userResponseDto = new UserResponseDto();

		userResponseDto.setName(userFromDBOpt.getUserName());
		userResponseDto.setEmail(userFromDBOpt.getEmail());
		userResponseDto.setUserId(userFromDBOpt.getUserId());

		mLogger.debug("saved values" + userResponseDto);
		mLogger.info("updateUser serviceImp has ended() ,  recieved " );
		return userResponseDto;

	}

	@Override
	public UserResponseDto getUserById(long userId) {
		mLogger.info("getUserById serviceImp has Start() ");
		UserResponseDto responseDto = new UserResponseDto();
		User Users = userRepository.findById(userId);
		mLogger.debug("found record for User based on id " + Users);
		if (Users.getUserId() == userId) {

			responseDto.setName(Users.getUserName());
			responseDto.setEmail(Users.getEmail());

			return responseDto;
		}
		mLogger.info("getUserById serviceImp has ended() ,  recieved " );
		return responseDto;
	}

	@Override
	public List<UserResponseDto> listAllUsers() {
		mLogger.info("listAllUsers serviceImp has Start() ");
		List<UserResponseDto> newArrayListOfUser = new ArrayList<UserResponseDto>();
		mLogger.debug("list<UserResponseDto> object has been created " + newArrayListOfUser);
		UserResponseDto newUSerREsponseDto;

		List<User> listOfUsers = userRepository.findAll();

		mLogger.debug("listodUsers searched in database " + listOfUsers);

		for (User user : listOfUsers) {
			mLogger.debug("loop for list of users has started");
			newUSerREsponseDto = new UserResponseDto();
			newUSerREsponseDto.setUserId(user.getUserId());
			newUSerREsponseDto.setEmail(user.getEmail());
			newUSerREsponseDto.setName(user.getUserName());

			newArrayListOfUser.add(newUSerREsponseDto);
			mLogger.info("adding reord to usersResponseDto" + newArrayListOfUser);
		}
		mLogger.info("listAllUsers serviceImp has ended() ,  recieved " );
		return newArrayListOfUser;

	}
}
