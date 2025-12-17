package Praticas.lab08.DistribuidorCabezes;
import java.util.*;

public class Caixa implements Produto {
    private String nome;
    private double peso;
    private List<Produto> produtos;

    public Caixa(String nome, double peso) {
        this.nome = nome;
        this.peso = peso;
        this.produtos = new ArrayList<>();
    }

    public void add(Produto p) {
        produtos.add(p);
    }

    @Override
    public double getWeight() {
        double total = peso;
        for (Produto p : produtos) {
            total += p.getWeight();
        }
        return total;
    }

    @Override
    public void draw(String indent) {
        System.out.println(indent + "* Caixa '" + nome + "' [ Weight: " + peso + " ; Total: " + getWeight() + "]");
        for (Produto p : produtos) {
            p.draw(indent + "   ");
        }
    }
}