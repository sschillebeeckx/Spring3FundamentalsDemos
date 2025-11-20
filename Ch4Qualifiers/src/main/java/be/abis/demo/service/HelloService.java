package be.abis.demo.service;

import be.abis.demo.model.Person;

public interface HelloService {

    Person findPerson(int id);
    void sayHelloTo(Person person);
}
