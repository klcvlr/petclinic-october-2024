package com.petclinic.practice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

class GreetingServiceTest {

    private ApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
         applicationContext = new AnnotationConfigApplicationContext("com.petclinic");
    }

    @Test
    void shouldGreetSuccessfully() {
        var greetingService = applicationContext.getBean(GreetingService.class);

        String message = greetingService.sayHi();
        
        assertThat(message).isEqualTo("Hello John");
    }

    @Test
    void shouldCountBeanDefinitions() {
        assertThat(applicationContext.getBeanDefinitionCount()).isPositive();
    }

    @Test
    void shouldDisplayBeanDefinitions() {
        String[] beanNames = this.applicationContext.getBeanDefinitionNames();
        System.out.println("All beans in the application context:");
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }
}