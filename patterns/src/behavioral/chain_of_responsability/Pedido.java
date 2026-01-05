package behavioral.chain_of_responsability;

class Pedido {
    private String tipo;
    private String descricao;
    private String prioridade;
    private String usuarioId;
    
    public Pedido(String tipo, String descricao, String prioridade, String usuarioId) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.usuarioId = usuarioId;
    }
    
    public String getTipo() { return tipo; }
    public String getDescricao() { return descricao; }
    public String getPrioridade() { return prioridade; }
    public String getUsuarioId() { return usuarioId; }
}
