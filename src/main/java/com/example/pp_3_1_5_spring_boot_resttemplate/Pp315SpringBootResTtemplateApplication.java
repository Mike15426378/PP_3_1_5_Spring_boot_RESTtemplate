package com.example.pp_3_1_5_spring_boot_resttemplate;

import com.example.pp_3_1_5_spring_boot_resttemplate.rest.client.Client;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Pp315SpringBootResTtemplateApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Pp315SpringBootResTtemplateApplication.class, args);
        Client client = context.getBean("client", Client.class);
        System.out.println("Answer: " + client.getAnswer());
    }

}
