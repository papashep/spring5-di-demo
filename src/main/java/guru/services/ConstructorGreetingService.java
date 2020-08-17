package guru.services;

import org.springframework.stereotype.Service;

/**
 * Created by Melvyn on 17/Aug/2020
 */
@Service
public class ConstructorGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello - I was injected via the constructor!!!";
    }
}
