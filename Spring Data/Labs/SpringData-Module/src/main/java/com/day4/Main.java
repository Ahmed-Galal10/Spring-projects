package com.day4;

import com.day4.dao.CustomerDAO;
import com.day4.dao.CustomerDAO2;
import com.day4.model.Customer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class Main {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");

        CustomerDAO2 customerDAO2 = (CustomerDAO2) context.getBean("customerDAO2");


        Customer customer1 = new Customer("galal", 100);
        Customer customer2 = new Customer("ahmed", 90);

        //save customer
//        customerDAO.save(customer1);
//        customerDAO.save(customer2);
//
//        // find all customers
//        System.out.println("All Customers: ");
//        customerDAO.findAll().forEach(System.out::println);
//
//        // Find customer by id
//        System.out.println("Find by Id " + customerDAO.findById(customer1.getId()));
//
//        // Is customer Exists by id
//        System.out.println("Existence : " + customerDAO.existsById(customer1.getId()));

//        customerDAO.deleteAll();

        //#############################################################################

//        Pageable pageable = PageRequest.of(2, 4, Sort.by("age"));
//
//        Page<Customer> result = customerDAO2.findAll(pageable);
//
//        if (result.hasContent()) {
//            System.out.println(result.getContent());
//        }

        // #############################################################################

//        System.out.println("count customers By Name :" + customerDAO.countByName("jets"));
//
//        System.out.println("find Customers By Id Greater Than age : " + customerDAO.findCustomersByIdGreaterThan(95));
//
//        System.out.println("countByNameAndAgeAfter " + customerDAO.countByNameAndAgeAfter("iti", 35));
//
//        // #############################################################################
//
        customerDAO.updateCustomer(111, "wOoOoOoW", 41);

        System.out.println("findByName");
        customerDAO.findByName("iti").forEach(System.out::println);
    }
}
