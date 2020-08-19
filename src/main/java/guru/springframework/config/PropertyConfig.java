package guru.springframework.config;

import guru.springframework.examplebeans.FakeDataSource;
import guru.springframework.examplebeans.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Melvyn on 19/Aug/2020
 */
@Configuration
// Using Multiple properties files
//@PropertySource ({"classpath:datasource.properties", "classpath:jms.properties"})
//@PropertySources ({
//        @PropertySource ("classpath:datasource.properties"),
//        @PropertySource ("classpath:jms.properties")
//})

// Now using the default Spring Boot Properties file

public class PropertyConfig {

//    @Autowired                  // Using Environment properties setup by Intellij in the edit Configuration
//    Environment env;            // The Environment Parameters can override the properties parameters

    @Value("${guru.username}")
    String user;

    @Value("${guru.password}")
    String password;

    @Value ("${guru.dburl}")
    String url;

    @Value("${guru.jms.username}")
    String jmsUsername;

    @Value("${guru.jms.password}")
    String jmsPassword;

    @Value ("${guru.jms.url}")
    String jmsUrl;

    @Bean
    public FakeDataSource fakeDataSource() {
        FakeDataSource fakeDataSource = new FakeDataSource ();
//        fakeDataSource.setUser (env.getProperty ("USERNAME"));
        fakeDataSource.setUser (user);
        fakeDataSource.setPassword (password);
        fakeDataSource.setUrl (url);
        return fakeDataSource;
    }

    @Bean
    public FakeJmsBroker fakeJmsBroker() {
        FakeJmsBroker jmsBroker = new FakeJmsBroker ();
        jmsBroker.setUsername (jmsUsername);
        jmsBroker.setPassword (jmsPassword);
        jmsBroker.setUrl (jmsUrl);
        return jmsBroker;
    }

// Now using the Spring Boot default application.properties file
// =============================================================
//    @Bean
//    public static PropertySourcesPlaceholderConfigurer properties() {
//        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
//        return propertySourcesPlaceholderConfigurer;
//    }

}
