package com.yin.eventsampleproject;

import com.yin.eventsampleproject.event.FirstEvent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DisplayName("Custom Event Tests")
class CustomEventTest {

    @Autowired
    private CustomEventPublisher eventPublisher;

    @Autowired
    private CustomEventListener customEventListener;

    @Test
    @DisplayName("CustomEvent가 정상적으로 발행되고 리스너에서 처리되는지 테스트")
    void testCustomEventPublishing() {
        // Given
        String testMessage = "Test Message";
        FirstEvent firstEvent = new FirstEvent(this, testMessage);

        // When
        eventPublisher.publishEvent(firstEvent);

        // Then
        assertThat(customEventListener.getMessage())
                .as("Event listener should receive the exact message")
                .isEqualTo(testMessage);
    }
}