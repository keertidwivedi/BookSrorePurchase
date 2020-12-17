package org.store.com.RequestDto;

import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.store.com.model.Comment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRequestDto {

	@NotNull
	@NotBlank(message = "BookName is mandatory")

	private String bookName;

	@NotNull
	private String author;

	@NotNull
	private String quantity;

	private Set<Comment> comment;

	
	

}
