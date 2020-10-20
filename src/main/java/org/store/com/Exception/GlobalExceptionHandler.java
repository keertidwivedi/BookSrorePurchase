
package org.store.com.Exception;
  
  import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus; import
  org.springframework.http.ResponseEntity; import
  org.springframework.security.core.userdetails.UsernameNotFoundException;
  import org.springframework.stereotype.Controller; import
  org.springframework.ui.Model; import
  org.springframework.web.bind.annotation.ControllerAdvice; import
  org.springframework.web.bind.annotation.ExceptionHandler; import
  org.store.com.model.User;
  
  @Controller
  
  @ControllerAdvice 
  
  public class GlobalExceptionHandler {
  
  
  @ExceptionHandler(NullPointerException.class) 
  public String handleNullPinterException(NullPointerException nullPointerException) 
  { 
	 
	 // .addAttribute("error message","Try after Some time");
	  System.out.println();
	  System.out.println(nullPointerException.getMessage()+"----------------");
  return  nullPointerException.getMessage();
  
  }
  
  
  @ExceptionHandler(value = UsernameNotFoundException.class) public String
  handleUserNotFoundException(Model model) {model.addAttribute("error message",
  "user is not found"); return "error"; } }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  

	/*
	 * @ExceptionHandler(value = NullPointerException.class) public
	 * ResponseEntity<Object> handleNullPinterException(NullPointerException ex) {
	 * return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.NOT_FOUND);
	 * 
	 * }
	 */
