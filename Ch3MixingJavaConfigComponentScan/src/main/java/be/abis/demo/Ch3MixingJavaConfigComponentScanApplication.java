package be.abis.demo;

import be.abis.demo.service.AbisCoffeeService;
import be.abis.demo.service.CoffeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ch3MixingJavaConfigComponentScanApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ch3MixingJavaConfigComponentScanApplication.class, args);
    }

    @Bean(initMethod="init", destroyMethod="destroy")
    public CoffeeService coffeeService(){
        return new AbisCoffeeService();
    }
}
