package Praticas.lab05.Exercício2;

public class Milk implements Portion {
    private final Temperature temperature;

    public Milk(Temperature temperature) {
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
        return "Milk: Temperature " + temperature + ", State " + getState();
    }
}
