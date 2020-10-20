package org.store.com.model;

import java.util.List;

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
	private long bookId;
	
	
	private String bookName;
	
	private String author;
	
	private String quantity;
	
	
	@OneToMany(mappedBy = "book",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Comment> comments;

	public Book()
	{
		
	}
	
	

	public Book(long bookId, String bookName, String author, String quantity) {
		
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.quantity = quantity;
		
	}





	public long getBookId() {
		return bookId;
	}





	public void setBookId(long bookId) {
		this.bookId = bookId;
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





	public List<Comment> getComments() {
		return comments;
	}





	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}


	
	
	
}
