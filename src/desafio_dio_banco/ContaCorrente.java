package desafio_dio_banco;


public class ContaCorrente extends Conta {
    private double limiteChequeEspecial;

    public ContaCorrente(Cliente cliente) {
        super(cliente);
        this.limiteChequeEspecial = 500.0;
    }

    public ContaCorrente(Cliente cliente, double limiteChequeEspecial) {
        super(cliente);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    @Override
    public void sacar(double valor) {
        if (valor > 0 && valor <= (saldo + limiteChequeEspecial)) {
            saldo -= valor;
            transacoes.add(new Transacao("SAQUE", valor, "Saque com cheque especial"));
        } else {
            System.out.println("Limite insuficiente incluso cheque especial!");
        }
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("\n=== Extrato Conta Corrente ===");
        imprimirDadosBasicos();
        System.out.println("Limite Cheque Especial: R$ " + String.format("%.2f", limiteChequeEspecial));
        System.out.println("Saldo Disponível: R$ " + String.format("%.2f", saldo + limiteChequeEspecial));
        super.imprimirExtrato();
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public void setLimiteChequeEspecial(double novoLimite) {
        this.limiteChequeEspecial = novoLimite;
    }
}