package com.petclinic.practice;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GreetingServiceTest {

    @Test
    void shouldGreetSuccessfully() {
        var greetingService = new GreetingService();

        String message = greetingService.sayHi();
        
        assertThat(message).isEqualTo("Hello John");
    }
}