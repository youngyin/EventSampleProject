package com.yin.eventsampleproject.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;

@Getter
public class FirstEvent extends ApplicationEvent {
    private final String message;
    private final LocalDateTime createdAt;

    public FirstEvent(Object source, String message) {
        super(source);
        this.message = message;
        this.createdAt = LocalDateTime.now();
    }
}
