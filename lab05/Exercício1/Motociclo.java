package Praticas.lab05.Exercício1;

public class Motociclo extends Veiculo {
    private String tipo;

    public Motociclo(String matricula, String modelo, String marca, int potencia, String tipo) {
        super(matricula, modelo, marca, potencia);
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return super.toString() + "Motociclo [tipo=" + tipo + "]";
    }
}

