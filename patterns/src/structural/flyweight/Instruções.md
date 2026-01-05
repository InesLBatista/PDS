# Sistema de Renderização de Árvores

## Objetivo
Implementar o padrão Flyweight para optimizar a renderização de uma floresta com milhares de árvores, cujo objetivo é:
* Partilhar eficientemente dados intrínsecos comuns entre múltiplos objectos;
* Reduzir significativamente o uso de memória quando existem muitos objectos similares;
* Separar dados intrínsecos (partilhados) de dados extrínsecos (únicos);

## Contexto
Um jogo precisa renderizar uma floresta com milhares de árvores. Cada árvore tem:
- Dados intrínsecos (partilhados): Tipo de árvore, textura, cor base (iguais para todas as árvores do mesmo tipo)
- Dados extrínsecos (únicos): Posição (x, y), altura, largura (diferentes para cada árvore)

Criar um objecto separado para cada árvone consumiria demasiada memória. O padrão Flyweight permite partilhar os dados intrínsecos entre todas as árvores do mesmo tipo.

## Requisitos

### 1. Flyweight Factory:
* FlorestaFactory: com método: `TipoArvore getTipoArvore(String nome, String cor, String textura)`

### 2. Flyweight (Dados Intrínsecos):
* TipoArvore: com atributos:
  * `String nome` (ex: "Carvalho", "Pinheiro", "Eucalipto")
  * `String cor`
  * `String textura`

### 3. Contexto (Dados Extrínsecos):
* Arvore: com atributos:
  * `int x`, `int y` (posição)
  * `double altura`, `double largura` (tamanho)
  * `TipoArvore tipo` (referência ao flyweight partilhado)

### 4. Cliente (Sistema de Renderização):
* Deve criar milhares de árvores usando poucos tipos partilhados;
* Deve demonstrar economia de memória através da partilha de tipos;
* Não deve criar duplicados desnecessários de dados intrínsecos;

## Restrições
* Os dados intrínsecos (TipoArvore) devem ser imutáveis;
* A factory deve garantir que cada tipo de árvore é criado apenas uma vez;
* A renderização deve usar tanto dados intrínsecos como extrínsecos;
* O sistema deve suportar pelo menos 3 tipos diferentes de árvores;

## Cenário de Utilização
O sistema deve permitir:
1. Criar tipos de árvores (Carvalho, Pinheiro, Eucalipto) apenas uma vez cada;
2. Criar milhares de árvores individuais usando os tipos partilhados;
3. Renderizar cada árvore com sua posição única mas características partilhadas;
4. Demonstrar que 1000 árvores do mesmo tipo usam apenas 1 objeto TipoArvore;