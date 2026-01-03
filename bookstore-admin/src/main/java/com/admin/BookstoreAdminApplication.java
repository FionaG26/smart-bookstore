package com.admin;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@PWA(name = "Smart Bookstore Admin", shortName = "BookstoreAdmin")
public class BookstoreAdminApplication implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(BookstoreAdminApplication.class, args);
    }
}

