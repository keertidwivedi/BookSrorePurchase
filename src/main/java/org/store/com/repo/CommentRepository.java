package org.store.com.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.store.com.ResponseDto.CommentResponseDto;
import org.store.com.model.Book;
import org.store.com.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

	// List<Comment> getCommentByBook(String bookName);

	List<CommentResponseDto> findIdById(long id);

	Optional<CommentResponseDto> findById(long id);

	CommentResponseDto save(CommentResponseDto comment);

	List<Comment> findAll();

	List<CommentResponseDto> deleteById(long id);
}
