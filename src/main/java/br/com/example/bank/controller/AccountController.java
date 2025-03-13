package br.com.example.bank.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.example.bank.model.AccountRegister;

@RestController
@RequestMapping("account")
public class AccountController {

    private List<AccountRegister> repository = new ArrayList<>();

    @GetMapping
    public List<AccountRegister> index(){
        return repository;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public AccountRegister create(@RequestBody Acc)
}
