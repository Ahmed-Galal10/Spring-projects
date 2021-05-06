package dao;

import model.Customer;

public interface CustomerDAO2 {
    Customer saveWithTransaction(Customer customer);

    void update(Customer customer);

    void delete(Customer customer);
}
