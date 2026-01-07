package behavioral.visitor;

// DocumentoApresentacao.java - Elemento concreto
public class DocumentoApresentacao implements Documento {
    private String nome;
    private long tamanho;
    private int numeroSlides;
    
    public DocumentoApresentacao(String nome, long tamanho, int numeroSlides) {
        this.nome = nome;
        this.tamanho = tamanho;
        this.numeroSlides = numeroSlides;
    }
    
    @Override
    public void aceitar(Visitor visitor) {
        visitor.visitar(this);
    }
    
    @Override
    public String getTipo() {
        return "Apresentacao";
    }
    
    @Override
    public long getTamanho() {
        return tamanho;
    }
    
    @Override
    public String getFormato() {
        return "PPTX";
    }
    
    @Override
    public String getNome() {
        return nome;
    }
    
    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getNumeroSlides() {
        return numeroSlides;
    }
}
