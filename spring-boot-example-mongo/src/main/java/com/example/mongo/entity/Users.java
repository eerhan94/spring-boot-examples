package com.example.mongo.entity;

import java.util.HashMap;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Users {
    @Id
    private String id;
    private String name;
    private String surname;
    private HashMap properties;
}
