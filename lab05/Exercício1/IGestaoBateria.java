package Praticas.lab05.Exercício1;

public interface IGestaoBateria {
    double cargaDisponivel();
    void carregar(double percentagem);
    void limitarCargaMaxima(double percentagem);
}

