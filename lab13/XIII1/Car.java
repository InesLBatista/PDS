package Praticas.lab13.XIII1;

// Implementação concreta de Product para carros
public class Car implements Product {
    private String code;
    private String descr;
    private double points;
    
    public Car(String code, String descr, double points) {
        this.code = code;
        this.descr = descr;
        this.points = points;
    }
    
    @Override
    public String getCode() {
        return code;
    }
    
    @Override
    public String getDescr() {
        return descr;
    }
    
    @Override
    public double getPoints() {
        return points;
    }
    
    @Override
    public String toString() {
        return "Car [code=" + code + ", descr=" + descr + ", points=" + points + "]";
    }
}