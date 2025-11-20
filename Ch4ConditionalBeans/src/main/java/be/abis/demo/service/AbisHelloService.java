package be.abis.demo.service;

import be.abis.demo.condition.AbisCondition;
import be.abis.demo.model.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Component
@Conditional(AbisCondition.class)
public class AbisHelloService implements HelloService {

    @Value("Welcome to Abis")
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
