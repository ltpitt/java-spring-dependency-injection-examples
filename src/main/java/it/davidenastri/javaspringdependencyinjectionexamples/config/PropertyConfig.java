package it.davidenastri.javaspringdependencyinjectionexamples.config;

import it.davidenastri.javaspringdependencyinjectionexamples.examplebeans.FakeDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:datasource.properties")
public class PropertyConfig {

    @Value("${javaspringdependencyinjectionexamples.user}")
    String user;

    @Value("${javaspringdependencyinjectionexamples.password}")
    String password;

    @Value("${javaspringdependencyinjectionexamples.dburl}")
    String dburl;

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }

    @Bean
    public FakeDataSource fakeDataSource() {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUser(user);
        fakeDataSource.setPassword(password);
        fakeDataSource.setDbUrl(dburl);
        return fakeDataSource;
    }

}