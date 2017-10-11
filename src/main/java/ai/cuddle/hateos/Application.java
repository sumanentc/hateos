package ai.cuddle.hateos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by suman.das on 10/9/17.
 */
@SpringBootApplication
@ComponentScan("ai.cuddle.hateos.*")
@PropertySource("classpath:application.properties")
@Configuration
@EnableAutoConfiguration()
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
