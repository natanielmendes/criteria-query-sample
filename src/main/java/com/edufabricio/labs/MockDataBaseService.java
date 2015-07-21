package com.edufabricio.labs;

import com.edufabricio.labs.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.sql.DataSource;
import java.text.ParseException;
import java.util.List;

@Service
public class MockDataBaseService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private DataSource ds;

    @Transactional
    public void populateDataBaseForTest() throws ParseException {
        populateAccounts();
        executeCriteriaQueryWrongMultiplesJoins();
        executeCriteriaQueryWithBuilder();
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


    private void executeCriteriaQueryWrongMultiplesJoins() {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Account> cq = cb.createQuery(Account.class);

        Root<Account> accountRoot = cq.from(Account.class);
        Join<Account,Person> person = accountRoot.join(Account_.person);
        Join<Person,Address> personAddress = person.join(Person_.address);

        cq.select(accountRoot).where(
                cb.and(
                        cb.equal(accountRoot.join(Account_.person).get(Person_.name),"Roger"),
                        cb.greaterThan(accountRoot.join(Account_.person).get(Person_.age),18),
                        cb.equal(accountRoot.join(Account_.person)
                                .join(Person_.address).get(Address_.country),"United States")
                )
        );

        TypedQuery<Account> query = em.createQuery(cq);
        List<Account> result = query.getResultList();

    }

    private void executeCriteriaQueryWithBuilder() {

        AccountCriteriaBuilder criteriaBuilder = new AccountCriteriaBuilder(em.getCriteriaBuilder());
        TypedQuery<Account> query = em.createQuery(criteriaBuilder.buildQuery());
        List<Account> result = query.getResultList();

    }





}
