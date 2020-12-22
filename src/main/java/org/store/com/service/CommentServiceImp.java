
package org.store.com.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.store.com.Exception.BookNotFoundException;
import org.store.com.RequestDto.CommentRequestDto;
import org.store.com.ResponseDto.BookResponseDto;
import org.store.com.ResponseDto.CommentResponseDto;
import org.store.com.model.Book;
import org.store.com.model.Comment;
import org.store.com.repo.BookRepository;
import org.store.com.repo.CommentRepository;

@Service
public class CommentServiceImp implements CommentService {

	private final Logger mLogger = LoggerFactory.getLogger(CommentService.class);

	CommentRepository commentRepository;

	BookRepository bookRepository;

	@Override
	public CommentResponseDto createComments(long id, CommentRequestDto commentRequestDto) {
		mLogger.info("createComments service implementation has Strated() and recieved+" + id, commentRequestDto);
		Book idFoundDB = bookRepository.findById(id);
		mLogger.info("Book found for following id " + idFoundDB);

		if (idFoundDB.getBookId() == id) {
			
			mLogger.info(" Comment" + commentRequestDto);

			CommentResponseDto comment = new CommentResponseDto();
			comment.setText(commentRequestDto.getText()); // comment.setBook(book);
			CommentResponseDto aveComment = commentRepository.save(comment);
			mLogger.info("saving the comment in comment repository and returning" + aveComment);
			mLogger.info("createComments service implementation has ended()");
			return aveComment;
		} else

			throw new BookNotFoundException("invalid id");

	}

	@Override
	public List<CommentResponseDto> getComments(long commentId) {
		mLogger.info("getComments service implementation has Strated() and recieved+" + commentId);

		List<CommentResponseDto> comentsFromDB = commentRepository.findIdById(commentId);
		mLogger.info("Command found in DB " + comentsFromDB);
		mLogger.info("getComments service implementation has ended()");
		return comentsFromDB;
	}

	@Override
	public List<Comment> getComments() {
		mLogger.info("getComments service has Strated()+");
		List<Comment> allComentsFromDB = commentRepository.findAll();
		mLogger.info("Comment found in DB " + allComentsFromDB);
		mLogger.info("getComments service implementation has ended()");
		return allComentsFromDB;

	}

	@Override
	public List<CommentResponseDto> deleteById(long id) {
		mLogger.info("deleteById service has Strated()+" + id);
		List<CommentResponseDto> commentdelete = commentRepository.deleteById(id);
		mLogger.info("createComments service implementation has ended()");
		return commentdelete;

	}

	@Override
	public CommentResponseDto updateCommenent(long bookId, long commentId, CommentRequestDto commentRequestDto) {
		mLogger.info("updateCommenent service has Strated()+" + bookId, commentId, commentRequestDto);

		Book foundBookByIdInDB = bookRepository.findById(bookId);
		mLogger.info("book record from db"+foundBookByIdInDB);
		
	
		if (foundBookByIdInDB.getBookId() < 1) {
			mLogger.info("book record is not present");
			throw new BookNotFoundException("Book not found based  on Id");
		}

		Optional<CommentResponseDto> foundCommentByIdInDB = commentRepository.findById(commentId);
		mLogger.info("comment record "+foundCommentByIdInDB);

		CommentResponseDto fetchedFromDB = foundCommentByIdInDB.get();
		mLogger.info("getting comment record from db"+fetchedFromDB);

		fetchedFromDB.setText(commentRequestDto.getText());

		CommentResponseDto updateComment = commentRepository.save(fetchedFromDB);
		mLogger.info("updating the record and saving ");
		mLogger.info("updateCommenent service implementation has ended()");
		return updateComment;
	}

}
