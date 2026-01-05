# Sistema de Biblioteca Digital

## Objetivo
Implementar o padrão Iterator para percorrer coleções de itens de maneira uniforme, cujo objetivo é:
- Fornecer uma maneira de acessar os elementos de uma coleção sequencialmente sem expor sua representação interna;
- Separar a lógica de iteração da estrutura de dados subjacente;
- Permitir múltiplas formas de percorrer a mesma coleção;

## Contexto
Uma biblioteca digital precisa gerenciar diferentes tipos de coleções de livros (por categoria, por autor, lista de desejos, histórico de leitura). Cada coleção tem uma estrutura interna diferente (array, lista ligada, árvore, mapa), mas o sistema precisa fornecer uma maneira uniforme de:
1. Percorrer todos os livros de uma coleção
2. Filtrar livros por critérios específicos
3. Implementar diferentes estratégias de iteração (ordem alfabética, data, popularidade)
4. Permitir que múltiplos iteradores percorram a mesma coleção simultaneamente

## Requisitos

### Interface comum
- Iterator: com métodos:
  - `boolean hasNext()` - verifica se existe próximo elemento
  - `Object next()` - retorna o próximo elemento
  - `void remove()` - remove o elemento atual (opcional)

### Coleções concretas
- ColecaoLivros: coleção básica de livros
- ColecaoPorCategoria: livros organizados por categoria
- ColecaoPorAutor: livros organizados por autor
- ListaDesejos: lista de livros desejados pelo usuário

### Iteradores concretos
- IteratorSimples: percorre em ordem de inserção
- IteratorAlfabetico: percorre em ordem alfabética pelo título
- IteratorPorData: percorre por data de publicação
- IteratorPorCategoria: percorre apenas livros de uma categoria específica

### Cliente (sistema de biblioteca)
- Deve poder percorrer qualquer coleção usando a interface Iterator
- Não deve conhecer a estrutura interna das coleções
- Deve poder usar diferentes estratégias de iteração na mesma coleção
- Deve suportar múltiplos iteradores simultâneos

## Restrições
- O cliente não deve conhecer a implementação interna das coleções
- A lógica de iteração deve ser separada da estrutura de dados
- Deve ser possível ter múltiplos iteradores na mesma coleção
- Novas estratégias de iteração devem poder ser adicionadas sem modificar as coleções
- A iteração deve ser type-safe (usar generics)