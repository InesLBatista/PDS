# Padrão Command - Sistema de Controle de Dispositivos Domésticos

## Objetivo
Implementar o padrão Command para controlar dispositivos domésticos inteligentes, cujo objetivo é:
- Encapsular solicitações como objetos, permitindo parametrizar clientes com diferentes solicitações;
- Permitir o desacoplamento entre quem solicita uma ação e quem a executa;
- Suportar operações como undo (desfazer), redo (refazer) e criação de macros (sequências de comandos);

## Características principais
- Cada ação é encapsulada em um objeto Comando;
- O invocador (controle remoto) não conhece os detalhes dos dispositivos;
- Comandos podem ser armazenados, passados como parâmetros e executados posteriormente;
- Suporte nativo a operações de undo/redo através do histórico;
- Comandos podem ser combinados em macros;

## Componentes do sistema

### Interface comum
- Comando: Interface que define o contrato para todos os comandos
  - `executar()`: Executa a ação do comando
  - `desfazer()`: Desfaz a ação do comando

### Comandos concretos
- LigarLuzComando: Encapsula a ação de ligar uma luz
- DesligarLuzComando: Encapsula a ação de desligar uma luz
- AumentarTemperaturaComando: Encapsula a ação de aumentar temperatura
- DiminuirTemperaturaComando: Encapsula a ação de diminuir temperatura
- LigarTVComando: Encapsula a ação de ligar a TV em um canal específico
- DesligarTVComando: Encapsula a ação de desligar a TV

### Dispositivos receptores
- Luz: Representa uma luz inteligente com estado ligado/desligado
- ArCondicionado: Representa um ar-condicionado com controle de temperatura
- Televisao: Representa uma TV com controle de canal e estado

### Invocador
- ControleRemoto: Gerencia comandos e fornece interface para o usuário
  - Botões configuráveis com diferentes comandos
  - Histórico para undo/redo
  - Suporte a macros

### Comando composto
- MacroComando: Agrupa múltiplos comandos em uma única ação
  - Executa todos os comandos em sequência
  - Desfaz todos os comandos em ordem inversa