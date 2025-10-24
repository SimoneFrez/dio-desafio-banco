package desafio_dio_banco;

public class ContaInvestimento extends Conta {
    private String tipoInvestimento;
    private double taxaRendimento;

    public ContaInvestimento(Cliente cliente, String tipoInvestimento) {
        super(cliente);
        this.tipoInvestimento = tipoInvestimento;
        
        switch(tipoInvestimento.toUpperCase()) {
            case "CDB":
                this.taxaRendimento = 0.008; // 0.8%
                break;
            case "TESOURO DIRETO":
                this.taxaRendimento = 0.009; // 0.9%
                break;
            case "AÇÕES":
                this.taxaRendimento = 0.012; // 1.2%
                break;
            default:
                this.taxaRendimento = 0.006; // 0.6%
        }
    }

    public void aplicarRendimento() {
        double rendimento = saldo * taxaRendimento;
        if (rendimento > 0) {
            saldo += rendimento;
            transacoes.add(new Transacao("RENDIMENTO", rendimento, 
                "Rendimento " + tipoInvestimento));
            System.out.println("Rendimento de R$ " + String.format("%.2f", rendimento) + " aplicado!");
        }
    }

    public void investir(double valor, String descricaoInvestimento) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            transacoes.add(new Transacao("INVESTIMENTO", valor, 
                "Aplicação em " + descricaoInvestimento));
            System.out.println("Investimento de R$ " + valor + " em " + descricaoInvestimento + " realizado!");
        } else {
            System.out.println("Saldo insuficiente para investir!");
        }
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("\n=== Extrato Conta Investimento ===");
        imprimirDadosBasicos();
        System.out.println("Tipo de Investimento: " + tipoInvestimento);
        System.out.println("Taxa de Rendimento: " + String.format("%.1f", taxaRendimento * 100) + "% ao mês");
        super.imprimirExtrato();
    }

    public String getTipoInvestimento() {
        return tipoInvestimento;
    }

    public double getTaxaRendimento() {
        return taxaRendimento;
    }
}