package org.store.com.Util;

public class Constants {

	//CONTANST FOR USER CONTROLLER
	public static final String CREATE_A_ROLE_ADMIN_CONTROLLER_ENDPOINT = "/user/create/admin";

	public static final String LIST_OF_USERS_CONTROLLER_ENDPOINT = "/user/all";

	public static final String CREATE_A_ROLE_USER_CONTROLLER_ENDPOINT = "/user/create/user";

	public static final String LIST_OF_ADMINS_CONTROLLER_ENDPOINT = "/admin/role";
	public static final String LIST_OF_USER_ROLE_CONTROLLER_ENDPOINT = "/user/role";
	public static final String DELETE_CONTROLLER_ENDPOINT = "user/delete/{userid}";
	public static final String UPDATE_CONTROLLER_ENDPOINT = "user/{userId}";
	
	
	//CONTANTS FOR COMMENT CONTROLLER
	
	public static final String CREATE_COMMENT_CONTROLLER_ENDPOINT = "/comments/{bookId}";
	
	public static final String GETBYID_COMMENTS_CONTROLLER_ENDPOINT = "/comment/{commentId}";
	
	
	public static final String GETALL_COMMENTS_CONTROLLER_ENDPOINT = "/comments";
	
	
	public static final String DELETEBYID_COMMENTS_CONTROLLER_ENDPOINT = "/comments/{commentId}";
	
	public static final String UPDATE_COMMENTS_CONTROLLER_ENDPOINT = "/book/{bookId}/commenet/{commentId}";
	
	
	
	
	//CONSTANTS CONTROOLER BOOK CONTOLLER
	
	
	public static final String CREATE_BOOK_CONTROLLER_ENDPOINT = "/book";
	
	public static final String GET_BY_BOOK_NAME_CONTROLLER_ENDPOINT = "/book/{bookName}";
	
	public static final String GETBOOK_BY_ID_CONTROLLER_ENDPOINT = "/books/{bookId}";
	
	public static final String DELETE_BOOK_BYID_CONTROLLER_ENDPOINT = "/book/{bookId}";
	
	public static final String UPDATE_BOOK_BYID_CONTROLLER_ENDPOINT = "/book/{bookId}";
	
	
	
	
	
	
	


}
