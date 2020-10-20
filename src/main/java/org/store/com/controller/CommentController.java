package org.store.com.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.store.com.model.Book;
import org.store.com.repo.CommentRepository;


@RestController
public class CommentController {
	
	CommentRepository commentRepository;
	
	
	@GetMapping("/book/{bookname}")
	public List<Book> getCommentByBook(@PathVariable String bookName)
	{
		List<Book> comments = commentRepository.getCommentByBook(bookName);
		return comments;
		
	}
	
	

}
