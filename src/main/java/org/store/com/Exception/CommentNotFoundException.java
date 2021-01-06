package org.store.com.Exception;

public class CommentNotFoundException extends RuntimeException {
	private String Exceptionmessage;

	public CommentNotFoundException(String Exceptionmessage) {
		super(Exceptionmessage);
		this.Exceptionmessage = Exceptionmessage;
	}

}
