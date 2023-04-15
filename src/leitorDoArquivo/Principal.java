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
		
		List<Vertice> verticesDoGrafo = criarListaDeVerticesDoGrafo(nVertices);
		
		for(Vertice verticeAtual : verticesDoGrafo) {
			String[] linha = bReader.readLine().split(" ");
			for(int i = 0; i < linha.length; i++) {
				if(linha[i].equalsIgnoreCase("1")) {
					verticeAtual.adicionarVerticeAdjacente(verticesDoGrafo.get(i));
				}
			}
		}
		
		for(Vertice verticeAtual : verticesDoGrafo) {
			coloreVertice(verticeAtual);
		}
		
		mostrarVerticesESuasArestas(verticesDoGrafo, nVertices);
		reader.close();
		bReader.close();
	}
	
	public static List<Vertice> criarListaDeVerticesDoGrafo(int quantidadeDeVertices){
		List<Vertice> verticesDoGrafo = new ArrayList<Vertice>();
		for(int i = 1; i <= quantidadeDeVertices; i++ ) {
			verticesDoGrafo.add(new Vertice(i));
		}
		return verticesDoGrafo;
	}
	
	public static Vertice escolherVerticeDeMaiorGrau(List<Vertice> verticesDoGrafo) {
		Vertice VerticeDeAtualMaiorGrau = verticesDoGrafo.get(0);
		for(Vertice verticeAtual : verticesDoGrafo) {
			if(verticeAtual.getVerticesAdjacentes().size() > VerticeDeAtualMaiorGrau.getVerticesAdjacentes().size()) {
				VerticeDeAtualMaiorGrau = verticeAtual;
			}
		}
		return VerticeDeAtualMaiorGrau;
	}
	
	
	
	public static void coloreVertice(Vertice verticeASerColorido) {
		if (verticeASerColorido.getCor() == 0) {
			List<Vertice> verticesAdjacentesDoVerticeASerColorido = verticeASerColorido.getVerticesAdjacentes();
			int corDisponivel = 1;
			for(;corDisponivel <= verticesAdjacentesDoVerticeASerColorido.size(); corDisponivel++) {
				for(Vertice verticeAtual : verticesAdjacentesDoVerticeASerColorido) {
					if(verticeAtual.getCor() == corDisponivel) {
					}
					else {
						verticeASerColorido.setCor(corDisponivel);
					}
				}
			}
		
		}
	}
	
	public static void mostrarVerticesESuasArestas(List<Vertice> verticesDoGrafo, int n) {
		
		/*
		for(int i = 0; i < n; i++) {
			Vertice verticeAtual = verticesDoGrafo.get(i);
			System.out.print(getColor(i+1));
			System.out.print("Vertice " + Integer.toString(verticeAtual.getNumero()) + ": " + getColor(0));
			for(int j = 0; j < verticeAtual.getVerticesAdjacentes().size(); j++) {
				System.out.print(getColor(verticeAtual.getVerticesAdjacentes().get(j).getNumero()));
				System.out.print(verticeAtual.getVerticesAdjacentes().get(j).getNumero() + " " + getColor(0));
			}
			System.out.print("\n");
		}
		*/
		
		for(Vertice verticeAtual : verticesDoGrafo) {
			System.out.print(getColor(verticeAtual.getCor()) + "Vertice " + verticeAtual.getNumero() + ": " + getColor(0));
			for(Vertice verticeAdjacente : verticeAtual.getVerticesAdjacentes()) {
				System.out.print(getColor(verticeAdjacente.getCor()) + verticeAdjacente.getNumero() + " ");
			}
			System.out.println();
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
            case 1:
                return  ANSI_GREEN; // green
            case 2:
                return ANSI_CYAN;
            case 3:
                return ANSI_PURPLE;
            case 4:
                return ANSI_YELLOW;
            case 5:
            	return ANSI_RED;
            case 6:
            	return ANSI_BLUE;
            case 7:
            	return ANSI_BLACK;
            case 8:
            	return ANSI_WHITE;
            default:
                return ANSI_RESET;
        }
    }
}