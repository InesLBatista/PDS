package behavioral.mediator;

class UsuarioModerador extends UsuarioComum {
    public UsuarioModerador(ChatMediator mediator, String nome) {
        super(mediator, nome);
    }
    
    public void banirUsuario(String nomeUsuario) {
        System.out.println(nome + " tentando banir " + nomeUsuario);
        mediator.banirUsuario(this, nomeUsuario);
    }
    
    public void limparHistorico() {
        System.out.println(nome + " limpando histórico");
        mediator.limparHistorico(this);
    }
    
    @Override
    public void receberNotificacao(String notificacao) {
        System.out.println(nome + " [MODERADOR - NOTIFICAÇÃO]: " + notificacao);
    }
}
