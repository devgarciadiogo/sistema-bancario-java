package br.com.diogo.banco.model;

public class Cliente {

    private final String nome;
    private final String cpf;

    public Cliente(String nome, String cpf) {
        if(nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome inválido");
        }

        if (cpf == null || cpf.isBlank()) {
            throw new IllegalArgumentException("CPF inválido");
        }

        if (!cpf.matches("\\d{11}")) {
            throw new IllegalArgumentException("CPF deve conter exatamente 11 números");
        }

        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
}
