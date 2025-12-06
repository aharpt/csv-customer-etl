package com.camel.Customers.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CustomersRoute extends RouteBuilder {

    @Override
    public void configure() {
        from("file:/Users/aaronharpt/Documents/Programming/Spring-Boot/Inbound?include=.*\\.csv&noop=true")
                .routeId("customers")
                .log("Found CSV file: ${header.CamelFileName}")
                .end();
    }

}
