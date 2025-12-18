package behavioral.factory_method;

public class PushNotificacao implements Notificacao {
    @Override
    public void enviar(String Mensagem) {
        System.out.println("Push Notification enviada: " + Mensagem);
    }
}
