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
		mLogger.info("UserResponseDto object is created");
		User user = new User();
		mLogger.info("User object is created");
		if (userRepository.findByEmail(userRequestDto.getEmail()).isPresent()) {
			throw new BookNotFoundException("Email alreay presnt");

		} else {
			user.setEmail(userRequestDto.getEmail());
			user.setPassword(userRequestDto.getPassword());
			user.setUserName(userRequestDto.getUserName());

			Optional<Role> roleOpt = roleRepository.findByName("admin");
			mLogger.info(" found with role admin "+roleOpt);
			if (roleOpt.isPresent()) {
				mLogger.info(" admin is presnt in DB ");
				user.getRole().add(roleOpt.get());

			} else {
				Role role = new Role();
				mLogger.info("  Role object has been created"+role);
				role.setName("admin");
				mLogger.info("  setting value tp admin");
				Role savedRole = roleRepository.save(role);
				System.out.println(savedRole.toString());
				user.getRole().add(savedRole);
				System.out.println(user);

			}

			String encodedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
			user.setPassword(encodedPassword);

			User AdminRoleSaved = userRepository.save(user);
			mLogger.info(" saving the record " + AdminRoleSaved );
			userResponseDto.setId(AdminRoleSaved.getId());
			userResponseDto.setEmail(AdminRoleSaved.getEmail());
			userResponseDto.setName(AdminRoleSaved.getUserName());
			mLogger.info("setting the values to userResponseDto"+userResponseDto );

			if (userRepository.findById(AdminRoleSaved.getId()).isPresent()) {
				mLogger.info(" usere with role  admin has been create sucessfully");
			} else {
				throw new UsernameNotFoundException("user Not created");
			}
			mLogger.info("createRoleAdmin serviceImp has ended() ");
			return userResponseDto;
		}

	}

	@Override
	public UserResponseDto createUserRoleUser(UserRequestDto userRequestDto) {
		mLogger.info("createUserRoleUser serviceImp has Start() , recieved  "+userRequestDto );
		UserResponseDto responseDto = new UserResponseDto();
		mLogger.info("object of  UserResponseDto has created"+ responseDto);
		List<String> userNames = new ArrayList<>();
		mLogger.info(" list has create"+userNames);
		userNames.add("user");

		User userNewObject = new User();
		mLogger.info("new user object created"+userNewObject);
		if (userRepository.findByEmail(userRequestDto.getEmail()).isPresent()) {
			mLogger.info("Email is not presnt ");
			throw new UsernameNotFoundException("the email  already present");

		} else {
			userNewObject.setEmail(userRequestDto.getEmail());
			userNewObject.setPassword(userRequestDto.getPassword());
			userNewObject.setUserName(userRequestDto.getUserName());
		
			mLogger.info("finding with name user ");
			Optional<Role> roleOpt = roleRepository.findByName("user");
			mLogger.info("found with role user"+roleOpt);
			
			if (roleOpt.isPresent()) {
				mLogger.info("role with user is present");
				userNewObject.getRole().add(roleOpt.get());

			} else {
				mLogger.info("role with user nor presnt creating one");
				Role role = new Role();
				mLogger.info("new role object created"+role);
				role.setName("user");
				Role saveRole = roleRepository.save(role);
				mLogger.info("savinf with role after creating it"+saveRole);
				userNewObject.getRole().add(saveRole);
				

			}
		}

		User userRoleSaved = userRepository.save(userNewObject);
		responseDto.setId(userRoleSaved.getId());
		responseDto.setName(userRoleSaved.getUserName());
		responseDto.setPassword(userRoleSaved.getPassword());
		responseDto.setEmail(userRoleSaved.getEmail());

		if (userRepository.findById(userRoleSaved.getId()).isPresent())
			mLogger.info(" usere with role has been create sucessfully");
			
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
			mLogger.info("List<UserResponseDto object has been created"+userResponseDtoList);
			Optional<Role> adminRole = roleRepository.findByName("admin");
			mLogger.info(" found by name admin in rolerepository"+adminRole);
			ArrayList<User> adminUsersList = userRepository.findByRole(adminRole);
				System.out.println(adminUsersList + "-------------");
			UserResponseDto newUserResponseDto;
			for (User user : adminUsersList)

			{
				mLogger.info(" loop started for users");
				newUserResponseDto = new UserResponseDto();

				newUserResponseDto.setId(user.getId());
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
		mLogger.info("List<UserResponseDto object has been created");
		Optional<Role> userRole = roleRepository.findByName("user");
		mLogger.info("found user in db"+userRole);
		ArrayList<User> adminUsersList = userRepository.findByRole(userRole);
		UserResponseDto newUSerREsponseDto;

		for (User user : adminUsersList) {
			newUSerREsponseDto = new UserResponseDto();
			newUSerREsponseDto.setId(user.getId());
			newUSerREsponseDto.setEmail(user.getEmail());
			newUSerREsponseDto.setName(user.getUserName());
			userREsponseDtoListOfUserRole.add(newUSerREsponseDto);

		}
		mLogger.info("getUser serviceImp has ended()  ");
		return userREsponseDtoListOfUserRole;

	}

	@Override
	public UserResponseDto deleteById(long userId) {
		mLogger.info("deleteById serviceImp has Start() ,  recieved "+ userId);

		if (userId < 1) {

			throw new NullPointerException("id is not present");
		}

		UserResponseDto userById = userRepository.deleteById(userId);
		mLogger.info("deleteById serviceImp has ended() ,  recieved "+ userId);
		return userById;

	}
	

	@Override
	public UserResponseDto updateUser(long userId, UserRequestDto requestDto) {
		mLogger.info("updateUser serviceImp has Start() ,  recieved "+ userId ,requestDto);
		Optional<UserResponseDto> userFromDBOpt = userRepository.findById(userId);
		if (userFromDBOpt.isEmpty()) {
			throw new UsernameNotFoundException("User no found");
		}
		UserResponseDto updateUser = userFromDBOpt.get();
		updateUser.setName(requestDto.getUserName());
		updateUser.setEmail(requestDto.getEmail());

		UserResponseDto updatedUser = userRepository.save(updateUser);
		mLogger.info("updateUser serviceImp has ended()");
		return updatedUser;

	}

	@Override
	public Optional<UserResponseDto> getUserById(long userId) {
		mLogger.info("getUserById serviceImp has Start() ");
		Optional<UserResponseDto> UsersList = userRepository.findById(userId);
		mLogger.info("found record for User based on id "+UsersList);
		if (UsersList.get().getId() == userId) {
			return UsersList;
		}

		return UsersList;
	}

	@Override
	public List<UserResponseDto> listAllUsers() {
		mLogger.info("listAllUsers serviceImp has Start() ");
		List<UserResponseDto> newArrayListOfUser = new ArrayList<UserResponseDto>();
		mLogger.info("list<UserResponseDto> object has been created " + newArrayListOfUser);
		UserResponseDto newUSerREsponseDto;

		List<User> listOfUsers = userRepository.findAll();

		mLogger.info("listodUsers searched in database " + listOfUsers);

		for (User user : listOfUsers) {
			mLogger.info("loop for list of users has started");
			newUSerREsponseDto = new UserResponseDto();
			newUSerREsponseDto.setId(user.getId());
			newUSerREsponseDto.setEmail(user.getEmail());
			newUSerREsponseDto.setName(user.getUserName());

			newArrayListOfUser.add(newUSerREsponseDto);
			mLogger.info("adding reord to usersResponseDto" + newArrayListOfUser);
		}
		return newArrayListOfUser;

	}
}
