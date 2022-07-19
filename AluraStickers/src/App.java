import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        // fazer uma conexão HTTP (Protocolo de comunicação da web)
        // buscar os filmes e extrair, parsiar, pegar o que realmente interessa
        // titulo, poster, classificação
        // exibir e manipular os dados 

        String url = "https://api.mocki.io/v2/549a5d8b";
        // classe de URL genérica
        URI endereco = URI.create(url);
        // Lib nativa do Java
        // quando o tipo é explícito podemos usar a palavra reservada var
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        // neste caso, poderiamos deixar o var, mas para um melhor legibilidade deixaremos o tipo explícito no próprio código
        // BodyHandlers classe cria maneiras de ler os dados  
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        JsonParser parser = new JsonParser();
        // jackson parser json java lib pronta

        // extraindo com expressões regulares
        // criando um lista com chave e valor
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        //System.out.println(listaDeFilmes.size());
        //System.out.println(listaDeFilmes.get(0));

        for (Map<String,String> filme : listaDeFilmes) {
            System.out.println("\u001B[44m \u001b[1m" + filme.get("title") + "\u001B[0m");
            System.out.println("\u001B[34m \u001b[1m" + filme.get("image") + "\u001B[0m");
            
            //TerminalColorido txtColorido = new TerminalColorido();

            switch (filme.get("imDbRating")) {
                case "1.0":
                System.out.println("\u001B[33m \u001b[1m" + " * ");
                    break;
                case "2.0":
                System.out.println("\u001B[33m \u001b[1m" + " * ");
                    break;
                case "3.0":
                System.out.println("\u001B[33m \u001b[1m" + " * * ");
                    break;
                case "4.0":
                System.out.println("\u001B[33m \u001b[1m" + " * * ");
                    break;
                case "5.0":
                System.out.println("\u001B[33m \u001b[1m" + " * * * ");
                    break;
                case "6.0":
                System.out.println("\u001B[33m \u001b[1m" + " * * * ");
                    break;
                case "7.0":
                System.out.println("\u001B[33m \u001b[1m" + " * * * * ");
                    break;
                    case "8.0":
                System.out.println("\u001B[33m\u001b[1m" + " * * * * ");
                    break;
                    case "9.0":
                System.out.println("\u001B[33m \u001b[1m" + " * * * * * ");
                    break;
                default:
                    break;
            }
            //System.out.println(filme.get("imDbRating") + "[char]::ConvertFromUtf32(0x2B50)");

            

        }
    }
}
