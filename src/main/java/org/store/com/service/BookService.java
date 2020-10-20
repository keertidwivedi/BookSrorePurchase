package org.store.com.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.store.com.Exception.StoreException;
import org.store.com.controller.BookController;
import org.store.com.controller.UserController;
import org.store.com.model.Book;
import org.store.com.model.Comment;
import org.store.com.repo.BookRepository;
import org.store.com.repo.CommentRepository;

@Service
public class BookService {

	private final Logger mLogger = LoggerFactory.getLogger(BookController.class);

	private BookRepository bookRepository;

	private CommentRepository commentRepository;

	// Create/add a Book
	public Book createBook(Book book) {

		Book newBook = new Book();
		newBook.setAuthor(book.getAuthor());
		newBook.setBookName(book.getBookName());
		newBook.setQuantity(book.getQuantity());

		Book savedBook = bookRepository.save(newBook);
		return savedBook;
	}

	public List<Book> getBookByName(String bookName) {
		mLogger.info("Service Started" + bookName);

		List<Book> searchBook = bookRepository.findByBookName(bookName);
		// mLogger.debug("searche dBook Found"+bookName);
		/*
		 * if(searchBook == null) { throw new StoreException("book not found");
		 * 
		 * } else
		 */
		return searchBook;

		/*
		 * if(((Book) searchBook).getBookName()== bookName) { return searchBook; } throw
		 * new StoreException("Book not found");
		 */

	}

	public List<Book> deleteByName(String bookName) {

		List<Book> deleteBook = bookRepository.deleteByBookName(bookName);
		return deleteBook;
	}
	
	
	public Optional<Book> getBookById(long id)
	{
		Optional<Book> foundBookByID = bookRepository.findById(id); 
		if(foundBookByID.isEmpty())
		{
			throw new StoreException("id not found");
		}
		return foundBookByID;
		
		
	}

}