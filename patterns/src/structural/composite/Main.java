package structural.composite;

public class Main {
    public static void main(String[] args) {
        Arquivo arquivo1 = new Arquivo("documento1.txt");
        Arquivo arquivo2 = new Arquivo("documento2.txt");
        Arquivo arquivo3 = new Arquivo("imagem.png");

        Pasta pasta1 = new Pasta("PastaA");
        Pasta pasta2 = new Pasta("PastaB");

        pasta1.adicionar(arquivo1);
        pasta1.adicionar(arquivo2);
        pasta2.adicionar(arquivo3);
        pasta1.adicionar(pasta2);

        pasta1.mostrar(0);
    }
}
