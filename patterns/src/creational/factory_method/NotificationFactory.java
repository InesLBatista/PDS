package creational.factory_method;

public class NotificationFactory {
    public static Notificacao criarNotificacao(String tipo) {

        switch (tipo.toUpperCase()) {
            case "EMAIL":
                return new EmailNotificacao();
            case "SMS":
                return new SmsNotificacao();
            case "PUSH":
                return new PushNotificacao();
            default:
                throw new IllegalArgumentException("Tipo de notificação não suportado: " + tipo);
        } 
    }
}
