package br.com.diogo.banco.model;


public class ContaCorrente extends Conta {

    private static final double TAXA_SAQUE = 1.5;

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public ResultadoSaque sacar(double valor) {

        if (valor <= 0) {
            return ResultadoSaque.VALOR_INVALIDO;
        }

        double valorComTaxa = valor + TAXA_SAQUE;

        if (saldo < valorComTaxa) {
            return ResultadoSaque.SALDO_INSUFICIENTE;
        }

        saldo -= valorComTaxa;
        return ResultadoSaque.SUCESSO;
    }

    @Override
    public String toString() {
        return "Conta Corrente - Número: " + getNumero() +
                " | Cliente: " + getCliente().getNome() +
                " | CPF: " + getCliente().getCpf() +
                " | Saldo: " + getSaldo();
    }
}
