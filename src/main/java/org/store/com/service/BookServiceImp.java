package org.store.com.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.store.com.Exception.BookNotFoundException;
import org.store.com.Exception.StoreException;
import org.store.com.RequestDto.BookRequestDto;
import org.store.com.ResponseDto.BookResponseDto;
import org.store.com.controller.BookController;
import org.store.com.model.Book;
import org.store.com.repo.BookRepository;

@Service
public class BookServiceImp implements BookService {

	private final Logger mLogger = LoggerFactory.getLogger(BookController.class);

	@Autowired
	private BookRepository bookRepository;

	@Override
	public BookResponseDto createBook(BookRequestDto bookRequestDto) {
		mLogger.info("create Book service implementation has started and recievecd"+bookRequestDto);
		BookResponseDto bookResponseDto = new BookResponseDto();
		mLogger.info("object of BookRsponseDto has created"+bookResponseDto);
		Book newBook = new Book();
		mLogger.info("object of Book has created"+newBook);
		newBook.setAuthor(bookRequestDto.getAuthor());
		newBook.setBookName(bookRequestDto.getBookName());
		newBook.setQuantity(bookRequestDto.getQuantity());
		mLogger.info("values are set to new book object"+newBook);

		Book savedBook = bookRepository.save(newBook);
		mLogger.info("book values have been saved "+ savedBook);
		bookResponseDto.setBookName(savedBook.getBookName());
		bookResponseDto.setBookName(savedBook.getAuthor());
		bookResponseDto.setBookName(savedBook.getQuantity());
		mLogger.info("saved values are set to bookResponseDto and are returned"+
				bookResponseDto);
		return bookResponseDto;
	}

	@Override
	public List<BookResponseDto> getBookByName(String bookName) {
		mLogger.info("getBookByName Service implementation has Started , reciebed bookName" + bookName);

		List<BookResponseDto> searchBook = bookRepository.findByBookName(bookName);
		mLogger.info("searching of book by bookname has been done "+searchBook);

		return searchBook;

	}

	@Override
	public Optional<BookResponseDto> getBookById(long bookId) {
		mLogger.info("getBookById Service implementation has Started , reciebed bookId" + bookId);
		Optional<BookResponseDto> searchbyId = bookRepository.findById(bookId);
		mLogger.info("searched record brom datbase" + searchbyId);
		if (searchbyId.isEmpty()) {
			throw new BookNotFoundException("Book not found");// exception change
		}
		return searchbyId;
	}

	@Override
	public Optional<Book> deleteById(long bookId) {
		mLogger.info("deleteById Service implementation has Started , reciebed bookId" + bookId);
		Optional<Book> searchbyId = bookRepository.deleteById(bookId);
		mLogger.info("searched record from datbase" + searchbyId);
		if (searchbyId.isEmpty()) {
			throw new BookNotFoundException("Book not found");
		}
		return searchbyId;

	}

	@Override
	public BookResponseDto updateBook(long bookId, BookRequestDto requestDto) {
		mLogger.info("updateBook Service implementation has Started , reciebed bookId" + bookId);
		Optional<BookResponseDto> bookFromDBOpt = bookRepository.findById(bookId);
		if (bookFromDBOpt.isEmpty()) {
			throw new BookNotFoundException("Book not found");
		}
		BookResponseDto bookResponseDtofromDB = bookFromDBOpt.get();
		mLogger.info("record from datbase"+bookResponseDtofromDB);
		bookResponseDtofromDB.setBookAuthor(requestDto.getAuthor());

		bookResponseDtofromDB.setBookName(requestDto.getBookName());
		bookResponseDtofromDB.setQuantity(requestDto.getQuantity());
		
		BookResponseDto updatedBooks = bookRepository.save(bookResponseDtofromDB);
		mLogger.info("updatinf the record and saving the record"+updatedBooks);
		return updatedBooks;
	}

}