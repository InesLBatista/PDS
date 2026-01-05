# Sistema de Cafeteria Personalizado

## Objetivo
Implementar o padrão Decorator para criar um sistema de pedidos de café personalizável, cujo objetivo é:
* Adicionar funcionalidades a objetos de forma dinâmica e flexível;
* Evitar a explosão de subclasses para cada combinação possível de ingredientes;
* Seguir o princípio Open/Closed: aberto para extensão, fechado para modificação;

## Contexto
Uma cafeteria precisa de um sistema para montar pedidos de café personalizados. Cada cliente pode escolher um tipo de café base e adicionar diversos ingredientes extras (leite, chocolate, chantilly, etc.). Cada ingrediente adicional tem um custo extra e altera a descrição do produto. O sistema deve ser flexível para permitir qualquer combinação de ingredientes sem criar uma classe específica para cada combinação possível.

## Requisitos

### 1. Componente Base (Interface):
* `Cafe` com métodos: 
  * `String getDescricao()`
  * `double getCusto()`

### 2. Componentes Concretos (Cafés Base):
* CafeSimples: Café puro - R$ 2,00
* CafeExpresso: Café expresso forte - R$ 3,00
* CafeComLeite: Café com leite - R$ 2,50

### 3. Decorators (Ingredientes Extras):
* LeiteDecorator: Adiciona leite - R$ 0,50
* ChocolateDecorator: Adiciona chocolate - R$ 1,00
* ChantillyDecorator: Adiciona chantilly - R$ 0,75
* CanelaDecorator: Adiciona canela - R$ 0,25
* CarameloDecorator: Adiciona caramelo - R$ 0,80

### 4. Cliente (Sistema de Pedidos):
* Deve poder criar cafés personalizados com qualquer combinação de ingredientes
* Cada decorator envolve o objeto anterior, formando uma "cadeia de decorators"
* O sistema deve calcular o custo total automaticamente
* A descrição deve refletir todos os ingredientes adicionados

## Restrições
* Não criar subclasses para cada combinação possível de ingredientes
* Cada decorator deve poder ser aplicado a qualquer tipo de café
* O sistema deve permitir adicionar múltiplas unidades do mesmo ingrediente
* O código deve ser extensível para novos tipos de café e ingredientes sem modificar classes existentes

## Cenário de Uso
O sistema deve permitir criar pedidos como:
1. Café Expresso com Leite e Chocolate - R$ 3,00 + R$ 0,50 + R$ 1,00 = R$ 4,50
2. Café Simples com Duplo Chocolate e Chantilly - R$ 2,00 + R$ 2,00 + R$ 0,75 = R$ 4,75
3. Café com Leite com Canela e Caramelo - R$ 2,50 + R$ 0,25 + R$ 0,80 = R$ 3,55
4. Café Expresso com Leite, Chocolate e Chantilly - R$ 3,00 + R$ 0,50 + R$ 1,00 + R$ 0,75 = R$ 5,25
