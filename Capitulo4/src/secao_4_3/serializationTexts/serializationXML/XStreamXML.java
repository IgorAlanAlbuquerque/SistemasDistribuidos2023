package secao_4_3.serializationTexts.serializationXML;
//Importa��es
import com.thoughtworks.xstream.XStream;
import secao_4_2.entidades.Pessoa;

public class XStreamXML {

   public static void main(String args[]) {
         // Criando uma inst�ncia da classe 'Pessoa'
         Pessoa pessoa = new Pessoa("Antonio Rafael Braga", 70, 180);
         // Exibindo uma representa��o XML da inst�ncia 'pessoa' usando XStream
         XStream xstream= new XStream();
         // Convertendo o objeto 'pessoa' em uma representa��o XML
         String representacao = xstream.toXML(pessoa);
         // Exibindo a representa��o XML no console
         System.out.println(representacao);
         
         // Criando uma segunda inst�ncia do XStream para desserializa��o
         XStream xstream2 = new XStream();
         // Desserializando a representa��o XML de volta para um objeto 'Pessoa'
         Pessoa pessoa2 = (Pessoa) xstream2.fromXML(representacao);
         // Exibindo o nome da pessoa2 no console
         System.out.println(pessoa2.getNome());
     }
}