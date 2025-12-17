package Praticas.lab05.Exercício2;

public class Pork implements Portion {
    private final Temperature temperature;

    public Pork(Temperature temperature) {
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
        return "Pork: Temperature " + temperature + ", State " + getState();
    }
}

