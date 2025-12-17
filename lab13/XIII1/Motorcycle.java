package Praticas.lab13.XIII1;

// Implementação concreta de Product para motociclos
public class Motorcycle implements Product {
    private String code;
    private String descr;    // Mudado de description para descr
    private double points;
    
    public Motorcycle(String code, String descr, double points) {
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
        return "Motorcycle [code=" + code + ", descr=" + descr + ", points=" + points + "]";
    }
}