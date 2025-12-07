package com.camel.Customers.utility;

import com.camel.Customers.models.Customer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerMapper {

    public Customer map(List<String> row) {
        if (row == null) {
            throw new IllegalArgumentException("Invalid CSV row: " + row);
        }

        Customer customer = new Customer();
        customer.setIndex(row.get(0));
        customer.setId(row.get(1));
        customer.setFirstName(row.get(2));
        customer.setLastName(row.get(3));
        customer.setCompany(row.get(4));
        customer.setCity(row.get(5));
        customer.setCountry(row.get(6));
        customer.setPhone1(row.get(7));
        customer.setPhone2(row.get(8));
        customer.setEmail(row.get(9));
        customer.setSubscriptionDate(row.get(10));
        customer.setWebsite(row.get(11));

        return customer;
    }
}
