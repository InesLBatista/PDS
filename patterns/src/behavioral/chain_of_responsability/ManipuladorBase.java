package behavioral.chain_of_responsability;

abstract class ManipuladorBase implements ManipuladorPedido {
    protected ManipuladorPedido proximo;
    
    @Override
    public void definirProximo(ManipuladorPedido proximo) {
        this.proximo = proximo;
    }
    
    @Override
    public void processarPedido(Pedido pedido) {
        if (proximo != null) {
            proximo.processarPedido(pedido);
        } else {
            System.out.println("Nenhum manipulador pode processar o pedido: " + pedido.getDescricao());
        }
    }
    
    protected abstract boolean podeProcessar(Pedido pedido);
    protected abstract void processar(Pedido pedido);
}
