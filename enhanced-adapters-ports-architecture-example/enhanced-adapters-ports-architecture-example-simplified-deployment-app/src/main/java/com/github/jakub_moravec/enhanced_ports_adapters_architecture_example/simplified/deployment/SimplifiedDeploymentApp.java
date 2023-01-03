package com.github.jakub_moravec.enhanced_ports_adapters_architecture_example.simplified.deployment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.github.jakub_moravec.enhanced_ports_adapters_architecture_example"})
@SpringBootApplication
public class SimplifiedDeploymentApp {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(SimplifiedDeploymentApp.class);
        application.run(args);
    }
}
