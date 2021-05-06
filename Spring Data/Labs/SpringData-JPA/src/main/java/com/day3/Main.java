package com.day3;

import com.day3.dao.CustomerDAO1;
import com.day3.dao.CustomerDAO2;
import com.day3.model.Customer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        CustomerDAO1 customerDAO1 = context.getBean("customerDAO1", CustomerDAO1.class);

        Customer customer1 = new Customer("fra5 mashwya", 33);
//        System.out.println("save customer1 : " + customerDAO1.save(customer1));
//
//        System.out.println("Customer with id 1 : " + customerDAO1.findOne(29));
//
//        System.out.println("countByAgeGreaterThan 26 : " + customerDAO1.countByAgeGreaterThan(22));
//
//        System.out.println("number of customers : " + customerDAO1.countCustomers());
//
//        System.out.println("retrieve All customers :");
//
//        List<Customer> customerList = customerDAO1.findAll();
//        customerList.forEach(System.out::println);
//
//        System.out.println("update customer : ");
//
//        customer1.setAge(222);
//        customerDAO1.update(customer1);

//        System.out.println("delete customer by id : ");
//        customerDAO1.deleteById(32);
//

        //###############################################################################################

        CustomerDAO2 customerDAO2 = context.getBean("customerDAO2", CustomerDAO2.class);

        Customer customer = new Customer("hahaha", 60);
        customerDAO2.save(customer);

        customer1.setName("jets");
        customerDAO2.update(customer1);

        customerDAO2.deleteById(29);

        context.close();
    }
}
