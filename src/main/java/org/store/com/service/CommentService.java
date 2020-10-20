package org.store.com.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.store.com.model.Book;
import org.store.com.repo.BookRepository;
import org.store.com.repo.CommentRepository;

@Service
public class CommentService {

	
	CommentRepository commentRepository;
	
	BookRepository bookRepository;
	
	
	public List<Book> getCommentByBook(String bookName)
	{
		List<Book> bookWithComments = commentRepository.getCommentByBook(bookName);
		return bookWithComments;
	}
	
	
	
}
