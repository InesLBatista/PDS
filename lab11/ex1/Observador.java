package Praticas.lab11.ex1;

public interface Observador {
    void atualizar(String mensagem);  // método chamado quando o subject tem uma atualização a notificar
    String getNome();   // retorna nome do observador para identificação
}
