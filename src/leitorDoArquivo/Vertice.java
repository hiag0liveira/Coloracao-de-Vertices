package leitorDoArquivo;

import java.util.ArrayList;

public class Vertice {
	
	private int numero;
	
	private ArrayList<Integer> numeroDosVerticesAdjacentes;
	
	private String cor = "";
	
	public Vertice(int numero) {
		this.numeroDosVerticesAdjacentes = new ArrayList<Integer>();
		this.numero = numero;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public ArrayList<Integer> getVerticesAdjacentes() {
		return this.numeroDosVerticesAdjacentes;
	}

	public void adicionarVerticeAdjacente(Integer numeroDoVertice) {
		this.numeroDosVerticesAdjacentes.add(numeroDoVertice);
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	
	

}
