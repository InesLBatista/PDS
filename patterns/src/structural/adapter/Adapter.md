# Padrão Adapter - Sistema de Integração de Pagamentos

## Objetivo
Implementar o padrão Adapter para criar um sistema de integração de pagamentos centralizado, cujo objetivo é:
* Garantir que diferentes provedores de pagamento possam ser usados através de uma interface comum;
* Converter a interface de cada provedor para a interface padrão esperada pelo cliente;
* Evitar modificações nas implementações originais dos provedores;

## Características principais
* O cliente não instancia diretamente os provedores;
* Cada Adapter converte a interface específica do provedor para a interface padrão `PagamentoProcessor`;
* O padrão promove controle centralizado e consistência no processamento de pagamentos;
* Facilita a adição de novos provedores sem alterar o código do cliente;

## Sistemas Existentes (Adaptees)
* **PayPalGateway:** interface própria para pagamentos;
* **StripeAPI:** interface própria para pagamentos;
* **BancoLocal:** interface própria para pagamentos;
* Não podem ser modificados;

## Adapters
* Cada Adapter implementa a interface padrão `PagamentoProcessor`;
* Converte a interface específica do provedor para a interface esperada pelo cliente;
* Permite que o cliente use qualquer provedor sem conhecer detalhes internos;

## Cliente (Sistema de E-commerce)
* Trabalha exclusivamente com a interface `PagamentoProcessor`;
* Pode trocar provedores sem alterar o código do cliente;
* Não precisa conhecer a implementação específica de cada provedor;

## Benefícios do Padrão Adapter
* Integra provedores de pagamento com interfaces incompatíveis;
* Promove reuso de código existente sem modificações;
* Mantém o cliente desacoplado das implementações específicas;
* Facilita manutenção e expansão futura do sistema.
