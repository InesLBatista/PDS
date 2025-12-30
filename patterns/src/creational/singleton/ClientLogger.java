package creational.singleton;

public class ClientLogger {
    public void processarPedido() {
        // Obtém a instância única do Logger
        Logger logger = Logger.getInstancia();
        logger.info("Iniciando o processamento de pedido");
        logger.log("Validação dados do pedido...");
        
        // Simula alguma lógica de negócio
        try {
            // Simulação de processamento
            Thread.sleep(100);
            logger.info("Pedido processado com sucesso");
        } catch (InterruptedException e) {
            logger.error("Erro ao processar pedido: " + e.getMessage());
        }
    }
    
    public void realizarPagamento() {
        // Obtém a mesma instância do Logger
        Logger logger = Logger.getInstancia();
        logger.info("Iniciando o processo de pagamento");
        logger.warning("Verificação do limite de crédito...");
        logger.log("Pagamento autorizado");
    }
}
