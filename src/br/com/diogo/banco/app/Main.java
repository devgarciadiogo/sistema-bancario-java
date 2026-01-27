package br.com.diogo.banco.app;

import br.com.diogo.banco.model.*;
import br.com.diogo.banco.service.BancoService;

public class Main {
    public static void main(String[] args) {

        BancoService banco = new BancoService();

        // Criando cliente
        Cliente cliente = new Cliente("Diogo", "123.123.123-45");

        // Criando contas
        ContaCorrente cc = new ContaCorrente(cliente);
        ContaPoupanca cp = new ContaPoupanca(cliente);

        // Registrando contas no banco
        banco.adicionarConta(cc);
        banco.adicionarConta(cp);

        // Estado inicial
        System.out.println("=== Contas criadas ===");
        System.out.println(cc);
        System.out.println(cp);

        // Operações
        banco.depositar(cc.getNumero(), 500);
        banco.sacar(cc.getNumero(), 100);
        banco.transferir(cc.getNumero(), cp.getNumero(), 200);

        // Estado final
        System.out.println("\n=== Após operações ===");
        System.out.println(cc);
        System.out.println(cp);
    }
}
