package be.abis.demo.service;

import be.abis.demo.model.Coffee;
import be.abis.demo.model.Person;


public class AbisReceptionService implements ReceptionService {

    private HelloService helloService;
    private CoffeeService coffeeservice;

    public AbisReceptionService(HelloService helloService){
        this.helloService=helloService;
    }

    public HelloService getHelloService() {return helloService; }
    public void setHelloService(HelloService helloService) {
        this.helloService=helloService;
    }

    public CoffeeService getCoffeeservice() {
        return coffeeservice;
    }

    public void setCoffeeservice(CoffeeService coffeeservice) {
        this.coffeeservice = coffeeservice;
    }

    public void welcomePersonAndGetCoffee(Person person) {
        helloService.sayHelloTo(person);
        Coffee coffee= coffeeservice.serveCoffeeToVisitor(person);
        System.out.println("Here is your "  + coffee.getFlavour() + " coffee.");
    }
}
