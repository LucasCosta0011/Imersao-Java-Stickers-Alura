import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        String url = "https://alura-linguagem-api.herokuapp.com/Linguagens";
        var extrator = new ExtratorConteudoIMDB();

        var http = new ClienteHttp();
        String json = http.buscaDados(url);
        
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var geradorFigurinha = new GeradorFigurinhas();
        
        for(int i = 0; i < 4; i++){

            Conteudo conteudo = conteudos.get(i);

            String estado = "";
            int rank; //= Integer.parseInt(conteudo.getRanking());
            
            Scanner sc = new Scanner(System.in);
            System.out.println("ESCOLHA A NOTA: ");
            rank = sc.nextInt();
            System.out.println(rank);
            if(rank == 1){
                System.out.println("\u001B[33m \u001b[1m" + " * * * * * ");
                estado = "aprovado";
            }else{
                System.out.println("\u001B[33m \u001b[1m" + " * * * ");
                estado = "reprovado";
            }
        
            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();

            String nomeArquivo = conteudo.getTitulo() + ".png";

            geradorFigurinha.criarFigurinhas(inputStream, nomeArquivo, estado, conteudo.getTitulo());

            System.out.println(conteudo.getTitulo());
            System.out.println();
        }
    }
}
