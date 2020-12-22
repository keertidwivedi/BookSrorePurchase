package org.store.com.ResponseDto;

import org.store.com.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {

	private Long userId;
	private String name;
	private String email;
	private String password;

	

	public UserResponseDto(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public UserResponseDto(User user) {

	}

	@Override
	public String toString() {
		return "UserResponseDto [id=" + userId + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}

}
