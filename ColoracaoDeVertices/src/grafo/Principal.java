// Bruno Nascimento e Hiago de Oliveira 
package grafo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) throws IOException {

		Scanner teclado = new Scanner(System.in);
		String caminhoDoArquivo = "";

		System.out.println("Qual grafo gostaria de aplicar a coloração de vertice?\n"
				+ "1 = Grafo 1\n"
				+ "2 = Grafo 2\n"
				+ "3 = Grafo 3");
		int escolha = teclado.nextInt();

		switch(escolha){
			case 1:
				caminhoDoArquivo = "..\\ColoracaoDeVertices\\src\\grafo\\grafo.txt";
				break;
			case 2:
				caminhoDoArquivo = "..\\ColoracaoDeVertices\\src\\grafo\\grafo2.txt";
				break;

			case 3:
				caminhoDoArquivo = "..\\ColoracaoDeVertices\\src\\grafo\\grafo3.txt";
				break;

			default:
				System.out.println("Opção inválida!!!");
				System.exit(0);
				break;

		}

		System.out.println("\n");

		FileReader reader = new FileReader(caminhoDoArquivo);
		BufferedReader bReader = new BufferedReader(reader); // Le o arquivo com a grafo e o armazena em memoria
		
		String[] linha1 = bReader.readLine().split(" "); // le a primeira linha do arquivo
		
		int nVertices = Integer.parseInt(linha1[0]); // armezena as n vertices do grafo
		int nArestas = Integer.parseInt(linha1[1]); // armezena as n arestas do grafo
		
		List<Vertice> verticesDoGrafo = criarListaDeVerticesDoGrafo(nVertices); // faz a criacao da lista que representa todas as vertices do grafo
		
		for(Vertice verticeAtual : verticesDoGrafo) { // Laco responsavel por verificar os vertices adjacentes de cada vertice onde, para cada vertice do grafo, uma linha da matriz será lida,adicionando os vertices adjacentes na lista de vertices adjacentes dovertice atual.

			String[] linha = bReader.readLine().split(" "); // Separa a linha lida por ' '
			for(int i = 0; i < linha.length; i++) {
				if(linha[i].equalsIgnoreCase("1")) { // Verifica se a posicao i da linha lida é igual a 1 o que significa que o vertice atual é adjacente ao vertice na posicao i

					verticeAtual.adicionarVerticeAdjacente(verticesDoGrafo.get(i)); // Adiciona o vertice i na lista de vertices adjacentes do vertice atual
				}
			}
		}
		
		for(Vertice verticeAtual : verticesDoGrafo) { // Laco destinado a colorir cada vertice presente no grafo
			coloreVertice(verticeAtual);
		}
		
		mostrarVerticesESuasArestas(verticesDoGrafo, nVertices); // Funcao determinada a mostrar na tela, na forma de listas de adjacencias cada vertice com os seus devidos vertices adjacentes.
		reader.close(); 
		bReader.close();
	}
	
	public static List<Vertice> criarListaDeVerticesDoGrafo(int quantidadeDeVertices){ // Funcao destinada a criar a lista que ira conter todos os vertices do grafo
		List<Vertice> verticesDoGrafo = new ArrayList<Vertice>();
		for(int i = 1; i <= quantidadeDeVertices; i++ ) {    // Adiciona verticees na lista de acordo com a quantidade de vertices informada
			verticesDoGrafo.add(new Vertice(i));
		}
		return verticesDoGrafo;  // Por fim, retorna a lista com todos os vertices.
	}
	
	public static void coloreVertice(Vertice verticeASerColorido) {  // Funcao destinada a colorir um vertice
		
		if (verticeASerColorido.getCor() == 0) {   // verifica se o vertice em questao ja nao possui uma cor atribuida pois caso ja possua, nao sera necessario fazer sua coloracao
			
			List<Vertice> verticesAdjacentesDoVerticeASerColorido = verticeASerColorido.getVerticesAdjacentes(); // guarda a lista de vertices de vertices adjacentes ao vertice a ser colorido em uma variavel
			int corDisponivel = 1;  // Assume que a cor disponivel é a cor numero 1
			
			for(Vertice verticeAtual : verticesAdjacentesDoVerticeASerColorido) { // laco responsavel por verificar se a cor de cada 
																				  // vertice adjacente ao vertice atual é igual a cor que foi assumida
																				  // como disponivel
				if(verticeAtual.getCor() == corDisponivel) {
					corDisponivel++;    // caso a cor assumida como disponivel seja igual a cor de um vertice adjacente significa que a cor assumida como disponivel não esta disponivel entao assumimos que a cor disponivel é a cor de numero seguinte e continuamos a verificacao
				}
			}
			verticeASerColorido.setCor(corDisponivel);   // Por fim, a cor resultante da verificacao é atribuida ao vertice em questao
		}
	}
	
	public static void mostrarVerticesESuasArestas(List<Vertice> verticesDoGrafo, int n) {  // Funcao responsavel por mostrar no terminal cada vertice com seus respectivos vertices adjacentes
		
		for(Vertice verticeAtual : verticesDoGrafo) { // Laco responsavel por passar por cada vertice existente na lista de vertices do grafo
			
			System.out.print(getColor(verticeAtual.getCor()) + "Vertice " + verticeAtual.getNumero() + ": " + getColor(0)); // Mosta o numero do vertice atual com a sua respectiva cor
			
			for(Vertice verticeAdjacente : verticeAtual.getVerticesAdjacentes()) {  // Laco responsavel por passar por cada vertice adjacente ao vertice atual
				
				System.out.print(getColor(verticeAdjacente.getCor()) + verticeAdjacente.getNumero() + " "); // Mostra na tela o numero do vertice adjacente com a sua respectiva cor
			}
			System.out.println(); // Pula uma linha para comecar uma nova iteracao com outro vertice
		}
	}
	
	private static String getColor(int i) {  // fucao responsavel por alterar a cor da saída do terminal de acordo com o numero inteiro i
		
		String ANSI_RESET = "\u001B[0m";  // O reset nao serve para atribuir uma cor especifica, serve para resetar a cor de saida do terminal para a cor padrão do terminal apos sua cor ser alterada
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
