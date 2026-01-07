package behavioral.visitor;

// DocumentoPDF.java - Elemento concreto
public class DocumentoPDF implements Documento {
    private String nome;
    private long tamanho;
    private int numeroPaginas;
    
    public DocumentoPDF(String nome, long tamanho, int numeroPaginas) {
        this.nome = nome;
        this.tamanho = tamanho;
        this.numeroPaginas = numeroPaginas;
    }
    
    @Override
    public void aceitar(Visitor visitor) {
        visitor.visitar(this);
    }
    
    @Override
    public String getTipo() {
        return "PDF";
    }
    
    @Override
    public long getTamanho() {
        return tamanho;
    }
    
    @Override
    public String getFormato() {
        return "PDF";
    }
    
    @Override
    public String getNome() {
        return nome;
    }
    
    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getNumeroPaginas() {
        return numeroPaginas;
    }
}
