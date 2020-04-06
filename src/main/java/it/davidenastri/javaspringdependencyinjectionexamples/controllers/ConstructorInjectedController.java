package it.davidenastri.javaspringdependencyinjectionexamples.controllers;

import it.davidenastri.javaspringdependencyinjectionexamples.services.GreetingService;
import org.springframework.stereotype.Controller;

@Controller
public class ConstructorInjectedController {

    private final GreetingService greetingService;

    // Constructors do not longer need @Autowired in Spring
    public ConstructorInjectedController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting() {
        return greetingService.sayGreeting();
    }
}
