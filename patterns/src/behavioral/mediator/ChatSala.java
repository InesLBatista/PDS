package behavioral.mediator;
import java.util.*;

class ChatSala implements ChatMediator {
    private List<Usuario> usuarios;
    private List<String> historicoMensagens;
    private String nomeSala;
    
    public ChatSala(String nomeSala) {
        this.nomeSala = nomeSala;
        this.usuarios = new ArrayList<>();
        this.historicoMensagens = new ArrayList<>();
        System.out.println("Sala de chat criada: " + nomeSala);
    }
    
    @Override
    public void enviarMensagem(String mensagem, Usuario remetente) {
        // Adiciona ao histórico
        String mensagemFormatada = remetente.getNome() + ": " + mensagem;
        historicoMensagens.add(mensagemFormatada);
        
        // Encaminha para todos os usuários exceto o remetente
        System.out.println("\n[" + nomeSala + "] Broadcast: " + mensagemFormatada);
        for (Usuario usuario : usuarios) {
            if (!usuario.equals(remetente)) {
                usuario.receberMensagem(mensagem);
            }
        }
    }
    
    @Override
    public void enviarMensagemPrivada(String mensagem, Usuario remetente, String nomeDestinatario) {
        Usuario destinatario = null;
        
        // Busca destinatário
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nomeDestinatario)) {
                destinatario = usuario;
                break;
            }
        }
        
        if (destinatario != null && !destinatario.equals(remetente)) {
            String mensagemPrivada = "[PRIVADO de " + remetente.getNome() + "]: " + mensagem;
            historicoMensagens.add(mensagemPrivada);
            System.out.println("\n[" + nomeSala + "] Mensagem privada: " + 
                              remetente.getNome() + " -> " + destinatario.getNome());
            destinatario.receberMensagemPrivada(mensagem, remetente.getNome());
        } else if (destinatario == null) {
            remetente.receberNotificacao("Usuário '" + nomeDestinatario + "' não encontrado.");
        }
    }
    
    @Override
    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        notificarEntrada(usuario);
    }
    
    @Override
    public void removerUsuario(Usuario usuario) {
        if (usuarios.remove(usuario)) {
            notificarSaida(usuario);
        }
    }
    
    @Override
    public void notificarEntrada(Usuario usuario) {
        String notificacao = usuario.getNome() + " entrou na sala.";
        historicoMensagens.add("[SISTEMA] " + notificacao);
        System.out.println("\n[" + nomeSala + "] " + notificacao);
        
        for (Usuario u : usuarios) {
            if (!u.equals(usuario)) {
                u.receberNotificacao(notificacao);
            }
        }
    }
    
    @Override
    public void notificarSaida(Usuario usuario) {
        String notificacao = usuario.getNome() + " saiu da sala.";
        historicoMensagens.add("[SISTEMA] " + notificacao);
        System.out.println("\n[" + nomeSala + "] " + notificacao);
        
        for (Usuario u : usuarios) {
            if (!u.equals(usuario)) {
                u.receberNotificacao(notificacao);
            }
        }
    }
    
    @Override
    public List<Usuario> getUsuariosOnline() {
        return new ArrayList<>(usuarios);
    }
    
    @Override
    public void banirUsuario(Usuario moderador, String nomeUsuario) {
        if (moderador instanceof UsuarioModerador || moderador instanceof UsuarioAdministrador) {
            Usuario usuarioParaBanir = null;
            
            for (Usuario usuario : usuarios) {
                if (usuario.getNome().equals(nomeUsuario)) {
                    usuarioParaBanir = usuario;
                    break;
                }
            }
            
            if (usuarioParaBanir != null && !(usuarioParaBanir instanceof UsuarioAdministrador)) {
                usuarios.remove(usuarioParaBanir);
                String notificacao = usuarioParaBanir.getNome() + " foi banido por " + moderador.getNome();
                historicoMensagens.add("[SISTEMA] " + notificacao);
                System.out.println("\n[" + nomeSala + "] " + notificacao);
                
                for (Usuario u : usuarios) {
                    u.receberNotificacao(notificacao);
                }
                
                usuarioParaBanir.receberNotificacao("Você foi banido da sala por " + moderador.getNome());
            } else if (usuarioParaBanir instanceof UsuarioAdministrador) {
                moderador.receberNotificacao("Não é possível banir um administrador.");
            }
        } else {
            moderador.receberNotificacao("Você não tem permissão para banir usuários.");
        }
    }
    
    @Override
    public void limparHistorico(Usuario moderador) {
        if (moderador instanceof UsuarioModerador || moderador instanceof UsuarioAdministrador) {
            int tamanhoAnterior = historicoMensagens.size();
            historicoMensagens.clear();
            historicoMensagens.add("[SISTEMA] Histórico limpo por " + moderador.getNome());
            System.out.println("\n[" + nomeSala + "] Histórico limpo. " + tamanhoAnterior + " mensagens removidas.");
        } else {
            moderador.receberNotificacao("Você não tem permissão para limpar o histórico.");
        }
    }
    
    public void mostrarHistorico() {
        System.out.println("\n=== HISTÓRICO DA SALA " + nomeSala + " ===");
        for (String mensagem : historicoMensagens) {
            System.out.println(mensagem);
        }
        System.out.println("Total: " + historicoMensagens.size() + " mensagens\n");
    }
    
    public String getNomeSala() {
        return nomeSala;
    }
}
