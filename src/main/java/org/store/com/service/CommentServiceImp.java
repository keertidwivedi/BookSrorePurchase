
package org.store.com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.store.com.Exception.BookNotFoundException;
import org.store.com.RequestDto.CommentRequestDto;
import org.store.com.ResponseDto.CommentResponseDto;
import org.store.com.model.Book;
import org.store.com.model.Comment;
import org.store.com.repo.BookRepository;
import org.store.com.repo.CommentRepository;

@Service
public class CommentServiceImp implements CommentService {

	private final Logger mLogger = LoggerFactory.getLogger(CommentService.class);

	@Autowired
	CommentRepository commentRepository;

	@Autowired
	BookRepository bookRepository;

	@Override
	public CommentResponseDto createComments(long bookId, CommentRequestDto commentRequestDto) {
		mLogger.info("createComments service implementation has Strated() and recieved+" + bookId, commentRequestDto);
		Book foundInDB = bookRepository.findById(bookId);
		mLogger.info("Book found for following id " + foundInDB);

		if (foundInDB == null) {
			throw new BookNotFoundException("Book not  found based on id");
		}
		mLogger.info(" Comment" + commentRequestDto);
		Comment comment = new Comment();

		Book newBook = new Book();
		newBook.setBookId(foundInDB.getBookId());
		newBook.setAuthor(foundInDB.getAuthor());
		newBook.setBookName(foundInDB.getBookName());
		newBook.setQuantity(foundInDB.getQuantity());

		comment.setBook(newBook);

		comment.setText(commentRequestDto.getText());

		Comment aveComment = commentRepository.save(comment);
		mLogger.info("saving the comment in comment repository and returning" + aveComment);

		CommentResponseDto commentResponseDto = new CommentResponseDto();
		commentResponseDto.setText(aveComment.getText());

		mLogger.info("createComments service implementation has ended()");
		return commentResponseDto;

	}

	@Override
	public List<CommentResponseDto> getComments(long commentId) {
		mLogger.info("getComments service implementation has Strated() and recieved+" + commentId);
		List<CommentResponseDto> listCommentResponseDtos = new ArrayList<CommentResponseDto>();
		List<Comment> comentsFromDB = commentRepository.findIdById(commentId);
		mLogger.info("Command found in DB " + comentsFromDB);

		CommentResponseDto commentResponseDto;

		for (Comment comment : comentsFromDB) {
			commentResponseDto = new CommentResponseDto();
			commentResponseDto.setText(comment.getText());
			listCommentResponseDtos.add(commentResponseDto);

		}
		mLogger.info("list of comments" + listCommentResponseDtos);

		mLogger.info("getComments service implementation has ended()");
		return listCommentResponseDtos;
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
	public CommentResponseDto deleteById(long commentId) {
		mLogger.info("deleteById service has Strated()+" + commentId);
		CommentResponseDto commentResponseDto;
		Comment commentdelete = commentRepository.deleteById(commentId);

		commentResponseDto = new CommentResponseDto();
		commentResponseDto.setText(commentdelete.getText());
		mLogger.info("createComments service implementation has ended()");
		return commentResponseDto;

	}

	@Override
	public CommentResponseDto updateCommenent(long bookId, long commentId, CommentRequestDto commentRequestDto) {
		mLogger.info("updateCommenent service has Strated()+" + bookId, commentId, commentRequestDto);

		Book foundBookByIdInDB = bookRepository.findById(bookId);
		mLogger.info("book record from db" + foundBookByIdInDB);

		if (foundBookByIdInDB.getBookId() < 1) {
			mLogger.info("book record is not present");
			throw new BookNotFoundException("Book not found based  on Id");
		}

		Optional<Comment> foundCommentByIdInDB = commentRepository.findById(commentId);
		mLogger.info("comment record " + foundCommentByIdInDB);

		Comment fetchedFromDB = foundCommentByIdInDB.get();
		mLogger.info("getting comment record from db" + fetchedFromDB);

		fetchedFromDB.setText(commentRequestDto.getText());
		mLogger.info("updated record" + fetchedFromDB);
		Comment updateComment = commentRepository.save(fetchedFromDB);
		mLogger.info("updating the record and saving ");
		mLogger.info("updateCommenent service implementation has ended()");

		CommentResponseDto commentResponseDto = new CommentResponseDto();
		commentResponseDto.setText(updateComment.getText());
		return commentResponseDto;
	}

}
