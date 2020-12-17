package org.store.com.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.store.com.Exception.StoreException;
import org.store.com.RequestDto.BookRequestDto;
import org.store.com.ResponseDto.BookResponseDto;
import org.store.com.controller.BookController;
import org.store.com.model.Book;
import org.store.com.repo.BookRepository;
import org.store.com.repo.CommentRepository;

@Service
public class BookServiceImp implements BookService {

	private final Logger mLogger = LoggerFactory.getLogger(BookController.class);

	private BookRepository bookRepository;

	private CommentRepository commentRepository;

	@Override
	public BookResponseDto  createBook(BookRequestDto bookRequestDto) {

		BookResponseDto bookResponseDto = new BookResponseDto();
		
		Book newBook = new Book();
		newBook.setAuthor(bookRequestDto.getAuthor());
		newBook.setBookName(bookRequestDto.getBookName());
		newBook.setQuantity(bookRequestDto.getQuantity());

		Book savedBook = bookRepository.save(newBook);
		bookResponseDto.setBookName(savedBook.getBookName());
		bookResponseDto.setBookName(savedBook.getAuthor());
		bookResponseDto.setBookName(savedBook.getQuantity());
		return bookResponseDto;
	}

	@Override
	public List<BookResponseDto> getBookByName(BookRequestDto  BookRequestDto) {
		mLogger.info("Service Started" + BookRequestDto);

		List<BookResponseDto> searchBook = bookRepository.findByBookName(BookRequestDto);

		return searchBook;

	}

	@Override
	public Optional<BookResponseDto> getBookById(long id) {
		mLogger.info("Service Started" + id);
		Optional<BookResponseDto> searchbyId = bookRepository.findById(id);
		mLogger.info("searched record brom datbase" + searchbyId);
		if (searchbyId.isEmpty()) {
			throw new StoreException("Id not found");
		}
		return searchbyId;
	}

	@Override
	public Optional<Book> deleteById(long bookId) {
		mLogger.info("Service Started" + bookId);
		Optional<Book> searchbyId = bookRepository.deleteById(bookId);
		mLogger.info("searched record brom datbase" + searchbyId);
		if (searchbyId.isEmpty()) {
			throw new StoreException("Id not found");
		}
		return null;

	}


	

	@Override
	public BookResponseDto updateBook(long id, BookRequestDto requestDto) {

		Optional<BookResponseDto> bookFromDBOpt = bookRepository.findById(id);
		if (bookFromDBOpt.isEmpty()) {
			throw new StoreException("User Not FOund Based On ID");
		}
		BookResponseDto updateBook = bookFromDBOpt.get();
		updateBook.setBookAuthor(requestDto.getAuthor());

		updateBook.setBookName(requestDto.getBookName());
		updateBook.setQuantity(requestDto.getQuantity());
		updateBook.setComment(requestDto.getComment());

		BookResponseDto updatedBooks = bookRepository.save(updateBook);
		return updatedBooks;
	}

	


}