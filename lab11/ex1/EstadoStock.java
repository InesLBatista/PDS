package Praticas.lab11.ex1;

// Implementação do estado Stock no padrão State - produto não disponível para leilão
public class EstadoStock implements EstadoProduto {
    @Override
    public boolean podeReceberLances() {
        return false;
    }

    @Override
    public boolean processarLance(Produto produto, double valor, Cliente cliente) {
        System.out.println("Produto " + produto.getDescricao() + " não está em leilão");
        return false;
    }

    @Override
    public String getNomeEstado() {
        return "Stock";
    }

    @Override
    public void gerirEstado(Produto produto) {
        produto.setMaiorLance(0);
        produto.setLicitadorAtual(null);
        System.out.println("Produto " + produto.getDescricao() + " colocado em stock");
    }
}