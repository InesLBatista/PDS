# Padrão Iterator - Sistema de Biblioteca Digital

## Características principais
- A coleção e a iteração são responsabilidades separadas;
- Interface uniforme para percorrer diferentes tipos de coleções;
- Múltiplos iteradores podem percorrer a mesma coleção simultaneamente;
- Novas estratégias de iteração podem ser adicionadas sem modificar a coleção;

## Componentes do sistema

### Interface Iterator
- Iterator<T>: Interface genérica que define o contrato
  - `hasNext()`: Verifica se existe próximo elemento
  - `next()`: Retorna o próximo elemento e avança
  - `remove()`: Remove o elemento atual (opcional)

### Interface Coleção
- ColecaoLivros<T>: Interface que as coleções devem implementar
  - `criarIterator()`: Factory method para criar iteradores
  - `adicionarLivro()`: Adiciona um livro à coleção
  - `getTamanho()`: Retorna o tamanho da coleção

### Implementação concreta
- Biblioteca: Implementação de coleção de livros
  - Armazena livros em uma lista interna
  - Fornece diferentes fábricas de iteradores
  - Cada tipo de iterator encapsula uma estratégia diferente

### Iteradores concretos
- IteratorSimples: Percorre em ordem de inserção
- IteratorAlfabetico: Percorre em ordem alfabética pelo título
- IteratorPorAno: Percorre por ano de publicação (mais recente primeiro)
- IteratorPorCategoria: Filtra por categoria específica
- IteratorPorAvaliacao: Percorre por avaliação (melhores primeiro)

### Cliente
- Usa a interface Iterator para percorrer coleções
- Não conhece a estrutura interna das coleções
- Pode usar diferentes estratégias de iteração
- Pode ter múltiplos iteradores ativos simultaneamente