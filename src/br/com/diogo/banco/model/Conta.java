package br.com.diogo.banco.model;

public abstract class Conta {

    private static int SEQUENCIAL = 1;

    protected final int numero;
    protected double saldo;
    protected final Cliente cliente;

    public Conta(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não pode ser nulo");
        }

        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.saldo = 0.0;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de depósito inválido");
        }

        saldo += valor;
    }

    public abstract ResultadoSaque sacar(double valor);
}
