package com.camel.Customers.db.repository;

import com.camel.Customers.db.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {}
