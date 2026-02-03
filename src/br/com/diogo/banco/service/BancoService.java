package br.com.diogo.banco.service;

import br.com.diogo.banco.model.Conta;
import br.com.diogo.banco.model.ResultadoSaque;

import java.util.ArrayList;
import java.util.List;

public class BancoService {

    private List<Conta> contas = new ArrayList<>();

    public void adicionarConta(Conta conta) {
        if (conta == null) {
            throw new IllegalArgumentException("Conta inválida");
        }

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

        if (conta == null || valor <= 0) {
            return false;
        }

        conta.depositar(valor);
        return true;
    }

    public ResultadoSaque sacar(int numeroConta, double valor) {
        Conta conta = buscarContaPorNumero(numeroConta);

        if (conta == null) {
            return ResultadoSaque.CONTA_NAO_ENCONTRADA;
        }

        return conta.sacar(valor);
    }

    public ResultadoSaque transferir(int origem, int destino, double valor) {
        Conta contaOrigem = buscarContaPorNumero(origem);
        Conta contaDestino = buscarContaPorNumero(destino);

        if (contaOrigem == null || contaDestino == null) {
            return ResultadoSaque.CONTA_NAO_ENCONTRADA;
        }

        ResultadoSaque resultado = contaOrigem.sacar(valor);

        if (resultado == ResultadoSaque.SUCESSO) {
            contaDestino.depositar(valor);
        }

        return resultado;
    }

    public List<Conta> listarContas() {
        return new ArrayList<>(contas);
    }
}
