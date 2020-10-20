package org.store.com.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long commentsId;
	
	
	private String text;
	
	 @ManyToOne()
	    @JoinColumn(name = "book_id", nullable = false)
	private Book book;
	 
	 
		public Comment() {
		
		}
	 
	 
	 
	 

	public Comment(long commentsId, String text, Book book) {
		
		this.commentsId = commentsId;
		this.text = text;
		this.book = book;
	}

	public long getCommentsId() {
		return commentsId;
	}

	public void setCommentsId(long commentsId) {
		this.commentsId = commentsId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	 
	 
	 
}
