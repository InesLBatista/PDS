# Abstract Factory

O Abstract Factory é um padrão de criação de objetos, cujo objetivo é:
* Fornecer uma interface para criar famílias de objetos relacionados;
* Garantir a consistência entre objetos da mesma família;
* Desacoplar o código cliente das implementações concretas;
* Permitir a adição de novas famílias de produtos sem modificar o código cliente (Open/Closed Principle).

## Características principais:
* O cliente não instancia diretamente nenhuma classe concreta;
* Uma factory abstrata define métodos para criar diferentes produtos;
* Factories concretas implementam a criação de famílias específicas de objetos;
* O padrão promove polimorfismo: o cliente trabalha apenas com interfaces abstratas, tanto das factories como dos produtos.

## Sistema de Interface Gráfica Multi-Plataforma

* Interfaces dos produtos
  * Button e TextBox
    ```java
    interface Button { void render(); }
    interface TextBox { void render(); }
    ```
  * O cliente trabalha apenas com estas abstrações, independentemente da plataforma.

* Classes concretas dos produtos
  * WindowsButton, MacButton, LinuxButton
  * WindowsTextBox, MacTextBox, LinuxTextBox
  * Cada classe implementa a respetiva interface
  * Representam o comportamento específico de cada plataforma

* Abstract Factory (GUIFactory)
  * Define os métodos:
    * createButton()
    * createTextBox()
  * Estabelece o contrato para a criação das famílias de produtos

* Factories concretas
  * WindowsFactory, MacFactory, LinuxFactory
  * Cada factory cria apenas produtos da mesma família, garantindo consistência

* Cliente (Main)
  * Trabalha exclusivamente com a interface GUIFactory
  * Não conhece nem depende das classes concretas
  * Pode mudar de plataforma apenas trocando a factory utilizada

