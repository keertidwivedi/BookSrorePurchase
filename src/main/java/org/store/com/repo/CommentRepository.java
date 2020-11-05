package org.store.com.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.store.com.model.Book;
import org.store.com.model.Comment;
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

	//List<Comment> getCommentByBook(String bookName);

	
	List<Comment> findIdById(long id);
	
	Optional<Comment> findById(long id);
	
	List<Comment> save(String text);
	
	List<Comment> findAll();
	
	List<Comment> deleteById(long id);
}
