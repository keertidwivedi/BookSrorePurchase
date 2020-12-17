package org.store.com.RequestDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.UniqueElements;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {

	@NotNull
	@Size(min = 7)
	@NotBlank(message = "Name is mandatory")
	private String userName;

	@NotNull
	@NotBlank(message = "email is mandatory")
	@UniqueElements
	private String email;

	@NotBlank(message = "password is mandatory")
	@Size(min = 10, max = 60, message = "Should contain one Capital and one special charecter")
	private String password;

	public UserRequestDto(@NotNull @Size(min = 7) @NotBlank(message = "Name is mandatory") String userName,
			@NotNull @NotBlank(message = "email is mandatory") @UniqueElements String email,
			@NotBlank(message = "password is mandatory") @Size(min = 10, max = 60, message = "Should contain one Capital and one special charecter") String password) {
		this.userName = userName;
		this.email = email;
		this.password = password;
	}


	@Override
	public String toString() {
		return "UserRequestDto [id=" + ", userName=" + userName + ", email=" + email + ", password=" + password + "]";
	}

}
