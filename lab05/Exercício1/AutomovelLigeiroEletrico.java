package Praticas.lab05.Exercício1;

public class AutomovelLigeiroEletrico extends AutomovelLigeiro {
    // Classe que representa um automóvel ligeiro elétrico
    private double carga, cargaMaxima;
    
    public AutomovelLigeiroEletrico(String matricula, String modelo, String marca, int potencia, int numQuadro, int capBagageira) {
        super(matricula, marca, modelo, potencia, numQuadro, capBagageira);
        this.carga = 100;
        this.cargaMaxima = 100;
    }

    public double cargaDisponivel() {
        return carga;
    }

    public void carregar(double percentagem) {
        carga = Math.min(carga + percentagem, cargaMaxima);
    }

    public void limitarCargaMaxima(double percentagem) {
        cargaMaxima = percentagem;
        if (carga > cargaMaxima) carga = cargaMaxima;
    }

    @Override
    public String toString() {
        return super.toString() + "AutomovelLigeiroEletrico [carga=" + carga + ", cargaMaxima=" + cargaMaxima + "]";
    }
}

