# Sistema de Reprodução de Música

## Objetivo
Implementar o padrão State para alterar o comportamento de um objeto quando seu estado interno muda, cujo objetivo é:
- Permitir que um objeto altere seu comportamento quando seu estado interno muda;
- Encapsular estados específicos em classes separadas;
- Evitar condicionais complexas baseadas no estado do objeto;

## Contexto
Um reprodutor de música precisa comportar-se de forma diferente dependendo do seu estado atual (parado, reproduzindo, pausado). Em vez de usar múltiplos condicionais (if/switch) em todos os métodos, deve-se criar estados concretos que:
1. Representam cada estado possível do reprodutor
2. Implementam o comportamento específico para cada estado
3. Geram transições entre estados de forma encapsulada
4. Tornam fácil adicionar novos estados no futuro

## Requisitos

### Interface estado
- EstadoReproducao: com métodos:
  - `void reproduzir()`
  - `void pausar()`
  - `void parar()`
  - `void proximaFaixa()`
  - `void faixaAnterior()`

### Estados concretos
- EstadoParado: estado inicial do reprodutor
- EstadoReproduzindo: quando a música está a tocar
- EstadoPausado: quando a música está pausada

### Contexto
- ReprodutorMusica: mantém referência ao estado atual
  - Delega todas as operações para o estado atual
  - Fornece métodos para mudar de estado
  - Mantém informação sobre a faixa atual

### Funcionalidades do reprodutor
- Reproduzir música (dependendo do estado atual)
- Pausar reprodução
- Parar reprodução
- Avançar para próxima faixa
- Retroceder para faixa anterior
- Mostrar estado atual e faixa atual

### Cliente (aplicação de música)
- Interage apenas com o contexto (ReprodutorMusica)
- Não conhece os estados concretos
- Invoca operações que são delegadas para o estado atual
- Observa mudanças de comportamento automáticas

## Restrições
- O cliente não deve conhecer os estados concretos
- Todas as operações devem ser delegadas para o estado atual
- As transições de estado devem ser controladas pelos próprios estados
- Deve ser fácil adicionar novos estados no futuro
- O código não deve usar condicionais complexas baseadas no estado

## Cenário de utilização
O sistema deve permitir:
1. Iniciar reprodução a partir do estado parado
2. Pausar quando está a reproduzir
3. Continuar reprodução quando está pausado
4. Parar a reprodução a partir de qualquer estado
5. Mudar de faixa dependendo do estado atual
6. Comportamentos diferentes para cada operação em cada estado
7. Adicionar novos estados (ex: modo aleatório) facilmente