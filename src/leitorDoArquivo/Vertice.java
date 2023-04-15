package leitorDoArquivo;

import java.util.ArrayList;

public class Vertice {
	
	private int numero;
	
	private ArrayList<Vertice> numeroDosVerticesAdjacentes;
	
	private int cor = 0;
	
	public Vertice(int numero) {
		this.numeroDosVerticesAdjacentes = new ArrayList<Vertice>();
		this.numero = numero;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public ArrayList<Vertice> getVerticesAdjacentes() {
		return this.numeroDosVerticesAdjacentes;
	}

	public void adicionarVerticeAdjacente(Vertice numeroDoVertice) {
		this.numeroDosVerticesAdjacentes.add(numeroDoVertice);
	}

	public int getCor() {
		return cor;
	}

	public void setCor(int cor) {
		this.cor = cor;
	}
}
