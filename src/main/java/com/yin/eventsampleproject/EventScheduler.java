package com.yin.eventsampleproject;

import com.yin.eventsampleproject.event.FirstEvent;
import com.yin.eventsampleproject.event.SecondEvent;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EventScheduler {
    private final CustomEventPublisher customEventPublisher;

    private int executionCountFirstEvent = 0;
    private int executionCountSecondEvent = 0;

    @Autowired
    public EventScheduler(CustomEventPublisher customEventPublisher) {
        this.customEventPublisher = customEventPublisher;
    }

    @Scheduled(fixedRate = 1000) // 1초마다 실행
    public void publishEvents01() {
        if (executionCountFirstEvent < 3) { // 3번 실행 제한
            FirstEvent firstEvent = new FirstEvent(this, "Hello, My First Event!");
            customEventPublisher.publishEvent(firstEvent);
            executionCountFirstEvent++;
        } else {
            //System.out.println("Event publishing completed.");
        }
    }

    @Scheduled(fixedRate = 2000) // 2초마다 실행
    public void publishEvents02() {
        if (executionCountSecondEvent < 2) { // 2번 실행 제한
            SecondEvent secondEvent = new SecondEvent(this, "Hello, Second Event!");
            customEventPublisher.publishEvent(secondEvent);
            executionCountSecondEvent++;
        } else {
            //System.out.println("Event publishing completed.");
        }
    }
}
