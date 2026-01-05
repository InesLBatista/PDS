# Padrão Decorator - Sistema de Cafeteria Personalizado

## Objetivo
Implementar o padrão Decorator para criar um sistema de pedidos de café personalizável, cujo objetivo é:
* Adicionar funcionalidades a objetos de forma dinâmica e flexível;
* Evitar a explosão de subclasses para cada combinação possível de ingredientes;
* Seguir o princípio Open/Closed: aberto para extensão, fechado para modificação;

## Características principais
* O cliente pode decorar objetos em tempo de execução com múltiplos decorators;
* Cada decorator adiciona comportamento sem modificar a classe original;
* Promove composição sobre herança, evitando explosão de subclasses;
* Mantém a interface consistente entre componentes e decorators;

## Interfaces e Abstrações
* Component: `Cafe` com métodos `getDescricao()` e `getCusto()`;
* Concrete Component: Classes base como `CafeSimples`, `CafeExpresso`;
* Decorator: `CafeDecorator`, classe abstrata que implementa `Cafe`;
* Concrete Decorator: Classes como `LeiteDecorator`, `ChocolateDecorator`;

## Cliente (Sistema de Pedidos)
* Cria cafés base e os decora com ingredientes adicionais;
* Pode combinar múltiplos decorators em qualquer ordem;
* Chama métodos como `getDescricao()` e `getCusto()` sem diferenciar entre objetos simples e decorados;
* Demonstra flexibilidade do padrão em criar combinações personalizadas;

## Cenário de Uso
O sistema deve permitir:
1. Criar cafés base (simples, expresso, com leite);
2. Adicionar ingredientes extras (leite, chocolate, chantilly, etc.);
3. Combinar múltiplos ingredientes na mesma bebida;
4. Adicionar o mesmo ingrediente múltiplas vezes (ex: duplo chocolate);
5. Calcular custo total automaticamente considerando todos os decorators;

## Benefícios do Padrão Decorator
* Permite adicionar funcionalidades dinamicamente sem modificar código existente;
* Evita explosão de subclasses para cada combinação possível;
* Facilita a criação de objetos personalizados em tempo de execução;
* Mantém o código limpo, extensível e seguindo o princípio Open/Closed; 