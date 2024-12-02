package com.yin.eventsampleproject;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CustomEventListener {

    @EventListener
    public void handleCustomEvent(CustomEvent event){
        System.out.println("Received event with message: " + event.getMessage());
    }
}
