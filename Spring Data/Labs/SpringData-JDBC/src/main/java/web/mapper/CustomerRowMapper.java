package web.mapper;

import web.model.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.*;


public class CustomerRowMapper implements RowMapper<Customer> {

    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {

        Customer customer = new Customer();

        customer.setId(rs.getInt("id"));
        customer.setName(rs.getString("name"));
        customer.setAge(rs.getInt("age"));

        return customer;
    }
}
