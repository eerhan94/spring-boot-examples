package com.example.elasticsearch.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "accounts", type = "account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    private String id;

    @Field(name = "username", type = FieldType.Text)
    private String username;

    @Field(name = "password", type = FieldType.Text)
    private String password;

    @Field(name = "last_login", type = FieldType.Date)
    private Date lastLogin;

}
