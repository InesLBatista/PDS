package behavioral.factory_method;

public class Main {
    public static void main(String[] args) {
        Notificacao notificacao = NotificationFactory.criarNotificacao("EMAIL");
        notificacao.enviar("Notificação por Email!");

        Notificacao not = NotificationFactory.criarNotificacao("SMS");
        not.enviar("Notificação por SMS!");

        Notificacao not_push = NotificationFactory.criarNotificacao("PUSH");
        not_push.enviar("Notificação por Push Notification!");

        Notificacao not_null = NotificationFactory.criarNotificacao("DISCORD");
        not_null.enviar("Esta notificação não deve ser enviada!");
    }
}
