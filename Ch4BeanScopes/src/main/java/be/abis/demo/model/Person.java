package be.abis.demo.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Person {
    private String firstName;
    private String coffeePreference;

    public Person(){}
    public Person(String firstName) {this.firstName = firstName;}
    public Person(String firstName, String coffeePreference) {
        this(firstName);
        this.coffeePreference=coffeePreference;
    }

    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName=firstName;}
    public String getCoffeePreference() {return coffeePreference;}
    public void setCoffeePreference(String coffeePreference) {
        this.coffeePreference=coffeePreference;
    }
}
