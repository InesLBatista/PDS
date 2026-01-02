package structural.adapter;

public class Ecommerce {
    public static void main(String[] args) {
        PagamentoProcessor paypal = new PayPalAdapter(new PayPalGateway());
        paypal.processarPagamento(300);

        PagamentoProcessor stripe = new StripeAdapter(new StripeAPI());
        stripe.processarPagamento(500);

        PagamentoProcessor banco = new BancoLocalAdapter(new BancoLocal());
        banco.processarPagamento(651);
    }
}
