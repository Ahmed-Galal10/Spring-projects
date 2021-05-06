package com.day4.dao;

import com.day4.model.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface CustomerDAO extends CrudRepository<Customer, Integer> {

    List<Customer> findCustomersByIdGreaterThan(int id);

    int countByName(String firstName);

    int countByNameAndAgeAfter(String name, int age);

    @Query(value = "from Customer c where name = ?1")
    List<Customer> findByName(String name);

    @Transactional
    // TransactionRequiredException: Executing an update/delete query
    @Modifying
    // Not supported for DML operations [UPDATE com.day4.entity.Customer c SET age = ?1, name = ?2 WHERE id = ?3]
    @Query("update Customer c set age = ?1, name = ?2 where id = ?3")
    void updateCustomer(int age, String name, int id);
}
