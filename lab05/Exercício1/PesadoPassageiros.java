package Praticas.lab05.Exercício1;

public class PesadoPassageiros extends Veiculo {
    private int numQuadro;
    private int peso;
    private int maxPassageiros;

    public PesadoPassageiros(String matricula, String modelo, String marca, int potencia, int numQuadro, int peso, int maxPassageiros) {
        super(matricula, modelo, marca, potencia);
        this.numQuadro = numQuadro;
        this.peso = peso;
        this.maxPassageiros = maxPassageiros;
    }

    @Override
    public String toString() {
        return super.toString() + "PesadoPassageiros [numQuadro=" + numQuadro + ", peso=" + peso + ", maxPassageiros=" + maxPassageiros
                + "]";
    }
}
