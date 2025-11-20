package be.abis.demo;

import be.abis.demo.model.Person;
import be.abis.demo.service.ReceptionService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@SpringBootTest
class ReceptionServiceTest {

    static ReceptionService receptionService;
    private Person person;

    @BeforeAll
    public static void retrieveBean(){
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Ch3FullJavaConfigApplication.class);
        receptionService = (ReceptionService) context.getBean("receptionService");
    }

    @BeforeEach
    void init(){ person  = new Person("John","black");}

    @Test
    void personNameIsJohn(){
        assertEquals("John",
                receptionService.getHelloService().findPerson(1).getFirstName());
    }

    @Test
    void welcomeJohn(){
        receptionService.welcomePersonAndGetCoffee(person);
    }

}
