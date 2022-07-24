import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorConteudoIMDB implements ExtratorConteudo{
  public List<Conteudo> extraiConteudos (String json){
    
    JsonParser parser = new JsonParser();
    List<Map<String, String>> listaAtributos = parser.parse(json);
    List<Conteudo> conteudos = new ArrayList<>();
    
    // popular a lista
    for (Map<String, String> atributos : listaAtributos) {
      System.out.println(atributos.get("title"));
      String titulo = atributos.get("title");
      String urlImagem = atributos.get("image")
      .replaceAll("(@+)(.*).jpg$", "$l.jpg");
      System.out.println(atributos.get("ranking"));
      String ranking = atributos.get("ranking");
      
      
      var conteudo = new Conteudo(titulo, urlImagem, ranking);
      conteudos.add(conteudo);
    }
    return conteudos;
  }
}
