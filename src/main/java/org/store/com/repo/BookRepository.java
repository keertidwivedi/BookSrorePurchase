package org.store.com.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.store.com.RequestDto.BookRequestDto;
import org.store.com.ResponseDto.BookResponseDto;
import org.store.com.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

	List<BookResponseDto> findByBookName(BookRequestDto bookRequestDto);
	
	List<BookResponseDto> getBookById(long id);

//List<Book> deleteByBook(String bookName);

	Optional<BookResponseDto> findById(long id);

	Optional<Book> deleteById(long id);

	BookResponseDto save(BookResponseDto newBook);

}
