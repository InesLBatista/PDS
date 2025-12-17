package Praticas.lab05.Exercício1;

public class PesadoMercadorias extends Veiculo {
    private int numQuadro;
    private int peso;
    private int maxCarga;

    public PesadoMercadorias(String matricula, String modelo, String marca, int potencia, int numQuadro, int peso, int maxCarga) {
        super(matricula, modelo, marca, potencia);
        this.numQuadro = numQuadro;
        this.peso = peso;
        this.maxCarga = maxCarga;
    }

    @Override
    public String toString() {
        return super.toString() + "PesadoMercadorias [numQuadro=" + numQuadro + ", peso=" + peso + ", maxCarga=" + maxCarga + "]";
    } 
}
