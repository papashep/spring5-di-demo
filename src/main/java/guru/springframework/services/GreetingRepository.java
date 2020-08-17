package guru.springframework.services;

/**
 * Created by Melvyn on 17/Aug/2020
 */
public interface GreetingRepository {

    String getEnglishGreeting();

    String getSpanishGreeting();

    String getGermanGreeting();
}
