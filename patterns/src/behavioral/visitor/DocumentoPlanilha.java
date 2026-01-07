package behavioral.visitor;

// DocumentoPlanilha.java - Elemento concreto
public class DocumentoPlanilha implements Documento {
    private String nome;
    private long tamanho;
    private int numeroLinhas;
    private int numeroColunas;
    
    public DocumentoPlanilha(String nome, long tamanho, int numeroLinhas, int numeroColunas) {
        this.nome = nome;
        this.tamanho = tamanho;
        this.numeroLinhas = numeroLinhas;
        this.numeroColunas = numeroColunas;
    }
    
    @Override
    public void aceitar(Visitor visitor) {
        visitor.visitar(this);
    }
    
    @Override
    public String getTipo() {
        return "Planilha";
    }
    
    @Override
    public long getTamanho() {
        return tamanho;
    }
    
    @Override
    public String getFormato() {
        return "XLSX/CSV";
    }
    
    @Override
    public String getNome() {
        return nome;
    }
    
    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getNumeroLinhas() {
        return numeroLinhas;
    }
    
    public int getNumeroColunas() {
        return numeroColunas;
    }
}
