package behavioral.mediator;

class UsuarioComum extends Usuario {
    public UsuarioComum(ChatMediator mediator, String nome) {
        super(mediator, nome);
    }
    
    @Override
    public void enviarMensagem(String mensagem) {
        System.out.println(nome + " enviando mensagem: " + mensagem);
        mediator.enviarMensagem(mensagem, this);
    }
    
    @Override
    public void enviarMensagemPrivada(String mensagem, String destinatario) {
        System.out.println(nome + " enviando mensagem privada para " + destinatario);
        mediator.enviarMensagemPrivada(mensagem, this, destinatario);
    }
    
    @Override
    public void receberMensagem(String mensagem) {
        System.out.println(nome + " recebeu: " + mensagem);
    }
    
    @Override
    public void receberMensagemPrivada(String mensagem, String remetente) {
        System.out.println(nome + " recebeu mensagem privada de " + remetente + ": " + mensagem);
    }
    
    @Override
    public void receberNotificacao(String notificacao) {
        System.out.println(nome + " [NOTIFICAÇÃO]: " + notificacao);
    }
}
