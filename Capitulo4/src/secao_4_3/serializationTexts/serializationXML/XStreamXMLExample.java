package secao_4_3.serializationTexts.serializationXML;
//importa��es
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

import secao_4_2.entidades.Pessoa;

public class XStreamXMLExample {
	public static void main(String[] args) throws IOException {
		
		// Cria��o de uma inst�ncia da classe 'Pessoa'
		Pessoa pessoa = new Pessoa("Antonio", 123456789, 15);
		// Chama a fun��o 'Object2XML' para serializar a inst�ncia 'pessoa' em XML
		Object2XML(pessoa);
		//poe um enter pra ter um espa�o
		System.out.println();
		// Chama a fun��o 'XML2Object' para desserializar XML em um objeto 'Pessoa'
		XML2Object();
	}

	// Fun��o para desserializar XML em um objeto 'Pessoa'
	private static void XML2Object() throws IOException {
		
		// Cria��o de uma inst�ncia do XStream
		XStream instream = new XStream();

		// Cria��o de um leitor de arquivo para ler o arquivo "pessoa.xml"
		BufferedReader br = new BufferedReader(new FileReader("pessoa.xml"));
		// Cria��o de um buffer para armazenar o conte�do lido do arquivo
		StringBuffer buff = new StringBuffer();
		String line;
		// L� o conte�do do arquivo linha por linha e o armazena no buffer
		while((line = br.readLine()) != null){
		   buff.append(line);
		}
		
		// Define um alias "Pessoa" para a classe 'Pessoa'
		instream.alias("Pessoa", secao_4_2.entidades.Pessoa.class);
		// Adiciona permiss�o para converter qualquer tipo de objeto durante a desserializa��o
		instream.addPermission(AnyTypePermission.ANY);
		
		// Desserializa o XML do buffer em um objeto 'Pessoa'
		Pessoa p = (Pessoa)instream.fromXML(buff.toString());
		// Exibe os dados da pessoa no console
		System.out.println("Nome: "+p.getNome());
		System.out.println("CPF: "+p.getCpf());
		System.out.println("idade: "+p.getIdade());
	}
	
	// Fun��o para serializar um objeto 'Pessoa' em XML e grav�-lo em um arquivo
	private static void Object2XML(Pessoa pessoa) throws IOException {
		// Cria��o de uma inst�ncia do XStream
		XStream xstream = new XStream();
		// Define um alias "Pessoa" para a classe 'Pessoa'
		xstream.alias("Pessoa", Pessoa.class);
		// Converte o objeto 'pessoa' em uma representa��o XML
		String xml = xstream.toXML(pessoa);
		// Exibe o XML gerado no console
		System.out.println(xml);
		// Cria��o de um escritor de arquivo para gravar o XML em um arquivo chamado "pessoa.xml"
		FileWriter gravar = new FileWriter("pessoa.xml");
		try {
		    BufferedWriter s = new BufferedWriter(gravar);
		    // Escreve o XML no arquivo
		    s.write(xml);
		    s.flush();
		    s.close();		
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		    gravar.close();
		}
	}
}
