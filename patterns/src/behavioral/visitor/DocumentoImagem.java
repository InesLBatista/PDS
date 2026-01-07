package behavioral.visitor;

// DocumentoImagem.java - Elemento concreto
public class DocumentoImagem implements Documento {
    private String nome;
    private long tamanho;
    private String resolucao;
    
    public DocumentoImagem(String nome, long tamanho, String resolucao) {
        this.nome = nome;
        this.tamanho = tamanho;
        this.resolucao = resolucao;
    }
    
    @Override
    public void aceitar(Visitor visitor) {
        visitor.visitar(this);
    }
    
    @Override
    public String getTipo() {
        return "Imagem";
    }
    
    @Override
    public long getTamanho() {
        return tamanho;
    }
    
    @Override
    public String getFormato() {
        return "JPG/PNG";
    }
    
    @Override
    public String getNome() {
        return nome;
    }
    
    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getResolucao() {
        return resolucao;
    }
}
