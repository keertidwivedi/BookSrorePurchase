package org.store.com.ResponseDto;

import java.util.Set;

import org.store.com.model.Comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookResponseDto {

	String bookName;

	String bookAuthor;

	String quantity;

	Set<Comment> comment;

	public BookResponseDto(String bookName, String bookAuthor, String quantity) {

		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.quantity = quantity;
	}

}
