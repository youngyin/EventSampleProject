package com.yin.eventsampleproject;

import com.yin.eventsampleproject.event.FirstEvent;
import com.yin.eventsampleproject.event.SecondEvent;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@AllArgsConstructor
@EnableScheduling
public class EventSampleProjectApplication implements CommandLineRunner {

    @Autowired
    private final CustomEventPublisher customEventPublisher;

    public static void main(String[] args) {
        SpringApplication.run(EventSampleProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        FirstEvent firstEvent = new FirstEvent(this, "Hello, My First Event!");
        customEventPublisher.publishEvent(firstEvent);

        SecondEvent secondEvent = new SecondEvent(this, "Hello, Second Event!");
        customEventPublisher.publishEvent(secondEvent);
    }
}
