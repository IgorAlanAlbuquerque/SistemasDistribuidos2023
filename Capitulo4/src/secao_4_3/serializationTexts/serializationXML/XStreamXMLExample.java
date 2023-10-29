package secao_4_3.serializationTexts.serializationXML;
//importações
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
		
		// Criação de uma instância da classe 'Pessoa'
		Pessoa pessoa = new Pessoa("Antonio", 123456789, 15);
		// Chama a função 'Object2XML' para serializar a instância 'pessoa' em XML
		Object2XML(pessoa);
		//poe um enter pra ter um espaço
		System.out.println();
		// Chama a função 'XML2Object' para desserializar XML em um objeto 'Pessoa'
		XML2Object();
	}

	// Função para desserializar XML em um objeto 'Pessoa'
	private static void XML2Object() throws IOException {
		
		// Criação de uma instância do XStream
		XStream instream = new XStream();

		// Criação de um leitor de arquivo para ler o arquivo "pessoa.xml"
		BufferedReader br = new BufferedReader(new FileReader("pessoa.xml"));
		// Criação de um buffer para armazenar o conteúdo lido do arquivo
		StringBuffer buff = new StringBuffer();
		String line;
		// Lê o conteúdo do arquivo linha por linha e o armazena no buffer
		while((line = br.readLine()) != null){
		   buff.append(line);
		}
		
		// Define um alias "Pessoa" para a classe 'Pessoa'
		instream.alias("Pessoa", secao_4_2.entidades.Pessoa.class);
		// Adiciona permissão para converter qualquer tipo de objeto durante a desserialização
		instream.addPermission(AnyTypePermission.ANY);
		
		// Desserializa o XML do buffer em um objeto 'Pessoa'
		Pessoa p = (Pessoa)instream.fromXML(buff.toString());
		// Exibe os dados da pessoa no console
		System.out.println("Nome: "+p.getNome());
		System.out.println("CPF: "+p.getCpf());
		System.out.println("idade: "+p.getIdade());
	}
	
	// Função para serializar um objeto 'Pessoa' em XML e gravá-lo em um arquivo
	private static void Object2XML(Pessoa pessoa) throws IOException {
		// Criação de uma instância do XStream
		XStream xstream = new XStream();
		// Define um alias "Pessoa" para a classe 'Pessoa'
		xstream.alias("Pessoa", Pessoa.class);
		// Converte o objeto 'pessoa' em uma representação XML
		String xml = xstream.toXML(pessoa);
		// Exibe o XML gerado no console
		System.out.println(xml);
		// Criação de um escritor de arquivo para gravar o XML em um arquivo chamado "pessoa.xml"
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
