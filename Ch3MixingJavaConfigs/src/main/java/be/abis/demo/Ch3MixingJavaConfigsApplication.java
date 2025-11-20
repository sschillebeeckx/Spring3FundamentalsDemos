package be.abis.demo;

import be.abis.demo.service.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(SecondConfig.class)
public class Ch3MixingJavaConfigsApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ch3MixingJavaConfigsApplication.class, args);
    }


    @Bean(initMethod="init", destroyMethod="destroy")
    public CoffeeService coffeeService(){
        return new AbisCoffeeService();
    }

    @Bean
    public ReceptionService receptionService(HelloService helloService){
        ReceptionService rs = new AbisReceptionService(helloService);
        ((AbisReceptionService)rs).setCoffeeservice(coffeeService());
        return rs;
    }
}
