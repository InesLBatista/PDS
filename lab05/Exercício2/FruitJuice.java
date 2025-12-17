package Praticas.lab05.Exercício2;

public class FruitJuice implements Portion {
    private final Temperature temperature;
    private final String fruitName = "Orange";

    public FruitJuice(Temperature temperature) {
        this.temperature = temperature;
    }

    @Override
    public Temperature getTemperature() {
        return temperature;
    }

    @Override
    public State getState() {
        return State.Liquid;
    }

    @Override
    public String toString() {
        return "FruitJuice: " + fruitName + ", Temperature " + temperature + ", State " + getState();
    }
}

