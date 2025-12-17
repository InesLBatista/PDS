package Praticas.lab12.ex3;

public interface EstadoLivro {
    void regista(Livro livro);
    void requisita(Livro livro);
    void devolve(Livro livro);
    void reserva(Livro livro);
    void cancelaReserva(Livro livro);
    String getNomeEstado();
}
