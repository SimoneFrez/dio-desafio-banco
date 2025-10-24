package desafio_dio_banco;


import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String cpf;
    private List<Conta> contas;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.contas = new ArrayList<>();
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
        System.out.println("Conta " + conta.getNumero() + " adicionada para " + nome);
    }

    public void listarContas() {
        System.out.println("\n=== Contas de " + nome + " ===");
        for (Conta conta : contas) {
            conta.imprimirExtrato();
            System.out.println();
        }
    }

    public void mostrarExtratos() {
        System.out.println("\n=== Extratos de " + nome + " ===");
        for (Conta conta : contas) {
            conta.imprimirExtrato(); 
            System.out.println();
        }
    }

    // Getters
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public List<Conta> getContas() { return contas; }
}