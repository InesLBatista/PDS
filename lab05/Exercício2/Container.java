package Praticas.lab05.Exercício2;

public abstract class Container {
    protected Portion portion;

    protected Container(Portion portion) {
        this.portion = portion;
    }

    public static Container create(Portion portion) {
        Temperature t = portion.getTemperature();
        State s = portion.getState();

        if (s == State.Liquid && t == Temperature.COLD)
            return new PlasticBottle(portion);
        else if (s == State.Liquid && t == Temperature.WARM)
            return new TermicBottle(portion);
        else if (s == State.Solid && t == Temperature.WARM)
            return new Tupperware(portion);
        else if (s == State.Solid && t == Temperature.COLD)
            return new PlasticBag(portion);
        else
            throw new IllegalArgumentException("No container available for " + s + " " + t);
    }

    @Override
    public abstract String toString();
}

