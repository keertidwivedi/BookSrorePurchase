package org.store.com.RequestDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookRequestDto {

	@NotNull
	@NotBlank(message = "BookName is mandatory")
	private String bookName;

	@NotNull
	private String author;

	@NotNull
	private String quantity;

	public BookRequestDto(@NotNull @NotBlank(message = "BookName is mandatory") String bookName, @NotNull String author,
			@NotNull String quantity) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.quantity = quantity;
	}

}
