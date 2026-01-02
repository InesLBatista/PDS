package structural.adapter;

public class StripeAdapter implements PagamentoProcessor {
    private StripeAPI stripe;

    public StripeAdapter (StripeAPI stripe) {
        this.stripe = stripe;
    }

    @Override
    public boolean processarPagamento (double valor) {
        return stripe.charge(valor);
    }
}
