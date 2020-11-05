package org.store.com.RequestDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class UserRequestDto 
{
	private Long id;
	
	@NotNull
	@Size(min =7)
	@NotBlank(message =  "Name is mandatory")
	private String userName;
	
	
	@NotNull
	@NotBlank(message =  "email is mandatory")
	private String email;
	
	@NotBlank(message =  "password is mandatory")
	@Size(min = 10,message = "Should contain one Capital and one special charecter")
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	@Override
	public String toString() {
		return "UserRequestDto [id=" + id + ", userName=" + userName + ", email=" + email + ", password=" + password
				+ "]";
	}

}
