package behavioral.strategy;

interface MetodoPagamento {
    boolean validarPagamento(double valor);
    boolean processarPagamento(double valor);
    double calcularTaxa(double valor);
    String getNomeMetodo();
    String getDescricao();
}
