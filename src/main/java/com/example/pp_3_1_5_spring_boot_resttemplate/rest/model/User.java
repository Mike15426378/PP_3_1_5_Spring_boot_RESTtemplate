package com.example.pp_3_1_5_spring_boot_resttemplate.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private Long id;
    private String name;
    private String lastName;
    private Byte age;
}
