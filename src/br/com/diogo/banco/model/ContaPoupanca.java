package br.com.diogo.banco.model;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public String toString() {
        return "Conta Poupança - Número: " + getNumero() +
                " | Cliente: " + getCliente().getNome() +
                " | CPF: " + getCliente().getCpf() +
                " | Saldo: " + getSaldo();
    }

}
