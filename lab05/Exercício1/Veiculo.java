package Praticas.lab05.Exercício1;

public abstract class Veiculo implements IKmPercorridos {
    private String matricula;
    private String modelo;
    private String marca;
    private int potencia;
    private int ultimoTrajeto, distanciaTotal;
    
    public Veiculo(String matricula, String modelo, String marca, int potencia) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
        this.ultimoTrajeto = 0;
        this.distanciaTotal = 0;
    }

    public void trajeto(int quilometros) {
        this.ultimoTrajeto = quilometros;
        this.distanciaTotal += quilometros;
    }

    public int ultimoTrajeto() {
        return ultimoTrajeto;
    }

    public int distanciaTotal() {
        return distanciaTotal;
    }

    @Override
    public String toString() {
        return "Veiculo [matricula=" + matricula + ", modelo=" + modelo + ", marca=" + marca + ", potencia=" + potencia
                + "]";
    }
}

