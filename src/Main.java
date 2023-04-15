import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        String caminho = "C:\\Users\\Hiago\\Desktop\\IFF\\4 Quarto periodo\\Estrutura de Dados\\ED_T2_ColoracaoVertices\\ED-T2-ColoracaoVertices\\grafo.txt";
        FileReader reader = new FileReader(caminho);
        BufferedReader bReader = new BufferedReader(reader);

        String[] linha1 = bReader.readLine().split(" ");

        int nVertices = Integer.parseInt(linha1[0]);
        int nArestas = Integer.parseInt(linha1[1]);

        List<int[]> vertices = new ArrayList<int[]>();

        for(int i = 0; i < nVertices; i++) {
            String[] linha = bReader.readLine().split(" ");
            int[] arestasDoVertice = new int[nVertices];
            for(int j = 0; j < nVertices; j++) {
                if (linha[j].equalsIgnoreCase("1")) {
                    arestasDoVertice[j] = j+1;
                }
            }
            vertices.add(arestasDoVertice);
        }


        mostrarVerticesESuasArestas(vertices, nVertices);

        System.out.print("\u001B[31m teste red" );
    }

    public static void mostrarVerticesESuasArestas(List<int[]> vertices, int n) {
        for(int i = 0; i < n; i++) {
            System.out.print("Vertice " + Integer.toString(i+1) + ": ");
            for(int j = 0; j < n; j++) {
                if(vertices.get(i)[j] != 0) {
                    System.out.print(vertices.get(i)[j] + " ");
                }

            }
            System.out.print("\n");

        }
    }
}