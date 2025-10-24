package desafio_dio_banco;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA BANCÁRIO DIO ===");
        

        Banco banco = new Banco("Banco DIO");
        
 
        Cliente joao = new Cliente("João Silva", "111.222.333-44");
        Cliente maria = new Cliente("Maria Santos", "555.666.777-88");

        banco.cadastrarCliente(joao);
        banco.cadastrarCliente(maria);
        

        IConta ccJoao = new ContaCorrente(joao, 1000.0);
        IConta cpJoao = new ContaPoupanca(joao);
        IConta ciJoao = new ContaInvestimento(joao, "CDB");
        

        IConta ccMaria = new ContaCorrente(maria);
        IConta ciMaria = new ContaInvestimento(maria, "TESOURO DIRETO");
        

        joao.adicionarConta((Conta) ccJoao);
        joao.adicionarConta((Conta) cpJoao);
        joao.adicionarConta((Conta) ciJoao);
        
        maria.adicionarConta((Conta) ccMaria);
        maria.adicionarConta((Conta) ciMaria);
        
        System.out.println("\n--- Realizando operações ---");
        
 
        ccJoao.depositar(2000.0);
        ccJoao.sacar(500.0);
        ccJoao.transferir(300.0, ccMaria); 
        

        cpJoao.depositar(1000.0);
        ((ContaPoupanca) cpJoao).renderJuros(); 
        
   
        ciJoao.depositar(5000.0);
        ((ContaInvestimento) ciJoao).investir(2000.0, "CDB Banco DIO");
        ((ContaInvestimento) ciJoao).aplicarRendimento();
        

        ccMaria.depositar(1500.0);
        ciMaria.depositar(3000.0);
        ((ContaInvestimento) ciMaria).aplicarRendimento();
        
        System.out.println("\n--- Mostrando extratos ---");
        

        ccJoao.imprimirExtrato();
        cpJoao.imprimirExtrato();
        ciJoao.imprimirExtrato();
        ccMaria.imprimirExtrato();
        ciMaria.imprimirExtrato();
        

        banco.mostrarRelatorio();
        
        System.out.println("\n=== Fim do sistema ===");
    }
}