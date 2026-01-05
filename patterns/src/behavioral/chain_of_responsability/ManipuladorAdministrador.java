package behavioral.chain_of_responsability;

class ManipuladorAdministrador extends ManipuladorBase {
    @Override
    protected boolean podeProcessar(Pedido pedido) {
        // Administrador processa tudo
        return true;
    }
    
    @Override
    protected void processar(Pedido pedido) {
        System.out.println("Administrador está processando o pedido: " + pedido.getDescricao());
        System.out.println("  Tipo: " + pedido.getTipo());
        System.out.println("  Nota: processado como fallback");
    }
    
    @Override
    public void processarPedido(Pedido pedido) {
        processar(pedido);
    }
}

