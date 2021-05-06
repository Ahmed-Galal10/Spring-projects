package web.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import web.dao.CustomerDAO;
import web.mapper.CustomerRowMapper;
import web.model.Customer;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;


/* use JdbcDaoSupport class to get instance of jdbcTemplate
   1) get current connection by getConnection();
   2) release connection by calling releaseConnection();
*/
//public class CustomerDAOImpl extends JdbcDaoSupport implements CustomerDAO {

public class CustomerDAOImpl implements CustomerDAO {

    // use indexing parameter
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);

    }

    @Override
    public int countCustomers(){
        String query = "select count(*) from customer";

        /*
           use getJdbcTemplate() from JdbcDaoSupport class to get instance of jdbcTemplate
           1) get current connection by using getConnection()
           2) release connection by using releaseConnection()
        */
//        int rowCount = getJdbcTemplate().queryForObject(query, Integer.class);

        int rowCount = jdbcTemplate.queryForObject(query, Integer.class);
        return rowCount;
    }

    @Override
    public int countByAgeGreaterThan(int age){
        String query = "select count(*) from customer where age >= ?";
        Object[] args = new Object[]{age};
        int rowCount = jdbcTemplate.queryForObject(query,args, Integer.class);

        return rowCount;
    }

    // using CustomerRowMapper
    @Override
    public Customer getCustomerById(int id) {
        String selectQuery = "select * from customer where id =?";
        Object[] args = new Object[]{id};
        Customer customer = jdbcTemplate.queryForObject(selectQuery, args, new CustomerRowMapper());

        return customer;
    }

    // using built in class that implements RowMapper
    //    @Override
//    public Customer getCustomerById(int id) {
//        String selectQuery = "select * from customer where id =?";
//
//        using built in class that implements RowMapper
//        Object[] args = new Object[]{id};
//        Customer customer = jdbcTemplate.queryForObject(selectQuery, args, new BeanPropertyRowMapper<>(Customer.class));
//
//        return customer;
//
//    }

    // by CustomerRowMapper()
    @Override
    public List<Customer> findAllCustomers() {
        String query = "select * from customer";
        List<Customer> customers = jdbcTemplate.query(query, new CustomerRowMapper());

        return customers;
    }

    // by BeanPropertyRowMapper
//    @Override
//    public List<Customer> findAllCustomers() {
//        String query = "select * from customer";
//        List<Customer> customers = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Customer.class));
//
//        return customers;
//    }

    @Override
    public int insertCustomer(Customer customer) {
        String query = "insert into customer values(?, ?, ?)";
        Object[] args = new Object[]{customer.getId(), customer.getName(), customer.getAge()};

        int insertResult = jdbcTemplate.update(query, args);

        return insertResult;
    }

    @Override
    public int updateCustomer(int id, Customer customer) {
        String query = "update customer set name=?, age=? where id=? ";
        Object[] args = new Object[]{customer.getName(), customer.getAge(), id};

        int updateResult = jdbcTemplate.update(query, args);

        return updateResult;
    }

    @Override
    public int deleteCustomer(int id) {
        String query = "delete from customer where id =?";
        Object[] args = new Object[]{id};

        int deleteResult = jdbcTemplate.update(query, args);

        return deleteResult;
    }

    // use execute method (often used for DDL statements)
    @Override
    public void createTable() {
        String sql = "create table test( id INT, testCol VARCHAR(50), PRIMARY KEY (id))";
        jdbcTemplate.execute(sql);
    }





    @Override
    public int insertCustomerByJdbcInsert(Customer customer) {
        return 0;
    }

    @Override
    public int insertCustomerByMapSqlParameter(Customer customer) {
        return 0;
    }

    @Override
    public int insertCustomerByBeanSqlParameter(Customer customer) {
        return 0;
    }
}
