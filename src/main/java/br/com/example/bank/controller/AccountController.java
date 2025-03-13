package br.com.example.bank.controller;

import java.time.LocalDate;
import java.util.List;

import br.com.example.bank.Repository.AccountRepository;
import br.com.example.bank.model.Account;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountRepository repository;

    public AccountController(AccountRepository repository) {
        this.repository = repository;
    }

    @PatchMapping
    public ResponseEntity<?> accountRegister(@RequestBody Account account) {
        if (account.getNomeTitular() == null || account.getCpfTitular() == null ||
            account.getDataAbertura() == null || account.getSaldo() < 0 ||
                (!account.getTipo().equals("corrente") && !account.getTipo().equals("poupança") && !account.getTipo().equals("salário"))){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Data de abertura inválida");
        }

        if (account.getDataAbertura().isAfter(LocalDate.now())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Data de abertura inválida");
        }

        Account newAccount = repository.save(account);
        return ResponseEntity.ok(newAccount);

    }

    @GetMapping
    public List<Account> listAccounts(){
        return repository.list();
    }

    @GetMapping("{id}")
    public ResponseEntity<?> searchForId(@PathVariable Long id){
        Account account = repository.searchById(id);
        return account != null ? ResponseEntity.ok(account) : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Conta não encontrada");
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<?> searchForCpf(@PathVariable String cpf){
        Account account = repository.searchByCpf(cpf);
        return account != null ? ResponseEntity.ok(account) : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Conta não encontrada");
    }

    @PutMapping("/{id}/encerrar")
    public ResponseEntity<?> closeAccount(@PathVariable Long id){
        repository.closeAccount(id);
        return ResponseEntity.ok("Conta encerrada com sucesso");
    }

}
