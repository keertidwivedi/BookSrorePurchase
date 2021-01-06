package org.store.com.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GeneratorType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long bookId;

	private String bookName;

	private String author;

	private String quantity;

	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Column(nullable = false)
	private Set<Comment> comment = new HashSet<Comment>();

	@Override
	public String toString() {
		return "Book [id=" + bookId + ", bookName=" + bookName + ", author=" + author + ", quantity=" + quantity
				+ ", comment=" + comment + "]";
	}

	public Book(String bookName, String author, String quantity, Set<Comment> comment) {

		this.bookName = bookName;
		this.author = author;
		this.quantity = quantity;
		this.comment = comment;
	}

	

}
