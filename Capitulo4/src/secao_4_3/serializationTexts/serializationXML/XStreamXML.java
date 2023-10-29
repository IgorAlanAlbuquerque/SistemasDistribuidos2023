package secao_4_3.serializationTexts.serializationXML;
//Importações
import com.thoughtworks.xstream.XStream;
import secao_4_2.entidades.Pessoa;

public class XStreamXML {

   public static void main(String args[]) {
         // Criando uma instância da classe 'Pessoa'
         Pessoa pessoa = new Pessoa("Antonio Rafael Braga", 70, 180);
         // Exibindo uma representação XML da instância 'pessoa' usando XStream
         XStream xstream= new XStream();
         // Convertendo o objeto 'pessoa' em uma representação XML
         String representacao = xstream.toXML(pessoa);
         // Exibindo a representação XML no console
         System.out.println(representacao);
         
         // Criando uma segunda instância do XStream para desserialização
         XStream xstream2 = new XStream();
         // Desserializando a representação XML de volta para um objeto 'Pessoa'
         Pessoa pessoa2 = (Pessoa) xstream2.fromXML(representacao);
         // Exibindo o nome da pessoa2 no console
         System.out.println(pessoa2.getNome());
     }
}