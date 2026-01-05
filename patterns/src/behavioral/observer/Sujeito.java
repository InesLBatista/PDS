package behavioral.observer;

interface Sujeito {
    void registarObservador(Observador observador);
    void removerObservador(Observador observador);
    void notificarObservadores();
}