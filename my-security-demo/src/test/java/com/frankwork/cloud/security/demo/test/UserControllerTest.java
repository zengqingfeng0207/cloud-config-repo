package com.frankwork.cloud.security.demo.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.MockMvcConfigurerAdapter;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void whenQueryUserPage() throws Exception {
		String rsul = mockMvc
				.perform(MockMvcRequestBuilders.get("/users").contentType(MediaType.APPLICATION_JSON_UTF8)
						.param("username", "frank").param("age", "16").param("ageTo", "60").param("xxx", "yyy")
						.param("size", "5").param("page", "2").param("sort", "age,desc"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0]['username']").value("frank"))

				.andReturn().getResponse().getContentAsString();
		System.out.println(rsul);
	}

	@Test
	public void whenQueryUser() throws Exception {
		String str = mockMvc.perform(MockMvcRequestBuilders.get("/user").contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3)).andReturn().getResponse()
				.getContentAsString();
		System.out.println(str);
	}

	@Test
	public void whenQueryUserByIdSuccess() throws Exception {
		String str = mockMvc.perform(MockMvcRequestBuilders.get("/user/1").contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.username").value("frank")).andReturn().getResponse()
				.getContentAsString();
		System.out.println(str);
	}

	@Test
	public void whenCreateUser() throws Exception {
		Date date = new Date();
		System.out.println(date.getTime());
		
		String content = "{\"username\":\"frank\",\"password\":\"12345\"}";
		String reuslt = mockMvc.perform(post("/user").contentType(MediaType.APPLICATION_JSON_UTF8).content(content))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"))
				.andReturn().getResponse().getContentAsString();
		System.out.println(reuslt); 
	}
	@Test
	public void whenDeleteUser( ) throws Exception{
		mockMvc.perform(delete("/user/1").contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
