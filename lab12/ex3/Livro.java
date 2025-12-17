package Praticas.lab12.ex3;

public class Livro {
   private String titulo;
    private String isbn;
    private int ano;
    private String autor;
    private EstadoLivro estado;
    
    public Livro(String titulo, String isbn, int ano, String autor) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.ano = ano;
        this.autor = autor;
        this.estado = EstadoInventario.getInstancia(); // Estado inicial
    }
    
    // Métodos que delegam para o estado atual
    public void regista() {
        estado.regista(this);
    }
    
    public void requisita() {
        estado.requisita(this);
    }
    
    public void devolve() {
        estado.devolve(this);
    }
    
    public void reserva() {
        estado.reserva(this);
    }
    
    public void cancelaReserva() {
        estado.cancelaReserva(this);
    }
    
    public boolean disponivel() {
        return estado instanceof EstadoDisponivel;
    }
    
    // Getters e Setters
    public String getTitulo() { return titulo; }
    public String getIsbn() { return isbn; }
    public int getAno() { return ano; }
    public String getAutor() { return autor; }
    public String getEstadoAtual() { return estado.getNomeEstado(); }
    
    public void setEstado(EstadoLivro estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return String.format("%s  %s  %s", titulo, autor, getEstadoAtual());
    }
} 

