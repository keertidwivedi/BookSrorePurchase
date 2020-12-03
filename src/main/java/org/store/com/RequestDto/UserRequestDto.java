package org.store.com.RequestDto;

import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.UniqueElements;


public class UserRequestDto 
{
	
	@NotNull
	@Size(min =7)
	@NotBlank(message =  "Name is mandatory")
	private String userName;
	
	
	@NotNull
	@NotBlank(message =  "email is mandatory")
	@UniqueElements
	private String email;
	
	@NotBlank(message =  "password is mandatory")
	@Size(min = 10,max = 60,message = "Should contain one Capital and one special charecter")
	private String password;





	public UserRequestDto(@NotNull @Size(min = 7) @NotBlank(message = "Name is mandatory") String userName,
			@NotNull @NotBlank(message = "email is mandatory") @UniqueElements String email,
			@NotBlank(message = "password is mandatory") @Size(min = 10, max = 60, message = "Should contain one Capital and one special charecter") String password) {
				this.userName = userName;
		this.email = email;
		this.password = password;
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

	public UserRequestDto() {
		super();
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
		return "UserRequestDto [id="  + ", userName=" + userName + ", email=" + email + ", password=" + password
				+ "]";
	}

}
