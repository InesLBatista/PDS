package structural.bridge;

public class RelatorioEstoque extends Relatorio {
    public RelatorioEstoque (Formato formato) {
        super(formato);
    }

    @Override
    public void gerar() {
        String conteudo = "Dados de Estoque";
        formato.exportar(conteudo);
    }
}
