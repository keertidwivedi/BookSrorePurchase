
package org.store.com.service;

import java.util.ArrayList; 
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.event.ListSelectionEvent;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.store.com.Exception.StoreException;
import org.store.com.RequestDto.UserRequestDto;
import org.store.com.ResponseDto.UserResponseDto;
import org.store.com.model.Role;
import org.store.com.model.User;
import org.store.com.repo.RoleRepository;
import org.store.com.repo.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	@PersistenceContext
	EntityManager entityManager;

	
	public UserService(UserRepository userRepository, RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}

	// create role "admin"
	public UserResponseDto createRoleAdmin(UserRequestDto userRequestDto) {

		/*
		 * List<String> roleNames = new ArrayList<>(); roleNames.add("admin");
		 */
		UserResponseDto userResponseDto = new UserResponseDto();
		User user = new User();
		if (userRepository.findByEmail(userRequestDto.getEmail()).isPresent()) {
			throw new StoreException("the email  already present");
			
			//return userResponseDto;

		} else {
			user.setEmail(userRequestDto.getEmail());
			user.setPassword(userRequestDto.getPassword());
			user.setUserName(userRequestDto.getUserName());
			// user.setRole(model.getRole());

			Optional<Role> roleOpt = roleRepository.findByName("admin");
			if (roleOpt.isPresent()) {
				user.getRole().add(roleOpt.get());

			} else {
				Role role = new Role();
				role.setName("admin");
				Role savedRole = roleRepository.save(role);
				System.out.println(savedRole.toString());
				user.getRole().add(savedRole);
				System.out.println(user);

			}

			User AdminRoleSaved = userRepository.save(user);
			userResponseDto.setId(AdminRoleSaved.getId());
			userResponseDto.setEmail(AdminRoleSaved.getEmail());
			userResponseDto.setName(AdminRoleSaved.getUserName());

			if (userRepository.findById(AdminRoleSaved.getId()).isPresent()) {
				System.out.println("Sucessfully created  ");
			} else {
				throw new StoreException("Failed Creating User as Specified");
			}
			System.out.println(AdminRoleSaved);
			return userResponseDto;
		}

	}

//create role "user"
	public UserResponseDto createUserRoleUser(UserRequestDto userRequestDto) {

		UserResponseDto responseDto = new UserResponseDto();
		List<String> userNames = new ArrayList<>();
		userNames.add("user");

		User userNewObject = new User();
		if (userRepository.findByEmail(userRequestDto.getEmail()).isPresent()) {
			throw new StoreException("the email  already present");
			
		} else {
			userNewObject.setEmail(userRequestDto.getEmail());
			userNewObject.setPassword(userRequestDto.getPassword());
			userNewObject.setUserName(userRequestDto.getUserName());
			// user.setRole(model.getRole());

			Optional<Role> roleOpt = roleRepository.findByName("user");
			roleOpt.isPresent();
			if (roleOpt.isPresent()) {
				userNewObject.getRole().add(roleOpt.get());

			} else {
				Role role = new Role();
				role.setName("user");
				Role saveRole = roleRepository.save(role);

				userNewObject.getRole().add(saveRole);
				System.out.println(userNewObject);

			}
		}

		User userRoleSaved = userRepository.save(userNewObject);
		responseDto.setId(userRoleSaved.getId());
		responseDto.setName(userRoleSaved.getUserName());
		responseDto.setPassword(userRoleSaved.getPassword());
		responseDto.setEmail(userRoleSaved.getEmail());

		if (userRepository.findById(userRoleSaved.getId()).isPresent())
			System.out.println("User Created Sucessfully");
		else {
			throw new StoreException("Failed Creating User as Specified");
		}
		System.out.println(userRoleSaved);
		return responseDto;

	}

	// to get all the records of admin role
	public List<UserResponseDto> getAdmin() {

		List<UserResponseDto> userResponseDtoList = new ArrayList();
		Optional<Role> adminRole = roleRepository.findByName("admin");
		ArrayList<User> adminUsersList = userRepository.findByRole(adminRole);
		System.out.println(adminUsersList + "-------------");
		UserResponseDto newUserResponseDto;
		for (User user : adminUsersList)

		{
			newUserResponseDto = new UserResponseDto();

			newUserResponseDto.setId(user.getId());
			newUserResponseDto.setName(user.getUserName());

			newUserResponseDto.setEmail(user.getEmail());

			userResponseDtoList.add(newUserResponseDto);
			
			System.out.println(userResponseDtoList);

		}
		return userResponseDtoList;
	}

	public List<UserResponseDto> getUser() {

		List<UserResponseDto> userREsponseDtoListOfUserRole = new ArrayList<>();
		Optional<Role> userRole = roleRepository.findByName("user");
		ArrayList<User> adminUsersList = userRepository.findByRole(userRole);
		UserResponseDto newUSerREsponseDto;
		

		for (User user : adminUsersList) {
			newUSerREsponseDto = new UserResponseDto();
			newUSerREsponseDto.setId(user.getId());
			newUSerREsponseDto.setEmail(user.getEmail());
			newUSerREsponseDto.setName(user.getUserName());
			userREsponseDtoListOfUserRole.add(newUSerREsponseDto);

		}

		return userREsponseDtoListOfUserRole;

	}

	
	public User deleteById(long id) {

		if (id < 1) {

			throw new NullPointerException("id is not present");
		}

		User userById = userRepository.deleteById(id);

		return userById;

	}
	 

	public User updateUser(long id, UserRequestDto requestDto) {
		
		Optional<User> userFromDBOpt = userRepository.findById(id);
		if (userFromDBOpt.isEmpty()) {
			throw new StoreException("User Not FOund Based On ID");
		}
		User updateUser = userFromDBOpt.get();
		updateUser.setUserName(requestDto.getUserName());
		updateUser.setEmail(requestDto.getEmail());

		User updatedUser = userRepository.save(updateUser);
		return updatedUser;
	
	
	
	}

	

	public Optional<User> getUserById(long id) {
		Optional<User> UsersList = userRepository.findById(id);

		if (UsersList.get().getId() == id) {
			return UsersList;
		}

		return null;
	}
	 
	
	public  List<UserResponseDto> listAllUsers()
	{
		
		List<UserResponseDto> newArrayListOfUser = new ArrayList();
		UserResponseDto newUSerREsponseDto;
	
		List<User> listOfUsers = userRepository.findAll();
		
		for (User user : listOfUsers)
		{
			newUSerREsponseDto = new UserResponseDto();
			newUSerREsponseDto.setId(user.getId());
			newUSerREsponseDto.setEmail(user.getEmail());
			newUSerREsponseDto.setName(user.getUserName());

		newArrayListOfUser.add(newUSerREsponseDto);
		}
		return newArrayListOfUser;
	
	}
}
