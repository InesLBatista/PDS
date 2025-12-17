package Praticas.lab11.ex1;

// Gestor que implementa Observador para monitorizar o sistema
public class Gestor implements Observador {
    private String nome;
    
    public Gestor(String nome) {
        this.nome = nome;
        System.out.println("Gestor criado: " + nome);
    }
    
    public String getNome() { 
        return nome; 
    }
    
    public void colocarProdutoEmLeilao(Produto produto, long tempoSegundos) {
        System.out.println("Gestor " + nome + " a colocar " + produto.getDescricao() + " em leilão");
        SistemaLeiloes.getInstancia().colocarProdutoEmLeilao(produto, tempoSegundos);
        produto.registarObservador(this);
    }
    
    public void mostrarEstatisticas() {
        System.out.println("Estatísticas do Sistema solicitadas por " + nome);
        SistemaLeiloes.getInstancia().mostrarEstatisticas();
    }
    
    @Override
    public void atualizar(String mensagem) {
        System.out.println("[GESTOR " + nome.toUpperCase() + "] " + mensagem);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Gestor gestor = (Gestor) obj;
        return nome.equalsIgnoreCase(gestor.nome);
    }
    
    @Override
    public int hashCode() {
        return nome.toLowerCase().hashCode();
    }
}