package org.store.com.ResponseDto;

import org.springframework.http.HttpStatus;
import org.store.com.model.User;

public class UserResponseDto {

	private Long id;
	private String name;
	private String email;
	private String password;

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

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

	public UserResponseDto() {
		// TODO Auto-generated constructor stub
	}

	public UserResponseDto(User user) {
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public String toString() {
		return "UserResponseDto [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}

}
