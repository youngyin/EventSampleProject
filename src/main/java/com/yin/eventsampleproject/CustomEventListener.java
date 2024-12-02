package com.yin.eventsampleproject;

import lombok.Getter;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Getter
public class CustomEventListener {

    private String message;

    @EventListener
    public void handleCustomEvent(CustomEvent event){
        message = event.getMessage();
        System.out.println("Received event with message: " + event.getMessage());
    }
}
