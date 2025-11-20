package be.abis.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:myconfig.xml")
public class Ch3MixingJavaConfigXmlApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ch3MixingJavaConfigXmlApplication.class, args);
    }

}
