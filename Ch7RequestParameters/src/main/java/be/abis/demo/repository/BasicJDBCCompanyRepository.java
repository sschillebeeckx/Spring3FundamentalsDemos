package be.abis.demo.repository;

import be.abis.demo.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@Qualifier("basic")
public class BasicJDBCCompanyRepository implements CompanyRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void createCompanyTableCopy() {
        jdbcTemplate.execute("create table companies2 as select * from companies");
    }

    public void dropCompanyTableCopy() {
        jdbcTemplate.execute("drop table companies2");
    }

    public List<Company> getCompanies() {
        return jdbcTemplate
                .query("select * from companies2", new CompanyRowMapper());
    }

    public List<Company> getCompaniesForCountry(String country) {
        return jdbcTemplate.query("select  * from companies2 where rtrim(cocountr)=?", new CompanyRowMapper(),country);
    }

    public Company getCompany(int id) {
        return jdbcTemplate.queryForObject("select * from companies2 where cono=?", new CompanyRowMapper(),id);
    }

    public void insertCompany(Company c) {
        jdbcTemplate.update("insert into companies2 (cono,coname,costreet,costrno,cotown,cotownno,cocountr) values (?,?,?,?,?,?,?)",
        c.getCompanyNumber(),c.getName(),c.getStreet(),c.getNumber(),
                c.getTown(), c.getZipCode(),c.getCountry());
    }

    public void updateCompany(Company c) {
        jdbcTemplate.update("update companies2 set coname=?, costreet=?, costrno=?, " +
                        "cotown=?, cotownno=?, cocountr=? where cono=?",
        c.getName(), c.getStreet(), c.getNumber(), c.getTown(), c.getZipCode(),
                c.getCountry(),c.getCompanyNumber());
    }

    public void deleteCompany(int id) {
        jdbcTemplate.update("delete from companies2 where cono=?" ,id);
    }

    private static final class CompanyRowMapper implements RowMapper<Company> {
        public Company mapRow(ResultSet rs, int rownum) throws SQLException {
            return new Company(
                    rs.getInt("cono"),
                    rs.getString("coname"),
                    rs.getString("costreet"),
                    rs.getString("costrno"),
                    rs.getString("cotownno"),
                    rs.getString("cotown"),
                    rs.getString("cocountr"));
        }
    }
}
