package org.store.com.ResponseDto;


import org.store.com.model.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserResponseDto {

	private Long id;
	private String name;
	private String email;
	private String password;

	
	public UserResponseDto(Long id, String name, String email, String password) {

		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public UserResponseDto(String name, String email) {
		this.name = name;
		this.email = email;
	}

	

	public UserResponseDto(User user) {
		
	}

	@Override
	public String toString() {
		return "UserResponseDto [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}

}
