# Sistema de Processamento de Pagamentos

## Objetivo
Implementar o padrão Strategy para definir uma família de algoritmos, encapsular cada um e torná-los intercambiáveis, cujo objetivo é:
- Permitir que um algoritmo varie independentemente dos clientes que o utilizam;
- Definir uma família de algoritmos, encapsular cada um e torná-los intercambiáveis;
- Permitir que o algoritmo varie independentemente dos clientes que o utilizam;

## Contexto
Um sistema de e-commerce precisa processar diferentes tipos de pagamentos (cartão de crédito, PayPal, transferência bancária, vale-presente). Cada método tem as suas próprias regras de validação, processamento e cálculo de taxas. Em vez de ter condicionais complexas no código, deve-se criar estratégias que:
1. Encapsulam cada método de pagamento numa classe separada
2. Implementam a mesma interface para serem intercambiáveis
3. Permitem adicionar novos métodos de pagamento facilmente
4. Tornam o código de processamento independente dos detalhes de cada método

## Requisitos

### Interface estratégia
- MetodoPagamento: com métodos:
  - `boolean validarPagamento(double valor)`
  - `boolean processarPagamento(double valor)`
  - `double calcularTaxa(double valor)`
  - `String getNomeMetodo()`

### Estratégias concretas
- PagamentoCartaoCredito: processa pagamentos com cartão
- PagamentoPayPal: processa pagamentos com PayPal
- PagamentoTransferencia: processa transferências bancárias
- PagamentoValePresente: processa vales-presente
- PagamentoCriptomoeda: processa pagamentos com criptomoedas

### Contexto
- ProcessadorPagamentos: utiliza uma estratégia de pagamento
  - Permite definir a estratégia em tempo de execução
  - Delega o processamento para a estratégia actual
  - Fornece interface unificada para o cliente

### Cliente (sistema de e-commerce)
- Escolhe a estratégia de pagamento baseada na seleção do cliente
- Processa pagamentos usando a estratégia selecionada
- Pode mudar de estratégia dinamicamente
- Não conhece os detalhes de implementação de cada estratégia

## Restrições
- O cliente não deve conhecer as estratégias concretas
- As estratégias devem ser completamente intercambiáveis
- Novo método de pagamento pode ser adicionado sem modificar código existente
- O código de processamento deve funcionar com qualquer estratégia
- Cada estratégia deve encapsular completamente o seu algoritmo

## Cenário de utilização
O sistema deve permitir:
1. Cliente seleciona método de pagamento
2. Sistema valida o pagamento usando a estratégia apropriada
3. Sistema processa o pagamento com as regras específicas do método
4. Sistema calcula taxas de acordo com o método selecionado
5. Sistema pode mudar de método de pagamento dinamicamente
6. Novos métodos podem ser adicionados sem modificar o processador principal