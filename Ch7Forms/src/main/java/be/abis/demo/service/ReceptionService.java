package be.abis.demo.service;

import be.abis.demo.model.Company;
import be.abis.demo.model.Person;
import be.abis.demo.repository.CompanyRepository;

import java.util.List;

public interface ReceptionService {
    HelloService getHelloService();
    void welcomePersonAndGetCoffee(Person person);
    List<Company> getCompaniesForCountry(String country);
    CompanyRepository getCompanyRepository();
}
