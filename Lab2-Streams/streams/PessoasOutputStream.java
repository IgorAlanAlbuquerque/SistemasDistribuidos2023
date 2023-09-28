package streams;

import java.io.*;
import java.net.*;

import entidades.Pessoa;

public class PessoasOutputStream extends OutputStream {
	
	private OutputStream op;
	private Pessoa[] pessoas; //mesma coisa de antes
	
	public PessoasOutputStream() {}
	
	public PessoasOutputStream(Pessoa[] p, OutputStream os) { //construtor de novo
		this.pessoas = p;
		this.op = os;
	}

	public void writeSystem() { //esse método printa os dados dos objetos que estão no vertor pessoas
		
		PrintStream opLocal = new PrintStream(op);
		
		//envia quantidade de pessoas;
		int qtdpessoa = pessoas.length;
		opLocal.println("Quantidade de pessoas: "+qtdpessoa);
		
		//envia os dados de um conjunto (array) de Pessoas
		for (Pessoa pessoa : pessoas) {
			if (pessoa != null) {
				int tamanhoNomePessoa = pessoa.getNome().getBytes().length;
				String nome = pessoa.getNome();
				double cpf = pessoa.getCpf();
				int idade = pessoa.getIdade();
							
				opLocal.println(" tamanhoNomePessoa: "+tamanhoNomePessoa+ "\n"+
								" nomePessoa: "+nome+ "\n"+
								" cpf: "+cpf+ "\n"+
								" idade: "+idade);
			}
		}
	}

	public void writeFile() { //suponho pelo nome que é pra salvar os dados de pessoa em um arquivo
		// envia os dados de um conjunto (array) de Pessoas
	}
	
	public void writeTCP() { //envia os dados do array pessoas via TCP para algum lugar
		int porta = 7888; //porta do servidor que vai receber
		Socket s;
		try {
			s = new Socket("localhost",porta); //criando o socket 
			ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream()); //criando objeto de envio
			for(Pessoa pessoa : pessoas) { //enviando cada um dos objetos de pessoa
				out.writeObject(pessoa);
			}
			out.writeObject(null);  //sinalizando o fim do envio
			out.close();
			s.close(); //fechado a conexão
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //criando socket	
	}		
	
	@Override
	public void write(int b) throws IOException {
		// TODO Auto-generated method stub
	}

	@Override
	public String toString() { //esse é o metodo toString
		return "Ola, mundo! Estamos sobrescrevendo o mÃ©todo toString()!\n"
				+ " PessoasOutputStream [ \n"
				+ " getClass()=" + getClass() +",\n"
				+ " hashCode()=" + hashCode() +",\n"
				+ " toString()="+ super.toString() + "]";
	}
}

