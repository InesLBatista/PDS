package Praticas.lab05.Exercício1;

public class AutomovelLigeiro extends Veiculo {
    private int numQuadro;
    private int capBagageira;

    public AutomovelLigeiro(String matricula, String modelo, String marca, int potencia, int numQuadro, int capBagageira) {
        super(matricula, modelo, marca, potencia);
        this.numQuadro = numQuadro;
        this.capBagageira = capBagageira;
    }

    @Override
    public String toString() {
        return super.toString() + "AutomovelLigeiro [numQuadro=" + numQuadro + ", capBagageira=" + capBagageira + "]";
    }
}


