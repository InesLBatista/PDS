# Desenvolver um sistema de notificações
A aplicação precisa enviar notificações por diferentes canais, dependendo da configuração informada em tempo de execução.

## Contexto
Existem diferentes tipos de notificações:
* Email;
* SMS;
* Push Notification;

Cada tipo de notificação deve:
* enviar uma mensagem de texto;
* implementar uma interface comum;

## Requisitos
- Criar uma interface Notificacao com um método: void enviar(String Mensagem);
- Criar uma classe concreta para cada tipo de notificação: EmailNotificacao / SmsNotificacao / PushNotificacao;
- Criar uma classe NotificaoFactory responsável por:
    * receber um tipo de notificação (String ou enum);
    * retornar a instância correta de Notificacao;
    * centralizar toda a lógica de criação dos objetos;
- A aplicação principal não pode instanciar diretamente nenhuma classe concreta de notificação. Ela deve obter o objeto exclusivamente através da factory.
- O sistema deve permitir a fácil adição de novos tipos de notificação sem alterar o código cliente.