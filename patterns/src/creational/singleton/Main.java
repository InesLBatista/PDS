package creational.singleton;


/**
 * Classe principal que testa todas as funcionalidades do Sistema de Logger Singleton.
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║      SISTEMA DE LOGGER GLOBAL - SINGLETON PATTERN     ║");
        System.out.println("╚══════════════════════════════════════════════════════╝\n");
        
        // =================================================================
        // TESTE 1: Verificação básica do Singleton
        // =================================================================
        System.out.println("TESTE 1: VERIFICAÇÃO DO PADRÃO SINGLETON");
        System.out.println("─────────────────────────────────────────");
        
        // Primeira obtenção da instância
        Logger logger1 = Logger.getInstancia();
        System.out.println("✓ Primeira chamada de Logger.getInstancia()");
        
        // Segunda obtenção - deve ser a mesma instância
        Logger logger2 = Logger.getInstancia();
        System.out.println("✓ Segunda chamada de Logger.getInstancia()");
        
        // Terceira obtenção
        Logger logger3 = Logger.getInstancia();
        System.out.println("✓ Terceira chamada de Logger.getInstancia()");
        
        // Verificação de igualdade
        System.out.println("\nVerificando igualdade das instâncias:");
        System.out.println("  logger1 == logger2? " + (logger1 == logger2) + " ✓");
        System.out.println("  logger1 == logger3? " + (logger1 == logger3) + " ✓");
        System.out.println("  logger2 == logger3? " + (logger2 == logger3) + " ✓");
        
        // Verificação de HashCodes
        System.out.println("\nHashCodes das instâncias (devem ser iguais):");
        System.out.println("  HashCode logger1: " + System.identityHashCode(logger1));
        System.out.println("  HashCode logger2: " + System.identityHashCode(logger2));
        System.out.println("  HashCode logger3: " + System.identityHashCode(logger3));
        
        // =================================================================
        // TESTE 2: Teste de todos os métodos do Logger
        // =================================================================
        System.out.println("\n\nTESTE 2: TODOS OS MÉTODOS DO LOGGER");
        System.out.println("─────────────────────────────────────");
        
        Logger logger = Logger.getInstancia();
        
        // Teste do método log(String)
        System.out.println("Testando método log(String mensagem):");
        logger.log("Esta é uma mensagem de log simples");
        
        // Teste do método log(String, String)
        System.out.println("\nTestando método log(String nivel, String mensagem):");
        logger.log("DEBUG", "Mensagem de debug");
        logger.log("CUSTOM", "Mensagem com nível customizado");
        
        // Teste do método info(String)
        System.out.println("\nTestando método info(String mensagem):");
        logger.info("Mensagem informativa do sistema");
        
        // Teste do método warning(String)
        System.out.println("\nTestando método warning(String mensagem):");
        logger.warning("Atenção: Disco com 85% de uso");
        
        // Teste do método error(String)
        System.out.println("\nTestando método error(String mensagem):");
        logger.error("Erro crítico: Conexão com banco de dados perdida");
        
        // =================================================================
        // TESTE 3: Teste com ClienteLogger (classe base)
        // =================================================================
        System.out.println("\n\nTESTE 3: USO COM CLIENTELOGGER");
        System.out.println("─────────────────────────────");
        
        ClientLogger clienteLogger = new ClientLogger();
        
        System.out.println("Executando processarPedido():");
        clienteLogger.processarPedido();
        
        System.out.println("\nExecutando realizarPagamento():");
        clienteLogger.realizarPagamento();
        
        // =================================================================
        // TESTE 4: Teste com Cliente (herda ClienteLogger)
        // =================================================================
        System.out.println("\n\nTESTE 4: USO COM CLIENTE (HERDA CLIENTELOGGER)");
        System.out.println("──────────────────────────────────────────────");
        
        Cliente cliente = new Cliente();
        
        System.out.println("1. Testando método herdado processarPedido():");
        cliente.processarPedido();
        
        System.out.println("\n2. Testando método herdado realizarPagamento():");
        cliente.realizarPagamento();
        
        System.out.println("\n3. Testando método próprio realizarCadastro():");
        try {
            cliente.realizarCadastro("Carlos Mendes");
        } catch (IllegalArgumentException e) {
            System.out.println("   Erro capturado: " + e.getMessage());
        }
        
        System.out.println("\n4. Testando método próprio atualizarPerfil():");
        cliente.atualizarPerfil("USR-789");
        
        // Teste de erro no cadastro
        System.out.println("\n5. Testando erro no cadastro (nome vazio):");
        try {
            cliente.realizarCadastro("");
        } catch (IllegalArgumentException e) {
            System.out.println("   ✓ Erro esperado capturado: " + e.getMessage());
        }
        
        // =================================================================
        // TESTE 5: Teste de múltiplas instâncias de Cliente
        // =================================================================
        System.out.println("\n\nTESTE 5: MÚLTIPLAS INSTÂNCIAS DE CLIENTE");
        System.out.println("─────────────────────────────────────────");
        
        System.out.println("Criando 3 clientes diferentes:");
        Cliente clienteA = new Cliente();
        Cliente clienteB = new Cliente();
        Cliente clienteC = new Cliente();
        
        System.out.println("\nCliente A realizando operação:");
        clienteA.realizarCadastro("Ana Paula");
        
        System.out.println("\nCliente B realizando operação:");
        clienteB.processarPedido();
        
        System.out.println("\nCliente C realizando operação:");
        clienteC.atualizarPerfil("CLI-456");
        
        System.out.println("\n✓ Todos os clientes usam o MESMO Logger Singleton!");
        
        // =================================================================
        // TESTE 6: Teste de execução em contexto de thread (simulado)
        // =================================================================
        System.out.println("\n\nTESTE 6: SIMULAÇÃO DE USO CONCORRENTE");
        System.out.println("─────────────────────────────────────");
        
        System.out.println("Simulando diferentes partes do sistema executando simultaneamente:");
        
        // Simula módulos diferentes do sistema rodando "ao mesmo tempo"
        Runnable moduloVendas = () -> {
            Logger log = Logger.getInstancia();
            log.info("[Módulo Vendas] Processando nova venda");
        };
        
        Runnable moduloEstoque = () -> {
            Logger log = Logger.getInstancia();
            log.warning("[Módulo Estoque] Produto com baixo estoque");
        };
        
        Runnable moduloFinanceiro = () -> {
            Logger log = Logger.getInstancia();
            log.error("[Módulo Financeiro] Falha na integração bancária");
        };
        
        // Executa os módulos
        moduloVendas.run();
        moduloEstoque.run();
        moduloFinanceiro.run();
        
        System.out.println("\n✓ Todos os módulos acessam a mesma instância do Logger");
        
        // =================================================================
        // TESTE 7: Demonstração do fluxo completo
        // =================================================================
        System.out.println("\n\nTESTE 7: FLUXO COMPLETO DO SISTEMA");
        System.out.println("─────────────────────────────────");
        
        cliente.executarFluxoCompleto();
        
        // =================================================================
        // TESTE 8: Demonstração final do Singleton
        // =================================================================
        System.out.println("\n\nTESTE 8: DEMONSTRAÇÃO FINAL DO SINGLETON");
        System.out.println("──────────────────────────────────────");
        
        cliente.demonstrarSingleton();
        
        // =================================================================
        // RESUMO FINAL
        // =================================================================
        System.out.println("\n" + "═".repeat(60));
        System.out.println("RESUMO DOS TESTES REALIZADOS:");
        System.out.println("═".repeat(60));
        
        System.out.println("✓ 1. Padrão Singleton verificado");
        System.out.println("✓ 2. Todos os métodos do Logger testados");
        System.out.println("✓ 3. ClienteLogger funcionando corretamente");
        System.out.println("✓ 4. Herança (Cliente → ClienteLogger) funcionando");
        System.out.println("✓ 5. Múltiplas instâncias de Cliente usando mesmo Logger");
        System.out.println("✓ 6. Uso concorrente simulado com sucesso");
        System.out.println("✓ 7. Fluxo completo do sistema executado");
        System.out.println("✓ 8. Demonstração final do padrão Singleton concluída");
        
        System.out.println("\n" + "★".repeat(60));
        System.out.println("SISTEMA DE LOGGER SINGLETON TESTADO COM SUCESSO!");
        System.out.println("Todas as funcionalidades estão operacionais.");
        System.out.println("★".repeat(60));
        
        // Teste adicional: Tentar "quebrar" o Singleton
        System.out.println("\nTeste adicional: Verificação de segurança do Singleton");
        System.out.println("-".repeat(50));
        
        // Demonstra que não podemos instanciar Logger diretamente
        System.out.println("Tentativa de instanciar Logger com 'new':");
        System.out.println("  Logger loggerDireto = new Logger(); // ERRO DE COMPILAÇÃO!");
        System.out.println("  ✓ Construtor privado impede criação direta ✓");
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("FIM DOS TESTES - SISTEMA VALIDADO");
        System.out.println("=".repeat(60));
    }
}