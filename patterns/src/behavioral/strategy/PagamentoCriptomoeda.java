package behavioral.strategy;

class PagamentoCriptomoeda implements MetodoPagamento {
    private String enderecoCarteira;
    private String tipoCriptomoeda;
    
    public PagamentoCriptomoeda(String enderecoCarteira, String tipoCriptomoeda) {
        this.enderecoCarteira = enderecoCarteira;
        this.tipoCriptomoeda = tipoCriptomoeda;
    }
    
    @Override
    public boolean validarPagamento(double valor) {
        if (valor <= 0) {
            System.out.println("valor do pagamento inválido");
            return false;
        }
        
        if (enderecoCarteira == null || enderecoCarteira.length() < 26) {
            System.out.println("endereço da carteira inválido");
            return false;
        }
        
        if (tipoCriptomoeda == null || (!tipoCriptomoeda.equals("bitcoin") && 
                                        !tipoCriptomoeda.equals("ethereum") &&
                                        !tipoCriptomoeda.equals("litecoin"))) {
            System.out.println("tipo de criptomoeda não suportado");
            return false;
        }
        
        System.out.println("pagamento com criptomoeda validado");
        return true;
    }
    
    @Override
    public boolean processarPagamento(double valor) {
        if (!validarPagamento(valor)) {
            return false;
        }
        
        double taxa = calcularTaxa(valor);
        double valorEmCripto = converterParaCripto(valor + taxa);
        
        System.out.println("a processar pagamento com criptomoeda:");
        System.out.println("  tipo: " + tipoCriptomoeda);
        System.out.println("  endereço da carteira: " + enderecoCarteira.substring(0, 10) + "...");
        System.out.println("  valor em euros: " + valor + "€");
        System.out.println("  taxa de rede: " + taxa + "€");
        System.out.println("  total em euros: " + (valor + taxa) + "€");
        System.out.println("  total em " + tipoCriptomoeda + ": " + valorEmCripto);
        
        // simulação de processamento
        System.out.println("  a calcular taxa de rede...");
        System.out.println("  a converter para " + tipoCriptomoeda + "...");
        System.out.println("  a gerar QR code para pagamento...");
        System.out.println("  a aguardar confirmação na blockchain...");
        System.out.println("  pagamento confirmado (3 confirmações)");
        
        return true;
    }
    
    @Override
    public double calcularTaxa(double valor) {
        // criptomoeda: taxa fixa de rede
        return 1.50;
    }
    
    private double converterParaCripto(double valorEuros) {
        // taxas de conversão fictícias
        switch (tipoCriptomoeda.toLowerCase()) {
            case "bitcoin": return valorEuros / 35000.0;
            case "ethereum": return valorEuros / 2500.0;
            case "litecoin": return valorEuros / 150.0;
            default: return valorEuros / 1.0;
        }
    }
    
    @Override
    public String getNomeMetodo() {
        return "criptomoeda";
    }
    
    @Override
    public String getDescricao() {
        return "pagamento com criptomoeda (taxa de rede: 1.50€)";
    }
}
