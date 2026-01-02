package structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Pasta implements Item {
    private String nome;
    private List<Item> itens = new ArrayList<>();

    public Pasta(String nome) {
        this.nome = nome;
    }

    public void adicionar(Item item) {
        itens.add(item);
    }

    public void remover(Item item) {
        itens.remove(item);
    }

    @Override
    public void mostrar(int nivel) {
        System.out.println("  ".repeat(nivel) + "+ Pasta: " + nome);
        for (Item item : itens) {
            item.mostrar(nivel + 1);
        }
    }
}

