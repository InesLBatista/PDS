package structural.bridge;

public class RelatorioFinanceiro extends Relatorio {
    public RelatorioFinanceiro (Formato formato) {
        super(formato);
    }

    @Override
    public void gerar() {
        String conteudo = "Dados Financeiros";
        formato.exportar(conteudo);
    }
}
