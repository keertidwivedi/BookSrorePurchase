
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
import org.springframework.stereotype.Service;
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

	public UserResponseDto createRoleAdmin(User userDto) {

		/*
		 * List<String> roleNames = new ArrayList<>(); roleNames.add("admin");
		 */
		UserResponseDto userResponseDto = new UserResponseDto();
		User user = new User();
		if (userRepository.findByEmail(userDto.getEmail()).isPresent()) {
			System.out.println("the email  already present");
			return userResponseDto;

		} else {
			user.setEmail(userDto.getEmail());
			user.setPassword(userDto.getPassword());
			user.setUsername(userDto.getUsername());
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
			userResponseDto.setName(AdminRoleSaved.getUsername());

			if (userRepository.findById(AdminRoleSaved.getId()).isPresent()) {
				System.out.println("Sucessfully created  ");
			} else {
				System.out.println("Failed Creating User as Specified");
			}
			System.out.println(AdminRoleSaved);
			return userResponseDto;
		}

	}

	public UserResponseDto createUserRoleUser(User userDto) {

		UserResponseDto responseDto = new UserResponseDto();
		List<String> userNames = new ArrayList<>();
		userNames.add("user");

		User userNewObject = new User();
		if (userRepository.findByEmail(userDto.getEmail()).isPresent()) {
			System.out.println("the email  already present");
		} else {
			userNewObject.setEmail(userDto.getEmail());
			userNewObject.setPassword(userDto.getPassword());
			userNewObject.setUsername(userDto.getUsername());
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
		responseDto.setName(userRoleSaved.getUsername());
		responseDto.setPassword(userRoleSaved.getPassword());
		responseDto.setEmail(userRoleSaved.getEmail());

		if (userRepository.findById(userRoleSaved.getId()).isPresent())
			System.out.println("User Created Sucessfully");
		else {
			System.out.println("Failed Creating User as Specified");
		}
		System.out.println(userRoleSaved);
		return responseDto;

	}

	public List<UserResponseDto> viewAllAdminUsers() {
		UserResponseDto responseDto = new UserResponseDto();
		
		List<UserResponseDto> arrayList  = new ArrayList();
		Optional<Role> adminRole=  roleRepository.findByName("admin");
		ArrayList<User> adminUsers = userRepository.findByRole(adminRole);
		System.out.println(adminUsers+"-------------");
		User userNewObject;
		for (User user : adminUsers ) 
		
		{
			userNewObject = new User();
			
			responseDto.setId(user.getId());
			responseDto.setName(user.getUsername());
			
			responseDto.setEmail(user.getEmail());
			System.out.println();
			
arrayList.add(responseDto);
System.out.println();
		}
		

		return  arrayList;
	}

}


















