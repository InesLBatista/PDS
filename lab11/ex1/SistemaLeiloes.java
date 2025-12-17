package Praticas.lab11.ex1;
import java.util.ArrayList;
import java.util.List;

// Classe central que implementa o padrão Singleton e atua como Mediator
public class SistemaLeiloes {
    private static SistemaLeiloes instancia;
    private List<Produto> produtos;
    private List<Produto> produtosEmLeilao;
    
    private SistemaLeiloes() {
        this.produtos = new ArrayList<>();
        this.produtosEmLeilao = new ArrayList<>();
        System.out.println("Sistema de Leilões iniciado");
    }
    
    public static SistemaLeiloes getInstancia() {
        if (instancia == null) {
            instancia = new SistemaLeiloes();
        }
        return instancia;
    }
    
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        System.out.println("Produto adicionado: " + produto.getDescricao());
    }
    
    public boolean processarLance(Cliente cliente, Produto produto, double valor) {
        if (!produtosEmLeilao.contains(produto)) {
            System.out.println("Produto não está em leilão: " + produto.getDescricao());
            return false;
        }
        return produto.getEstado().processarLance(produto, valor, cliente);
    }
    
    public void colocarProdutoEmLeilao(Produto produto, long tempoSegundos) {
        produto.setTempoMaximoLeilao(tempoSegundos);
        produto.setEstado(new EstadoLeilao());
        if (!produtosEmLeilao.contains(produto)) {
            produtosEmLeilao.add(produto);
        }
    }
    
    public void removerProdutoDeLeilao(Produto produto) {
        produtosEmLeilao.remove(produto);
        System.out.println("Produto removido dos leilões: " + produto.getDescricao());
    }
    
    public List<Produto> getProdutosEmLeilao() {
        return new ArrayList<>(produtosEmLeilao);
    }
    
    public List<Produto> getProdutos() {
        return new ArrayList<>(produtos);
    }
    
    public void mostrarEstatisticas() {
        System.out.println("=== ESTATÍSTICAS DO SISTEMA ===");
        System.out.println("Total de produtos: " + produtos.size());
        System.out.println("Produtos em leilão: " + produtosEmLeilao.size());
        
        long emStock = produtos.stream().filter(p -> p.getEstado().getNomeEstado().equals("Stock")).count();
        long emLeilao = produtos.stream().filter(p -> p.getEstado().getNomeEstado().equals("Leilao")).count();
        long vendidos = produtos.stream().filter(p -> p.getEstado().getNomeEstado().equals("Vendido")).count();
        
        System.out.println("Produtos em Stock: " + emStock);
        System.out.println("Produtos em Leilão: " + emLeilao);
        System.out.println("Produtos Vendidos: " + vendidos);
        
        System.out.println("\nLista de produtos em Stock:");
        produtos.stream().filter(p -> p.getEstado().getNomeEstado().equals("Stock")).forEach(System.out::println);
        
        System.out.println("\nLista de produtos em Leilão:");
        produtos.stream().filter(p -> p.getEstado().getNomeEstado().equals("Leilao")).forEach(System.out::println);
        
        System.out.println("\nLista de produtos Vendidos:");
        produtos.stream().filter(p -> p.getEstado().getNomeEstado().equals("Vendido")).forEach(System.out::println);
    }
}