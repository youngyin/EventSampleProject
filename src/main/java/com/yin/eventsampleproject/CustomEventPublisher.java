package com.yin.eventsampleproject;

import com.yin.eventsampleproject.event.FirstEvent;
import com.yin.eventsampleproject.event.SecondEvent;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class CustomEventPublisher {

    @Autowired
    private final ApplicationEventPublisher eventPublisher;

    public void publishEvent(ApplicationEvent event) {
        if (event instanceof FirstEvent) {
            publishFirstEvent((FirstEvent) event);
        } else if (event instanceof SecondEvent) {
            publishSecondEvent((SecondEvent) event);
        } else {
            throw new RuntimeException("지원하지 않는 이벤트입니다.");
        }
    }

    private void publishFirstEvent(FirstEvent event){
        System.out.println("Publishing first event with message: " + event.getMessage());
        eventPublisher.publishEvent(event);
    }

    private void publishSecondEvent(SecondEvent event){
        System.out.println("Publishing second event with message: " + event.getMessage());
        eventPublisher.publishEvent(event);
    }

}
