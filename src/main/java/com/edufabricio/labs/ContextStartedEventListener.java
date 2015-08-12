package com.edufabricio.labs;

import com.edufabricio.labs.examples.CriteriaQueryMaxPeriodExample;
import com.edufabricio.labs.examples.MultipleJoinBuilderExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class ContextStartedEventListener implements
        ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private MultipleJoinBuilderExample multipleJoinBuilderExample;

    @Autowired
    private CriteriaQueryMaxPeriodExample criteriaQueryMaxPeriodExample;

    private static final Logger log = LoggerFactory.getLogger(ContextStartedEventListener.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info(" ContextStartedEventListener received "
                + event.getClass() + "\n at "
                + event.getTimestamp() + "\n with Source as "
                + event.getSource().getClass() + "\n for application context "
                + event.getApplicationContext().getClass());

        try {

            //multipleJoinBuilderExample.executeExample();
            criteriaQueryMaxPeriodExample.executeExample();

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }


}