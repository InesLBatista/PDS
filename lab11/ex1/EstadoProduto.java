package Praticas.lab11.ex1;

// define o contrato para os diferentes estados de um produto
public interface EstadoProduto {
   boolean podeReceberLances();
    boolean processarLance(Produto produto, double valor, Cliente cliente);
    String getNomeEstado();
    void gerirEstado(Produto produto);
}
