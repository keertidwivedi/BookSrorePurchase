
package org.store.com.service;

import java.util.List;
import java.util.Optional;

import org.store.com.RequestDto.UserRequestDto;
import org.store.com.ResponseDto.UserResponseDto;

public interface UserService {

	UserResponseDto createRoleAdmin(UserRequestDto userRequestDto);

	UserResponseDto createUserRoleUser(UserRequestDto userRequestDto);

	List<UserResponseDto> getAdmin();

	List<UserResponseDto> getUser();

	UserResponseDto deleteById(long id);

	UserResponseDto updateUser(long id, UserRequestDto requestDto);

	UserResponseDto getUserById(long id);

	List<UserResponseDto> listAllUsers();

}
