package br.com.example.bank.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class Account {
    private Long id;
    private String numero;
    private String agencia;
    private String nomeTitular;
    private String cpfTitular;
    private LocalDate dataAbertura;
    private double saldo;
    private boolean situacao;
    private String tipo;

    public Account() {}

    public Account(Long id, String numero, String agencia, String nomeTitular, String cpfTitular, LocalDate dataAbertura, double saldo, boolean situacao, String tipo) {
        this.id = id;
        this.numero = numero;
        this.agencia = agencia;
        this.nomeTitular = nomeTitular;
        this.cpfTitular = cpfTitular;
        this.dataAbertura = dataAbertura;
        this.saldo = saldo;
        this.situacao = situacao;
        this.tipo = tipo;
    }

}
