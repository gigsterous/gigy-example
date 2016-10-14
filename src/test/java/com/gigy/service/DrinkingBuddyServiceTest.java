package com.gigy.service;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.gigy.model.Person;
import com.gigy.repository.PersonRepository;

public class DrinkingBuddyServiceTest {
	
	private PersonRepository repository;
	private DrinkingBuddyService service;
	
	@Before
	public void prepare() {
		repository = mock(PersonRepository.class);
		service = new DrinkingBuddyService(repository);
	}
	
	@Test
	public void findBuddyTest() {
	    List<Person> people = new ArrayList<Person>();
	    
	    Person p1 = new Person();
	    p1.setId(1l);
	    p1.setName("John");
	    p1.setAge(25);
	    people.add(p1);
	    
	    Person p2 = new Person();
	    p2.setId(2l);
	    p2.setName("Marry");
	    p2.setAge(22);
	    people.add(p2);
	    
	    Person p3 = new Person();
	    p3.setId(1l);
	    p3.setName("Peter");
	    p3.setAge(35);
	    people.add(p3);
	    
	    when(repository.findAll()).thenReturn(people);
	    
	    assertEquals(service.findBuddy(p1), p2);
	}

}
