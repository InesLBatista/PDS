package behavioral.mediator;
import java.util.*;

class UsuarioAdministrador extends UsuarioModerador {
    public UsuarioAdministrador(ChatMediator mediator, String nome) {
        super(mediator, nome);
    }
    
    public void mostrarUsuariosOnline() {
        List<Usuario> usuarios = mediator.getUsuariosOnline();
        System.out.println("\n=== USUÁRIOS ONLINE (" + usuarios.size() + ") ===");
        for (Usuario usuario : usuarios) {
            System.out.println("  • " + usuario);
        }
    }
    
    @Override
    public void receberNotificacao(String notificacao) {
        System.out.println(nome + " [ADMIN - NOTIFICAÇÃO]: " + notificacao);
    }
}
