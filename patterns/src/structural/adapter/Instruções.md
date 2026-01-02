# Sistema de Integração de Pagamentos

## Objetivo
Implementar o padrão Adapter para integrar sistemas de pagamento com interfaces incompatíveis, cujo objetivo é:
* Permitir que classes com interfaces incompatíveis trabalhem juntas;
* Converter a interface de uma classe em outra interface esperada pelo cliente;
* Promover reuso de código existente sem modificar sua implementação original;

## Contexto
Uma empresa precisa de integrar diferentes provedores de pagamento em seu sistema de e-commerce. Cada provedor tem sua própria interface e métodos específicos para processar pagamentos. O sistema principal trabalha com uma interface padrão de pagamento, então é preciso adaptar os diferentes provedores para essa interface comum sem modificar o código fonte original.

## Requisitos
### 1. Interface de Pagamento ## Restrições
* Não modificar as classes existentes dos provedores (PayPalGateway, StripeAPI, BancoLocal)
* O cliente deve poder usar qualquer provedor através da mesma interface
* Adicionar um novo provedor no futuro não deve exigir mudanças no código clienteAlvo (Target):
* `PagamentoProcessor` com método: `boolean processarPagamento(double valor)`

### 2. Sistemas Existentes (Adaptees):
* **PayPalGateway:** Tem método: `void fazerPagamento(double amount)`
* **StripeAPI:** Tem método: `boolean charge(double amount)`
* **BancoLocal:** Tem método: `String autorizarPagamento(BigDecimal valor)`

### 3. Adapters:
* Criar adaptadores para cada sistema de pagamento
* Cada adapter implementa `PagamentoProcessor`
* Adapta a interface específica de cada provedor para a interface padrão

### 4. Cliente (Sistema de E-commerce):
* Trabalha exclusivamente com a interface `PagamentoProcessor`
* Não precisa conhecer os detalhes de cada provedor
* Pode trocar provedores sem alterar o código do cliente

## Restrições
* Não modificar as classes existentes dos provedores (PayPalGateway, StripeAPI, BancoLocal)
* O cliente deve poder usar qualquer provedor através da mesma interface
* Adicionar um novo provedor no futuro não deve exigir mudanças no código cliente

## Cenário de Uso
O sistema deve processar pagamentos usando diferentes provedores:
1. Processar R$ 150,00 via PayPal
2. Processar R$ 299,90 via Stripe
3. Processar R$ 75,50 via Banco Local
4. Demonstrar que todos usam a mesma interface