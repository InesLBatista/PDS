# Sistema de Controle de Dispositivos Domésticos

## Objetivo
Implementar o padrão Command para controlar dispositivos domésticos inteligentes, cujo objetivo é:
- Encapsular solicitações como objetos, permitindo parametrizar clientes com diferentes solicitações;
- Permitir o desacoplamento entre quem solicita uma ação e quem a executa;
- Suportar operações como undo (desfazer), redo (refazer) e criação de macros (sequências de comandos);

## Contexto
Um sistema de automação residencial precisa controlar diversos dispositivos (luzes, ar-condicionado, TV, cortinas, etc.). Em vez de ter código direto que chama métodos específicos de cada dispositivo, deve-se criar comandos que:
1. Encapsulam uma ação específica (ligar luz, aumentar temperatura, etc.)
2. Podem ser armazenados, passados como parâmetros e executados posteriormente
3. Podem ser desfeitos (undo) e refeitos (redo)
4. Podem ser combinados em macros (sequências de comandos)

## Requisitos

### Interface comum
- Comando: com métodos:
  - `void executar()` - executa a ação do comando
  - `void desfazer()` - desfaz a ação do comando (opcional)

### Comandos concretos
- LigarLuzComando: liga uma luz específica
- DesligarLuzComando: desliga uma luz específica
- AumentarTemperaturaComando: aumenta a temperatura do ar-condicionado
- DiminuirTemperaturaComando: diminui a temperatura do ar-condicionado
- LigarTVComando: liga a TV em um canal específico
- DesligarTVComando: desliga a TV

### Dispositivos receptores
- Luz: representa uma luz inteligente com métodos ligar() e desligar()
- ArCondicionado: representa um ar-condicionado com métodos setTemperatura() e getTemperatura()
- Televisao: representa uma TV com métodos ligar(), desligar() e setCanal()

### Cliente/invocador
- ControleRemoto: controla dispositivos através de comandos
- AppMobile: aplicativo que pode programar comandos
- Deve suportar botões que executam comandos
- Deve suportar histórico para undo/redo
- Deve suportar criação de macros

## Restrições
- O invocador não deve conhecer os dispositivos específicos
- Os comandos devem ser objetos que podem ser armazenados e executados posteriormente
- O sistema deve suportar operações de undo (desfazer)
- Deve ser possível criar macros (comandos compostos)
- Novos dispositivos devem poder ser adicionados sem modificar o controle remoto

## Cenário de utilização
O sistema deve permitir:
1. Ligar e desligar luzes com um botão
2. Ajustar temperatura do ar-condicionado
3. Ligar a TV em um canal específico
4. Desfazer a última operação
5. Refazer uma operação desfeita
6. Criar uma macro "modo cinema" que: desliga luzes, liga TV no canal de filmes, ajusta temperatura
7. Criar uma macro "modo sair" que: desliga todos os dispositivos