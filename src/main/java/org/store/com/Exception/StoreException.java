package org.store.com.Exception;

public class StoreException extends RuntimeException{
	
	private String Exceptionmessage;

	
	public StoreException(String Exceptionmessage)
	{
		super(Exceptionmessage);
		this.Exceptionmessage=Exceptionmessage;
	}
}
