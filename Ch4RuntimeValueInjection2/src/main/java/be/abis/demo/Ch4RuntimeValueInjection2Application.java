package be.abis.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:my.properties")
public class Ch4RuntimeValueInjection2Application {

    public static void main(String[] args) {
        SpringApplication.run(Ch4RuntimeValueInjection2Application.class, args);
    }

}
