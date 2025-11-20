package be.abis.demo;

import be.abis.demo.service.AbisHelloService;
import be.abis.demo.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecondConfig {
    @Bean
    public HelloService helloService() {
        AbisHelloService ahs = new AbisHelloService();
        ahs.setHelloMessage("Welcome to Abis");
        return ahs;
    }
}
