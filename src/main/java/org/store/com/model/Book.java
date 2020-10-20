package org.store.com.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GeneratorType;



@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	private String bookName;
	
	private String author;
	
	private String quantity;
	
	
	@OneToMany(targetEntity = Book.class ,mappedBy = "book")
	private Set<Comment> comment = new HashSet<Comment>();

	public Book()
	{
		
	}

	public Book(long id, String bookName, String author, String quantity, Set<Comment> comment) {
		
		this.id = id;
		this.bookName = bookName;
		this.author = author;
		this.quantity = quantity;
		this.comment = comment;
	}

	public long getBookId() {
		return id;
	}

	public void setBookId(long id) {
		this.id = id;
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

	public Set<Comment> getComment() {
		return comment;
	}

	public void setComment(Set<Comment> comment) {
		this.comment = comment;
	}
	
	

	

	
}
