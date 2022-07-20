import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        // fazer uma conexão HTTP (Protocolo de comunicação da web)
        // buscar os filmes e extrair, parsiar, pegar o que realmente interessa
        // titulo, poster, classificação
        // exibir e manipular os dados 

        String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-16&end_date=2022-06-18";
        ExtratorConteudo extrator = new ExtratorConteudoNasa();

        var http = new ClienteHttp();
        String json = http.buscaDados(url);
        
        //System.out.println(listaDeFilmes.size());
        //System.out.println(listaDeFilmes.get(0));
        
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var geradorFigurinha = new GeradorFigurinhas();

        /*
        for (Map<String,String> filme : listaDeFilmes) {
            //System.out.println("\u001B[44m \u001b[1m" + filme.get("title") + "\u001B[0m");

            String titulo = filme.get("title");
            String urlImagem = filme.get("image");
            
            //TerminalColorido txtColorido = new TerminalColorido();

            InputStream inputStream = new URL(urlImagem).openStream();
            String nomeArquivo = titulo + ".png";
            
            String estado = "";

            switch (filme.get("imDbRating")) {
                case "8.7":
                System.out.println("\u001B[33m \u001b[1m" + " * * * ");
                estado = "reprovado";
                    break;
                case "8.8":
                System.out.println("\u001B[33m \u001b[1m" + " * * * * ");
                estado = "reprovado";
                    break;
                case "8.9":
                System.out.println("\u001B[33m\u001b[1m" + " * * * * ");
                estado = "reprovado";
                    break;
                case "9.0":
                System.out.println("\u001B[33m \u001b[1m" + " * * * * * ");
                estado = "aprovado";
                    break;
                default:
                    break;
            }
            geradorFigurinha.criarFigurinhas(inputStream, nomeArquivo, estado);

            System.out.println(titulo + filme.get("imDbRating"));
            System.out.println();
            
            //System.out.println(filme.get("imDbRating") + "[char]::ConvertFromUtf32(0x2B50)");
        }
        */

        for(int i = 0; i < 3; i++){

            Conteudo conteudo = conteudos.get(i);
        
            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();

            String nomeArquivo = conteudo.getTitulo() + ".png";

            geradorFigurinha.criarFigurinhas(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitulo());
            System.out.println();

        }
    }
}
