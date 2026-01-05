# Padrão Memento - Sistema de Editor de Texto com Histórico

## Características principais
- O estado interno é capturado em objetos memento opacos;
- Apenas o objeto originador pode acessar o conteúdo dos mementos;
- Um cuidador gerencia o histórico de mementos;
- Suporte completo a undo/redo com múltiplos níveis;

## Componentes do sistema

### Originador
- EditorTexto: Objeto cujo estado precisa ser salvo/restaurado
  - Gerencia conteúdo de texto, cursor e formatação
  - Cria mementos do seu estado atual
  - Restaura seu estado a partir de mementos
  - Não expõe seu estado interno diretamente

### Memento
- MementoEditor: Representa um snapshot do estado do editor
  - Armazena texto, posição do cursor e formatação
  - Imutável (uma vez criado, não pode ser modificado)
  - Métodos package-private (acessível apenas pelo originador)
  - Contém timestamp para rastreamento

### Cuidador
- GerenciadorHistorico: Gerencia o histórico de mementos
  - Armazena mementos em pilhas para undo/redo
  - Limita tamanho do histórico para controle de memória
  - Fornece operações de undo, redo e limpeza
  - Não acessa conteúdo interno dos mementos

### Formatação
- FormatoTexto: Representa formatação de texto
  - Negrito, itálico, sublinhado
  - Tamanho da fonte
  - Cópia defensiva para evitar aliasing