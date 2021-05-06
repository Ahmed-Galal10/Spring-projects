import dao.CustomerDAO1;
import dao.CustomerDAO2;
import dao.CustomerDAO3;
import model.Customer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        CustomerDAO1 customerDAO1 = context.getBean("customerDAO1", CustomerDAO1.class);
        CustomerDAO2 customerDAO2 = context.getBean("customerDAO2", CustomerDAO2.class);
        CustomerDAO3 customerDAO3 = context.getBean("customerDAO3", CustomerDAO3.class);

        Customer customer = new Customer("galalzzz", 25);
//        System.out.println("save customer1  : " + customerDAO1.save(customer));
        System.out.println("save customer2 : " + customerDAO2.saveWithTransaction(customer));


        System.out.println("find by id 2 : " + customerDAO1.findOne(1));

        System.out.println("customers with Age Greater Than : " + customerDAO1.countByAgeGreaterThan(23));

        Customer customer2 = new Customer("woOoOow", 36);
        System.out.println("save customer2 : " + customerDAO2.saveWithTransaction(customer2));

        System.out.println("number of customers : " + customerDAO1.countCustomers());

        System.out.println("retrieve All customers :");

        List<Customer> customerList = customerDAO1.findAll();
        customerList.forEach(System.out::println);

//        System.out.println("update customer : ");
//        Customer customer3 = new Customer(9, "test", 37);
////        customer2.setName("hahaha");
//        customerDAO2.update(customer3);

        System.out.println("delete customer by id : ");
        customerDAO1.deleteById(11);


        // #################################################################################

        System.out.println(" findOne : " + customerDAO3.findOne(2));

        Customer customer4 = new Customer("jets", 41);

        System.out.println("Save customer : " + customerDAO3.save(customer4));


        System.out.println("update done? : ");
        Customer customer1 = new Customer(2, "ay 7aga", 11);
        customerDAO2.update(customer1);



        context.close();


    }
}
