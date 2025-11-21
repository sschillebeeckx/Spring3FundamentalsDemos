package be.abis.demo.repository;

import be.abis.demo.model.Company;

import java.util.List;

public interface CompanyRepository {

    void createCompanyTableCopy();
    void dropCompanyTableCopy();

    List<Company> getCompanies();
    List<Company> getCompaniesForCountry(String country);

    Company getCompany(int id);
    void insertCompany(Company c);
    void updateCompany(Company c);
    void deleteCompany(int id);

    int getKeyValue();
}
