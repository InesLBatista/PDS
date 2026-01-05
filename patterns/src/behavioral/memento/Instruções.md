# Sistema de Editor de Texto com Histórico

## Objetivo
Implementar o padrão Memento para capturar e restaurar o estado interno de um objeto, cujo objetivo é:
- Capturar e externalizar o estado interno de um objeto sem violar o encapsulamento;
- Permitir que o objeto seja restaurado a um estado anterior;
- Implementar funcionalidades de undo/redo sem expor detalhes de implementação;

## Contexto
Um editor de texto precisa implementar funcionalidades de histórico (undo/redo). Em vez de armazenar cada alteração diretamente ou expor o estado interno do editor, deve-se criar mementos que:
1. Capturam o estado atual do editor (texto, cursor, formatação)
2. Armazenam esse estado de forma segura e encapsulada
3. Permitem restaurar o editor a qualquer estado anterior
4. Gerenciam um histórico de estados com limite de tamanho
5. Implementam undo (desfazer) e redo (refazer) de forma eficiente

## Requisitos

### Classe originadora
- EditorTexto: representa o editor de texto com:
  - Conteúdo do texto
  - Posição do cursor
  - Formatação atual
  - Métodos para modificar o texto

### Classe memento
- MementoEditor: representa um snapshot do estado do editor
  - Deve armazenar o estado de forma encapsulada
  - Apenas o EditorTexto pode acessar o estado interno
  - Deve ser imutável

### Classe cuidadora
- GerenciadorHistorico: gerencia o histórico de mementos
  - Armazena mementos em uma pilha para undo
  - Armazena mementos em uma pilha para redo
  - Limita o tamanho do histórico
  - Fornece métodos para undo e redo

### Funcionalidades do editor
- Inserir texto em uma posição específica
- Apagar texto
- Mover cursor
- Alterar formatação (negrito, itálico)
- Salvar estado atual (criar memento)
- Restaurar estado anterior (aplicar memento)
- Undo (desfazer última operação)
- Redo (refazer operação desfeita)
- Limpar histórico

### Cliente (aplicação de editor)
- Usa o editor para modificar texto
- Usa o gerenciador para undo/redo
- Não tem acesso direto aos mementos
- Interage apenas com a interface pública

## Restrições
- O estado interno do editor não deve ser exposto
- Apenas o editor pode criar e aplicar mementos
- Os mementos devem ser imutáveis
- O histórico deve ter limite máximo para evitar uso excessivo de memória
- Deve suportar múltiplos níveis de undo/redo
- Deve ser eficiente em termos de memória
