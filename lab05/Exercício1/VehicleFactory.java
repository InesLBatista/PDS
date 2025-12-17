package Praticas.lab05.Exercício1;

public class VehicleFactory {
    // Classe Factory que cria instâncias de veículos (Factory Method)

    public static Veiculo createMotociclo(String matricula, String marca, String modelo, int potencia, String tipo) {
        return new Motociclo(matricula, marca, modelo, potencia, tipo);
    }

    public static Veiculo createAutomovelLigeiro(String matricula, String marca, String modelo, int potencia,
                                                  String numQuadro, int capBagageira) {
        return new AutomovelLigeiro(matricula, marca, modelo, potencia, numQuadro.hashCode(), capBagageira);
    }

    public static Veiculo createTaxi(String matricula, String marca, String modelo, int potencia,
                                     String numQuadro, int capBagageira, String numLicenca) {
        return new Taxi(matricula, marca, modelo, potencia, numQuadro.hashCode(), capBagageira, numLicenca.hashCode());
    }

    public static Veiculo createPesadoMercadorias(String matricula, String marca, String modelo, int potencia,
                                                  String numQuadro, int peso, int maxCarga) {
        return new PesadoMercadorias(matricula, marca, modelo, potencia, numQuadro.hashCode(), peso, maxCarga);
    }

    public static Veiculo createPesadoPassageiros(String matricula, String marca, String modelo, int potencia,
                                                  int peso, String numQuadro, int maxPassageiros) {
        return new PesadoPassageiros(matricula, marca, modelo, potencia, numQuadro.hashCode(), peso, maxPassageiros);
    }

    public static Veiculo createALEletrico(String matricula, String marca, String modelo, int potencia,
                                           String numQuadro, int capBagageira, double carga, double cargaMaxima) {
        AutomovelLigeiroEletrico v = new AutomovelLigeiroEletrico(matricula, marca, modelo, potencia, numQuadro.hashCode(), capBagageira);
        v.limitarCargaMaxima(cargaMaxima);
        v.carregar(carga);
        return v;
    }

    public static Veiculo createPPEletrico(String matricula, String marca, String modelo, int potencia,
                                           int peso, String numQuadro, int maxPassageiros,
                                           double carga, double cargaMaxima) {
        PesadoPassageirosEletrico v = new PesadoPassageirosEletrico(matricula, marca, modelo, potencia, numQuadro.hashCode(), peso, maxPassageiros);
        v.limitarCargaMaxima(cargaMaxima);
        v.carregar(carga);
        return v;
    }
}
