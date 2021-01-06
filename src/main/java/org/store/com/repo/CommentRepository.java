package org.store.com.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.store.com.ResponseDto.CommentResponseDto;
import org.store.com.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

	// List<Comment> getCommentByBook(String bookName);

	List<Comment> findIdById(long commentId);

	Optional<Comment> findById(long CommentId);

	Comment save(CommentResponseDto comment);

	List<Comment> findAll();

	Comment deleteById(long commentId);
}
