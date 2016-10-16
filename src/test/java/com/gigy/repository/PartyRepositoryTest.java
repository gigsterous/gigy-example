package com.gigy.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gigy.model.Party;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@DataJpaTest
public class PartyRepositoryTest {

    @Autowired
    private PartyRepository repository;

    @Test
    public void repositorySavesParty() {
        Party party = new Party();
        party.setLocation("Garden");
        
        Party result = repository.save(party);
        
        assertEquals(result.getLocation(), "Garden");
    }

}
