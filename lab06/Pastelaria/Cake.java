package Praticas.lab06.Pastelaria;

public class Cake {
    private Shape shape;
    private String cakeLayer; 
    private int numCakeLayers; 
    private Cream midLayerCream; 
    private Cream topLayerCream; 
    private Topping topping; 
    private String message;
    
    public void setShape(Shape shape) {
        this.shape = shape;
    }
    public void setCakeLayer(String cakeLayer) {
        this.cakeLayer = cakeLayer;
    }
    public void setNumCakeLayers(int numCakeLayers) {
        this.numCakeLayers = numCakeLayers;
    }
    public void setMidLayerCream(Cream midLayerCream) {
        this.midLayerCream = midLayerCream;
    }
    public void setTopLayerCream(Cream topLayerCream) {
        this.topLayerCream = topLayerCream;
    }
    public void setTopping(Topping topping) {
        this.topping = topping;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    
    public Shape getShape() {
        return shape;
    }

    public int getNumCakeLayers() {
        return numCakeLayers;
    }

    @Override
    public String toString() {
        return String.format(
            "%s cake with %d layers%s, topped with %s cream and %s. Message says: \"%s\".",
            cakeLayer,
            numCakeLayers,
            (midLayerCream != null ? " and " + midLayerCream + " cream" : ""),
            topLayerCream,
            topping,
            message
        );
    }
}
