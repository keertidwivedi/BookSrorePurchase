package org.store.com.RequestDto;

import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.store.com.model.Comment;

public class BookRequestDto {

	@NotNull
	@NotBlank(message = "BookName is mandatory")

	private String bookName;

	@NotNull
	private String author;

	@NotNull
	private String quantity;

	private Set<Comment> comment;

	public Set<Comment> getComment() {
		return comment;
	}

	public void setComment(Set<Comment> comment) {
		this.comment = comment;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

}
