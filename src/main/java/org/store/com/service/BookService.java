package org.store.com.service;

import java.util.List; 
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.store.com.Exception.StoreException;
import org.store.com.RequestDto.BookRequestDto;
import org.store.com.RequestDto.UserRequestDto;
import org.store.com.controller.BookController;
import org.store.com.controller.UserController;

import org.store.com.model.Book;
import org.store.com.model.Comment;
import org.store.com.model.User;
import org.store.com.repo.BookRepository;
import org.store.com.repo.CommentRepository;


public interface BookService {

	
	// Create/add a Book
	Book createBook(Book book);

	List<Book> getBookByName(String bookName);

	
 Optional<Book> getBookById(long bookID);
	
	  Optional<Book> deleteById(long bookId);
	
	
	
	
Book updateBook(long id, BookRequestDto requestDto);
}