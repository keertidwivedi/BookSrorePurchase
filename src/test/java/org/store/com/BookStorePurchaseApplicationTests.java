package org.store.com;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.store.com.RequestDto.UserRequestDto;
import org.store.com.ResponseDto.UserResponseDto;
import org.store.com.controller.UserController;
import org.store.com.model.User;
import org.store.com.service.UserService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@RunWith(SpringRunner.class)

@WebMvcTest(value = UserController.class,secure = false)
class BookStorePurchaseApplicationTests {

	@Autowired
	private MockMvc mockMvc; 
	
	
	@MockBean
	UserService userService; 

	

	User userTest;

	String InputInJson;

	@BeforeEach
	void setUp() throws JsonProcessingException {

		UserRequestDto requestDto = new UserRequestDto("user1", "user@1", "userpass");
		userTest = new User();
		userTest.setUserName("user1");
		userTest.setPassword("userpass");
		userTest.setEmail("user@1");

		InputInJson = this.mapToJson(requestDto);

	}

	@Test
	public void testCreateUser() throws Exception {
	

		String URI = "/user/create/admin";

		UserResponseDto userResponseDto = new UserResponseDto("user1", "user@gmail");

		String expectedOutputInJsn = mapToJson(userResponseDto);

		Mockito.when(userService.createRoleAdmin(Mockito.any(UserRequestDto.class))).thenReturn(userResponseDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON)
				.content(InputInJson).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();

		String outputInJson = response.getContentAsString();

		assertThat(outputInJson).isEqualTo(InputInJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	
	

	/*
	 * @Test public void testGetAllUsers() throws Exception {
	 * 
	 * UserRequestDto userMock1 = new UserRequestDto();
	 * userMock1.setUserName("user1"); userMock1.setPassword("userpass");
	 * userMock1.setEmail("user@1");
	 * 
	 * 
	 * 
	 * UserRequestDto userMock2 = new UserRequestDto();
	 * userMock2.setUserName("user2"); userMock2.setPassword("userpass2");
	 * userMock2.setEmail("user@2");
	 * 
	 * 
	 * List<UserRequestDto> UserList = new ArrayList<UserRequestDto>();
	 * UserList.add(userMock1); UserList.add(userMock2); o
	 * 
	 * String URI = "/api/tickets/alltickets"; RequestBuilder requestBuilder =
	 * MockMvcRequestBuilders.get( URI).accept( MediaType.APPLICATION_JSON);
	 * 
	 * MvcResult result = mockMvc.perform(requestBuilder).andReturn();
	 * 
	 * String expectedJson = this.mapToJson(UserList); String outputInJson =
	 * result.getResponse().getContentAsString();
	 * assertThat(outputInJson).isEqualTo(expectedJson);
	 * 
	 * 
	 * }
	 */
	
	
	
	
	
	
	
	
	
	
	

	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}

}
