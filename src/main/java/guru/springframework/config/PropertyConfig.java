package guru.springframework.config;

import guru.springframework.examplebeans.FakeDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

/**
 * Created by Melvyn on 19/Aug/2020
 */
@Configuration
@PropertySource ("classpath:datasource.properties")
public class PropertyConfig {

    @Autowired                  // Using Environment properties setup by Intellij in the edit Configuration
    Environment env;            // The Environment Parameters can override the properties parameters

    @Value("${guru.username}")
    String user;

    @Value("${guru.password}")
    String password;

    @Value ("${guru.dburl}")
    String url;

    @Bean
    public FakeDataSource fakeDataSource() {
        FakeDataSource fakeDataSource = new FakeDataSource ();
        fakeDataSource.setUser (env.getProperty ("USERNAME"));
        // fakeDataSource.setUser (user)  // Replaced with the Environment variable
        fakeDataSource.setPassword (password);
        fakeDataSource.setUrl (url);
        return fakeDataSource;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }

}
