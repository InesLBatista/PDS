package behavioral.chain_of_responsability;

class ManipuladorSuporte extends ManipuladorBase {
    @Override
    protected boolean podeProcessar(Pedido pedido) {
        return pedido.getTipo().equals("suporte") && 
               !pedido.getPrioridade().equals("alta") &&
               !pedido.getPrioridade().equals("critica");
    }
    
    @Override
    protected void processar(Pedido pedido) {
        System.out.println("Suporte está processando o pedido: " + pedido.getDescricao());
        System.out.println("  Prioridade: " + pedido.getPrioridade());
        System.out.println("  Usuário: " + pedido.getUsuarioId());
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
