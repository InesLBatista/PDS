# Padrão Chain of Responsibility - Sistema de Processamento de Pedidos

## Objetivo
Implementar o padrão Chain of Responsibility para processar pedidos em uma cadeia de manipuladores, cujo objetivo é:
- Desacoplar o remetente de um pedido de seus destinatários;
- Permitir que múltiplos objetos tenham a oportunidade de processar um pedido;
- Criar uma cadeia flexível de processamento onde cada manipulador pode decidir processar ou passar para o próximo;

## Características principais
- O cliente envia um pedido para a cadeia sem saber qual manipulador irá processá-lo;
- Cada manipulador na cadeia decide se pode processar o pedido;
- Se um manipulador não pode processar, passa o pedido para o próximo;
- A cadeia é flexível e pode ser reconfigurada dinamicamente;

## Componentes do sistema

### Interface comum
- ManipuladorPedido: Interface que define os métodos da cadeia
  - `definirProximo()`: Define o próximo manipulador na cadeia
  - `processarPedido()`: Tenta processar o pedido ou passa para o próximo

### Classe base abstrata
- ManipuladorBase: Implementação base que fornece comportamento comum
  - Mantém referência para o próximo manipulador
  - Implementa lógica de passagem para o próximo
  - Define métodos abstratos para implementação específica

### Manipuladores concretos
- ManipuladorSuporte: Processa pedidos simples de suporte
- ManipuladorTecnico: Processa pedidos técnicos complexos
- ManipuladorGerente: Processa pedidos que requerem aprovação
- ManipuladorAdministrador: Processa todos os pedidos como fallback

### Objeto pedido
- Pedido: Contém toda a informação necessária
  - Tipo do pedido
  - Descrição
  - Prioridade
  - ID do usuário

### Cliente (sistema)
- Configura a cadeia de manipuladores
- Submete pedidos ao primeiro manipulador
- Não precisa conhecer a estrutura interna da cadeia