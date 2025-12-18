# Behavioral Patterns

## Objetivo
Os padrões comportamentais são um grupo de padrões de projeto cujo foco principal é a forma como os objetos interagem e se comunicam entre si.  
O objetivo destes padrões é definir responsabilidades, controlar o fluxo de comunicação e delegar comportamentos de forma eficiente, promovendo sistemas mais flexíveis e fáceis de manter.

Estes padrões ajudam a:

* Definir como os objetos colaboram sem acoplamento excessivo;
* Encapsular algoritmos e comportamentos que podem variar;
* Delegar responsabilidades e organizar fluxos de controle de maneira clara;
* Melhorar a legibilidade e a manutenção do código, separando quem faz o quê.

---

## Benefícios da utilização
* Desacoplamento: Objetos se comunicam através de interfaces ou abstrações, evitando dependências rígidas;
* Flexibilidade: Permitem alterar ou estender comportamentos sem modificar o código cliente;
* Reutilização de código: Comportamentos comuns podem ser encapsulados em classes ou métodos reutilizáveis;
* Organização e clareza: Estruturam a comunicação entre objetos de forma previsível e documentada;
* Manutenção facilitada: Mudanças no comportamento podem ser feitas em apenas uma parte do sistema, sem quebrar outras funcionalidades.


## Exemplos de padrões comportamentais
Alguns padrões comportamentais comuns incluem:
* **Chain of Responsibility**: Encadeia objetos para processar requisições de forma flexível;
* **Command**: Encapsula solicitações como objetos, permitindo desfazer/registrar ações;
* **Iterator**: Permite percorrer elementos de uma coleção sem expor sua representação interna;
* **Observer**: Notifica automaticamente dependentes quando um objeto muda de estado;
* **Strategy**: Permite trocar algoritmos ou comportamentos em tempo de execução;
* **Template Method**: Define o esqueleto de um algoritmo, permitindo que subclasses implementem passos específicos;
* **Visitor**: Permite adicionar operações a estruturas de objetos sem modificar suas classes;
* **Memento**: Captura e restaura o estado interno de um objeto sem violar encapsulamento.