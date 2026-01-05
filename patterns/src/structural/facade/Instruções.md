# Sistema de Home Theater Simplificado

## Objetivo
Implementar o padrão Facade para simplificar a interacção com um sistema complexo de home theater, cujo objectivo é:
* Fornecer uma interface unificada e simplificada para um subsistema complexo;
* Reduzir a complexidade para o cliente, escondendo detalhes de implementação;
* Facilitar o uso de sistemas complexos através de uma interface amigável;

## Contexto
Um sistema de home theater consiste em vários componentes complexos (Amplificador, Leitor de Blu-ray, Projector, Luzes, etc.), cada um com as suas próprias interfaces e métodos. Configurar manualmente todos os componentes para ver um filme requer múltiplos passos e conhecimentos técnicos. É necessário criar uma fachada que simplifique este processo para o utilizador final.

## Requisitos

### 1. Subsistema Complexo (Componentes do Home Theater):
* Amplificador:
  * `void ligar()`, `void desligar()`
  * `void setVolume(int nivel)`
  * `void setEntrada(String entrada)`
* LeitorBluRay:
  * `void ligar()`, `void desligar()`
  * `void reproduzir(String filme)`
  * `void parar()`
  * `void ejectar()`
* Projector:
  * `void ligar()`, `void desligar()`
  * `void setModoWideScreen()`
  * `void setModoNormal()`
* SistemaDeLuzes:
  * `void ligar()`, `void desligar()`
  * `void atenuar(int nivel)`
* EcrãProjecção:
  * `void descer()`, `void subir()`
* MáquinaDePipocas:
  * `void ligar()`, `void desligar()`
  * `void fazerPipocas()`

### 2. Fachada (Interface Simplificada):
* HomeTheaterFacade: com métodos:
  * `void verFilme(String filme)`
  * `void fimDoFilme()`
  * `void ouvirMusica(String musica)`
  * `void fimDaMusica()`

### 3. Cliente (Utilizador do Sistema):
* Deve interagir apenas com a fachada `HomeTheaterFacade`;
* Não precisa conhecer os detalhes de cada componente;
* Pode executar operações complexas com chamadas simples;

## Restrições
* O cliente não deve interagir directamente com os componentes do subsistema;
* A fachada deve encapsular toda a complexidade da configuração do sistema;
* Adicionar novos componentes no futuro não deve exigir mudanças no código do cliente;
* A fachada deve fornecer métodos de alto nível que realizam múltiplas operações;

## Cenário de Utilização
O sistema deve permitir operações como:
1. Ver um Filme:
   - Liga a máquina de pipocas e faz pipocas
   - Atenua as luzes para 10%
   - Desce o ecrã de projecção
   - Liga o projector em modo widescreen
   - Liga o amplificador e configura entrada para Blu-ray
   - Liga o leitor de Blu-ray e inicia o filme

2. Fim do Filme:
   - Para o leitor de Blu-ray
   - Ejecta o disco
   - Desliga todos os equipamentos
   - Sobe o ecrã de projecção
   - Liga as luzes novamente

3. Ouvir Música:
   - Liga o amplificador
   - Configura volume para nível médio
   - Configura entrada para streaming
   - Liga o leitor de Blu-ray para streaming

