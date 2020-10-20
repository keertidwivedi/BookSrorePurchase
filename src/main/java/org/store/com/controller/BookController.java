package org.store.com.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.store.com.model.Book;
import org.store.com.repo.BookRepository;
import org.store.com.service.BookService;

@RestController
public class BookController {
	private final Logger mLogger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private BookService bookService;
	
	
	
	
	@PostMapping("/createBook")
	public Book createBook(@RequestBody Book book)
	{
		return bookRepository.save(book);
	}
	
	@GetMapping("/book/{bookName}")
	public List<Book> getBookByName(@PathVariable String bookName)
	{
		mLogger.info("getBookByNAme Controller has Strated()+"+bookName);
		List<Book> bookByName = bookService.getBookByName(bookName);
		mLogger.info("Recieved bookbyname"+bookByName);
		mLogger.info("getBookByNAme Controller has Ended();");
		return bookByName;
		
	}
	
	
	@DeleteMapping("/delete/book/{name}")
	public List<Book> deleteByName(@PathVariable("name") String bookName)
	{
		mLogger.info("deleteByName Controller has Strated();"+bookName);
		List<Book> deleteBook = bookService.deleteByName(bookName);
		mLogger.info("deleteByName Controller has Ended();");
		return deleteBook;
	}
	
	
	@GetMapping("/book/{id}")
	public Optional<Book> getBookById(@PathVariable("id")long id)
	{
		Optional<Book> foundBookById = bookRepository.findById(id);
		return foundBookById;
	}
	
	
	
	
}
