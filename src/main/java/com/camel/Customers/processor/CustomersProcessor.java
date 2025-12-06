package com.camel.Customers.processor;

import com.camel.Customers.db.repository.CustomerRepository;
import com.camel.Customers.models.Customer;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomersProcessor implements Processor {

    @Autowired
    CustomerRepository repository;

    @Override
    public void process(Exchange exchange) throws Exception {
        Customer customer = exchange.getIn().getBody(Customer.class);
        System.out.println("Customer Index: " + customer.getIndex());
        System.out.println("Customer First name: " + customer.getFirstName());
        System.out.println("Customer Last Name: " + customer.getLastName());
        System.out.println("\n\n");

        // Map to DB Customer Model
        com.camel.Customers.db.models.Customer dbCustomer = new com.camel.Customers.db.models.Customer();
        dbCustomer.setIndex(customer.getIndex());
        dbCustomer.setFirstName(customer.getFirstName());
        dbCustomer.setLastName(customer.getLastName());

        // Call Repository.save()
        repository.save(dbCustomer);
    }
}
