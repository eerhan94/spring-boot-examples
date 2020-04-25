package com.example.elasticsearch.controller;

import com.example.elasticsearch.entity.Account;
import com.example.elasticsearch.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountRepository accountRepository;

    @PostConstruct
    public void init() {
        Account account = new Account();
        account.setUsername("username1");
        account.setPassword("password1");
        account.setLastLogin(Calendar.getInstance().getTime());
        accountRepository.save(account);

        Account account2 = new Account();
        account2.setUsername("username2");
        account2.setPassword("password2");
        account2.setLastLogin(Calendar.getInstance().getTime());
        accountRepository.save(account2);
    }

    @GetMapping("/{search}")
    public ResponseEntity<List<Account>> getKisi(@PathVariable String search) {
        List<Account> accounts = accountRepository.findByUsernameLikeOrPasswordLike(search, search);
        return ResponseEntity.ok(accounts);
    }
}
