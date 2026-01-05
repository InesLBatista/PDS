package behavioral.mediator;
import java.util.*;

interface ChatMediator {
    void enviarMensagem(String mensagem, Usuario remetente);
    void enviarMensagemPrivada(String mensagem, Usuario remetente, String nomeDestinatario);
    void adicionarUsuario(Usuario usuario);
    void removerUsuario(Usuario usuario);
    void notificarEntrada(Usuario usuario);
    void notificarSaida(Usuario usuario);
    List<Usuario> getUsuariosOnline();
    void banirUsuario(Usuario moderador, String nomeUsuario);
    void limparHistorico(Usuario moderador);
}
