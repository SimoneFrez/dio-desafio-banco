package desafio_dio_banco;


public class ContaPoupanca extends Conta {
    private double taxaRendimento;

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
        this.taxaRendimento = 0.005; 
    }

    public void renderJuros() {
        double rendimento = saldo * taxaRendimento;
        if (rendimento > 0) {
            saldo += rendimento;
            transacoes.add(new Transacao("RENDIMENTO", rendimento, "Rendimento poupança"));
            System.out.println("Rendimento de R$ " + String.format("%.2f", rendimento) + " aplicado!");
        }
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("\n=== Extrato Conta Poupança ===");
        imprimirDadosBasicos();
        System.out.println("Taxa de Rendimento: " + String.format("%.1f", taxaRendimento * 100) + "% ao mês");
        super.imprimirExtrato();
    }

    public double getTaxaRendimento() {
        return taxaRendimento;
    }
}