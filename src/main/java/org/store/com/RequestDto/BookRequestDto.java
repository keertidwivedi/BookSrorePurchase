package org.store.com.RequestDto;

import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.store.com.model.Comment;

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

	private Set<Comment> comment;

	public BookRequestDto(@NotNull @NotBlank(message = "BookName is mandatory") String bookName, @NotNull String author,
			@NotNull String quantity) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.quantity = quantity;	
	}

}
