# Builder Pattern

O Builder Pattern é um padrão de criação de objetos, cujo objetivo é:
* Separar o processo de construção de um objeto complexo da sua representação final;
* Permitir a criação de diferentes representações do mesmo objeto;
* Construir objetos passo a passo, de forma controlada;
* Evitar construtores complexos com muitos parâmetros.

Características principais:
* O objeto final é construído gradualmente;
* Um builder define os passos necessários para a construção;
* Builders concretos definem diferentes variações do produto;
* Um director controla a ordem de construção;
* O cliente não conhece os detalhes da construção interna.

## Sistema de Construção de Computadores

* Classe Computer
    * Representa o produto final
    * Contém os componentes:
      * cpu
      * gpu
      * ram
      * storage
      * so

* Interface ComputerBuilder
    * Define os métodos de construção:
      * buildCPU()
      * buildGPU()
      * buildRAM()
      * buildStorage()
      * buildSO()
    * Define o método getComputer()

* Builders concretos
    * GamingComputerBuilder
    * OfficeComputerBuilder
    * ServerComputerBuilder
    * Cada builder constrói uma configuração específica de Computer
    * Encapsulam os detalhes de construção de cada tipo de computador

* Director
    * Responsável por definir a sequência de construção
    * Orquestra o processo de criação do objeto

* Cliente (Main)
    * Escolhe o tipo de computador a criar
    * Utiliza o Director e um Builder concreto
    * Não conhece nem instancia diretamente os componentes do Computer