package org.store.com.service;

import java.util.List;
import java.util.Optional;

import org.store.com.RequestDto.BookRequestDto;
import org.store.com.ResponseDto.BookResponseDto;
import org.store.com.model.Book;

public interface BookService {

	// Create/add a Book
	BookResponseDto createBook(BookRequestDto bookRequestDto);

	List<BookResponseDto> getBookByName(BookRequestDto bookRequestDto);

	Optional<BookResponseDto> getBookById(long bookId);

	Optional<Book> deleteById(long bookId);

	BookResponseDto updateBook(long id, BookRequestDto requestDto);

	

	
}