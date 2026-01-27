package br.com.diogo.banco.model;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public ResultadoSaque sacar(double valor){
        if(valor <= 0){
            return ResultadoSaque.VALOR_INVALIDO;
        }

        if (saldo < valor){
            return ResultadoSaque.SALDO_INSUFICIENTE;
        }

        saldo -= valor;
        return ResultadoSaque.SUCESSO;
    }

    @Override
    public String toString() {
        return "Conta Poupança - Número: " + getNumero() +
                " | Cliente: " + getCliente().getNome() +
                " | CPF: " + getCliente().getCpf() +
                " | Saldo: " + getSaldo();
    }

}
