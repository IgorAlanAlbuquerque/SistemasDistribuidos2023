package secao_4_2.streams;

import java.io.*;
import java.net.*;
import java.util.Scanner;

import secao_4_2.entidades.Pessoa;

public class PessoasInputStream extends InputStream {

	private InputStream is; 
	private Pessoa[] pessoas; //array de pessoas
	
	public PessoasInputStream(Pessoa[] p, InputStream is) { //construtor da classe que recebe um array e um inputstream
		this.pessoas = p;
		this.is = is;
	}

	public Pessoa[] readSystem() { //metodo para ler uma pessoa do teclado
       
        Scanner sc = new Scanner(is);
        
		System.out.println("Informa o nome da pessoa:"); 
		String nome = sc.nextLine(); //lendo o nome
		System.out.println("Informe o cpf da pessoa:"); 
		double cpf = sc.nextDouble(); //lendo o CPF
		System.out.println("Informe a idade do pessoa:"); 
		int idade = sc.nextInt(); //lendo idade
		
		pessoas[0] = new Pessoa(nome, cpf, idade); //cria a pessoa e adiciona no vetor
		
		sc.close();
		
		return pessoas; //retornando a pessoa lida
	}
	
	public Pessoa[] readFile() { //suponho pelo nome que esse m�todo � pra ler uma pessoa atrav�s de um arquivo
		
		return pessoas;
	}
	
	public Pessoa[] readTCP() throws ClassNotFoundException { //lendo a pessoa via TCP
		int serverPort = 7888; //porta no servidor
		try {
			Socket s = new Socket("localhost",serverPort); //criando o socket
			ObjectInputStream in = new ObjectInputStream(s.getInputStream()); //criado o objeto para leitura
			Pessoa pessoa = (Pessoa) in.readObject(); //lendo a string recebida via socket
			s.close(); //fechando o socket
			pessoas[0] = pessoa; //adiciona ao array
		} catch (UnknownHostException e) {
			// 
			e.printStackTrace();
		} catch (IOException e) {
			// 
			e.printStackTrace();
		}
		
		return pessoas; //retorna o array pessoas
	}

	@Override
	public int read() throws IOException {
		// 
		return 0;
	}


}
