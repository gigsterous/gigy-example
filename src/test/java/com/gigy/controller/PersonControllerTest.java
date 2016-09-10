package com.gigy.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.gigy.model.Person;
import com.gigy.repository.PersonRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(PersonController.class)
public class PersonControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private PersonRepository personRepo;

	@Test
	public void getPersonTest() throws Exception {
		Person person = new Person();
		person.setName("John");
		person.setAge(25);

		given(personRepo.findOne(1l)).willReturn(person);
		mvc.perform(get("/people/1")
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json("{'name':'John', 'age':25}"));
	}

}
