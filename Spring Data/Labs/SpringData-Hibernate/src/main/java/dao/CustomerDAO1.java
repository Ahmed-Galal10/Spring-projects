package dao;

import model.Customer;

import java.util.List;

public interface CustomerDAO1 {
    long countCustomers();

    long countByAgeGreaterThan(int age);

    Customer findOne(Integer customerId);

    List<Customer> findAll();

    Customer save(Customer customer);

    void deleteById(Integer customerId);

    void delete(Customer customer);
}
