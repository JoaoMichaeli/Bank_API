package br.com.example.bank.Repository;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountRepository {
    private List<Account> accounts = new ArrayList<>();
    private Long idSequence = 1L;

    public Account save(Account account){
        account.setId(idSequence++);
        accounts.add(account);
        return account;
    }

    public List<Account> list(){
        return accounts;
    }

    public Account searchById(Long id){
        return accounts.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }

    public Account searchByCpf(String cpf){
        return accounts.stream().filter(c -> c.getCpfTitular().equals(cpf)).findFirst().orElse(null);
    }

    public void closeAccount(Long id){
        Account account = searchById(id);
        if (account != null) account.setSituacao(false);
    }
}
