package behavioral.factory_method;

public class EmailNotificacao implements Notificacao{
    @Override
    public void enviar(String Mensagem) {
        System.out.println("Enviado Email: " + Mensagem);
    }
}
