package org.store.com.Exception;

public class UserNotFoundException  extends Exception{
	
	private String Exceptionmessage;

	public UserNotFoundException(String Exceptionmessage) {
		super(Exceptionmessage);
		this.Exceptionmessage = Exceptionmessage;
	}
	
	

}
