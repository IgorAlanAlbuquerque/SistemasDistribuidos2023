package secao_4_2.streams;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import secao_4_2.entidades.Pessoa;

public class PessoasInputStream extends InputStream {

	private InputStream is;
	private Pessoa[] pessoas;
	
	public PessoasInputStream(Pessoa[] p, InputStream is) {
		this.pessoas = p;
		this.is = is;
	}

	public Pessoa[] readSystem() {
       
        Scanner sc = new Scanner(is);
        
		System.out.println("Informa o nome da pessoa:"); 
		String nome = sc.nextLine();
		System.out.println("Informe o cpf da pessoa:"); 
		double cpf = sc.nextDouble();
		System.out.println("Informe a idade do pessoa:"); 
		int idade = sc.nextInt();
		
		pessoas[0] = new Pessoa(nome, cpf, idade);
		
		sc.close();
		
		return pessoas;
	}
	
	public Pessoa[] readFile() {
		
		return pessoas;
	}
	
	public Pessoa[] readTCP() {
		
		return pessoas;
	}

	@Override
	public int read() throws IOException {
		
		return 0;
	}

}
