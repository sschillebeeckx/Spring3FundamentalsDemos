package be.abis.demo;

import be.abis.demo.exception.PersonNotWelcomeException;
import be.abis.demo.model.Person;
import be.abis.demo.service.ReceptionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class ReceptionServiceTest {

    @Autowired
    ReceptionService receptionService;

    private Person person;

    @BeforeEach
    void init(){ person  = new Person("John","black");}

    @Test
    void personNameIsJohn(){
        assertEquals("John",
                receptionService.getHelloService().findPerson(1).getFirstName());
    }

    @Test
    void welcomeJohn() throws PersonNotWelcomeException {
        receptionService.welcomePersonAndGetCoffee(person);
    }

    @Test
    void welcomeMrBeanException(){
       Person person2 = new Person("Mr. Bean","none");
       assertThrows(PersonNotWelcomeException.class, ()-> receptionService.welcomePersonAndGetCoffee(person2) ) ;
    }

}
