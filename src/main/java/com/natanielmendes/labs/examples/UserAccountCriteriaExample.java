package com.natanielmendes.labs.examples;

import com.natanielmendes.labs.UserInfoCriteriaBuilder;
import com.natanielmendes.labs.domain.Document;
import com.natanielmendes.labs.domain.Email;
import com.natanielmendes.labs.domain.Login;
import com.natanielmendes.labs.domain.UserEntity;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.sql.DataSource;
import java.text.ParseException;
import java.util.List;

/**
 * Created by nataniel.neto on 12/04/2016.
 */
@Service
public class UserAccountCriteriaExample {
    private static Logger log = Logger.getLogger(CriteriaQueryMaxPeriodExample.class);
    private List<Predicate> predicados;

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private DataSource ds;

    @Transactional
    public void executeExample() throws ParseException {
        populateUserEntity();
        executeUserInfoSearchCriteria();
    }

    private void populateUserEntity() {
        UserEntity user1 = new UserEntity();
        user1.setName("Chuck Norris");
        em.persist(user1);

        UserEntity user2 = new UserEntity();
        user2.setName("Sylvester Stallone");
        em.persist(user2);

        Login login1 = new Login();
        login1.setEntityId(1L);
        login1.setLoginName("chuck");
        em.persist(login1);

        Login login2 = new Login();
        login2.setEntityId(2L);
        login2.setLoginName("sylvester");
        em.persist(login2);

        Email email1 = new Email();
        email1.setEntityId(1L);
        email1.setPrefix("chuck");
        email1.setProvider("superbid.net");
        em.persist(email1);

        Email email2 = new Email();
        email2.setEntityId(2L);
        email2.setPrefix("sylvester");
        email2.setProvider("superbid.net");
        em.persist(email2);

        Document document1 = new Document();
        document1.setEntityId(1L);
        document1.setDocumentNumber("123456");
        em.persist(document1);

        Document document2 = new Document();
        document2.setEntityId(2L);
        document2.setDocumentNumber("654321");
        em.persist(document2);
    }




    private void executeUserInfoSearchCriteria() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<UserEntity> cq = cb.createQuery(UserEntity.class);
        Root<UserEntity> entityRoot = cq.from(UserEntity.class);
        cq.select(entityRoot);

        UserInfoCriteriaBuilder userInfoCriteriaBuilder = new UserInfoCriteriaBuilder(cb, cq, entityRoot, null, null, null, null, "654321", false, true);
        cq.where(cb.and(userInfoCriteriaBuilder.getPredicates()));

        TypedQuery<UserEntity> query = em.createQuery(cq);
        List<UserEntity> result = query.getResultList();

        for (UserEntity entity : result){
            System.out.println(entity);
        }

        System.out.println("\n\n===================================================");
    }
}
