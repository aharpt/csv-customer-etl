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

        // Map to DB Customer Model
        com.camel.Customers.db.models.Customer dbCustomer = new com.camel.Customers.db.models.Customer();
        dbCustomer.setIndex(customer.getIndex());
        dbCustomer.setCustomerId(customer.getId());
        dbCustomer.setFirstName(customer.getFirstName());
        dbCustomer.setLastName(customer.getLastName());
        dbCustomer.setCompany(customer.getCompany());
        dbCustomer.setCity(customer.getCity());
        dbCustomer.setCountry(customer.getCountry());
        dbCustomer.setPhone1(customer.getPhone1());
        dbCustomer.setPhone2(customer.getPhone2());
        dbCustomer.setEmail(customer.getEmail());
        dbCustomer.setSubscriptionDate(customer.getSubscriptionDate());
        dbCustomer.setWebsite(customer.getWebsite());

        // Call Repository.save()
        repository.save(dbCustomer);
    }
}
