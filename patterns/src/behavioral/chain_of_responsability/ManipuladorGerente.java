package behavioral.chain_of_responsability;

class ManipuladorGerente extends ManipuladorBase {
    @Override
    protected boolean podeProcessar(Pedido pedido) {
        return pedido.getTipo().equals("gerencia") || 
               pedido.getDescricao().contains("aprovacao") ||
               pedido.getDescricao().contains("orcamento");
    }
    
    @Override
    protected void processar(Pedido pedido) {
        System.out.println("Gerente está processando o pedido: " + pedido.getDescricao());
        System.out.println("  Aprovacao necessaria: sim");
        System.out.println("  Nível: gerencia");
    }
    
    @Override
    public void processarPedido(Pedido pedido) {
        if (podeProcessar(pedido)) {
            processar(pedido);
        } else {
            super.processarPedido(pedido);
        }
    }
}