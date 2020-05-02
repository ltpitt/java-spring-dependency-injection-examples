package it.davidenastri.javaspringdependencyinjectionexamples.config;

import it.davidenastri.javaspringdependencyinjectionexamples.examplebeans.FakeDataSource;
import it.davidenastri.javaspringdependencyinjectionexamples.examplebeans.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
// Also possible in a single line: @PropertySource({"classpath:datasource.properties", "classpath:jms.properties"})
@PropertySources({
        @PropertySource("classpath:datasource.properties"),
        @PropertySource("classpath:jms.properties")
})
public class PropertyConfig {

    @Autowired
    Environment env;

    @Value("${javaspringdependencyinjectionexamples.user}")
    String user;

    @Value("${javaspringdependencyinjectionexamples.password}")
    String password;

    @Value("${javaspringdependencyinjectionexamples.dburl}")
    String dburl;

    @Value("${javaspringdependencyinjectionexamples.jms.user}")
    String jmsUser;

    @Value("${javaspringdependencyinjectionexamples.jms.password}")
    String jmsPassword;

    @Value("${javaspringdependencyinjectionexamples.jms.dburl}")
    String jmsDburl;

    @Bean
    public FakeDataSource fakeDataSource() {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUser(env.getProperty("USERNAME"));
        fakeDataSource.setPassword(password);
        fakeDataSource.setDbUrl(dburl);
        return fakeDataSource;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }

    @Bean
    public FakeJmsBroker fakeJmsBroker() {
        FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
        fakeJmsBroker.setUser(jmsUser);
        fakeJmsBroker.setPassword(jmsPassword);
        fakeJmsBroker.setDbUrl(jmsDburl);
        return fakeJmsBroker;
    }

}
