package com.petclinic.practice;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class GreetingServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(GreetingServiceTest.class);

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private GreetingService greetingService;

    @Test
    void shouldGreetSuccessfully() {
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
        logger.info("All beans in the application context:");
        for (String beanName : beanNames) {
            logger.info(beanName);
        }
    }
}