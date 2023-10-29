package secao_4_3.serializationTexts.serializationJSON; // Importações necessárias para utilizar classes do XStream para serialização JSON

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import secao_4_2.entidades.Pessoa;

public class XStreamJSONExample {

	public static void main(String[] args) {

		// Cria uma instância da classe 'Pessoa'
        Pessoa pessoa = new Pessoa("Antonio", 123456789, 15);
        // Chama o método 'object2JSON' para serializar a instância 'pessoa' em JSON
        String xml  = new XStreamJSONExample().object2JSON(pessoa);
        // Exibe o JSON gerado no console
        System.out.println(xml);
        //JSON2Object(xml);
	}

	// Método para converter um objeto 'Pessoa' em JSON
	private String object2JSON(Pessoa pessoa) {
		// Cria uma instância do XStream configurado para gerar JSON usando o driver Jettison
		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		// Define que não devem ser incluídas referências aos objetos serializados
        xstream.setMode(XStream.NO_REFERENCES);
        // Define um alias "pessoa" para a classe 'Pessoa' para uso na serialização
        xstream.alias("pessoa", Pessoa.class);
        // Converte o objeto 'pessoa' em JSON (XML formatado como JSON)
		String xml = xstream.toXML(pessoa);
		//retorna o json criado
		return xml;
	}
	// Método para converter JSON em objeto 'Pessoa'
	private static void JSON2Object(String xml) {
		// Cria uma instância do XStream configurado para processar JSON usando o driver Jettison
		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		// Define um alias "Pessoa" para a classe 'Pessoa' do pacote 'secao_4_2.entidades'
		xstream.alias("Pessoa", secao_4_2.entidades.Pessoa.class);
		// Adiciona permissão para converter qualquer tipo de objeto durante a desserialização
		xstream.addPermission(AnyTypePermission.ANY);
		// Converte o JSON de volta para um objeto 'Pessoa'
		Pessoa pessoa = (Pessoa) xstream.fromXML(xml);
		//exibe o nome da pessoa no objeto 'pessoa'
		System.out.println(pessoa.getNome());		
	}
}