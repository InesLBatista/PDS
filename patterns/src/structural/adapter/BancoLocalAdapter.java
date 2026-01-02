package structural.adapter;

import java.math.BigDecimal;

public class BancoLocalAdapter implements PagamentoProcessor {
    private BancoLocal banco;

    public BancoLocalAdapter (BancoLocal banco) {
        this.banco=banco;
    }

    @Override
    public boolean processarPagamento (double valor) {
        String resultado = banco.autorizarPagamento(BigDecimal.valueOf(valor));
        return "AUTORIZADO".equalsIgnoreCase(resultado);
    }
}
