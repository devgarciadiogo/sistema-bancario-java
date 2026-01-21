package br.com.diogo.banco.model;

public class Conta {

    private static int SEQUENCIAL = 1;

    private int numero;
    private double saldo;
    private Cliente cliente;

    public Conta(Cliente cliente) {
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
        if (valor > 0) {
            saldo += valor;
        }
    }

    public boolean sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }

}
