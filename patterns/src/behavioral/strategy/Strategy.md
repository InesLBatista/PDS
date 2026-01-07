# Padrão Strategy - Sistema de Processamento de Pagamentos

## Objetivo
Implementar o padrão Strategy para definir uma família de algoritmos, encapsular cada um e torná-los intercambiáveis, cujo objetivo é:
- Permitir que um algoritmo varie independentemente dos clientes que o utilizam;
- Definir uma família de algoritmos, encapsular cada um e torná-los intercambiáveis;
- Permitir que o algoritmo varie independentemente dos clientes que o utilizam;

## Características principais
- Define uma família de algoritmos relacionados;
- Encapsula cada algoritmo numa classe separada;
- Torna os algoritmos intercambiáveis dentro dessa família;
- Permite que o algoritmo varie independentemente dos clientes;

## Componentes do sistema

### Interface estratégia
- MetodoPagamento: Interface comum a todas as estratégias
  - `validarPagamento()`: Valida se o pagamento pode ser processado
  - `processarPagamento()`: Executa o processamento do pagamento
  - `calcularTaxa()`: Calcula taxas específicas do método
  - `getNomeMetodo()`: Retorna nome do método de pagamento
  - `getDescricao()`: Retorna descrição do método

### Estratégias concretas
- PagamentoCartaoCredito: Processa pagamentos com cartão
- PagamentoPayPal: Processa pagamentos com PayPal
- PagamentoTransferencia: Processa transferências bancárias
- PagamentoValePresente: Processa vales-presente
- PagamentoCriptomoeda: Processa pagamentos com criptomoedas

### Contexto
- ProcessadorPagamentos: Utiliza uma estratégia de pagamento
  - Mantém referência a uma estratégia concreta
  - Delega operações para a estratégia actual
  - Permite mudar estratégia em tempo de execução
  - Fornece interface unificada para o cliente

### Cliente
- Interage apenas com o contexto
- Seleciona estratégia apropriada
- Não conhece detalhes das estratégias concretas
- Pode mudar de estratégia dinamicamente