package behavioral.visitor;

// Documento.java - Interface elemento
public interface Documento {
    void aceitar(Visitor visitor);
    String getTipo();
    long getTamanho();
    String getFormato();
    String getNome();
    void setNome(String nome);
}
