package com.camel.Customers.routes;

import com.camel.Customers.models.Customer;
import com.camel.Customers.utility.CustomerMapper;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.csv.CsvDataFormat;
import org.springframework.stereotype.Component;
import tools.jackson.dataformat.csv.CsvMapper;
import tools.jackson.dataformat.csv.CsvSchema;

@Component
public class CustomersRoute extends RouteBuilder {

    @Override
    public void configure() {
        CsvDataFormat csv = new CsvDataFormat();
        csv.setSkipHeaderRecord(true);

        from("file:/Users/aaronharpt/Documents/Programming/Spring-Boot/Inbound?include=.*\\.csv&noop=true")
                .routeId("customers")
                .log("Found CSV file: ${header.CamelFileName}")
                .unmarshal(csv)
                .split(body())
                .bean(CustomerMapper.class)
                .log("Parsed POJO: ${body}")
                .end();
    }

}
