package structural.bridge;

public class HTML implements Formato {
    @Override
    public void exportar(String conteudo) {
        System.out.println("Relatório exportado como HTML: " + conteudo);
    }
}
