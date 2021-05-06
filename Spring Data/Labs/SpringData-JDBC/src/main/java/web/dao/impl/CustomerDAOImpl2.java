package web.dao.impl;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import web.dao.CustomerDAO;
import web.model.Customer;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerDAOImpl2 implements CustomerDAO {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private SimpleJdbcInsert jdbcInsert;

    public void setDataSource(DataSource dataSource) {
        // use named parameter
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

        jdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("customer")
                .usingColumns("name", "age")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public int countCustomers() {
        String query = "select count(*) from customer";
        Map<String, Object> args = new HashMap<>();
        int rowCount = namedParameterJdbcTemplate.queryForObject(query, args, Integer.class);

        return rowCount;
    }

    @Override
    public int insertCustomer(Customer customer) {
        String insertQuery = "insert into customer (name, age) values(:name,:age)";
        Map<String, Object> args = new HashMap<>();
//        args.put("id", customer.getId());
        args.put("name", customer.getName());
        args.put("age", customer.getAge());

        int insertResult = namedParameterJdbcTemplate.update(insertQuery, args);

        return insertResult;
    }

    // using SimpleJdbcInsert
    @Override
    public int insertCustomerByJdbcInsert(Customer customer) {
        Map<String, Object> args = new HashMap<>();
//        args.put("id", customer.getId());
        args.put("name", customer.getName());
        args.put("age", customer.getAge());

        int insertResult = jdbcInsert.execute(args);

        return insertResult;
    }

    // using SqlParameterSource instead of Map<String, Object>
    @Override
    public int insertCustomerByBeanSqlParameter(Customer customer) {

        SqlParameterSource parameters = new BeanPropertySqlParameterSource(customer);

        int insertResult = jdbcInsert.execute(parameters);

        return insertResult;
    }

    // using MapSqlParameterSource instead of Map<String, Object>
    @Override
    public int insertCustomerByMapSqlParameter(Customer customer) {

        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("name", customer.getName())
                .addValue("age", customer.getAge());

        int insertResult = jdbcInsert.execute(parameters);

        return insertResult;
    }




    @Override
    public int countByAgeGreaterThan(int age) {
        return 0;
    }

    @Override
    public Customer getCustomerById(int id) {
        return null;
    }

    @Override
    public List<Customer> findAllCustomers() {
        return null;
    }



    @Override
    public int updateCustomer(int id, Customer customer) {
        return 0;
    }

    @Override
    public int deleteCustomer(int id) {
        return 0;
    }

    @Override
    public void createTable() {
    }
}
