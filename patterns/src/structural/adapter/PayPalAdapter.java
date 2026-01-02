package structural.adapter;

public class PayPalAdapter implements PagamentoProcessor {
    private PayPalGateway payPal;

    public PayPalAdapter(PayPalGateway payPal) {
        this.payPal = payPal;
    }

    @Override
    public boolean processarPagamento (double valor) {
        payPal.fazerPagamento(valor);
        return true;
    }
}
