## Creational Patterns

### Objetivo

Os padrões criacionais têm como foco a forma como os objetos são criados.  
Eles fornecem mecanismos para criar objetos de maneira flexível, desacoplada e controlada, evitando dependências diretas do cliente em relação às classes concretas.

Estes padrões ajudam a:
* Encapsular a lógica de criação de objetos;
* Separar o cliente das classes concretas;
* Permitir que novos tipos de objetos sejam adicionados sem modificar código existente;
* Controlar a complexidade na criação de objetos complexos.

### Benefícios
* Desacoplamento entre criação e uso de objetos;
* Facilita a manutenção e extensão de sistemas;
* Promove reutilização de código;
* Centraliza a lógica de criação de objetos, tornando o sistema mais organizado.

### Exemplos de padrões criacionais
* **Singleton**: Garante que uma classe tenha apenas uma instância e fornece ponto de acesso global;
* **Factory Method**: Define uma interface para criar objetos, mas permite que subclasses decidam a classe concreta;
* **Abstract Factory**: Cria famílias de objetos relacionados sem especificar classes concretas;
* **Builder**: Constrói objetos complexos passo a passo, separando construção e representação;
* **Prototype**: Permite criar novos objetos clonando instâncias existentes.