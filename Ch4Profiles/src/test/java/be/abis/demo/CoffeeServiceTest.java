package be.abis.demo;

import be.abis.demo.model.Person;
import be.abis.demo.service.CoffeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
class CoffeeServiceTest {

    @Autowired
    CoffeeService coffeeService;

    private Person person;

    @BeforeEach
    void init(){ person  = new Person("John","black");}

    @Test
    void serveBlackCoffeeToJohn(){
        assertEquals("black with extra milk",coffeeService.serveCoffeeToVisitor(person).getFlavour());
    }

}
