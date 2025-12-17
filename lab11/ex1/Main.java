package Praticas.lab11.ex1;

// Classe principal para testar o sistema completo
public class Main {
    public static void main(String[] args) {
        System.out.println("INICIANDO SISTEMA DE LEILÕES LEI LAO");
        
        SistemaLeiloes sistema = SistemaLeiloes.getInstancia();
        
        Gestor gestor = new Gestor("Carlos Silva");
        Cliente cliente1 = new Cliente("Ana Santos");
        Cliente cliente2 = new Cliente("Pedro Costa");
        Cliente cliente3 = new Cliente("Maria Oliveira");
        
        Produto produto1 = new Produto("iPhone 15 Pro", 800.0);
        Produto produto2 = new Produto("MacBook Pro M3", 1500.0);
        Produto produto3 = new Produto("Smart TV Samsung 55", 400.0);
        Produto produto4 = new Produto("PlayStation 5", 450.0);
        Produto produto5 = new Produto("Nintendo Switch OLED", 300.0);
        
        sistema.adicionarProduto(produto1);
        sistema.adicionarProduto(produto2);
        sistema.adicionarProduto(produto3);
        sistema.adicionarProduto(produto4);
        sistema.adicionarProduto(produto5);
        
        gestor.colocarProdutoEmLeilao(produto1, 15);
        gestor.colocarProdutoEmLeilao(produto2, 15);
        gestor.colocarProdutoEmLeilao(produto3, 15);
        
        cliente1.consultarProdutosLeilao();
        
        System.out.println("\n=== INÍCIO DOS LANCES ===");
        cliente1.licitar(produto1, 850.0);
        cliente2.licitar(produto1, 900.0);
        cliente3.licitar(produto2, 1600.0);
        cliente1.licitar(produto1, 950.0);
        cliente2.licitar(produto3, 420.0);
        
        System.out.println("\n--- Teste de Lance Inválido ---");
        cliente3.licitar(produto1, 900.0);
        
        gestor.mostrarEstatisticas();
        
        System.out.println("\nAguardando término dos leilões (15 segundos)...");
        try {
            Thread.sleep(16000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("\n=== RESULTADO FINAL ===");
        gestor.mostrarEstatisticas();
        
        System.out.println("\nSIMULAÇÃO CONCLUÍDA");
    }
}