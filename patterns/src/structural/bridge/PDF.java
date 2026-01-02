package structural.bridge;

public class PDF implements Formato {
    @Override
    public void exportar(String conteudo) {
        System.out.println("Relatório exportado como PDF: " + conteudo);
    }
}
