
package org.store.com.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.store.com.RequestDto.BookRequestDto;
import org.store.com.ResponseDto.BookResponseDto;
import org.store.com.Util.Constants;
import org.store.com.model.Book;
import org.store.com.service.BookService;

@RestController
public class BookController {
	private final Logger mLogger = LoggerFactory.getLogger(BookController.class);

	@Autowired
	private BookService bookService;

	@PostMapping(path = Constants.CREATE_BOOK_CONTROLLER_ENDPOINT)
	public BookResponseDto createBook(@RequestBody BookRequestDto book) {
		mLogger.info("createBook Controller has Strated() , Recived book value+ " + book);
		BookResponseDto saveBook = bookService.createBook(book);
		mLogger.info("createBook Controller has Ended();");
		return saveBook;
	}

	@GetMapping(path = Constants.GET_BY_BOOK_NAME_CONTROLLER_ENDPOINT)
	public List<BookResponseDto> getBookByName(@PathVariable String bookName) {
		mLogger.info("getBookByNAme Controller has Strated() , Recived book value+ " + bookName);
		List<BookResponseDto> bookByName = bookService.getBookByName(bookName);
		mLogger.debug("Recieved bookbyname" + bookByName);
		mLogger.info("getBookByNAme Controller has Ended();");
		return bookByName;

	}

	@GetMapping(path = Constants.GETBOOK_BY_ID_CONTROLLER_ENDPOINT)
	public BookResponseDto getBookById(@PathVariable("bookId") long bookId) {
		mLogger.info("getBookByd Controller has Strated(),recived " + bookId);

		BookResponseDto bookBasedOnId = bookService.getBookById(bookId);
		mLogger.debug("Recieved bookbyname" + bookBasedOnId);
		mLogger.info("getBookByd Controller has Ended();");
		return bookBasedOnId;

	}

	@DeleteMapping(path = Constants.DELETE_BOOK_BYID_CONTROLLER_ENDPOINT)
	public ResponseEntity<BookResponseDto> deleteById(@PathVariable("bookId") long bookId) {
		mLogger.info("deleteById Controller has Strated()+ book id 	recieved" + bookId);
		BookResponseDto deletedBook = bookService.deleteById(bookId);

		mLogger.debug("deleted bookbyid" + deletedBook);
		mLogger.info("deleteById Controller has Ended();");
		return ResponseEntity.ok().body(deletedBook);
	}

	@PutMapping(path = Constants.UPDATE_BOOK_BYID_CONTROLLER_ENDPOINT)
	public ResponseEntity<BookResponseDto> updateBook(@PathVariable("bookId") long bookId, @RequestBody BookRequestDto requestDto) {
		mLogger.info("updateBook Controller has Strated()+ book id 	recieved" + bookId + requestDto);
		BookResponseDto updateBook = bookService.updateBook(bookId, requestDto);
		mLogger.debug("Recived updated book based on id updateUSer() :" + updateBook);
		return ResponseEntity.ok().body(updateBook);
	}

}
