package behavioral.chain_of_responsability;

class ManipuladorTecnico extends ManipuladorBase {
    @Override
    protected boolean podeProcessar(Pedido pedido) {
        return pedido.getTipo().equals("tecnico") || 
               pedido.getPrioridade().equals("alta");
    }
    
    @Override
    protected void processar(Pedido pedido) {
        System.out.println("Técnico está processando o pedido: " + pedido.getDescricao());
        System.out.println("  Tipo: " + pedido.getTipo());
        System.out.println("  Prioridade: " + pedido.getPrioridade());
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