package creational.singleton;

public class Cliente extends ClientLogger{
    // Métodos específicos do Cliente que usam o Logger
    
    public void realizarCadastro(String nome) {
        // Usa o Logger herdado indiretamente (através de ClienteLogger)
        Logger logger = Logger.getInstancia();
        
        logger.info("Cliente: Iniciando cadastro de " + nome);
        logger.log("Validando dados do cliente...");
        
        if (nome == null || nome.trim().isEmpty()) {
            logger.error("Erro: Nome do cliente é inválido");
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        
        // Simula lógica de cadastro
        try {
            Thread.sleep(100); // Simula processamento
            logger.info("Cliente " + nome + " cadastrado com sucesso");
        } catch (InterruptedException e) {
            logger.error("Erro durante cadastro: " + e.getMessage());
        }
    }
    
    public void atualizarPerfil(String clienteId) {
        Logger logger = Logger.getInstancia();
        
        logger.info("Cliente: Atualizando perfil " + clienteId);
        logger.warning("Verificando permissões...");
        
        // Simula atualização
        logger.info("Cliente: Perfil " + clienteId + " atualizado");
    }
    
    // Método que chama métodos herdados de ClienteLogger
    public void executarFluxoCompleto() {
        System.out.println("\n=== FLUXO COMPLETO DO CLIENTE ===\n");
        
        // Usa métodos herdados da classe pai
        processarPedido();  // Herdado de ClienteLogger
        realizarPagamento(); // Herdado de ClienteLogger
        
        // Usa métodos próprios
        realizarCadastro("Maria Oliveira");
        atualizarPerfil("CLI-001");
        
        // Demonstra que todos usam a mesma instância do Logger
        Logger logger = Logger.getInstancia();
        logger.info("Cliente: Fluxo completo executado com sucesso");
    }
    
    // Método para demonstrar o Singleton
    public void demonstrarSingleton() {
        System.out.println("\n=== DEMONSTRAÇÃO DO SINGLETON ===\n");
        
        // Mostra que mesmo em diferentes métodos, obtemos a mesma instância
        Logger logger1 = Logger.getInstancia();
        Logger logger2 = Logger.getInstancia();
        
        logger1.info("Primeiro log usando logger1");
        logger2.info("Segundo log usando logger2 - mesma instância!");
        
        // Verificação
        if (logger1 == logger2) {
            System.out.println("✓ Comprovado: Todas as chamadas retornam a mesma instância");
            System.out.println("  HashCode logger1: " + System.identityHashCode(logger1));
            System.out.println("  HashCode logger2: " + System.identityHashCode(logger2));
        }
    }
}
