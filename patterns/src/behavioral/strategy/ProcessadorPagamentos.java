package behavioral.strategy;

class ProcessadorPagamentos {
    private MetodoPagamento metodoPagamento;
    private String numeroTransacao;
    
    public ProcessadorPagamentos() {
        this.numeroTransacao = gerarNumeroTransacao();
    }
    
    public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
        System.out.println("método de pagamento definido: " + metodoPagamento.getNomeMetodo());
        System.out.println("descrição: " + metodoPagamento.getDescricao());
        System.out.println();
    }
    
    public boolean processar(double valor) {
        if (metodoPagamento == null) {
            System.out.println("erro: nenhum método de pagamento selecionado");
            return false;
        }
        
        System.out.println("transação: " + numeroTransacao);
        System.out.println("valor: " + valor + "€");
        System.out.println("método: " + metodoPagamento.getNomeMetodo());
        System.out.println();
        
        return metodoPagamento.processarPagamento(valor);
    }
    
    public double calcularTaxa(double valor) {
        if (metodoPagamento == null) {
            System.out.println("erro: nenhum método de pagamento selecionado");
            return 0.0;
        }
        
        return metodoPagamento.calcularTaxa(valor);
    }
    
    private String gerarNumeroTransacao() {
        return "TXN-" + System.currentTimeMillis();
    }
    
    public String getNumeroTransacao() {
        return numeroTransacao;
    }
    
    public String getMetodoPagamentoActual() {
        return metodoPagamento != null ? metodoPagamento.getNomeMetodo() : "nenhum";
    }
}
