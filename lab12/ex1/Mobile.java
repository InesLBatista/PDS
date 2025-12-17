package Praticas.lab12.ex1;

public class Mobile {
    private String brand;
    private double price;
    private int memoria;
    private int camera;

    public Mobile(String brand, double price, int memoria, int camera) {
        this.brand=brand;
        this.price=price;
        this.memoria=memoria;
        this.camera=camera;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public int getMemoria() {
        return memoria;
    }

    public int getCamera() {
        return camera;
    }

    @Override
    public String toString() {
        return "Mobile [brand=" + brand + ", price=" + price + ", memoria=" + memoria + ", camera=" + camera + "]";
    }
}
