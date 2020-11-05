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

@Service
public class BookService {

	private final Logger mLogger = LoggerFactory.getLogger(BookController.class);

	@Autowired
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
		
		return searchBook;

		
	}

	
	public Optional<Book> getBookById(long bookID)
	{
		mLogger.info("Service Started" + bookID);
		Optional<Book> searchbyId =  bookRepository.findById(bookID);
		mLogger.info("searched record brom datbase" + searchbyId);
		if(searchbyId.isEmpty())
		{
			throw new StoreException("Id not found");
		}
		return searchbyId;
	}
	
	public  Optional<Book> deleteById(long bookId)
	{
		mLogger.info("Service Started" + bookId);
		Optional<Book> searchbyId =  bookRepository.deleteById(bookId);
		mLogger.info("searched record brom datbase" + searchbyId);
		if(searchbyId.isEmpty())
		{
			throw new StoreException("Id not found");
		}
		return null;
		
	}
	
	
	
public Book updateBook(long id, BookRequestDto requestDto) {
		
		Optional<Book> bookFromDBOpt = bookRepository.findById(id);
		if (bookFromDBOpt.isEmpty()) {
			throw new StoreException("User Not FOund Based On ID");
		}
		Book updateBook = bookFromDBOpt.get();
		updateBook.setAuthor(requestDto.getAuthor());
		
		updateBook.setBookName(requestDto.getBookName());
		updateBook.setQuantity(requestDto.getQuantity());
		updateBook.setComment(requestDto.getComment());
		
		

		Book updatedBook = bookRepository.save(updateBook);
		return updateBook;
}
	

}