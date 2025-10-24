package desafio_dio_banco;


import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IConta {
    private static int numeroSequencial = 1;
    
    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected List<Transacao> transacoes;

    public Conta(Cliente cliente) {
        this.agencia = 1;
        this.numero = numeroSequencial++;
        this.cliente = cliente;
        this.saldo = 0.0;
        this.transacoes = new ArrayList<>();
    }

    @Override
    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            transacoes.add(new Transacao("SAQUE", valor, "Saque realizado"));
            System.out.println("Saque de R$ " + valor + " realizado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente para saque!");
        }
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            transacoes.add(new Transacao("DEPÓSITO", valor, "Depósito realizado"));
            System.out.println("Depósito de R$ " + valor + " realizado com sucesso!");
        }
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        if (valor > 0 && valor <= saldo) {
            this.sacar(valor);
            contaDestino.depositar(valor);
            transacoes.add(new Transacao("TRANSFERÊNCIA", valor, 
                "Transferência para conta " + ((Conta)contaDestino).getNumero()));
            System.out.println("Transferência de R$ " + valor + " realizada!");
        } else {
            System.out.println("Não foi possível realizar a transferência!");
        }
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("\n--- Extrato das últimas transações ---");
        for (Transacao transacao : transacoes) {
            System.out.println(transacao);
        }
        System.out.println("Saldo atual: R$ " + String.format("%.2f", saldo));
    }

    public void imprimirDadosBasicos() {
        System.out.println("Titular: " + cliente.getNome());
        System.out.println("Agência: " + agencia);
        System.out.println("Conta: " + numero);
        System.out.println("Saldo: R$ " + String.format("%.2f", saldo));
    }

    // Getters
    public int getAgencia() {
    	return agencia; 
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
    public List<Transacao> getTransacoes() {
    	return transacoes; 
    	}
}