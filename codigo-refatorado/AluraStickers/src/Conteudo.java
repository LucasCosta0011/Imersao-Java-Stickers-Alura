public class Conteudo {
  private String titulo;
  private String urlImagem;
  private String ranking;

  public Conteudo(String titulo, String urlImagem, String ranking) {
    this.titulo = titulo;
    this.urlImagem = urlImagem;
    this.ranking = ranking;
  }

  public String getTitulo() {
    return titulo;
  }

  public String getUrlImagem() {
    return urlImagem;
  }

  public String getRanking() {
    return ranking;
  }
}
