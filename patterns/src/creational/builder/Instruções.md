# Sistema de construção de computadores
A aplicação deve ser capaz de construir diferentes tipos de computadores, passo a passo, permitindo variar os seus componentes sem alterar o processo de construção.

## Contexto
Um computador é composto por vários componentes:
* CPU
* GPU
* Memória RAM
* Armazenamento
* Sistema Operativo

Existem diferentes configurações possíveis, por exemplo:
* Computador Gaming
* Computador de Escritório
* Computador Servidor

Cada computador pode ter combinações diferentes de componentes, mas o processo de construção segue sempre a mesma sequência.

## Requisitos
- Classe Computer que represente o produto final;
- Interface ComputerBuilder com métodos para construir cada componente:
  * buildCPU()
  * buildGPU()
  * buildRAM()
  * buildStorage()
  * buildOperatingSystem()
- Builders concretos:
  * GamingComputerBuilder
  * OfficeComputerBuilder
  * ServerComputerBuilder
- Cada builder define como cada componente é construído;
- Classe Director responsável por:
  * Definir a ordem de construção;
  * Orquestrar o processo de criação do computador;
- Cliente que utiliza o Director e um Builder, sem conhecer os detalhes da construção interna.

## Objetivo
Implementar o Builder Pattern para separar:
* O processo de construção de um objeto complexo;
* Da sua representação final, permitindo criar diferentes configurações usando o mesmo processo de construção.
