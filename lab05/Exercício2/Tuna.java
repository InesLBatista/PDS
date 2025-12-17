package Praticas.lab05.Exercício2;

public class Tuna implements Portion {
    private final Temperature temperature;

    public Tuna(Temperature temperature) {
        this.temperature = temperature;
    }

    @Override
    public Temperature getTemperature() {
        return temperature;
    }

    @Override
    public State getState() {
        return State.Solid;
    }

    @Override
    public String toString() {
        return "Tuna: Temperature " + temperature + ", State " + getState();
    }
}

