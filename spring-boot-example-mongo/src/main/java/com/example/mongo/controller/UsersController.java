package com.example.mongo.controller;

import com.example.mongo.entity.Users;
import com.example.mongo.repository.UsersRepository;

import java.util.List;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @PostConstruct
    public void init() {
        Users users = new Users();
        users.setName("name 1");
        users.setSurname("surname 2");
        usersRepository.save(users);
    }

    @PostMapping
    public ResponseEntity<Users> save(@RequestBody Users users) {
        return ResponseEntity.ok(usersRepository.save(users));
    }

    @GetMapping
    public ResponseEntity<List<Users>> getAll() {
        return ResponseEntity.ok(usersRepository.findAll());
    }
}
