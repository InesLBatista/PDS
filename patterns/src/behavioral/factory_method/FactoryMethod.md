# Factory Method
O Factory Method é um padrão de criação de objetos, cujo objetivo é:
* Encapsular a criação dos mesmos;
* Desacopolar o código cliente das classes concretas;
* Permitir que novoss tipos de objetos sejam adicionados sem modificar código existente (Open/Closed Principle);

Características principais:
* O cliente não instancia diretamente a classe concreta;
* Uma factory decide qual objeto criar;
* O padrão promove polimorfismo: o cliente trabalha com a interface abstrata, não com a implementação;

## Sistema de Notificações
* Interface Notificacao: public interface Notificacao { void enviar(String mensagem); }
    * O cliente trabalha com a interface, não com EmailNotificacao, SmsNotificacao, etc.
* Classes concretas (EmailNotificacao, SmsNotificacao, PushNotificacao)
    * Cada classe implementa Notificacao
    * Encapsulam o comportamento específico de cada tipo de notificação
* Factory NotificationFactory
    * Decide qual instância concreta criar
    * Centraliza toda a lógica de criação
* Cliente (Main)
    * Não precisa saber qual classe concreta está sendo instanciada
    * Basta trabalhar com a interface