package desafio_dio_banco;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private List<Cliente> clientes;

    public Banco(String nome) {
        this.nome = nome;
        this.clientes = new ArrayList<>();
    }

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("Cliente " + cliente.getNome() + " cadastrado com sucesso!");
    }

    public Cliente buscarCliente(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        System.out.println("Cliente com CPF " + cpf + " não encontrado.");
        return null;
    }

    public void listarClientes() {
        System.out.println("\n=== Clientes do " + nome + " ===");
        for (Cliente cliente : clientes) {
            System.out.println("Nome: " + cliente.getNome() + " | CPF: " + cliente.getCpf());
        }
    }

    public void mostrarRelatorio() {
        System.out.println("\n=== Relatório do Banco ===");
        System.out.println("Banco: " + nome);
        System.out.println("Total de clientes: " + clientes.size());
        
        int totalContas = 0;
        for (Cliente cliente : clientes) {
            totalContas += cliente.getContas().size();
        }
        System.out.println("Total de contas: " + totalContas);
    }

 
    public String getNome() {
    	return nome; 
    	}
    public List<Cliente> getClientes() {
    	return clientes; 
    	}
}