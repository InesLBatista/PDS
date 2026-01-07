package behavioral.strategy;

class PagamentoCartaoCredito implements MetodoPagamento {
    private String numeroCartao;
    private String nomeTitular;
    private String dataValidade;
    
    public PagamentoCartaoCredito(String numeroCartao, String nomeTitular, String dataValidade) {
        this.numeroCartao = numeroCartao;
        this.nomeTitular = nomeTitular;
        this.dataValidade = dataValidade;
    }
    
    @Override
    public boolean validarPagamento(double valor) {
        if (valor <= 0) {
            System.out.println("valor do pagamento inválido");
            return false;
        }
        
        if (numeroCartao == null || numeroCartao.length() != 16) {
            System.out.println("número do cartão inválido");
            return false;
        }
        
        if (nomeTitular == null || nomeTitular.trim().isEmpty()) {
            System.out.println("nome do titular inválido");
            return false;
        }
        
        // simulação de validação da data
        if (!dataValidade.matches("\\d{2}/\\d{2}")) {
            System.out.println("data de validade inválida");
            return false;
        }
        
        System.out.println("pagamento com cartão de crédito validado");
        return true;
    }
    
    @Override
    public boolean processarPagamento(double valor) {
        if (!validarPagamento(valor)) {
            return false;
        }
        
        System.out.println("a processar pagamento com cartão de crédito:");
        System.out.println("  número do cartão: **** **** **** " + numeroCartao.substring(12));
        System.out.println("  titular: " + nomeTitular);
        System.out.println("  valor: " + valor + "€");
        System.out.println("  taxa: " + calcularTaxa(valor) + "€");
        System.out.println("  total: " + (valor + calcularTaxa(valor)) + "€");
        
        // simulação de processamento
        System.out.println("  a ligar à rede de pagamentos...");
        System.out.println("  autorização solicitada...");
        System.out.println("  pagamento autorizado com sucesso");
        
        return true;
    }
    
    @Override
    public double calcularTaxa(double valor) {
        // cartão de crédito: 2% do valor, mínimo 0.50€
        double taxa = valor * 0.02;
        return Math.max(taxa, 0.50);
    }
    
    @Override
    public String getNomeMetodo() {
        return "cartão de crédito";
    }
    
    @Override
    public String getDescricao() {
        return "pagamento com cartão de crédito (taxa: 2%, mínimo 0.50€)";
    }
}
