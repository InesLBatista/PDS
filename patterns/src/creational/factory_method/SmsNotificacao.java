package creational.factory_method;

public class SmsNotificacao implements Notificacao {
    @Override
    public void enviar(String Mensagem) {
        System.out.println("SMS enviado: " + Mensagem);
    }
}
