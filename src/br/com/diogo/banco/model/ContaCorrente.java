package br.com.diogo.banco.model;

public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public String toString() {
        return "Conta Corrente - Número: " + getNumero() +
                " | Cliente: " + getCliente().getNome() +
                " | CPF: " + getCliente().getCpf() +
                " | Saldo: " + getSaldo();
    }
}
