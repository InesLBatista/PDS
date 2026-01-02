package structural.bridge;

public class RelatorioVendas extends Relatorio {
    public RelatorioVendas(Formato formato) {
        super(formato);
    }

    @Override
    public void gerar() {
        String conteudo = "Dados de Venda";
        formato.exportar(conteudo);
    }
}
