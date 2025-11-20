package be.abis.demo.service;

import be.abis.demo.model.Coffee;
import be.abis.demo.model.Person;

public interface CoffeeService {
    Coffee serveCoffeeToVisitor(Person person);
}
