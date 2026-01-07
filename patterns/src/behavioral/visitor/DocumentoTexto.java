package behavioral.visitor;

// DocumentoTexto.java - Elemento concreto
public class DocumentoTexto implements Documento {
    private String nome;
    private long tamanho;
    private String formato;
    
    public DocumentoTexto(String nome, long tamanho) {
        this.nome = nome;
        this.tamanho = tamanho;
        this.formato = "TXT";
    }
    
    @Override
    public void aceitar(Visitor visitor) {
        visitor.visitar(this);
    }
    
    @Override
    public String getTipo() {
        return "Texto";
    }
    
    @Override
    public long getTamanho() {
        return tamanho;
    }
    
    @Override
    public String getFormato() {
        return formato;
    }
    
    @Override
    public String getNome() {
        return nome;
    }
    
    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }
}