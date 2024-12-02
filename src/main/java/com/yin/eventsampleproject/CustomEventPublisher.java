package com.yin.eventsampleproject;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class CustomEventPublisher {

    @Autowired
    private final ApplicationEventPublisher eventPublisher;

    public void publishEvent(String message){
        System.out.println("Publishing event with message: " + message);
        CustomEvent event = new CustomEvent(this, message);
        eventPublisher.publishEvent(event);
    }
}
