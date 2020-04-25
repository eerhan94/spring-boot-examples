package com.example.redis.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Employee implements Serializable {
    public Long id;
    public String name;

    public Employee(String name) {
        this.name = name;
    }
}
