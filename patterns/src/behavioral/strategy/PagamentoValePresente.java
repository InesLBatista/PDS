package behavioral.strategy;

class PagamentoValePresente implements MetodoPagamento {
    private String codigoVale;
    private double saldoDisponivel;
    
    public PagamentoValePresente(String codigoVale, double saldoDisponivel) {
        this.codigoVale = codigoVale;
        this.saldoDisponivel = saldoDisponivel;
    }
    
    @Override
    public boolean validarPagamento(double valor) {
        if (valor <= 0) {
            System.out.println("valor do pagamento inválido");
            return false;
        }
        
        if (codigoVale == null || codigoVale.length() != 12) {
            System.out.println("código do vale-presente inválido");
            return false;
        }
        
        if (saldoDisponivel < valor) {
            System.out.println("saldo insuficiente no vale-presente");
            System.out.println("  saldo disponível: " + saldoDisponivel + "€");
            System.out.println("  valor necessário: " + valor + "€");
            return false;   
        }
        
        System.out.println("pagamento com vale-presente validado");
        return true;
    }
    
    @Override
    public boolean processarPagamento(double valor) {
        if (!validarPagamento(valor)) {
            return false;
        }
        
        System.out.println("a processar pagamento com vale-presente:");
        System.out.println("  código do vale: " + codigoVale);
        System.out.println("  valor: " + valor + "€");
        System.out.println("  taxa: " + calcularTaxa(valor) + "€");
        System.out.println("  total debitado: " + valor + "€");
        System.out.println("  novo saldo: " + (saldoDisponivel - valor) + "€");
        
        // simulação de processamento
        saldoDisponivel -= valor;
        System.out.println("  a validar código do vale...");
        System.out.println("  a debitar valor...");
        System.out.println("  pagamento processado com sucesso");
        
        return true;
    }
    
    @Override
    public double calcularTaxa(double valor) {
        // vale-presente: sem taxas
        return 0.0;
    }
    
    @Override
    public String getNomeMetodo() {
        return "vale-presente";
    }
    
    @Override
    public String getDescricao() {
        return "pagamento com vale-presente (sem taxas)";
    }
}