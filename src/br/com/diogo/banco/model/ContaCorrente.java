package br.com.diogo.banco.model;

public class ContaCorrente extends Conta {

    private static final double TAXA_SAQUE = 1.5;

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public boolean sacar(double valor) {

        if (valor <= 0) {
            return false;
        }

        double valorComTaxa = valor + TAXA_SAQUE;

        if (saldo < valorComTaxa) {
            return false;
        }

        saldo -= valorComTaxa;
        return true;
    }

    @Override
    public String toString() {
        return "Conta Corrente - Número: " + getNumero() +
                " | Cliente: " + getCliente().getNome() +
                " | CPF: " + getCliente().getCpf() +
                " | Saldo: " + getSaldo();
    }
}
