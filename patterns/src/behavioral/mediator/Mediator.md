# Padrão Mediator - Sistema de Chat em Grupo

## Características principais
- Um mediador central coordena toda a comunicação entre componentes;
- Componentes não se comunicam diretamente, apenas através do mediador;
- Redução drástica no número de conexões entre objetos;
- Fácil modificação das regras de comunicação;

## Componentes do sistema

### Interface Mediator
- ChatMediator: Interface que define os métodos de comunicação
  - `enviarMensagem()`: Envia mensagem para todos os usuários
  - `enviarMensagemPrivada()`: Envia mensagem privada para um usuário específico
  - `adicionarUsuario()`: Adiciona usuário à sala
  - `removerUsuario()`: Remove usuário da sala
  - `notificarEntrada/Saida()`: Notifica sobre entrada/saída de usuários

### Implementação concreta do Mediator
- ChatSala: Implementação concreta da sala de chat
  - Gerencia lista de usuários online
  - Mantém histórico de mensagens
  - Aplica regras de moderação
  - Distribui mensagens apropriadamente

### Classe base abstrata
- Usuario: Classe base para todos os tipos de usuários
  - Mantém referência ao mediador
  - Implementa métodos básicos de comunicação
  - Fornece funcionalidades comuns

### Implementações concretas de usuários
- UsuarioComum: Usuário regular do chat
- UsuarioModerador: Usuário com poderes de moderação
- UsuarioAdministrador: Usuário com controle total