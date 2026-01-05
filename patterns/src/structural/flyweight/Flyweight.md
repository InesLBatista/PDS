# Padrão Flyweight - Sistema de Renderização de Árvores

## Objetivo
Implementar o padrão Flyweight para optimizar a renderização de uma floresta com milhares de árvores, cujo objetivo é:
* Partilhar eficientemente dados intrínsecos comuns entre múltiplos objectos;
* Reduzir significativamente o uso de memória quando existem muitos objectos similares;
* Separar dados intrínsecos (partilhados) de dados extrínsecos (únicos);

## Características principais
* Os dados intrínsecos são partilhados entre múltiplos objectos;
* Os dados extrínsecos são armazenados separadamente em cada objecto;
* Uma factory garante que cada flyweight é criado apenas uma vez;
* O padrão é especialmente útil quando existem muitos objectos com dados repetidos;

## Componentes do Sistema

### Flyweight (Dados Intrínsecos)
* TipoArvore: Representa os dados partilhados de um tipo de árvore
  - `String nome` (ex: "Carvalho")
  - `String cor` (ex: "Castanho-escuro")
  - `String textura` (ex: "Textura rugosa")
  - Método `renderizar()` que usa dados intrínsecos e extrínsecos

### Flyweight Factory
* FlorestaFactory: Gerencia a criação e partilha de flyweights
  - `Map<String, TipoArvore> cacheTipos`: Cache de flyweights criados
  - `getTipoArvore()`: Retorna flyweight existente ou cria novo
  - Garante que cada combinação única é criada apenas uma vez

### Contexto (Dados Extrínsecos)
* Arvore: Representa uma árvore individual com dados únicos
  - `int x, y`: Posição na floresta
  - `double altura, largura`: Tamanho individual
  - `TipoArvore tipo`: Referência ao flyweight partilhado

### Cliente (Sistema de Renderização)
* Cria milhares de objectos Arvore usando poucos flyweights partilhados
* Demonstra economia de memória através da partilha
* Renderiza cada árvore combinando dados partilhados e únicos