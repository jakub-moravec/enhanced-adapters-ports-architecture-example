package com.github.jakub_moravec.enhanced_ports_adapters_architecture_example.friends.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan({"com.github.jakub_moravec.enhanced_ports_adapters_architecture_example"})
@SpringBootApplication
public class FriendsServiceApp {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(FriendsServiceApp.class);
        application.run(args);
    }
}
