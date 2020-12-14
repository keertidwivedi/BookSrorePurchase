
package org.store.com.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.store.com.Exception.StoreException;
import org.store.com.RequestDto.BookRequestDto;
import org.store.com.RequestDto.UserRequestDto;
import org.store.com.model.Book;
import org.store.com.model.User;
import org.store.com.repo.BookRepository;
import org.store.com.service.BookService;

@RestController
public class BookController {
	private final Logger mLogger = LoggerFactory.getLogger(BookController.class);

	

	@Autowired
	private BookService bookService;

	@PostMapping("/book")
	public Book createBook(@RequestBody Book book) {
		Book saveBook = bookService.createBook(book);
		return saveBook;
	}

	@GetMapping("/book/{bookName}")
	public List<Book> getBookByName(@PathVariable String bookName) {
		mLogger.info("getBookByNAme Controller has Strated()+" + bookName);
		List<Book> bookByName = bookService.getBookByName(bookName);
		mLogger.info("Recieved bookbyname" + bookByName);
		mLogger.info("getBookByNAme Controller has Ended();");
		return bookByName;

	}

	@GetMapping("/books/{id}")
	public Optional<Book> getBookByd(@PathVariable("id") long bookID) {
		mLogger.info("getBookByd Controller has Strated()+" + bookID);

		Optional<Book> bookBasedOnId = bookService.getBookById(bookID);
		mLogger.info("Recieved bookbyname" + bookBasedOnId);
		mLogger.info("getBookByd Controller has Ended();");
		return bookBasedOnId;

	}

	@DeleteMapping("/book/{id}")
	public Optional<Book> deleteById(@PathVariable("id") long bookId) {
		mLogger.info("deleteById Controller has Strated()+" + bookId);
		Optional<Book> deletedBook = bookService.deleteById(bookId);

		mLogger.info("deleted bookbyid" + deletedBook);
		mLogger.info("deleteById Controller has Ended();");
		return deletedBook;
	}

	@PutMapping("/book/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable("id") long id, BookRequestDto requestDto) {

		Book updateBook = bookService.updateBook(id, requestDto);
		mLogger.debug("Recived updated book based on id updateUSer() :" + updateBook);
		return ResponseEntity.ok().body(updateBook);
	}

}
