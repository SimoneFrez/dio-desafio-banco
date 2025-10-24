package desafio_dio_banco;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transacao {
    private LocalDateTime dataHora;
    private String tipo;
    private double valor;
    private String descricao;

    public Transacao(String tipo, double valor, String descricao) {
        this.dataHora = LocalDateTime.now();
        this.tipo = tipo;
        this.valor = valor;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return String.format("%s | %-15s | R$ %8.2f | %s", 
            dataHora.format(formatador), tipo, valor, descricao);
    }


    public LocalDateTime getDataHora() {
    	return dataHora; 
    	}
    public String getTipo() {
    	return tipo; 
    	}
    public double getValor() {
    	return valor; 
    	}
    public String getDescricao() {
    	return descricao; 
    	}
}