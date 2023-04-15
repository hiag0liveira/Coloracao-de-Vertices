package leitorDoArquivo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Principal {

	public static void main(String[] args) throws IOException {
		
		String caminho = "C:\\Users\\the_b\\eclipse-workspace\\ColoracaoDeVertices\\src\\leitorDoArquivo\\teste.txt";
		FileReader reader = new FileReader(caminho);
		BufferedReader bReader = new BufferedReader(reader);
		
		String[] linha1 = bReader.readLine().split(" ");
		
		int nVertices = Integer.parseInt(linha1[0]);
		int nArestas = Integer.parseInt(linha1[1]);
		
		List<Vertice> verticesDoGrafo = new ArrayList<Vertice>(); // Lista com todos os vertices do grafo
		
		Vertice verticeAtual; // Variavel que será usada para armazer cada vertice em cada iteracao
		for(int i = 0; i < nVertices; i++) {
			String[] linha = bReader.readLine().split(" ");
			verticeAtual = new Vertice(i+1); // criando o vertice atual e definindo qual vai ser o seu numero
			for(int j = 0; j < nVertices; j++) { // verifica cada posicao da linha lida
				if (linha[j].equalsIgnoreCase("1")) { // verifica se o caractere na posicao atual e igual a um, se for, ele adiciona 
													  // aquela posicao na lista de vertices do vertice atual 
					verticeAtual.adicionarVerticeAdjacente(j+1);
				}
			}
			verticesDoGrafo.add(verticeAtual); // no fim, adiciona o vertice em questao a lista de vertices do grafo
		}
		
		
		mostrarVerticesESuasArestas(verticesDoGrafo, nVertices);
	}
	
	public static void mostrarVerticesESuasArestas(List<Vertice> verticesDoGrafo, int n) {
		for(int i = 0; i < n; i++) {
			Vertice verticeAtual = verticesDoGrafo.get(i);
			System.out.print(getColor(i));
			System.out.print("Vertice " + Integer.toString(verticeAtual.getNumero()) + ": ");
			System.out.print(getColor(5));
			for(int j = 0; j < verticeAtual.getVerticesAdjacentes().size(); j++) {
				System.out.print(getColor(j));
				System.out.print(verticeAtual.getVerticesAdjacentes().get(j) + " ");
				System.out.print(getColor(5));
			}
			System.out.print("\n");
		}
	}
	
	private static String getColor(int i) {
		
		String ANSI_RESET = "\u001B[0m";
	    String ANSI_BLACK = "\u001B[30m";
	    String ANSI_RED = "\u001B[31m";
	    String ANSI_GREEN = "\u001B[32m";
	    String ANSI_YELLOW = "\u001B[33m";
	    String ANSI_BLUE = "\u001B[34m";
	    String ANSI_PURPLE = "\u001B[35m";
	    String ANSI_CYAN = "\u001B[36m";
	    String ANSI_WHITE = "\u001B[37m";
		
        switch (i) {
            case 0:
                return ANSI_BLUE;
            case 1:
                return  ANSI_GREEN;
            case 2:
                return ANSI_CYAN;
            case 3:
                return ANSI_PURPLE;
            case 4:
                return ANSI_YELLOW;
            case 5:
            	return ANSI_RED;
            case 6:
            	return ANSI_BLACK;
            case 7:
            	return ANSI_WHITE;
            default:
                return ANSI_RESET;
        }
    }
}
