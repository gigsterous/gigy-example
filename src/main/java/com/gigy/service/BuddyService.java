package com.gigy.service;

import com.gigy.model.Person;
import com.gigy.repository.PersonRepository;

public interface BuddyService {
	
	public Person findBuddy(PersonRepository repository, Person person);

}
