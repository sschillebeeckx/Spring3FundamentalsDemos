package be.abis.demo.model;

public class Company {
    private int companyNumber;
    private String name;
    private String street;
    private String number;
    private String zipCode;
    private String town;
    private String country;

    public Company(String name, String country) {
        this.name=name;  this.country=country;
    }

    public Company(int companyNumber, String name, String street, String number,
                   String zipCode, String town,String country) {
        this(name,country);
        this.companyNumber=companyNumber;
        this.street=street; this.number=number;
        this.zipCode=zipCode;  this.town=town;
    }

    public int getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(int companyNumber) {
        this.companyNumber = companyNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // getters and setters
    public String toString() {
        return "Company [companyNumber="  + companyNumber  + ", name="  + name
                + ", street=" + street + ", number=" + number  +", zipCode=" + zipCode
                +", town=" + town +   ", country=" + country + "]";
    }
}
