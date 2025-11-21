package be.abis.demo;

import be.abis.demo.model.Company;
import be.abis.demo.repository.CompanyRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.jdbc.JdbcTestUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CompanyRepositoryTest {

    @Autowired @Qualifier("basic") CompanyRepository companyRepository;

    @Autowired JdbcTemplate jdbcTemplate;

    Company newCompany;

    @BeforeEach
    public void init(){
        newCompany=new Company(123,"new comp","some street","10","1234AB","UTRECHT","NL");
    }

    @Test
    @Order(1)
    public void createTable() {
        companyRepository.createCompanyTableCopy();
    }

    @Test
    @Order(2)
    public void nrOfCompaniesIs24() {
        assertEquals(24,companyRepository.getCompanies().size());
    }

    @Test
    @Order(3)
    public void company3IsAbis() {
        assertEquals("ABIS N.V.",companyRepository.getCompany(3).getName().trim());
    }

    @Test
    @Order(4)
    public void insertingNewCourseWorks() {
        int linesBefore = JdbcTestUtils.countRowsInTable(jdbcTemplate,"companies2");
        companyRepository.insertCompany(newCompany);
        int linesAfter = JdbcTestUtils.countRowsInTable(jdbcTemplate,"companies2");
        assertEquals(1,linesAfter-linesBefore);
        System.out.println(companyRepository.getCompany(123));
    }

    @Test
    @Order(5)
    public void updateNewCourseWorks() {
        Company comp123 =companyRepository.getCompany(123);
        comp123.setName("Better Name");
        companyRepository.updateCompany(comp123);
        assertEquals("Better Name",companyRepository.getCompany(123).getName().trim());
    }

    @Test
    @Order(6)
    public void deleteNewCourseWorks() {
        int linesBefore = JdbcTestUtils.countRowsInTable(jdbcTemplate,"companies2");
        companyRepository.deleteCompany(123);
        int linesAfter = JdbcTestUtils.countRowsInTable(jdbcTemplate,"companies2");
        assertEquals(-1,linesAfter-linesBefore);
    }

    @Test
    @Order(7)
    public void dropTable() {
        companyRepository.dropCompanyTableCopy();
    }

}
