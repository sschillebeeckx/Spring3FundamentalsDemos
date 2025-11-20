package be.abis.demo;

import be.abis.demo.model.Person;
import be.abis.demo.service.ReceptionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ScopeTest {
    @Autowired
    private Person person1;
    @Autowired private Person person2;
    @Autowired private ReceptionService rs1;
    @Autowired private ReceptionService rs2;

    @Test
    void person1and2areDifferentObjects(){
        System.out.println("Person 1:"  + person1);
        System.out.println("Person 2:"  + person2);
        assertTrue(person1!=person2);
    }

    @Test
    void receptionServicesAreSameObject(){
        System.out.println("Service 1:"  + rs1);
        System.out.println("Service 2:" +  rs2);
        assertTrue(rs1==rs2);
    }

}
