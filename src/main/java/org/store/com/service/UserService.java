
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.store.com.Exception.BookNotFoundException;
import org.store.com.Exception.GlobalExceptionHandler;
import org.store.com.Exception.StoreException;
import org.store.com.RequestDto.UserRequestDto;
import org.store.com.ResponseDto.UserResponseDto;
import org.store.com.model.Role;
import org.store.com.model.User;
import org.store.com.repo.RoleRepository;
import org.store.com.repo.UserRepository;


public interface UserService {
	
	
	 UserResponseDto createRoleAdmin(UserRequestDto userRequestDto);

	 UserResponseDto createUserRoleUser(UserRequestDto userRequestDto);

	 List<UserResponseDto> getAdmin();

	 List<UserResponseDto> getUser();

	 User deleteById(long id);

	 User updateUser(long id, UserRequestDto requestDto);

	

	public Optional<User> getUserById(long id); 

	public List<UserResponseDto> listAllUsers(); 

	
}
