package com.example.restdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@SpringBootApplication
public class RestdataApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestdataApplication.class, args);
    }
}
