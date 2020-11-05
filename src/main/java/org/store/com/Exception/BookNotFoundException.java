package org.store.com.Exception;

public class BookNotFoundException extends RuntimeException{
	
	private String Exceptionmessage;

	public BookNotFoundException(String Exceptionmessage)
	{
		super(Exceptionmessage);
		this.Exceptionmessage=Exceptionmessage;
	}

}
