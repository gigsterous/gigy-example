package com.gigy.controller;

import org.junit.Before;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.*;

import com.gigy.model.Party;
import com.gigy.repository.PartyRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(PartyController.class)
public class PartyControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private PartyRepository partyRepo;
	
	private Party party;
	
	@Before
	public void prepare() {
		party = new Party();
		party.setId(1l);
		party.setLocation("Garden");
	}

	@Test
	public void getPartyTest() throws Exception {
		given(partyRepo.findOne(1l)).willReturn(party);
		mvc.perform(get("/parties/1").accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(1)))
				.andExpect(jsonPath("$.location", is("Garden")));
	}
	
	@Test
	public void partyNotFoundTest() throws Exception {
		mvc.perform(get("/parties/2").accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isNotFound());
	}
	
	@Test
	public void getPartiesTest() throws Exception {
		List<Party> parties = new ArrayList<Party>();
		parties.add(party);
		
		given(partyRepo.findAll()).willReturn(parties);
		mvc.perform(get("/parties").accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].id", is(1)))
				.andExpect(jsonPath("$[0].location", is("Garden")));
	}

}
