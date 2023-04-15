package leitorDoArquivo;

public class TesteDeCores {

	public static void main(String[] args) {
		String teste = "Ola mundo!";
		
		System.out.println("\u001B[30m"  + teste + "\u001B[0m" );
		
		
		
		System.out.println("\033[4;0;32m"  + teste + "\033[0m" );

	}

}
