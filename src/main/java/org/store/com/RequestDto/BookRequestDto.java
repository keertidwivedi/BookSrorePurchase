package org.store.com.RequestDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookRequestDto {

	@NotNull
	@NotBlank(message = "BookName is mandatory")
	private String bookName;

	@NotNull
	private String author;

	@NotNull
	private String quantity;

	@Override
	public String toString() {
		return "BookRequestDto [bookName=" + bookName + ", author=" + author + ", quantity=" + quantity + "]";
	}

}
