package br.com.diogo.banco.app;

import br.com.diogo.banco.model.*;
import br.com.diogo.banco.service.BancoService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BancoService bancoService = new BancoService();

        boolean executando = true;

        while (executando) {
            exibirMenu();
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> criarConta(scanner, bancoService);
                case 2 -> depositar(scanner, bancoService);
                case 3 -> sacar(scanner, bancoService);
                case 4 -> transferir(scanner, bancoService);
                case 5 -> listarContas(bancoService);
                case 0 -> executando = false;
                default -> System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }

    private static void criarConta(Scanner scanner, BancoService bancoService) {
        scanner.nextLine(); // limpa o buffer

        System.out.print("Nome do cliente: ");
        String nome = scanner.nextLine();

        System.out.print("CPF do cliente: ");
        String cpf = scanner.nextLine();

        Cliente cliente = new Cliente(nome, cpf);

        System.out.println("Tipo de conta:");
        System.out.println("1 - Conta Corrente");
        System.out.println("2 - Conta Poupança");
        int tipo = scanner.nextInt();

        Conta conta;

        if (tipo == 1) {
            conta = new ContaCorrente(cliente);
        } else if (tipo == 2) {
            conta = new ContaPoupanca(cliente);
        } else {
            System.out.println("Tipo inválido.");
            return;
        }

        bancoService.adicionarConta(conta);
        System.out.println("Conta criada com sucesso! Número: " + conta.getNumero());
    }

    private static void depositar(Scanner scanner, BancoService bancoService) {
        System.out.print("Número da conta: ");
        int numeroConta = scanner.nextInt();

        System.out.print("Valor do depósito: ");
        double valor = scanner.nextDouble();

        boolean sucesso = bancoService.depositar(numeroConta, valor);

        if (sucesso) {
            System.out.println("Depósito realizado com sucesso.");
        } else {
            System.out.println("Erro ao realizar depósito.");
        }
    }

    private static void sacar(Scanner scanner, BancoService bancoService) {
        System.out.print("Número da conta: ");
        int numeroConta = scanner.nextInt();

        System.out.print("Valor do saque: ");
        double valor = scanner.nextDouble();

        ResultadoSaque resultado = bancoService.sacar(numeroConta, valor);

        switch (resultado) {
            case SUCESSO -> System.out.println("Saque realizado com sucesso.");
            case SALDO_INSUFICIENTE -> System.out.println("Saldo insuficiente.");
            case VALOR_INVALIDO -> System.out.println("Valor inválido.");
            case CONTA_NAO_ENCONTRADA -> System.out.println("Conta não encontrada.");
        }
    }

    private static void transferir(Scanner scanner, BancoService bancoService) {
        System.out.print("Conta origem: ");
        int origem = scanner.nextInt();

        System.out.print("Conta destino: ");
        int destino = scanner.nextInt();

        System.out.print("Valor da transferência: ");
        double valor = scanner.nextDouble();

        ResultadoSaque resultado = bancoService.transferir(origem, destino, valor);

        switch (resultado) {
            case SUCESSO -> System.out.println("Transferência realizada com sucesso.");
            case SALDO_INSUFICIENTE -> System.out.println("Saldo insuficiente na conta de origem.");
            case VALOR_INVALIDO -> System.out.println("Valor inválido.");
            case CONTA_NAO_ENCONTRADA -> System.out.println("Conta não encontrada.");
        }
    }

    private static void listarContas(BancoService bancoService) {
        System.out.println("\n=== CONTAS CADASTRADAS ===");

        if (bancoService.listarContas().isEmpty()) {
            System.out.println("Nenhuma conta cadastrada.");
            return;
        }

        for (Conta conta : bancoService.listarContas()) {
            System.out.println(conta);
        }
    }

    private static void exibirMenu() {
        System.out.println("\n=== MENU BANCÁRIO ===");
        System.out.println("1 - Criar conta");
        System.out.println("2 - Depositar");
        System.out.println("3 - Sacar");
        System.out.println("4 - Transferir");
        System.out.println("5 - Listar contas");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }


}