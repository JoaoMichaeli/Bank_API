package br.com.example.bank.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.example.bank.model.Account;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("account")
public class AccountController {

    private List<Account> repository = new ArrayList<>();

    @GetMapping
    public List<Account> index(){
        return repository;
    }

}
