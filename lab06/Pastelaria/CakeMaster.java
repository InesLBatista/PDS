package Praticas.lab06.Pastelaria;

public class CakeMaster {
    private CakeBuilder builder;

    public void setCakeBuilder(CakeBuilder builder) {
        this.builder = builder;
    }

    // Construção genérica de bolo
    public void createCake(String message) {
        createCake(Shape.Circle, 1, message);
    }

    public void createCake(Shape shape, int layers, String message) {
        builder.createCake();
        builder.setCakeShape(shape);
        for (int i = 0; i < layers; i++) builder.addCakeLayer();
        if (layers > 1) builder.addCreamLayer();
        builder.addTopLayer();
        builder.addTopping();
        builder.addMessage(message);
    }

    public void createCake(int layers, String message) {
        createCake(Shape.Circle, layers, message);
    }

    public Cake getCake() {
        return builder.getCake();
    }
}

