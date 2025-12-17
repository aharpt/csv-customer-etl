package com.camel.Customers.routes;

import com.camel.Customers.processor.CustomersProcessor;
import com.camel.Customers.utility.CustomerMapper;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.csv.CsvDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CustomersRoute extends RouteBuilder {

    @Autowired
    CustomersProcessor processor;

    @Value("${folder.inbound}")
    private String inboundFolder;

    @Override
    public void configure() {
        CsvDataFormat csv = new CsvDataFormat();
        csv.setSkipHeaderRecord(true);

        from("file:" + inboundFolder + "?include=.*\\.csv&noop=true")
                .routeId("customers")
                .log("Found CSV file: ${header.CamelFileName}")
                .unmarshal(csv)
                .split(body())
                    .bean(CustomerMapper.class)
                    .process(processor)
                .end()
                .log("Finished Processing Customer Records");
    }

}
