
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.io.File;
//import java.io.FileInputStream;
import java.io.InputStream;
//import java.net.URL;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Font;
import java.awt.font.TextLayout;
import java.awt.font.FontRenderContext;

public class GeradorFigurinhas {
    // relançando a exception
    // só teste
    /* 
    public static void main(String[] args) throws Exception {
      var figurinha = new GeradorFigurinhas();
      figurinha.criarFigurinhas();
    }*/
    
    
    // dessa forma, A classe que chamar esse método vai ter que lidar com a exception genérica
    public void criarFigurinhas(InputStream inputStream, String nomeArquivo, String estado) throws Exception{

      // leitura  da imagem
      // InputStream é uma classe abstrata
      // representa uma fonte de stream de bytes 
      // varias formas de referenciar o mesmo objeto
      // indepente de ler a imagem e de onde vem
      // se vem do arquivo SO, se vem se uma socket, se vem de um array que estava na memória
      // conceitos de polimorfismo

      // lendo de com URL
      //InputStream inputStream = new URL("https://imersao-java-apis.s3.amazonaws.com/TopMovies_1.jpg").openStream();

      // lendo de diretorio
      //InputStream inputStream = new FileInputStream(new File("C://Users/sdnxf/Documents/NetBeansProjects/Imersao-Java-Stickers-Alura/AluraStickers/entrada/filme.jpg"));

      BufferedImage imagemOriginal = ImageIO.read(inputStream);

      // lendo de diretorio
      //BufferedImage imagemOriginal = ImageIO.read(new File("C://Users/sdnxf/Documents/NetBeansProjects/Imersao-Java-Stickers-Alura/AluraStickers/entrada/filme.jpg"));

      BufferedImage aprovado = ImageIO.read(new File("C://Users/sdnxf/Documents/NetBeansProjects/Imersao-Java-Stickers-Alura/AluraStickers/img/aprovado-corte.png"));

      BufferedImage reprovado = ImageIO.read(new File("C://Users/sdnxf/Documents/NetBeansProjects/Imersao-Java-Stickers-Alura/AluraStickers/img/reprovado-corte.png"));

      // cria nova imagem em memória com transparência e com tamnho novo
      int largura = imagemOriginal.getWidth();
      int altura = imagemOriginal.getHeight();
      int novaAltura = altura + 300;


      BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

      // copiar a imagem original pra nova imagem (em memória)
      Graphics2D copiaImagem = (Graphics2D) novaImagem.getGraphics();


      copiaImagem.drawImage(imagemOriginal, 0, 0, null);
      String s = "";
      System.out.println(estado);
      if(estado.equals("aprovado")){
        s = "Aprovado";
        copiaImagem.drawImage(aprovado, (largura / 2) - 150, altura, null);
      }else if(estado.equals("reprovado")){
        s = "Reprovado";
        copiaImagem.drawImage(reprovado, (largura / 2) - 150, altura, null);
      }

      
      // Config font
      var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 40);
      copiaImagem.setFont(fonte);
      

      copiaImagem.setColor(Color.WHITE);

      // escrever uma frase na nova imagem
      copiaImagem.drawString(s, (largura / 2) - 150, novaAltura - 20);
      if(!s.equals("")){
        TextLayout tl = new TextLayout(s, fonte, copiaImagem.getFontRenderContext());
        Shape shape = tl.getOutline(null);
        copiaImagem.translate((largura / 2) - 150, novaAltura - 20);
        copiaImagem.setColor(Color.BLACK);
        copiaImagem.draw(shape);
      }

      // escrever a nova imagem em um arquivo
      //ImageIO.write(novaImagem, "png", new File("C://Users/sdnxf/Documents/NetBeansProjects/Imersao-Java-Stickers-Alura/AluraStickers/saida/figurinha.png"));

      ImageIO.write(novaImagem, "png", new File(nomeArquivo));
    } 
    
}
