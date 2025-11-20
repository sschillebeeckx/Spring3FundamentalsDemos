package be.abis.hellospring.service;

import be.abis.hellospring.model.Person;

public interface HelloService {

    Person findPerson(int id);
    void sayHelloTo(Person person);
}
