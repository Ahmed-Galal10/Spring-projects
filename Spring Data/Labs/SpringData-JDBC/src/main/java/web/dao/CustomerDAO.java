package web.dao;

import web.model.Customer;

import java.util.List;

public interface CustomerDAO {

    int insertCustomerByJdbcInsert(Customer customer);

    int countCustomers();

    int insertCustomerByMapSqlParameter(Customer customer);

    int insertCustomerByBeanSqlParameter(Customer customer);

    int countByAgeGreaterThan(int age);

    public Customer getCustomerById(int id);

    public List<Customer> findAllCustomers();

    public int insertCustomer(Customer customer);

    public int updateCustomer(int id, Customer customer);

    public int deleteCustomer(int id);

    void createTable();


}
