package secao_4_2.streams;

import java.io.IOException;

import secao_4_2.entidades.Pessoa;

public class TestStreams {
	public static void main(String[] args) throws IOException {

		Pessoa[] pessoas = new Pessoa[1];
		PessoasInputStream pis = new PessoasInputStream(pessoas, System.in);
		pessoas = pis.readSystem();
		pis.close();        
		
		PessoasOutputStream pos = new PessoasOutputStream(pessoas, System.out);
		pos.writeSystem();
		pos.close();
	}
}
