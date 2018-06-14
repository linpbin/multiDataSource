package com.example.multisource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class})
public class MultisourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultisourceApplication.class, args);
    }
}
