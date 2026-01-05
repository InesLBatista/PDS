package behavioral.mediator;

abstract class Usuario {
    protected ChatMediator mediator;
    protected String nome;
    protected boolean online;
    
    public Usuario(ChatMediator mediator, String nome) {
        this.mediator = mediator;
        this.nome = nome;
        this.online = true;
    }
    
    public abstract void enviarMensagem(String mensagem);
    public abstract void enviarMensagemPrivada(String mensagem, String destinatario);
    public abstract void receberMensagem(String mensagem);
    public abstract void receberMensagemPrivada(String mensagem, String remetente);
    public abstract void receberNotificacao(String notificacao);
    
    public String getNome() {
        return nome;
    }
    
    public boolean isOnline() {
        return online;
    }
    
    public void entrarNaSala() {
        online = true;
        mediator.adicionarUsuario(this);
    }
    
    public void sairDaSala() {
        online = false;
        mediator.removerUsuario(this);
    }
    
    @Override
    public String toString() {
        return nome + " (" + this.getClass().getSimpleName() + ")";
    }
}