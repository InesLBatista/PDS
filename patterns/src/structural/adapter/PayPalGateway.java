package structural.adapter;

public class PayPalGateway {
    public void fazerPagamento(double amount) {
        System.out.println("Pagamento de " + amount + "feito via PayPal.");
    }
}
