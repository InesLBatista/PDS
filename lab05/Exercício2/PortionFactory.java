package Praticas.lab05.Exercício2;

public class PortionFactory {
    // // Classe responsável por criar objetos Portion (Factory Method)
    public static Portion create(String type, Temperature temp) {
        switch (type) {
            case "Milk": return new Milk(temp);
            case "FruitJuice": return new FruitJuice(temp);
            case "Tuna": return new Tuna(temp);
            case "Pork": return new Pork(temp);
            // mapeamento especial conforme enunciado:
            case "Beverage":
                if (temp == Temperature.COLD) return new FruitJuice(temp);
                else return new Milk(temp);
            case "Meat":
                if (temp == Temperature.WARM) return new Pork(temp);
                else return new Tuna(temp);
            default:
                throw new IllegalArgumentException("Unknown portion type: " + type);
        }
    }
}

