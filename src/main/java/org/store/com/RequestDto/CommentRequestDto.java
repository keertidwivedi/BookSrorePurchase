package org.store.com.RequestDto;


import java.util.Set;

import javax.validation.constraints.Size;

import org.store.com.model.Book;
import org.store.com.model.Comment;

public class CommentRequestDto {
	
	
	@Size(min=30)
	private String text;
	
		public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "CommentRequestDto [ text=" + text + "]";
	}

	public CommentRequestDto( String text) {
		super();
		this.text = text;
	}
	

	
	
}
