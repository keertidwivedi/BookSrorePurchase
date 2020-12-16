
package org.store.com.service;

import java.util.List;
import java.util.Optional;

import org.store.com.RequestDto.UserRequestDto;
import org.store.com.ResponseDto.UserResponseDto;
import org.store.com.model.User;

public interface UserService {

	UserResponseDto createRoleAdmin(UserRequestDto userRequestDto);

	UserResponseDto createUserRoleUser(UserRequestDto userRequestDto);

	List<UserResponseDto> getAdmin();

	List<UserResponseDto> getUser();

	User deleteById(long id);

	User updateUser(long id, UserRequestDto requestDto);

	Optional<User> getUserById(long id);

	List<UserResponseDto> listAllUsers();

}
