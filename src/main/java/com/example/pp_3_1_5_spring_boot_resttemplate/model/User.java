package com.example.pp_3_1_5_spring_boot_resttemplate.model;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
    private String lastName;
    private Byte age;
}
