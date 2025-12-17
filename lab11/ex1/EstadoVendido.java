package Praticas.lab11.ex1;

// Implementação do estado Vendido no padrão State - produto já foi vendido
public class EstadoVendido implements EstadoProduto {
    @Override
    public boolean podeReceberLances() {
        return false;
    }

    @Override
    public boolean processarLance(Produto produto, double valor, Cliente cliente) {
        System.out.println("Produto " + produto.getDescricao() + " já foi vendido");
        return false;
    }

    @Override
    public String getNomeEstado() {
        return "Vendido";
    }

    @Override
    public void gerirEstado(Produto produto) {
        System.out.println("Produto " + produto.getDescricao() + " foi vendido por " + produto.getMaiorLance());
    }
}