import web.dao.CustomerDAO;
import web.model.Customer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        CustomerDAO customerDAO = context.getBean("customerDAO",CustomerDAO.class);
        CustomerDAO customerDAO2 = context.getBean("customerDAO2",CustomerDAO.class);

        // Customer by id
        System.out.println("Customer by id 1 : "+ customerDAO.getCustomerById(1));

        // countCustomers()
        System.out.println("Number of customers is : "+ customerDAO.countCustomers());

        // create new customer
        Customer customer1 = new Customer("samak mashwyeee",19);

        // insert customer
        System.out.println("insert customer : " + customerDAO.insertCustomer(customer1));


        // ######################################################################################

        Customer customer3 = new Customer("haha",42);
        customerDAO2.insertCustomer(customer3);

        List<Customer> customerList = customerDAO.findAllCustomers();

        customerList.forEach(System.out::println);
    }
}
