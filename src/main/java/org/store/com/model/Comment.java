package org.store.com.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.sun.istack.NotNull;

@Entity
@Table(name = "comment")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String text;
	
	 @ManyToOne()
	    @JoinColumn(name = "book_id")
	private Book book;
	 
	 
		public Comment() {
		
		}
	 
	 
	 
	 

	public Comment(Long id, String text, Book book) {
		
		this.id = id;
		this.text = text;
		this.book = book;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
