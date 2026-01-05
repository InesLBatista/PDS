# Padrão State - Sistema de Reprodução de Música

## Objetivo
Implementar o padrão State para alterar o comportamento de um objeto quando seu estado interno muda, cujo objetivo é:
- Permitir que um objeto altere seu comportamento quando seu estado interno muda;
- Encapsular estados específicos em classes separadas;
- Evitar condicionais complexas baseadas no estado do objeto;

## Características principais
- O comportamento de um objeto depende do seu estado atual;
- Cada estado é representado por uma classe separada;
- O contexto delega operações para o objeto de estado atual;
- Os próprios estados controlam as transições para outros estados;

## Componentes do sistema

### Interface estado
- EstadoReproducao: Interface que todos os estados devem implementar
  - Define métodos comuns a todos os estados
  - Cada estado implementa comportamento específico
  - Inclui método para obter nome do estado

### Estados concretos
- EstadoParado: Estado inicial do reprodutor
- EstadoReproduzindo: Quando a música está a tocar
- EstadoPausado: Quando a reprodução está pausada
- Cada estado sabe como responder a cada operação
- Cada estado sabe para qual estado transitar

### Contexto
- ReprodutorMusica: Mantém referência ao estado atual
  - Delega todas as operações para o estado atual
  - Fornece acesso aos estados concretos
  - Mantém dados específicos (faixa atual, lista de faixas)

### Cliente
- Interage apenas com o contexto
- Não conhece os estados concretos
- Invoca operações que são automaticamente delegadas