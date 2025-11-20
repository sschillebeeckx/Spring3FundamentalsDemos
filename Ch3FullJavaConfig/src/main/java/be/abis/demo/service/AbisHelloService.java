package be.abis.demo.service;

import be.abis.demo.model.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class AbisHelloService implements HelloService {

    private String helloMessage;

    public String getHelloMessage() {
        return helloMessage;
    }

    public void setHelloMessage(String helloMessage) {
        this.helloMessage = helloMessage;
    }

    @Override
    public Person findPerson(int id) {
        return new Person("John");
    }

    @Override
    public void sayHelloTo(Person person) {
        System.out.println(helloMessage + ", " + person.getFirstName() +".");
    }
}
