package org.store.com.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.store.com.ResponseDto.BookResponseDto;
import org.store.com.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

	List<Book> findByBookName(String bookName);

	Book findById(long bookId);

	Optional<Book> deleteById(long id);

	Book save(BookResponseDto newBook);

}
