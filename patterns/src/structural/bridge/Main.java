package structural.bridge;

public class Main {
    public static void main(String[] args) {
        Formato pdf = new PDF();
        Formato excel = new Excel();
        Formato html = new HTML();

        Relatorio relatorio1 = new RelatorioVendas(pdf);
        Relatorio relatorio2 = new RelatorioEstoque(excel);
        Relatorio relatorio3 = new RelatorioFinanceiro(html);

        relatorio1.gerar(); // Vendas em PDF
        relatorio2.gerar(); // Estoque em Excel
        relatorio3.gerar(); // Financeiro em HTML

        // Combinações adicionais
        Relatorio relatorio4 = new RelatorioVendas(html);
        relatorio4.gerar(); // Vendas em HTML
    }
}
