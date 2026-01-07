# Sistema de Processamento de Bebidas Quentes

## Objetivo
Implementar o padrão Template Method para definir o esqueleto de um algoritmo numa superclasse, permitindo que subclasses sobrescrevam passos específicos sem alterar a estrutura do algoritmo, cujo objetivo é:
- Definir a estrutura de um algoritmo numa classe base, delegando alguns passos para subclasses;
- Evitar duplicação de código em algoritmos com estruturas similares;
- Permitir que subclasses redefinam certos passos de um algoritmo sem alterar a sua estrutura geral;
- Controlar pontos de extensão onde subclasses podem personalizar o comportamento;

## Contexto
Uma cafeteria precisa preparar diferentes tipos de bebidas quentes (café, chá, chocolate quente, cappuccino). Cada bebida tem um processo de preparação que segue uma estrutura comum, mas com variações em passos específicos. Em vez de ter algoritmos duplicados ou condicionais complexas, deve-se:
1. Definir um template na classe base com os passos comuns
2. Implementar os passos específicos em subclasses
3. Garantir que a sequência de preparação seja sempre a mesma
4. Permitir que algumas etapas sejam opcionais (hooks)

## Requisitos

### Classe abstrata template
- BebidaQuenteTemplate: com métodos:
  - `final void prepararBebida()` - método template que define a sequência fixa
  - `abstract void aquecerAgua()` - passo específico para cada bebida
  - `abstract void adicionarIngredientePrincipal()` - passo específico
  - `abstract void mexer()` - passo específico
  - `void adicionarCondimentos()` - passo opcional (hook)
  - `boolean clienteQuerCondimentos()` - hook para personalização
  - `void servir()` - implementação comum a todas as bebidas

### Implementações concretas
- Cafe: implementa os passos específicos para preparar café
- Cha: implementa os passos específicos para preparar chá
- ChocolateQuente: implementa os passos específicos para chocolate
- Cappuccino: implementa os passos específicos para cappuccino
- ChaVerde: especialização de chá com comportamento adicional

### Cliente (sistema da cafeteria)
- Instancia a bebida específica
- Chama o método template `prepararBebida()`
- Obtém a bebida pronta seguindo o processo padronizado
- Não precisa conhecer os detalhes de cada etapa

## Restrições
- A sequência de preparação deve ser fixa e controlada pela classe base
- Alguns passos devem ser obrigatórios (abstratos) para as subclasses implementarem
- Alguns passos podem ser opcionais (hooks) com implementação padrão
- O método template (`prepararBebida`) deve ser `final` para não ser sobrescrito
- Subclasses não podem alterar a sequência do algoritmo, apenas passos específicos
- A classe base deve definir pontos de extensão bem definidos

## Cenário de utilização
O sistema deve permitir:
1. O cliente pede uma bebida específica
2. O sistema prepara a bebida seguindo o template comum:
   - Aquecer água (específico)
   - Adicionar ingrediente principal (específico)
   - Mexer (específico)
   - Adicionar condimentos (opcional, se o cliente quiser)
   - Servir (comum)
3. Cada bebida implementa os passos à sua maneira
4. Novas bebidas podem ser adicionadas criando novas subclasses
5. A sequência de preparação permanece consistente para todas as bebidas