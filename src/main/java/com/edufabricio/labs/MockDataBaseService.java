package com.edufabricio.labs;

import com.edufabricio.labs.domain.Account;
import com.edufabricio.labs.domain.Address;
import com.edufabricio.labs.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import java.text.ParseException;

@Service
public class MockDataBaseService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private DataSource ds;

    @Transactional
    public void populateDataBaseForTest() throws ParseException {
        populateAccounts();
    }

    private void populateAccounts() {

        Account account = new Account();
        account.setId(1L);
        account.setType(1);
        em.persist(account);

        Address address = new Address();
        address.setId(1L);
        address.setLocation("New York");
        address.setCountry("United States");
        em.persist(address);

        Person person = new Person();
        person.setId(1L);
        person.setName("Roger");
        person.setAge(19);
        person.setAccount(account);
        person.setAddress(address);

        em.persist(person);


    }

}
