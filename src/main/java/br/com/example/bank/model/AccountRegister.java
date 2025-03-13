package br.com.example.bank.model;

import lombok.Data;


@Data
public class AccountRegister {
    private int numero;
    private String agencia;
    private String nomeTitular;
    private String cpfTitular;
    private String dataAbertura;
    private Long saldoInicial;
}
