package Praticas.lab05.Exercício1;

public class Taxi extends AutomovelLigeiro {
    private int numLicenca;

    public Taxi(String matricula, String modelo, String marca, int potencia, int numQuadro, int capBagageira, int numLicenca) {
        super(matricula, modelo, marca, potencia, numQuadro, capBagageira);
        this.numLicenca = numLicenca;
    }

    @Override
    public String toString() {
        return super.toString() + "Taxi [numLicenca=" + numLicenca + "]";
    }    
}

