# Sistema de Processamento de Pedidos

## Objetivo
Implementar o padrão Chain of Responsibility para processar pedidos em uma cadeia de manipuladores, cujo objetivo é:
- Desacoplar o remetente de um pedido de seus destinatários;
- Permitir que múltiplos objetos tenham a oportunidade de processar um pedido;
- Criar uma cadeia flexível de processamento onde cada manipulador pode decidir processar ou passar para o próximo;

## Contexto
Um sistema de processamento de pedidos precisa tratar diferentes tipos de pedidos com diferentes níveis de autoridade. Cada pedido pode ser processado por diferentes departamentos (suporte, técnico, gerente, administrador) dependendo do tipo e complexidade. Em vez de ter lógica complexa de condicionais, deve-se criar uma cadeia de responsabilidades onde cada manipulador:
1. Tenta processar o pedido se tiver autoridade
2. Passa para o próximo manipulador se não conseguir processar
3. Garante que o pedido é sempre processado por alguém adequado

## Requisitos

### Interface comum
- ManipuladorPedido: com métodos:
  - `void definirProximo(ManipuladorPedido proximo)` - define o próximo manipulador na cadeia
  - `void processarPedido(Pedido pedido)` - tenta processar o pedido ou passa para o próximo

### Manipuladores concretos
- ManipuladorSuporte: processa pedidos simples de suporte
- ManipuladorTecnico: processa pedidos técnicos complexos
- ManipuladorGerente: processa pedidos que requerem aprovação
- ManipuladorAdministrador: processa todos os pedidos restantes

### Objeto pedido
- Pedido: contém informação sobre:
  - Tipo do pedido (suporte, tecnico, gerencia, administrativo)
  - Descrição do pedido
  - Nível de prioridade (baixa, media, alta, critica)
  - ID do usuário

### Cliente (sistema de pedidos)
- Cria a cadeia de manipuladores
- Submete pedidos à cadeia
- Não precisa saber qual manipulador irá processar o pedido
- Pode adicionar ou remover manipuladores dinamicamente

## Restrições
- O cliente não deve conhecer os manipuladores específicos
- Cada manipulador deve decidir se processa ou passa o pedido
- A cadeia deve ser configurável em tempo de execução
- Todos os pedidos devem ser processados por alguém
- O sistema deve lidar com pedidos não processáveis

## Cenário de utilização
O sistema deve permitir:
1. Pedido simples de suporte: processado pelo suporte
2. Pedido técnico complexo: passado do suporte para o técnico
3. Pedido que requer aprovação: passado até o gerente
4. Pedido administrativo: passado até o administrador
5. Pedido desconhecido: processado pelo administrador como fallback

## Critérios de avaliação
- Implementação correta do padrão Chain of Responsibility
- Cadeia flexível e configurável
- Cada manipulador decide processar ou passar
- Transparência para o cliente
- Código limpo, extensível e bem estruturado