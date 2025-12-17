package Praticas.lab06.Pastelaria;

public class ChocolateCakeBuilder implements CakeBuilder {
    private Cake cake;

    @Override
    public void createCake() {
        cake = new Cake();
        cake.setCakeLayer("Soft chocolate");
    }

    @Override
    public void setCakeShape(Shape shape) {
        cake.setShape(shape);
    }

    @Override
    public void addCakeLayer() {
        cake.setNumCakeLayers(cake.getNumCakeLayers() + 1);
    }

    @Override
    public void addCreamLayer() {
        cake.setMidLayerCream(Cream.Whipped_Cream);
    }

    @Override
    public void addTopLayer() {
        cake.setTopLayerCream(Cream.Whipped_Cream);
    }

    @Override
    public void addTopping() {
        cake.setTopping(Topping.Fruit);
    }

    @Override
    public void addMessage(String m) {
        cake.setMessage(m);
    }

    @Override
    public Cake getCake() {
        return cake;
    }
}

