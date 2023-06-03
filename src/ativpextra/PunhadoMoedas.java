package ativpextra;

import java.io.Serializable;

public class PunhadoMoedas implements Serializable {
	// valores admitidos para as moedas
	public static final double[] valoresPossiveis = {0.05, 0.10, 0.25, 0.50, 0.75, 1};
	// valor de cada moeda (algum dos valores definidos em constante est�tica anterior)
	private double valor;
	// quantidade de moedas
	private int quantidade;
	// construtor (com valida��o de valor das moedas)
	public PunhadoMoedas(double valor, int quantidade) {
	// flag para identificar se valor indicado para as moedas � v�lido
	boolean valorValido = false;
	// itera��o entre os valores admitidos para as moedas
	for (int i = 0; i < valoresPossiveis.length; i++)
	// se en�simo valor admitido corresponder ao valor indicado...
	if (valor == valoresPossiveis[i]) {
	valorValido = true; // atualiza��o de flag (valor indicado � v�lido)
	break; // encerramento de bloco de valida��o de vaor
	}
	// inicializa��o de campos de inst�ncia com valores indicados
	// se valor indicado para a moeda (na forma de par�metro do construtor) for v�lido
	if (valorValido) {
	this.valor = valor;
	this.quantidade = quantidade;
	}
	// inicializa��o de campos de inst�ncia com valores padr�es se valor indicado
	// para a moeda (na forma de par�metro do construtor) n�o for v�lido
	else {
	this.valor = 0;
	this.quantidade = 0;
	}
	}
	// retorno de valor de cada moeda
	public double getValor() {
	return valor;
	}
	// retorno de quantidade de moedas
	public int getQuantidade() {
	return quantidade;
	}
	// retorno de valor total do punhado de moedas
	public double getTotalPunhado() {
	return valor * quantidade;
	}
	}
