package structural.adapter;

import java.math.BigDecimal;

public class BancoLocal {
    public String autorizarPagamento(BigDecimal valor) {
        System.out.println("Pagamento de " + valor + "efetuado pelo Banco Local.");
        return "AUTORIZADO";
    }
}
