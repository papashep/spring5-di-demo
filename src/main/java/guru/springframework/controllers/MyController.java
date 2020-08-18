package guru.springframework.controllers;

import guru.springframework.services.GreetingService;
import org.springframework.stereotype.Controller;

/**
 * Created by Melvyn on 17/Aug/2020
 */
@Controller
public class MyController {

    private GreetingService greetingService;

    public MyController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String hello(){
        System.out.println("Hello!!! ");

        return greetingService.sayGreeting ();
    }
}
