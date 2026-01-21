package br.com.diogo.banco.service;

import br.com.diogo.banco.model.Conta;

import java.util.ArrayList;
import java.util.List;

public class BancoService {
    private List<Conta> contas = new ArrayList<>();

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public Conta buscarContaPorNumero(int numero) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numero) {
                return conta;
            }
        }
        return null;
    }

    public boolean depositar(int numeroConta, double valor) {
        Conta conta = buscarContaPorNumero(numeroConta);

        if (conta == null) {
            return false;
        }

        if (valor <= 0){
            return false;
        }

        conta.depositar(valor);
        return true;

    }

    public boolean sacar(int numeroConta, double valor){
        Conta conta = buscarContaPorNumero(numeroConta);

        if(conta == null){
            return false;
        }

        return conta.sacar(valor);
    }

    public boolean transferir(int origem, int destino, double valor) {
        Conta contaOrigem = buscarContaPorNumero(origem);
        Conta contaDestino = buscarContaPorNumero(destino);

        if (contaOrigem == null || contaDestino == null) {
            return false;
        }

        if (contaOrigem.sacar(valor)) {
            contaDestino.depositar(valor);
            return true;
        }

        return false;
    }

}
