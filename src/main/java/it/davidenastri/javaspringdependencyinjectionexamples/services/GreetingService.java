package it.davidenastri.javaspringdependencyinjectionexamples.services;

import org.springframework.stereotype.Service;

@Service
public interface GreetingService {
    String sayGreeting();
}
