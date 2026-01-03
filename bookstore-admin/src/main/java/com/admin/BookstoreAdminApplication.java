package com.admin;

import com.vaadin.flow.server.PWA;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@PWA(name = "Smart Bookstore Admin", shortName = "Bookstore Admin")
public class BookstoreAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookstoreAdminApplication.class, args);
    }

}

