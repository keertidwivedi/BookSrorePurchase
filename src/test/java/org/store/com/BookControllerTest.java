package org.store.com;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.store.com.RequestDto.BookRequestDto;
import org.store.com.RequestDto.UserRequestDto;
import org.store.com.ResponseDto.BookResponseDto;
import org.store.com.ResponseDto.UserResponseDto;
import org.store.com.Util.Constants;
import org.store.com.controller.BookController;
import org.store.com.model.Book;
import org.store.com.model.User;
import org.store.com.service.BookService;
import org.store.com.service.MyUserDetailsService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration
@WebMvcTest(value = BookController.class)
public class BookControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	BookService bookService;

	@MockBean
	private MyUserDetailsService myUserDetailsService;

	Book bookTest;

	BookResponseDto newBookResponseDto;
	Optional<BookResponseDto> bookResponseDtoopt;

	// private String URI;

	String inputJson;

	@BeforeEach
	void setUp() throws JsonProcessingException {

		BookRequestDto bookRequestDto = new BookRequestDto("HarryPotter", "abcd", "3");
		bookTest = new Book();
		bookTest.setBookName("HarryPotter");
		bookTest.setAuthor("abcd");
		bookTest.setQuantity("3");

		inputJson = this.mapToJson(bookRequestDto);

	}

	@Test
	public void testCreateBook() throws Exception {
		String URI = Constants.CREATE_BOOK_CONTROLLER_ENDPOINT;
		BookResponseDto bookResponseDto = new BookResponseDto("HarryPotter", "abcd", "3");

		String expectedOutputInJsn = mapToJson(bookResponseDto);

		Mockito.when(bookService.createBook(Mockito.any(BookRequestDto.class))).thenReturn(bookResponseDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON)
				.content(inputJson).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();

		String outputInJson = response.getContentAsString();

		assertThat(outputInJson).isEqualTo(expectedOutputInJsn);
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}

	/*
	 * @Test public void testBookByName() throws Exception { String URI =
	 * Constants.GET_BY_BOOK_NAME_CONTROLLER_ENDPOINT;
	 * 
	 * List<BookResponseDto> bookResponseDtoList = new ArrayList<BookResponseDto>();
	 * 
	 * newBookResponseDto = new BookResponseDto();
	 * newBookResponseDto.setBookName(bookTest.getBookName());
	 * newBookResponseDto.setBookAuthor(bookTest.getAuthor());
	 * bookResponseDtoList.add(newBookResponseDto);
	 * 
	 * String expectedOutputInJsn = mapToJson(bookResponseDtoList);
	 * 
	 * Mockito.when(bookService.getBookByName(Mockito.any(BookRequestDto.class))).
	 * thenReturn(bookResponseDtoList); System.out.println("**************");
	 * 
	 * RequestBuilder requestBuilder =
	 * MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON); //
	 * .content(inputJson).contentType(MediaType.APPLICATION_JSON);
	 * 
	 * MvcResult result = mockMvc.perform(requestBuilder).andReturn();// controller
	 * call MockHttpServletResponse response = result.getResponse();
	 * System.out.println(result.getResponse());
	 * 
	 * String outputInJson = response.getContentAsString();
	 * 
	 * assertThat(outputInJson).isEqualTo(expectedOutputInJsn);
	 * assertEquals(HttpStatus.OK.value(), response.getStatus()); }
	 */

	
	/*
	 * @Test public void testBookById() throws Exception { URI =
	 * Constants.GETBOOK_BY_ID_CONTROLLER_ENDPOINT;
	 * 
	 * Optional<BookResponseDto> bookResponseDto;
	 * 
	 * String expectedOutputInJsn = mapToJson(bookResponseDtoopt);
	 * 
	 * Mockito.when(bookService.getBookById(Mockito.any(BookRequestDto.class))).
	 * thenReturn(bookResponseDtoopt); RequestBuilder requestBuilder =
	 * MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON)
	 * .content(inputJson).contentType(MediaType.APPLICATION_JSON);
	 * 
	 * MvcResult result = mockMvc.perform(requestBuilder).andReturn();
	 * MockHttpServletResponse response = result.getResponse();
	 * 
	 * String outputInJson = response.getContentAsString();
	 * 
	 * assertThat(outputInJson).isEqualTo(expectedOutputInJsn);
	 * assertEquals(HttpStatus.OK.value(), response.getStatus()); }
	 */
	  
	  private String mapToJson(Object object) throws JsonProcessingException {
	  ObjectMapper objectMapper = new ObjectMapper(); return
	  objectMapper.writeValueAsString(object); }
	 

}
