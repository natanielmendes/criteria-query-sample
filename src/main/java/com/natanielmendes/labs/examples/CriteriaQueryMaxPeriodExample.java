package com.natanielmendes.labs.examples;

import com.natanielmendes.labs.domain.Order;
import com.natanielmendes.labs.domain.Order_;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.sql.DataSource;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

@Service
public class CriteriaQueryMaxPeriodExample {

    private static Logger log = Logger.getLogger(CriteriaQueryMaxPeriodExample.class);

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private DataSource ds;

    @Transactional
    public void executeExample() throws ParseException {

        populateOrders();

        executeCriteriaQueryAllOrders();
        executeCriteriaQueryByPeriodWithLiteral();
        executeCriteriaQueryByPeriodWithIntegerField();

    }

    private void populateOrders() {

        Calendar dateOrder = Calendar.getInstance();

        Order order1 = new Order();
        order1.setId(1L);
        order1.setValue(new BigDecimal(100.0));
        order1.setCreatedAt(dateOrder.getTime());
        order1.setHoursMax(24);
        em.persist(order1);

        Order order2 = new Order();
        order2.setId(2L);
        order2.setValue(new BigDecimal(101.0));
        order2.setCreatedAt(dateOrder.getTime());
        order1.setHoursMax(24);
        em.persist(order2);

        dateOrder.add(Calendar.DAY_OF_MONTH, - 2);

        Order order3 = new Order();
        order3.setId(3L);
        order3.setValue(new BigDecimal(102.0));
        order3.setCreatedAt(dateOrder.getTime());
        order1.setHoursMax(24);
        em.persist(order3);
    }




    private void executeCriteriaQueryAllOrders() {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Order> cq = cb.createQuery(Order.class);
        Root<Order> orderRoot = cq.from(Order.class);
        cq.select(orderRoot);

        TypedQuery<Order> query = em.createQuery(cq);
        List<Order> result = query.getResultList();


        System.out.println("\n========= executeCriteriaQueryAllOrders =========\n\n");

        for(Order order: result){
            System.out.println(order);
        }

        System.out.println("\n\n===================================================");


    }


    private void executeCriteriaQueryByPeriodWithLiteral() {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Order> cq = cb.createQuery(Order.class);
        Root<Order> orderRoot = cq.from(Order.class);

        Calendar c = Calendar.getInstance();
        c.add(Calendar.HOUR_OF_DAY, -24);

        cq.select(orderRoot).where(
            cb.greaterThan(orderRoot.get(Order_.createdAt) ,c.getTime())
        );

        TypedQuery<Order> query = em.createQuery(cq);
        List<Order> result = query.getResultList();

        System.out.println("\n========= executeCriteriaQueryByPeriodWithLiteral =========\n\n");

        for(Order order: result){
            System.out.println(order);
        }

        System.out.println("\n\n===================================================");


    }

    private void executeCriteriaQueryByPeriodWithIntegerField() {


        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Order> cq = cb.createQuery(Order.class);
        Root<Order> orderRoot = cq.from(Order.class);

        cq.select(orderRoot).where(
                cb.greaterThan(orderRoot.get(Order_.createdAt) , orderRoot.get(Order_.createSinceLimitHours))
        );

        TypedQuery<Order> query = em.createQuery(cq);
        List<Order> result = query.getResultList();

        System.out.println("\n========= executeCriteriaQueryByPeriodWithIntegerField =========\n\n");

        for(Order order: result){
            System.out.println(order);
        }

        System.out.println("\n\n===================================================");


    }







}
