package org.store.com.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.store.com.Exception.BookNotFoundException;
import org.store.com.RequestDto.CommentRequestDto;
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
	public Comment createComments(long id, CommentRequestDto commentRequestDto) {
		mLogger.info("createComments service has Strated()+" + id, commentRequestDto);
		Optional<Book> idFoundDB = bookRepository.findById(id);
		mLogger.info("Book dound for following id " + idFoundDB);

		if (idFoundDB.isPresent()) {

			Book book = idFoundDB.get();

			// List<Book> newBook = new ArrayList<Book>();

			mLogger.info("book record from DB" + book);
			mLogger.info(" Comment" + commentRequestDto);

			Comment comment = new Comment();
			comment.setText(commentRequestDto.getText());
			comment.setBook(book);
			Comment aveComment = commentRepository.save(comment);

			return aveComment;
		} else

			throw new BookNotFoundException("invalid id");

	}

	@Override
	public List<Comment> getComments(long id) {
		mLogger.info("getComments service has Strated()+" + id);
		List<Comment> comentsFromDB = commentRepository.findIdById(id);
		mLogger.info("Command found in DB " + comentsFromDB);

		return comentsFromDB;
	}

	@Override
	public List<Comment> getComments() {
		mLogger.info("getComments service has Strated()+");
		List<Comment> allComentsFromDB = commentRepository.findAll();
		mLogger.info("Comment found in DB " + allComentsFromDB);
		return allComentsFromDB;

	}

	@Override
	public List<Comment> deleteById(long id) {
		mLogger.info("deleteById service has Strated()+" + id);
		List<Comment> commentdelete = commentRepository.deleteById(id);
		return commentdelete;

	}

	@Override
	public Comment updateCommenent(long bookId, long commentId, CommentRequestDto commentRequestDto) {
		mLogger.info("updateCommenent service has Strated()+" + bookId, commentId, commentId);

		Optional<Book> foundBookByIdInDB = bookRepository.findById(bookId);

		Book bookRecordFromDB = foundBookByIdInDB.get();

		if (foundBookByIdInDB.isEmpty()) {
			throw new BookNotFoundException("Book not found based  on Id");
		}

		Optional<Comment> foundCommentByIdInDB = commentRepository.findById(commentId);

		Comment fetchedFromDB = foundCommentByIdInDB.get();

		fetchedFromDB.setText(commentRequestDto.getText());

		Comment updateComment = commentRepository.save(fetchedFromDB);

		return updateComment;
	}

}
