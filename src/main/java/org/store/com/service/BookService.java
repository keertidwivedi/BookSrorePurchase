package org.store.com.service;

import java.util.List;
import java.util.Optional;

import org.store.com.RequestDto.BookRequestDto;
import org.store.com.model.Book;

public interface BookService {

	// Create/add a Book
	Book createBook(Book book);

	List<Book> getBookByName(String bookName);

	Optional<Book> getBookById(long bookID);

	Optional<Book> deleteById(long bookId);

	Book updateBook(long id, BookRequestDto requestDto);
}