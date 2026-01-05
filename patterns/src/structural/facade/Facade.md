# Padrão Facade - Sistema de Home Theater

## Objetivo
Implementar o padrão Facade para simplificar a interacção com um sistema complexo de home theater, cujo objectivo é:
* Fornecer uma interface unificada e simplificada para um subsistema complexo;
* Reduzir a complexidade para o cliente, escondendo detalhes de implementação;
* Facilitar o uso de sistemas complexos através de uma interface amigável;

## Características principais
* O cliente interage apenas com a fachada, não com os componentes individuais;
* A fachada encapsula sequências complexas de operações em métodos simples;
* Promove baixo acoplamento entre o cliente e o subsistema;
* Facilita a manutenção e evolução do sistema sem afectar o cliente;

## Componentes do Sistema

### Subsistema Complexo
* Amplificador: Controlo de áudio e volume
* LeitorBluRay: Reprodução de media
* Projector: Projecção de imagem com diferentes modos
* SistemaDeLuzes: Controlo de iluminação ambiente
* EcrãProjecção: Controlo mecânico do ecrã
* MáquinaDePipocas: Preparação de snacks

### Fachada (Facade)
* HomeTheaterFacade: Interface simplificada com métodos:
  - `verFilme(String filme)`
  - `fimDoFilme()`
  - `ouvirMusica(String musica)`
  - `fimDaMusica()`
  - `configurarModoJogo()`

### Cliente (Utilizador)
* Interage exclusivamente com a fachada `HomeTheaterFacade`;
* Não precisa conhecer os detalhes dos 6 componentes do subsistema;
* Executa operações complexas com chamadas simples de alto nível;

## Benefícios do Padrão Facade

### 1. Simplificação 
* Sem Facade: 12 passos manuais para iniciar um filme
* Com Facade: 1 comando simples: `verFilme("Matrix")`

### 2. Redução de Complexidade
* Cliente não precisa entender:
  - Como configurar cada componente
  - A ordem correcta das operações
  - As dependências entre componentes
  - Os detalhes técnicos de cada dispositivo

### 3. Facilidade de Manutenção
* Mudanças no subsistema não afectam o cliente
* Novos componentes podem ser adicionados sem modificar a interface
* Correções de bugs são centralizadas na fachada

### 4. Baixo Acoplamento
* Cliente depende apenas da fachada
* Subsistema pode evoluir independentemente
* Testes são mais simples e isolados
