package com.day4.dao;

import com.day4.model.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

///@NoRepositoryBean
//NoSuchBeanDefinitionException: No bean named 'customerDAO' available
public interface CustomerDAO2 extends PagingAndSortingRepository<Customer, Integer> {
}
