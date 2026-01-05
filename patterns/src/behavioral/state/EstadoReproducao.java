package behavioral.state;

interface EstadoReproducao {
    void reproduzir();
    void pausar();
    void parar();
    void proximaFaixa();
    void faixaAnterior();
    String getNomeEstado();
}