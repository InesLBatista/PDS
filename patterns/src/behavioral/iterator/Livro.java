package behavioral.iterator;

class Livro {
    private String titulo;
    private String autor;
    private String categoria;
    private int anoPublicacao;
    private double avaliacao;
    
    public Livro(String titulo, String autor, String categoria, int anoPublicacao, double avaliacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.anoPublicacao = anoPublicacao;
        this.avaliacao = avaliacao;
    }
    
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getCategoria() { return categoria; }
    public int getAnoPublicacao() { return anoPublicacao; }
    public double getAvaliacao() { return avaliacao; }
    
    @Override
    public String toString() {
        return titulo + " (" + autor + ", " + anoPublicacao + ") - " + categoria + " [" + avaliacao + "★]";
    }
}