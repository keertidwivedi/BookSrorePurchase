package org.store.com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.store.com.model.Comment;
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

	
}
