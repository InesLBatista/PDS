package behavioral.strategy;

class PagamentoPayPal implements MetodoPagamento {
    private String email;
    
    public PagamentoPayPal(String email) {
        this.email = email;
    }
    
    @Override
    public boolean validarPagamento(double valor) {
        if (valor <= 0) {
            System.out.println("valor do pagamento inválido");
            return false;
        }
        
        if (email == null || !email.contains("@")) {
            System.out.println("email do PayPal inválido");
            return false;
        }
        
        System.out.println("pagamento com PayPal validado");
        return true;
    }
    
    @Override
    public boolean processarPagamento(double valor) {
        if (!validarPagamento(valor)) {
            return false;
        }
        
        System.out.println("a processar pagamento com PayPal:");
        System.out.println("  email: " + email);
        System.out.println("  valor: " + valor + "€");
        System.out.println("  taxa: " + calcularTaxa(valor) + "€");
        System.out.println("  total: " + (valor + calcularTaxa(valor)) + "€");
        
        // simulação de processamento
        System.out.println("  a redireccionar para o PayPal...");
        System.out.println("  a aguardar confirmação...");
        System.out.println("  pagamento confirmado com sucesso");
        
        return true;
    }
    
    @Override
    public double calcularTaxa(double valor) {
        // PayPal: 3.4% + 0.35€ fixos
        return (valor * 0.034) + 0.35;
    }
    
    @Override
    public String getNomeMetodo() {
        return "paypal";
    }
    
    @Override
    public String getDescricao() {
        return "pagamento com PayPal (taxa: 3.4% + 0.35€ fixos)";
    }
}
