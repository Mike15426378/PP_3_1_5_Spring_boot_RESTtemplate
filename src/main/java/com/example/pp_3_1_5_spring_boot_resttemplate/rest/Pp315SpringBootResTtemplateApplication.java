package com.example.pp_3_1_5_spring_boot_resttemplate.rest;

import com.example.pp_3_1_5_spring_boot_resttemplate.rest.client.Client;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Pp315SpringBootResTtemplateApplication {
    public static void main(String[] args) {
        SpringApplication.run(Pp315SpringBootResTtemplateApplication.class, args);
        System.out.println(Client.start());
    }
}