# Sistema de Chat em Grupo

## Objetivo
Implementar o padrão Mediator para facilitar a comunicação entre múltiplos objetos, cujo objetivo é:
- Definir um objeto que encapsula como um conjunto de objetos interage;
- Promover o desacoplamento evitando que objetos se referenciem explicitamente uns aos outros;
- Simplificar a comunicação complexa entre múltiplos componentes;

## Contexto
Um sistema de chat em grupo precisa coordenar a comunicação entre múltiplos usuários. Em vez de cada usuário enviar mensagens diretamente para outros usuários (o que criaria um acoplamento forte e complexidade), deve-se criar um mediador que:
1. Centraliza toda a comunicação entre usuários
2. Gerencia a entrada e saída de usuários do chat
3. Controla quem pode enviar mensagens para quem
4. Registra todas as mensagens para moderacão
5. Notifica usuários sobre eventos do sistema

## Requisitos

### Interface mediador
- ChatMediator: com métodos:
  - `void enviarMensagem(String mensagem, Usuario remetente)`
  - `void adicionarUsuario(Usuario usuario)`
  - `void removerUsuario(Usuario usuario)`
  - `void enviarMensagemPrivada(String mensagem, Usuario remetente, Usuario destinatario)`

### Componentes (usuários)
- Usuario: classe base abstrata para usuários
- UsuarioComum: usuário regular do chat
- UsuarioModerador: usuário com poderes de moderacão
- UsuarioAdministrador: usuário com controle total

### Funcionalidades do chat
- Envio de mensagens para todo o grupo
- Mensagens privadas entre usuários
- Entrada e saída de usuários
- Moderação de conteúdo (apenas moderadores/administradores)
- Notificações de sistema
- Lista de usuários online

### Cliente (sistema de chat)
- Cria o mediador e os usuários
- Configura as relacões através do mediador
- Simula interacões entre usuários
- Não permite comunicação direta entre usuários

## Restrições
- Os usuários não devem se comunicar diretamente
- Todas as comunicacões devem passar pelo mediador
- O mediador deve conhecer todos os usuários
- Usuários só conhecem o mediador, não outros usuários
- Deve suportar diferentes tipos de usuários com diferentes permisões