package org.store.com.RequestDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.UniqueElements;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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


	@Override
	public String toString() {
		return "UserRequestDto [id=" + ", userName=" + userName + ", email=" + email + ", password=" + password + "]";
	}

}
