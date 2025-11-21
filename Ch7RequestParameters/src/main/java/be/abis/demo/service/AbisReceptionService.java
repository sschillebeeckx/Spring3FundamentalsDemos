package be.abis.demo.service;

import be.abis.demo.model.Coffee;
import be.abis.demo.model.Company;
import be.abis.demo.model.Person;
import be.abis.demo.repository.CompanyRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbisReceptionService implements ReceptionService {
    private HelloService helloService;
    @Autowired
    private CoffeeService coffeeservice;

    @Autowired @Qualifier("basic")
    private CompanyRepository companyRepository;

    //@Autowired
    public AbisReceptionService(HelloService helloService){
        this.helloService=helloService;
    }

    @PostConstruct
    public void createCompanyTable(){
        companyRepository.createCompanyTableCopy();
        System.out.println("created table");
    }

    @PreDestroy
    public void dropCompanyTable(){
        companyRepository.dropCompanyTableCopy();
        System.out.println("dropped table");
    }

    public HelloService getHelloService() {return helloService; }
    public void setHelloService(HelloService helloService) {
        this.helloService=helloService;
    }

    public void welcomePersonAndGetCoffee(Person person) {
        helloService.sayHelloTo(person);
        Coffee coffee= coffeeservice.serveCoffeeToVisitor(person);
        System.out.println("Here is your "  + coffee.getFlavour() + " coffee.");
    }

    @Override
    public List<Company> getCompaniesForCountry(String country) {
        return companyRepository.getCompaniesForCountry(country);
    }


}
