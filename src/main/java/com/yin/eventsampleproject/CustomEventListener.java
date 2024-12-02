package com.yin.eventsampleproject;

import com.yin.eventsampleproject.event.FirstEvent;
import com.yin.eventsampleproject.event.SecondEvent;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Getter
public class CustomEventListener {

    private String message;

    @EventListener(FirstEvent.class)
    public void handleFirstEvent(ApplicationEvent event){
        message = ((FirstEvent)event).getMessage();
        System.out.println("Received first event with message: " + message);
    }

    @EventListener(SecondEvent.class)
    public void handleSecondEvent(ApplicationEvent event){
        message = ((SecondEvent)event).getMessage();
        System.out.println("Received second event with message: " + event);
    }
}
