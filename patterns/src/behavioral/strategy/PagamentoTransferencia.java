package behavioral.strategy;

class PagamentoTransferencia implements MetodoPagamento {
    private String iban;
    private String nomeTitular;
    
    public PagamentoTransferencia(String iban, String nomeTitular) {
        this.iban = iban;
        this.nomeTitular = nomeTitular;
    }
    
    @Override
    public boolean validarPagamento(double valor) {
        if (valor <= 0) {
            System.out.println("valor do pagamento inválido");
            return false;
        }
        
        if (iban == null || iban.length() < 15) {
            System.out.println("IBAN inválido");
            return false;
        }
        
        if (nomeTitular == null || nomeTitular.trim().isEmpty()) {
            System.out.println("nome do titular inválido");
            return false;
        }
        
        System.out.println("pagamento por transferência validado");
        return true;
    }
    
    @Override
    public boolean processarPagamento(double valor) {
        if (!validarPagamento(valor)) {
            return false;
        }
        
        System.out.println("a processar pagamento por transferência:");
        System.out.println("  IBAN: " + iban);
        System.out.println("  titular: " + nomeTitular);
        System.out.println("  valor: " + valor + "€");
        System.out.println("  taxa: " + calcularTaxa(valor) + "€");
        System.out.println("  total: " + (valor + calcularTaxa(valor)) + "€");
        
        // simulação de processamento
        System.out.println("  a gerar referência de pagamento...");
        System.out.println("  referência: PT50 0000 0000 1234 5678 9012 3");
        System.out.println("  pague esta referência no seu banco");
        System.out.println("  pagamento será processado em 1-2 dias úteis");
        
        return true;
    }
    
    @Override
    public double calcularTaxa(double valor) {
        // transferência: 0.50€ fixos para valores até 1000€
        if (valor <= 1000) {
            return 0.50;
        }
        // 1€ para valores superiores
        return 1.00;
    }
    
    @Override
    public String getNomeMetodo() {
        return "transferência";
    }
    
    @Override
    public String getDescricao() {
        return "pagamento por transferência bancária (taxa: 0.50€ até 1000€, 1€ acima)";
    }
}
