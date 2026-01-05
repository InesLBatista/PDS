package behavioral.chain_of_responsability;

interface ManipuladorPedido {
    void definirProximo(ManipuladorPedido proximo);
    void processarPedido(Pedido pedido);
}
