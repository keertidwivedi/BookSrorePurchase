package org.store.com.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.store.com.ResponseDto.BookResponseDto;
import org.store.com.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

	List<BookResponseDto> findByBookName(String bookName);

	//List<BookResponseDto> findBybookId(long bookId);

	Optional<BookResponseDto> findById(long bookId);

	Optional<Book> deleteById(long id);

	BookResponseDto save(BookResponseDto newBook);

}
