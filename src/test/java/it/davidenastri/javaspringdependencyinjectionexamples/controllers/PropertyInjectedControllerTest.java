package it.davidenastri.javaspringdependencyinjectionexamples.controllers;

import it.davidenastri.javaspringdependencyinjectionexamples.services.GreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Controller;

import static org.junit.jupiter.api.Assertions.*;

class PropertyInjectedControllerTest {
    // Least preferred method to perform Dependency Injection in Spring
    PropertyInjectedController controller;

    @BeforeEach
    void setUp() {
        controller = new PropertyInjectedController();
        controller.greetingService = new GreetingServiceImpl();
    }

    @Test
    void getGreeting() {
        System.out.println(controller.getGreeting());
    }
}