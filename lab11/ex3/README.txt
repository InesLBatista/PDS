Problema: Gerir a comunicação entre vários utilizadores numa chat room. Se cada utilizador tivesse que manter uma lista de referências de todos os outros utilizadores para enviar mensagens, o sistema ficaria acoplado. A adição ou remoção de um utilizador exigiria a atualização da lógica em todos os outros utilizadores.

2. A Solução
O padrão Mediator é aplicado com o objeto ChatRoom como o mediador.

Utilizadores (ChatUser): Apenas enviam a sua mensagem para o ChatRoom usando o método mediator.sendMessage().

Mediador (ChatRoom): O ChatRoom recebe a mensagem e é responsável por coordenar a entrega, garantindo que a mensagem é distribuída a todos os outros User registados.

Isto elimina as dependências diretas, tornando o sistema fácil de expandir (basta adicionar novos utilizadores ao ChatRoom).

Referências: 
https://refactoring.guru/design-patterns/mediator