
package org.store.com.controller;

import java.util.List; 

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.store.com.RequestDto.CommentRequestDto;
import org.store.com.ResponseDto.CommentResponseDto;
import org.store.com.Util.Constants;
import org.store.com.model.Comment;
import org.store.com.service.CommentService;

@RestController
public class CommentController {
	private final Logger mLogger = LoggerFactory.getLogger(CommentController.class);

	
	@Autowired
	private CommentService commentService;

	@PostMapping(path = Constants.CREATE_COMMENT_CONTROLLER_ENDPOINT)
	public CommentResponseDto createComments(@PathVariable("bookId") long bookId, @RequestBody CommentRequestDto commentRequestDto) {
		mLogger.info("createComments Controller has Strated()+ recieved" + bookId + commentRequestDto);
		CommentResponseDto saveBook = commentService.createComments(bookId, commentRequestDto);
		mLogger.info("createComments Controller has ended()+" + bookId);
		return saveBook;
	}

	@GetMapping(path = Constants.GETBYID_COMMENTS_CONTROLLER_ENDPOINT)
	public List<CommentResponseDto> getComments(@PathVariable("commentId") long commentId) {
		mLogger.info("getComments Controller has Strated() recieved+" + commentId);
		List<CommentResponseDto> Comments = commentService.getComments(commentId);
		mLogger.info("getComments Controller has ended()+" + Comments);
		return Comments;
	}

	@GetMapping(path = Constants.GETALL_COMMENTS_CONTROLLER_ENDPOINT)
	public List<Comment> getAllComments() {
		mLogger.info("getAllComments Controller has Strated()+");
		List<Comment> comments = commentService.getComments();
		mLogger.info("getAllComments Controller has ended()+");
		return comments;
	}

	@DeleteMapping(path = Constants.DELETEBYID_COMMENTS_CONTROLLER_ENDPOINT)
	public CommentResponseDto deleteById(@PathVariable("commentId") long commentId) {
		mLogger.info("deleteById Controller has Strated() recieved commentid+" + commentId);
		CommentResponseDto deletedComments = commentService.deleteById(commentId);
		mLogger.info("deleteById Controller has ended()+" + deletedComments);
		return deletedComments;
	}

	@PutMapping(path = Constants.UPDATE_COMMENTS_CONTROLLER_ENDPOINT)
	public CommentResponseDto updateComment(@PathVariable("bookId") long bookId, @PathVariable("commentId") long commentId,
			@RequestBody CommentRequestDto commentRequestDto) {
		mLogger.info("updateComment Controller has ended()+" + bookId);
		CommentResponseDto deletComment = commentService.updateCommenent(bookId, commentId, commentRequestDto);

		return deletComment;

	}

	
}
