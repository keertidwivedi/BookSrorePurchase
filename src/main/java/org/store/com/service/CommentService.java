package org.store.com.service;

import java.util.List; 

import org.store.com.RequestDto.CommentRequestDto;
import org.store.com.ResponseDto.CommentResponseDto;
import org.store.com.model.Comment;

public interface CommentService {

	public CommentResponseDto createComments(long id, CommentRequestDto commentRequestDto);

	public List<CommentResponseDto> getComments(long id);

	public List<Comment> getComments();

	public CommentResponseDto deleteById(long id);

	public CommentResponseDto updateCommenent(long bookId, long commentId, CommentRequestDto commentRequestDto);

}
