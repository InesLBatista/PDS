package behavioral.strategy;

public class Main {
    public static void main(String[] args) {
        System.out.println("padrão strategy - sistema de processamento de pagamentos\n");
        
        // criar processador de pagamentos (contexto)
        ProcessadorPagamentos processador = new ProcessadorPagamentos();
        
        System.out.println("processador de pagamentos criado");
        System.out.println("número da transação: " + processador.getNumeroTransacao());
        System.out.println("método actual: " + processador.getMetodoPagamentoActual());
        System.out.println();
        
        System.out.println("=================================================\n");
        
        // testar diferentes estratégias de pagamento
        
        System.out.println("teste 1: pagamento com cartão de crédito");
        System.out.println("----------------------------------------\n");
        
        MetodoPagamento cartaoCredito = new PagamentoCartaoCredito(
            "1234567890123456", 
            "joão silva", 
            "12/25"
        );
        
        processador.setMetodoPagamento(cartaoCredito);
        processador.processar(150.75);
        
        System.out.println("\n=================================================\n");
        
        System.out.println("teste 2: pagamento com PayPal");
        System.out.println("-----------------------------\n");
        
        MetodoPagamento paypal = new PagamentoPayPal("joao.silva@email.com");
        processador.setMetodoPagamento(paypal);
        processador.processar(89.99);
        
        System.out.println("\n=================================================\n");
        
        System.out.println("teste 3: pagamento por transferência bancária");
        System.out.println("----------------------------------------------\n");
        
        MetodoPagamento transferencia = new PagamentoTransferencia(
            "PT50000000001234567890123",
            "joão silva"
        );
        
        processador.setMetodoPagamento(transferencia);
        processador.processar(1200.50);
        
        System.out.println("\n=================================================\n");
        
        System.out.println("teste 4: pagamento com vale-presente");
        System.out.println("-------------------------------------\n");
        
        MetodoPagamento valePresente = new PagamentoValePresente("ABC123XYZ789", 200.00);
        processador.setMetodoPagamento(valePresente);
        
        // testar com saldo suficiente
        processador.processar(75.50);
        
        System.out.println("\n--- teste com saldo insuficiente ---\n");
        processador.processar(250.00); // deve falhar
        
        System.out.println("\n=================================================\n");
        
        System.out.println("teste 5: pagamento com criptomoeda");
        System.out.println("-----------------------------------\n");
        
        MetodoPagamento criptomoeda = new PagamentoCriptomoeda(
            "1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa",
            "bitcoin"
        );
        
        processador.setMetodoPagamento(criptomoeda);
        processador.processar(500.00);
        
        System.out.println("\n=================================================\n");
        
        // demonstrar cálculo de taxas para diferentes métodos
        System.out.println("comparação de taxas para 100€:\n");
        
        double valor = 100.00;
        
        System.out.println("valor base: " + valor + "€\n");
        
        MetodoPagamento[] metodos = {
            new PagamentoCartaoCredito("1234567890123456", "teste", "12/25"),
            new PagamentoPayPal("teste@email.com"),
            new PagamentoTransferencia("PT50000000001234567890123", "teste"),
            new PagamentoValePresente("TEST12345678", 500.00),
            new PagamentoCriptomoeda("1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa", "ethereum")
        };
        
        for (MetodoPagamento metodo : metodos) {
            double taxa = metodo.calcularTaxa(valor);
            double total = valor + taxa;
            
            System.out.println(metodo.getNomeMetodo() + ":");
            System.out.println("  taxa: " + taxa + "€");
            System.out.println("  total: " + total + "€");
            System.out.println();
        }
        
        System.out.println("\n=================================================\n");
        
        // demonstrar mudança dinâmica de estratégia
        System.out.println("demonstração: mudança dinâmica de estratégia");
        System.out.println("---------------------------------------------\n");
        
        System.out.println("simulação de carrinho de compras:");
        
        double totalCompra = 250.00;
        System.out.println("total da compra: " + totalCompra + "€\n");
        
        // cliente escolhe cartão de crédito
        System.out.println("cliente escolhe cartão de crédito:");
        processador.setMetodoPagamento(cartaoCredito);
        processador.processar(totalCompra);
        
        System.out.println("\n--- cliente muda para PayPal ---\n");
        
        // cliente muda para PayPal
        System.out.println("cliente muda para PayPal:");
        processador.setMetodoPagamento(paypal);
        processador.processar(totalCompra);
        
        System.out.println("\n--- cliente muda para vale-presente ---\n");
        
        // cliente muda para vale-presente
        System.out.println("cliente muda para vale-presente:");
        processador.setMetodoPagamento(valePresente);
        processador.processar(totalCompra);
    }
}