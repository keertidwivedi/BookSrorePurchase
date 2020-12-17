
package org.store.com.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.store.com.RequestDto.BookRequestDto;
import org.store.com.RequestDto.CommentRequestDto;
import org.store.com.Util.Constants;
import org.store.com.model.Book;
import org.store.com.model.Comment;
import org.store.com.repo.BookRepository;
import org.store.com.repo.CommentRepository;
import org.store.com.service.CommentService;

@RestController
public class CommentController {
	private final Logger mLogger = LoggerFactory.getLogger(CommentController.class);

	
	

	@Autowired
	private CommentService commentService;

	@PostMapping(path = Constants.CREATE_COMMENT_CONTROLLER_ENDPOINT)
	public Comment createComments(@PathVariable("id") long id, @RequestBody CommentRequestDto commentRequestDto) {
		mLogger.info("createComments Controller has Strated()+" + id + commentRequestDto);
		Comment saveBook = commentService.createComments(id, commentRequestDto);
		mLogger.info("createComments Controller has ended()+" + id);
		return saveBook;
	}

	@GetMapping(path = Constants.GETBYID_COMMENTS_CONTROLLER_ENDPOINT)
	public List<Comment> getComments(@PathVariable("id") long id) {
		mLogger.info("getComments Controller has Strated()+" + id);
		List<Comment> Comments = commentService.getComments(id);
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
	public List<Comment> deleteById(@PathVariable("id") long id) {
		mLogger.info("deleteById Controller has Strated()+" + id);
		List<Comment> deletedComments = commentService.deleteById(id);
		mLogger.info("deleteById Controller has ended()+" + deletedComments);
		return deletedComments;
	}

	@DeleteMapping(path = Constants.UPDATE_COMMENTS_CONTROLLER_ENDPOINT)
	public Comment updateComment(@PathVariable("bookId") long bookId, @PathVariable("commentId") long commentId,
			CommentRequestDto commentRequestDto) {
		mLogger.info("updateComment Controller has ended()+" + bookId);
		Comment deletComment = commentService.updateCommenent(bookId, commentId, commentRequestDto);

		return deletComment;

	}

	/*
	 * @GetMapping("/book/{bookId}/Comment/{commentId}") public Comment
	 * getCommentById(@PathVariable("bookId") long
	 * bookId, @PathVariable("commentId") long commentId, CommentRequestDto
	 * commentRequestDto) { Comment BookandCommentId =
	 * commentService.getCommentByID(bookId, commentId, commentRequestDto);
	 * 
	 * return BookandCommentId; }
	 */
}
