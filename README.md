🏦 Banco Digital - Projeto Java POO
📋 Sobre o Projeto
Este é um sistema bancário desenvolvido em Java que aplica os conceitos de Programação Orientada a Objetos (POO) de forma prática e objetiva. O projeto simula operações bancárias básicas como saques, depósitos, transferências e investimentos, demonstrando como organizar código de maneira limpa e escalável.

🎯 Objetivo
Criar uma aplicação bancária que sirva como exemplo didático para entender os pilares da POO:

Abstração através de interfaces

Encapsulamento com atributos privados

Herança entre classes

Polimorfismo na execução dos métodos

🏗️ Estrutura do Projeto
Principais Classes
Conta (Classe Abstrata)
Classe base que define a estrutura comum para todas as contas, implementando a interface IConta:

java
// Exemplo de uso
ContaCorrente conta = new ContaCorrente(cliente);
conta.depositar(1000.00);
conta.sacar(200.00);
ContaCorrente
Limite de cheque especial

Operações bancárias do dia a dia

Saldo disponível incluindo o limite

ContaPoupanca
Rendimento mensal automático

Ideal para guardar dinheiro

Taxa de rendimento configurável

ContaInvestimento
Diferentes tipos de investimento (CDB, Tesouro Direto, Ações)

Taxas de rendimento variadas

Operações de aplicação específicas

IConta (Interface)
Define o contrato que todas as contas devem seguir:

java
public interface IConta {
    void sacar(double valor);
    void depositar(double valor);
    void transferir(double valor, IConta contaDestino);
    void imprimirExtrato();
}
Cliente
Gerencia as contas de cada cliente e fornece relatórios consolidados.

Banco
Controla o cadastro de clientes e fornece relatórios gerenciais.

Transacao
Registra o histórico completo de todas as operações realizadas.

💡 Conceitos de POO Aplicados
1. Abstração
A interface IConta define o que uma conta deve fazer, sem se preocupar com como cada tipo de conta implementa essas operações.

2. Encapsulamento
Todos os atributos são privados e o acesso é controlado através de métodos públicos:

java
// Atributos protegidos, acesso via métodos
private double saldo;
public double getSaldo() { return saldo; }
3. Herança
As classes específicas herdam da classe base Conta:

java
public class ContaCorrente extends Conta {
    // Herda todos os métodos e atributos de Conta
    // e adiciona comportamentos específicos
}
4. Polimorfismo
O mesmo método se comporta diferente em cada tipo de conta:

java
IConta conta1 = new ContaCorrente(cliente);
IConta conta2 = new ContaPoupanca(cliente);

// Mesmo método, comportamentos diferentes
conta1.imprimirExtrato(); // Mostra limite cheque especial
conta2.imprimirExtrato(); // Mostra taxa de rendimento

🚀 Como Executar
Pré-requisitos
Java JDK 8 ou superior

IDE de sua preferência (Eclipse, IntelliJ, VS Code)

Compilação e Execução
bash
# Compilar o projeto
javac -d bin src/desafio_dio_banco/*.java

# Executar a aplicação
java -cp bin desafio_dio_banco.Main
📊 Funcionalidades Implementadas
Operações Bancárias
✅ Abertura de contas (Corrente, Poupança, Investimento)

✅ Depósitos e saques

✅ Transferências entre contas

✅ Aplicação de rendimentos

✅ Investimentos em diferentes modalidades

Relatórios e Consultas
✅ Extrato detalhado por conta

✅ Listagem de todas as contas de um cliente

✅ Relatório gerencial do banco

✅ Histórico completo de transações

Controles
✅ Número sequencial automático para contas

✅ Validação de saldo para operações

✅ Registro de data e hora das transações

✅ Diferentes taxas por tipo de investimento

🎯 Exemplo de Uso
java
// Criando cliente e contas
Cliente joao = new Cliente("João Silva", "123.456.789-00");
ContaCorrente cc = new ContaCorrente(joao, 1000.00);
ContaInvestimento ci = new ContaInvestimento(joao, "CDB");

// Realizando operações
cc.depositar(2000.00);
cc.transferir(300.00, outraConta);
ci.investir(1000.00, "CDB 6 meses");

// Consultando informações
cc.imprimirExtrato();
joao.listarContas();

🔧 Possíveis Melhorias Futuras
Implementação de persistência em banco de dados

Interface gráfica para usuários

Sistema de autenticação e segurança

Operações em lote e relatórios avançados

Integração com sistemas de pagamento

📝 Aprendizados
Este projeto demonstra na prática como:

Organizar código em classes coesas

Utilizar interfaces para definir contratos

Aplicar os quatro pilares da POO

Criar hierarquias de classes eficientes

Manter o código limpo e de fácil manutenção

👨‍💻 Desenvolvido por
SimoneFrez - Como parte dos estudos em Java e Programação Orientada a Objetos.
