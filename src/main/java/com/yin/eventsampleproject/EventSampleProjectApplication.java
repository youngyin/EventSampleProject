package com.yin.eventsampleproject;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class EventSampleProjectApplication implements CommandLineRunner {

    @Autowired
    private final CustomEventPublisher customEventPublisher;

    public static void main(String[] args) {
        SpringApplication.run(EventSampleProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        customEventPublisher.publishEvent("Hello, Event!");
    }
}
