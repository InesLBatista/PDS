# Sistema de Logger Global
A aplicação deve ter um sistema de logging centralizado, garantindo que apenas **uma instância do Logger** exista em todo o sistema.

## Contexto
Em muitas aplicações, é necessário registrar mensagens de log (informações, avisos, erros) de forma consistente e centralizada.  
Criar múltiplas instâncias de um logger pode levar a inconsistências e duplicação de mensagens.

O Singleton Pattern garante que exista apenas uma instância de uma classe e fornece **um ponto de acesso global** a essa instância.

## Requisitos
- Classe Logger com:
  * Método para registrar mensagens, por exemplo: log(String mensagem)
  * Garantia de que apenas uma instância é criada (instância única)
  * Acesso global à instância
- Cliente que utiliza o Logger para registrar mensagens em diferentes partes do sistema
- Não permitir que múltiplas instâncias do Logger sejam criadas

## Objetivo
Implementar o Singleton Pattern para:
* Garantir que existe apenas uma instância do Logger em todo o sistema;
* Fornecer um ponto de acesso global à instância;
* Evitar problemas de inconsistência e duplicação;
* Demonstrar controle sobre a criação de instâncias de uma classe.

## Notas importantes
- O cliente não deve criar novas instâncias do Logger usando `new`;
- A classe deve fornecer um método estático para obter a instância única;