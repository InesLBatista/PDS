package structural.composite;

public class Arquivo implements Item {
    private String nome;

    public Arquivo(String nome) {
        this.nome = nome;
    }

    @Override
    public void mostrar(int nivel) {
        System.out.println("  ".repeat(nivel) + "- Arquivo: " + nome);
    }
}

