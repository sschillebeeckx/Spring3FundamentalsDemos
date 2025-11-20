package be.abis.demo.model;

public class Person {
    private String firstName;
    private String coffeePreference;

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
