package Praticas.lab08.DistribuidorCabezes;

public abstract class ProdutoSimples implements Produto{
    protected String nome;
    protected double peso;

    public ProdutoSimples(String nome, double peso) {
        this.nome=nome;
        this.peso=peso;
    }

    @Override
    public double getWeight() {
        return peso;
    }

    @Override
    public void draw(String indent) {
        System.out.println(indent + this.getClass().getSimpleName() + " '" + nome + " '-weight: " + peso);
    }
}
