package behavioral.mediator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Padrão Mediator - Sistema de Chat em Grupo\n");
        
        // 1. Criar mediator (sala de chat)
        ChatSala salaPrincipal = new ChatSala("Sala Principal");
        System.out.println();
        
        // 2. Criar usuários
        UsuarioComum alice = new UsuarioComum(salaPrincipal, "Alice");
        UsuarioComum bob = new UsuarioComum(salaPrincipal, "Bob");
        UsuarioComum carol = new UsuarioComum(salaPrincipal, "Carol");
        UsuarioModerador dave = new UsuarioModerador(salaPrincipal, "Dave");
        UsuarioAdministrador eve = new UsuarioAdministrador(salaPrincipal, "Eve");
        
        System.out.println("Usuários criados:");
        System.out.println("- Alice (Comum)");
        System.out.println("- Bob (Comum)");
        System.out.println("- Carol (Comum)");
        System.out.println("- Dave (Moderador)");
        System.out.println("- Eve (Administrador)");
        System.out.println("\n==============================================\n");
        
        // 3. Usuários entram na sala
        System.out.println("Usuários entrando na sala...\n");
        alice.entrarNaSala();
        bob.entrarNaSala();
        carol.entrarNaSala();
        dave.entrarNaSala();
        eve.entrarNaSala();
        
        System.out.println("\n==============================================\n");
        
        // 4. Testar envio de mensagens para o grupo
        System.out.println("TESTE 1: Mensagens para o grupo inteiro");
        System.out.println("----------------------------------------");
        alice.enviarMensagem("Olá pessoal!");
        bob.enviarMensagem("Oi Alice, tudo bem?");
        carol.enviarMensagem("Bom dia a todos!");
        
        System.out.println("\n==============================================\n");
        
        // 5. Testar mensagens privadas
        System.out.println("TESTE 2: Mensagens privadas");
        System.out.println("---------------------------");
        alice.enviarMensagemPrivada("Você viu o novo filme?", "Bob");
        bob.enviarMensagemPrivada("Sim, é muito bom!", "Alice");
        alice.enviarMensagemPrivada("Usuário inexistente", "Zé");
        
        System.out.println("\n==============================================\n");
        
        // 6. Testar funcionalidades de moderador
        System.out.println("TESTE 3: Funcionalidades de moderador");
        System.out.println("--------------------------------------");
        
        // Criar usuário problemático
        UsuarioComum troll = new UsuarioComum(salaPrincipal, "Troll");
        troll.entrarNaSala();
        troll.enviarMensagem("Mensagem inadequada!");
        
        // Moderador tenta banir
        dave.banirUsuario("Troll");
        
        // Tentar banir administrador (não deve funcionar)
        dave.banirUsuario("Eve");
        
        // Limpar histórico
        dave.limparHistorico();
        
        System.out.println("\n==============================================\n");
        
        // 7. Testar funcionalidades de administrador
        System.out.println("TESTE 4: Funcionalidades de administrador");
        System.out.println("------------------------------------------");
        eve.mostrarUsuariosOnline();
        
        // Administrador pode banir também
        UsuarioComum outroTroll = new UsuarioComum(salaPrincipal, "OutroTroll");
        outroTroll.entrarNaSala();
        outroTroll.enviarMensagem("Outra mensagem ruim");
        eve.banirUsuario("OutroTroll");
        
        System.out.println("\n==============================================\n");
        
        // 8. Testar entrada e saída de usuários
        System.out.println("TESTE 5: Entrada e saída de usuários");
        System.out.println("-------------------------------------");
        
        // Usuário sai
        bob.sairDaSala();
        
        // Novo usuário entra
        UsuarioComum frank = new UsuarioComum(salaPrincipal, "Frank");
        frank.entrarNaSala();
        frank.enviarMensagem("Acabei de chegar!");
        
        System.out.println("\n==============================================\n");
        
        // 9. Mostrar estado final
        System.out.println("TESTE 6: Estado final do sistema");
        System.out.println("---------------------------------");
        
        // Mostrar histórico
        salaPrincipal.mostrarHistorico();
        
        // Mostrar usuários online
        eve.mostrarUsuariosOnline();
        
        // Mais interações
        alice.enviarMensagem("Alguém quer jogar algo?");
        carol.enviarMensagem("Eu quero!");
        dave.enviarMensagem("Vamos organizar um torneio");
        
        System.out.println("\n==============================================\n");
        
        // 10. Demonstração do desacoplamento
        System.out.println("DEMONSTRAÇÃO: Desacoplamento entre usuários");
        System.out.println("--------------------------------------------");
        
        // Criar nova sala isolada
        ChatSala salaPrivada = new ChatSala("Sala Privada");
        
        UsuarioComum usuario1 = new UsuarioComum(salaPrivada, "User1");
        UsuarioComum usuario2 = new UsuarioComum(salaPrivada, "User2");
        
        usuario1.entrarNaSala();
        usuario2.entrarNaSala();
        
        // Mensagens nesta sala NÃO aparecem na sala principal
        usuario1.enviarMensagem("Esta mensagem só aparece na sala privada");
        
        // Mostrar que as salas são independentes
        System.out.println("\nSalas independentes:");
        System.out.println("- Sala Principal: " + salaPrincipal.getNomeSala());
        salaPrincipal.mostrarHistorico();
        
        System.out.println("- Sala Privada: " + salaPrivada.getNomeSala());
        salaPrivada.mostrarHistorico();
        
        System.out.println("\n==============================================\n");
        
        // 11. Resumo dos benefícios
        System.out.println("RESUMO DOS BENEFÍCIOS DO PADRÃO MEDIATOR:");
        System.out.println("==========================================\n");
        
        System.out.println("✓ Desacoplamento total:");
        System.out.println("  - Usuários não conhecem outros usuários");
        System.out.println("  - Usuários só conhecem o mediador");
        System.out.println("  - Comunicação centralizada no mediador");
        
        System.out.println("\n✓ Controle centralizado:");
        System.out.println("  - Todas as regras de comunicação em um lugar");
        System.out.println("  - Fácil modificar regras de comunicação");
        System.out.println("  - Controle de permissões centralizado");
        
        System.out.println("\n✓ Reutilização de componentes:");
        System.out.println("  - Usuários podem ser usados em diferentes mediadores");
        System.out.println("  - Mesmo usuário pode participar de múltiplas salas");
        System.out.println("  - Componentes são independentes e testáveis");
        
        System.out.println("\n✓ Simplicidade nas interações:");
        System.out.println("  - N conexões reduzem para 1 conexão por componente");
        System.out.println("  - Complexidade O(n) reduz para O(1) por componente");
        System.out.println("  - Fácil adicionar novas funcionalidades no mediador");
        
        System.out.println("\n✓ Extensibilidade:");
        System.out.println("  - Novos tipos de usuários podem ser adicionados");
        System.out.println("  - Novos tipos de mensagens podem ser suportados");
        System.out.println("  - Novas regras de comunicação podem ser implementadas");
        
        System.out.println("\n✓ Manutenibilidade:");
        System.out.println("  - Código de comunicação em um único lugar");
        System.out.println("  - Fácil debugar problemas de comunicação");
        System.out.println("  - Mudanças afetam apenas o mediador");
        
        System.out.println("\n==============================================\n");
        
        // 12. Comparação: Com vs Sem Mediator
        System.out.println("COMPARAÇÃO: Com vs Sem Mediator");
        System.out.println("===============================\n");
        
        System.out.println("SEM MEDIATOR (acoplamento forte):");
        System.out.println("- Cada usuário precisa conhecer todos os outros");
        System.out.println("- N² conexões para N usuários");
        System.out.println("- Difícil mudar regras de comunicação");
        System.out.println("- Código espalhado em todos os usuários");
        
        System.out.println("\nCOM MEDIATOR (desacoplamento):");
        System.out.println("- Cada usuário conhece apenas o mediador");
        System.out.println("- N conexões para N usuários");
        System.out.println("- Regras de comunicação centralizadas");
        System.out.println("- Fácil modificar comportamento do sistema");
        
        System.out.println("\nVANTAGENS:");
        System.out.println("- Redução de 75% nas conexões (para 4 usuários)");
        System.out.println("- Código mais organizado e mantível");
        System.out.println("- Reuso de componentes");
        System.out.println("- Testabilidade melhorada");
        
        System.out.println("\nPadrão Mediator implementado com sucesso!");
    }
}
