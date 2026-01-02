package structural.bridge;

public class Excel implements Formato {
    @Override
    public void exportar(String conteudo) {
        System.out.println("Relatorio exportado como Excel: " + conteudo);
    }
}
