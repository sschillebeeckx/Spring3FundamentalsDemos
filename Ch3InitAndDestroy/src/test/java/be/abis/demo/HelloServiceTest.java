package be.abis.demo;

import be.abis.demo.model.Person;
import be.abis.demo.service.HelloService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class HelloServiceTest {

    @Autowired
    HelloService helloService;

    private Person person;

    @BeforeEach
    void init(){ person  = new Person("John");}

    @Test
    void PersonNameIsJohn(){
        assertEquals("John", helloService.findPerson(1).getFirstName());
    }

    @Test
    void sayHelloToJohn(){
        helloService.sayHelloTo(person);
    }

}
