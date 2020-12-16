package org.store.com.service;

import java.util.List;

import org.store.com.RequestDto.CommentRequestDto;
import org.store.com.model.Comment;

public interface CommentService {

	public Comment createComments(long id, CommentRequestDto commentRequestDto);

	public List<Comment> getComments(long id);

	public List<Comment> getComments();

	public List<Comment> deleteById(long id);

	public Comment updateCommenent(long bookId, long commentId, CommentRequestDto commentRequestDto);

}
