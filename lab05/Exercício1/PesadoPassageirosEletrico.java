package Praticas.lab05.Exercício1;

public class PesadoPassageirosEletrico extends PesadoPassageiros implements IGestaoBateria {
    private double carga;
    private double cargaMaxima;

    public PesadoPassageirosEletrico(String matricula, String marca, String modelo, int potencia,
                                     int numQuadro, int peso, int maxPassageiros) {
        super(matricula, marca, modelo, potencia, numQuadro, peso, maxPassageiros);
        this.carga = 100;
        this.cargaMaxima = 100;
    }

    @Override
    public double cargaDisponivel() {
        return carga;
    }

    @Override
    public void carregar(double percentagem) {
        carga = Math.min(carga + percentagem, cargaMaxima);
    }

    @Override
    public void limitarCargaMaxima(double percentagem) {
        cargaMaxima = percentagem;
        if (carga > cargaMaxima) carga = cargaMaxima;
    }

    @Override
    public String toString() {
        return super.toString() + " [Eletrico: carga=" + carga + ", cargaMaxima=" + cargaMaxima + "]";
    }
}
