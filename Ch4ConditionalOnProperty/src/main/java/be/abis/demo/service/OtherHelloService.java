package be.abis.demo.service;

import be.abis.demo.model.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name="hello.company", havingValue="other")
public class OtherHelloService implements HelloService{
    private String helloMessage;
    public String getHelloMessage() {
        return helloMessage;
    }
    @Value("Welcome at our company")
    public void setHelloMessage(String helloMessage) {
        this.helloMessage = helloMessage;
    }

    @Override
    public Person findPerson(int id) {
        return new Person("Anne");
    }

    @Override
    public void sayHelloTo(Person person) {
        System.out.println("Hello " + person.getFirstName());
    }

}
