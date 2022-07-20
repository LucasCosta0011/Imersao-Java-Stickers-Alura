import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorConteudoIMDB implements ExtratorConteudo{
  public List<Conteudo> extraiConteudos (String json){
    JsonParser parser = new JsonParser();
    // jackson parser json java lib pronta

    // extraindo com expressões regulares
    // criando um lista com chave e valor
    List<Map<String, String>> listaAtributos = parser.parse(json);

    // O List é uma abstração, lista genérica
    // e pode ser organizada na memória de diferentes maneiras
    List<Conteudo> conteudos = new ArrayList<>();

    // popular a lista
    for (Map<String, String> atributos : listaAtributos) {
      String titulo = atributos.get("title");
      String urlImagem = atributos.get("image")
      .replaceAll("(@+)(.*).jpg$", "$l.jpg");
      var conteudo = new Conteudo(titulo, urlImagem);
      conteudos.add(conteudo);
    }
    return conteudos;
  }
}
