package Praticas.lab05.Exercício2;

public class PlasticBag extends Container {
    public PlasticBag(Portion portion) {
        super(portion);
    }

    @Override
    public String toString() {
        return "PlasticBag with portion = " + portion;
    }
}
