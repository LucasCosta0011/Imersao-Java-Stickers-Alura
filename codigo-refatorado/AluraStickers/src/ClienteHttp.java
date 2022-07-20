import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;
// ALT + SHIFT + O  importa oq precisa de uma vez


public class ClienteHttp {
  public String buscaDados(String url){
    try{
      // classe de URL genérica
      URI endereco = URI.create(url);
      // Lib nativa do Java
      // quando o tipo é explícito podemos usar a palavra reservada var
      var client = HttpClient.newHttpClient();
      var request = HttpRequest.newBuilder(endereco).GET().build();
      // neste caso, poderiamos deixar o var, mas para um melhor legibilidade deixaremos o tipo explícito no próprio código
      // BodyHandlers classe cria maneiras de ler os dados  
      HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
      return response.body();
    }catch(IOException | InterruptedException ex){
      throw new RuntimeException(ex);
    }
  }

}
