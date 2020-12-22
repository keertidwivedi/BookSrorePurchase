package org.store.com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.store.com.Exception.BookNotFoundException;
import org.store.com.RequestDto.BookRequestDto;
import org.store.com.ResponseDto.BookResponseDto;
import org.store.com.ResponseDto.UserResponseDto;
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
		mLogger.info("create Book service implementation has started and recievecd" + bookRequestDto);
		BookResponseDto bookResponseDto = new BookResponseDto();
		mLogger.debug("object of BookRsponseDto has created" + bookResponseDto);
		Book newBook = new Book();
		mLogger.debug("object of Book has created" + newBook);
		newBook.setAuthor(bookRequestDto.getAuthor());
		newBook.setBookName(bookRequestDto.getBookName());
		newBook.setQuantity(bookRequestDto.getQuantity());
		mLogger.debug("values are set to new book object" + newBook);

		Book savedBook = bookRepository.save(newBook);
		mLogger.debug("book values have been saved " + savedBook);
		bookResponseDto.setBookName(savedBook.getBookName());
		bookResponseDto.setBookAuthor(savedBook.getAuthor());
		bookResponseDto.setQuantity(savedBook.getQuantity());
		mLogger.info("saved values are set to bookResponseDto and are returned" + bookResponseDto);
		return bookResponseDto;
	}

	@Override
	public List<BookResponseDto> getBookByName(String bookName) {
		mLogger.info("getBookByName Service implementation has Started , reciebed bookName" + bookName);
		BookResponseDto newBookREsponseDto;
		List<BookResponseDto> listBookResponseDto = new ArrayList<BookResponseDto>();

		List<Book> searchBook = bookRepository.findByBookName(bookName);
		mLogger.debug("searching of book by bookname has been done " + searchBook);

		for (Book book : searchBook) {
			newBookREsponseDto = new BookResponseDto();
			newBookREsponseDto.setBookName(book.getBookName());
			newBookREsponseDto.setBookAuthor(book.getAuthor());
			newBookREsponseDto.setComment(book.getComment());
			newBookREsponseDto.setQuantity(book.getQuantity());

			listBookResponseDto.add(newBookREsponseDto);
		}
		mLogger.info("getBookByName has been ended ");
		return listBookResponseDto;

	}

	@Override
	public BookResponseDto getBookById(long bookId) {
		mLogger.info("getBookById Service implementation has Started , reciebed bookId" + bookId);
		BookResponseDto bookResponseDto = new BookResponseDto();
		Book searchbyId = bookRepository.findById(bookId);
		mLogger.debug("searched record brom datbase" + searchbyId);
		if (searchbyId.getBookId() == bookId) {
			bookResponseDto.setBookName(searchbyId.getBookName());
			bookResponseDto.setBookAuthor(searchbyId.getAuthor());
			bookResponseDto.setComment(searchbyId.getComment());
			bookResponseDto.setQuantity(searchbyId.getQuantity());

		} else {
			throw new BookNotFoundException("Book not found");
		}
		mLogger.info("getBookById Service implementation has ended ");
		return bookResponseDto;
	}

	@Override
	public BookResponseDto deleteById(long bookId) {
		mLogger.info("deleteById Service implementation has Started , reciebed bookId" + bookId);
		BookResponseDto bookResponseDto;
		Optional<Book> searchbyId = bookRepository.deleteById(bookId);
		mLogger.debug("searched record from datbase" + searchbyId);
		if (searchbyId.isEmpty()) {
			throw new BookNotFoundException("Book not found");
		} else {
			Book valuesfromoptional = searchbyId.get();
			bookResponseDto = new BookResponseDto();
			bookResponseDto.setBookName(valuesfromoptional.getBookName());
			bookResponseDto.setBookAuthor(valuesfromoptional.getAuthor());
		}
		mLogger.info("deleteById Service implementation has ended ");
		return bookResponseDto;

	}

	@Override
	public BookResponseDto updateBook(long bookId, BookRequestDto requestDto) {
		mLogger.info("updateBook Service implementation has Started , reciebed bookId" + bookId, requestDto);
		Book bookFromDBOpt = bookRepository.findById(bookId);
		if (bookFromDBOpt == null) {
			throw new BookNotFoundException("Book not found");
		}
		mLogger.debug("found based on id " + bookFromDBOpt);
		BookResponseDto bookResponseDto = new BookResponseDto();
		bookFromDBOpt.setBookName(requestDto.getBookName());
		bookFromDBOpt.setAuthor(requestDto.getAuthor());
		bookFromDBOpt.setQuantity(requestDto.getQuantity());

		mLogger.debug("" + bookFromDBOpt);

		Book savedBookObject = bookRepository.save(bookFromDBOpt);
		bookResponseDto.setBookName(savedBookObject.getBookName());
		bookResponseDto.setBookAuthor(savedBookObject.getAuthor());
		bookResponseDto.setQuantity(savedBookObject.getQuantity());
		mLogger.info("updateBook Service implementation has ended ");
		return bookResponseDto;
	}

}