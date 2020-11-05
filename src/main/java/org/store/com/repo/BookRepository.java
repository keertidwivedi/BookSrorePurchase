package org.store.com.repo;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.store.com.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book,Long > {
	
	List<Book> findByBookName(String bookName);
	
//List<Book> deleteByBook(String bookName);
	
	Optional<Book> findById(long id);
	
	Optional<Book> deleteById(long id );

	
	

	

	
	

}
