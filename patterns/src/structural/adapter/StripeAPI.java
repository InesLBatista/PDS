package structural.adapter;

public class StripeAPI {
    public boolean charge (double amount) {
        System.out.println("Pagamento de "+ amount + "efetuado via Stripe.");
        return true;
    }
}
