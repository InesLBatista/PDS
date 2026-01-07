# Padrão Template Method - Sistema de Preparação de Bebidas Quentes

## Objetivo
Implementar o padrão Template Method para definir o esqueleto de um algoritmo numa superclasse, permitindo que subclasses sobrescrevam passos específicos sem alterar a estrutura do algoritmo, cujo objetivo é:
- Definir a estrutura de um algoritmo numa classe base, delegando alguns passos para subclasses;
- Evitar duplicação de código em algoritmos com estruturas similares;
- Permitir que subclasses redefinam certos passos de um algoritmo sem alterar a sua estrutura geral;
- Controlar pontos de extensão onde subclasses podem personalizar o comportamento;

## Características principais
- Define o esqueleto de um algoritmo numa classe base;
- Deixa passos específicos para serem implementados por subclasses;
- Controla o fluxo do algoritmo na classe base;
- Permite extensão em pontos específicos através de hooks;
- Mantém a sequência do algoritmo inalterada;

## Componentes do sistema

### Classe abstrata template
- BebidaQuenteTemplate: Classe base que define o template
  - `prepararBebida()`: Método template FINAL que define a sequência fixa
  - `aquecerAgua()`: Passo abstrato específico para cada bebida
  - `adicionarIngredientePrincipal()`: Passo abstrato específico
  - `mexer()`: Passo abstrato específico
  - `adicionarCondimentos()`: Hook opcional que pode ser sobrescrito
  - `clienteQuerCondimentos()`: Hook para controle de personalização
  - `servir()`: Método concreto comum a todas as bebidas

### Implementações concretas
- Cafe: Implementa os passos específicos para preparar café
- Cha: Implementa os passos específicos para preparar chá
- ChocolateQuente: Implementa os passos específicos para chocolate quente
- Cappuccino: Implementa os passos específicos para cappuccino
- ChaVerde: Especialização de Cha com comportamento adicional

### Cliente
- Interage com a classe concreta específica
- Invoca o método template `prepararBebida()`
- Recebe o resultado seguindo o processo padronizado
- Não precisa controlar a sequência de preparação

## Estrutura do algoritmo template
1. Aquecer água - Passo abstrato (implementação específica)
2. Adicionar ingrediente principal - Passo abstrato (implementação específica)
3. Mexer - Passo abstrato (implementação específica)
4. Adicionar condimentos - Hook opcional (pode ser sobrescrito)
5. Servir - Método concreto (implementação comum)

## Pontos chave do padrão
- Método template final: Garante que a sequência não pode ser alterada
- Passos abstratos: Forçam implementação específica nas subclasses
- Hooks: Permitem personalização controlada
- Métodos concretos: Fornecem comportamento padrão
- Estrutura fixa: A sequência é controlada pela classe base

## Vantagens
- Elimina duplicação de código em algoritmos similares
- Facilita manutenção ao centralizar a estrutura comum
- Permite extensão controlada através de hooks
- Garante consistência na execução do algoritmo
- Facilita adição de novas variações do algoritmo

## Aplicabilidade
- Quando múltiplos algoritmos têm estrutura similar com variações pontuais
- Quando se quer controlar pontos de extensão no algoritmo
- Quando se quer evitar duplicação de código comum
- Quando a sequência de execução é importante e não deve ser alterada