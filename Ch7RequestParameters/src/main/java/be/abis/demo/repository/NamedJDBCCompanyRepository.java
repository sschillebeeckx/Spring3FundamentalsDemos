package be.abis.demo.repository;

import be.abis.demo.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Qualifier("named")
public class NamedJDBCCompanyRepository implements CompanyRepository{

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void createCompanyTableCopy() {
        //via DB view
    }

    @Override
    public void dropCompanyTableCopy() {
        //via DB view
    }

    public List<Company> getCompanies() {
         return jdbcTemplate.query("select * from companies2",new CompanyRowMapper());
     }

     public List<Company> getCompaniesForCountry(String country) {
         Map<String,String> params = new HashMap<>();
         params.put("country",country);
         return jdbcTemplate.query("select * from companies2 where rtrim(cocountr)=:country"
                        ,params,new CompanyRowMapper());
     }

     public Company getCompany(int id) {
          Map<String,Integer> params = new HashMap<>();
          params.put("id",id);
         return jdbcTemplate.queryForObject("select  * from companies2 where cono=:id", params, new CompanyRowMapper());
            }

    public void insertCompany(Company c) {
       Map<String,String> params = this.setParams(c);
       jdbcTemplate.update("insert into companies2 (cono,coname,costreet,costrno,cotown,cotownno,cocountr) "+
                "values (:cono,:coname,:costreet,:costrno,:cotown,:zip,:country)", params);
    }

    public void updateCompany(Company c) {
          Map<String,String> params = this.setParams(c);
          jdbcTemplate.update("update companies2 set coname=:coname, costreet=:costreet, costrno=:costrno, cotown=:cotown, cotownno=:zip, cocountr=:country where cono=:cono" ,params);
   }

   public void deleteCompany(int id) {
      Map<String,Integer> params = new HashMap<>();
      params.put("id",id);
      jdbcTemplate.update("delete from companies2 where cono=:id", params);
   }

   private static final class CompanyRowMapper implements RowMapper<Company> {
      @Override
      public Company mapRow(ResultSet rs, int rownum) throws SQLException {
          Company company = new Company(rs.getInt("cono"),
                  rs.getString("coname"),
                  rs.getString("costreet"),
                  rs.getString("costrno"),
                  rs.getString("cotownno"),
                  rs.getString("cotown"),
                  rs.getString("cocountr"));
          return company;
          }
      }

      public Map<String,String> setParams(Company c) {
                Map<String,String> params=new HashMap<>();
                params.put("cono" ,c.getCompanyNumber() + "");
                params.put("coname" ,c.getName());
                params.put("costreet", c.getStreet());
                params.put("costrno" ,c.getNumber());
                params.put("cotown", c.getTown());
                params.put("zip", c.getZipCode());
                params.put("country", c.getCountry());
                return params;
      }

}
