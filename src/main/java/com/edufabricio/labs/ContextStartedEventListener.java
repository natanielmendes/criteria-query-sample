package com.edufabricio.labs;

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
    private MockDataBaseService databaseService;

    private static final Logger log = LoggerFactory.getLogger(ContextStartedEventListener.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info(" ContextStartedEventListener received "
                + event.getClass() + "\n at "
                + event.getTimestamp() + "\n with Source as "
                + event.getSource().getClass() + "\n for application context "
                + event.getApplicationContext().getClass());

        try {

            databaseService.populateDataBaseForTest();

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }


}