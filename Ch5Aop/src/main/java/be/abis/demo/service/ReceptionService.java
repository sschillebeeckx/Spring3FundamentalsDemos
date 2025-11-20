package be.abis.demo.service;

import be.abis.demo.exception.PersonNotWelcomeException;
import be.abis.demo.model.Person;

public interface ReceptionService {
    HelloService getHelloService();
    void welcomePersonAndGetCoffee(Person person) throws PersonNotWelcomeException;
}
