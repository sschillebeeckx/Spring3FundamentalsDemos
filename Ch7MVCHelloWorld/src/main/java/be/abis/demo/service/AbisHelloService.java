package be.abis.demo.service;

import be.abis.demo.model.Person;
import org.springframework.stereotype.Component;

@Component
public class AbisHelloService implements HelloService {

    @Override
    public Person findPerson(int id) {
        return new Person("John");
    }

    @Override
    public void sayHelloTo(Person person) {
        System.out.println("Welcome to Spring, " + person.getFirstName());
    }
}
