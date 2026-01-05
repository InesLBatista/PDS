package behavioral.chain_of_responsability;

public class Main {
    public static void main(String[] args) {
        System.out.println("Padrão Chain of Responsibility - Sistema de Pedidos\n");
        
        // 1. Criar manipuladores
        ManipuladorSuporte suporte = new ManipuladorSuporte();
        ManipuladorTecnico tecnico = new ManipuladorTecnico();
        ManipuladorGerente gerente = new ManipuladorGerente();
        ManipuladorAdministrador administrador = new ManipuladorAdministrador();
        
        // 2. Configurar a cadeia
        System.out.println("Configurando a cadeia de responsabilidades...");
        suporte.definirProximo(tecnico);
        tecnico.definirProximo(gerente);
        gerente.definirProximo(administrador);
        
        System.out.println("Cadeia: Suporte -> Tecnico -> Gerente -> Administrador\n");
        System.out.println("========================================================\n");
        
        // 3. Criar pedidos de teste
        Pedido[] pedidos = {
            new Pedido("suporte", "Problema com impressora", "baixa", "user123"),
            new Pedido("suporte", "Servidor fora do ar", "critica", "user456"),
            new Pedido("tecnico", "Configurar novo servidor", "media", "user789"),
            new Pedido("gerencia", "Aprovacao de orcamento", "alta", "user101"),
            new Pedido("administrativo", "Relatorio financeiro", "media", "user202"),
            new Pedido("desconhecido", "Pedido de tipo desconhecido", "baixa", "user303")
        };
        
        // 4. Processar cada pedido
        for (int i = 0; i < pedidos.length; i++) {
            System.out.println("Processando pedido " + (i + 1) + ":");
            System.out.println("  Tipo: " + pedidos[i].getTipo());
            System.out.println("  Descricao: " + pedidos[i].getDescricao());
            System.out.println("  Prioridade: " + pedidos[i].getPrioridade());
            System.out.println();
            
            suporte.processarPedido(pedidos[i]);
            
            System.out.println("\n" + "-".repeat(50) + "\n");
        }
        
        System.out.println("========================================================\n");
        
        // 5. Testar cadeia alternativa
        System.out.println("Testando cadeia alternativa...\n");
        
        // Criar nova cadeia mais simples
        ManipuladorSuporte suporte2 = new ManipuladorSuporte();
        ManipuladorAdministrador admin2 = new ManipuladorAdministrador();
        
        suporte2.definirProximo(admin2);
        
        Pedido pedidoSimples = new Pedido("suporte", "Pedido simples", "baixa", "user999");
        System.out.println("Processando com cadeia simples (suporte -> admin):");
        System.out.println("  Descricao: " + pedidoSimples.getDescricao());
        System.out.println();
        
        suporte2.processarPedido(pedidoSimples);
        
        System.out.println("\n========================================================\n");
        
        // 6. Testar pedido não processável (sem próximo)
        System.out.println("Testando pedido sem manipuladores disponíveis...\n");
        
        ManipuladorSuporte suporteSolo = new ManipuladorSuporte();
        // Não definir próximo
        
        Pedido pedidoComplexo = new Pedido("tecnico", "Pedido complexo", "alta", "user777");
        System.out.println("Processando com apenas suporte (sem próximo):");
        System.out.println("  Descricao: " + pedidoComplexo.getDescricao());
        System.out.println();
        
        suporteSolo.processarPedido(pedidoComplexo);
        
        System.out.println("\n========================================================\n");
        
        // 7. Demonstração de flexibilidade
        System.out.println("Demonstração de flexibilidade da cadeia:\n");
        
        // Criar cadeia personalizada
        ManipuladorTecnico tecnico2 = new ManipuladorTecnico();
        ManipuladorAdministrador admin3 = new ManipuladorAdministrador();
        
        // Ordem diferente
        tecnico2.definirProximo(admin3);
        
        System.out.println("Nova cadeia: Tecnico -> Administrador\n");
        
        // Testar diferentes pedidos
        Pedido[] pedidosTeste = {
            new Pedido("suporte", "Teste suporte", "baixa", "test1"),
            new Pedido("tecnico", "Teste técnico", "media", "test2"),
            new Pedido("gerencia", "Teste gerencia", "alta", "test3")
        };
        
        for (Pedido p : pedidosTeste) {
            System.out.println("Processando: " + p.getDescricao());
            tecnico2.processarPedido(p);
            System.out.println();
        }
        
        System.out.println("========================================================\n");
        
        // 8. Resumo dos benefícios
        System.out.println("Resumo dos benefícios do padrão chain of responsibility:\n");
        
        System.out.println("- Desacoplamento: Cliente não conhece os manipuladores específicos");
        System.out.println("- Flexibilidade: Cadeia configurável em tempo de execução");
        System.out.println("- Extensibilidade: Novos manipuladores podem ser adicionados facilmente");
        System.out.println("- Responsabilidade única: Cada manipulador tem uma responsabilidade clara");
        System.out.println("- Processamento garantido: Fallback assegurado pelo último manipulador");
        
        System.out.println("\nPadrão Chain of Responsibility implementado com sucesso");
    }
}
