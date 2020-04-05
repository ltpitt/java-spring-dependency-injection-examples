package it.davidenastri.javaspringdependencyinjectionexamples.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class MyController {
    public String sayHello() {
        String greeting = "Hello World";
        System.out.println("From controller: " + greeting);
        return greeting;
    }
}
