package br.com.example.bank.controller;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home(){
        return "Projeto Bank - João Victor Michaeli";
    }
}
