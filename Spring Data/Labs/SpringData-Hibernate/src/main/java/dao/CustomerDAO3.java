package dao;

import model.Customer;
import org.springframework.transaction.annotation.Transactional;

public interface CustomerDAO3 {
    long countCustomers();

    @Transactional
    Customer save(Customer customer);

    @Transactional
    void update(Customer customer);

    void delete(Customer customer);

    void deleteById(Integer customerId);

    Customer findOne(Integer customerId);
}
