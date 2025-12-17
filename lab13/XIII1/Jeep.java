
package Praticas.lab13.XIII1;

// Adapter para OldJeep - converte interface antiga para interface Product
public class Jeep implements Product {
    private OldJeep oldJeep;
    
    public Jeep(OldJeep oldJeep) {
        this.oldJeep = oldJeep;
    }
    
    @Override
    public String getCode() {
        String data = oldJeep.getData();
        String[] parts = data.split(";");
        return parts.length > 0 ? parts[0] : "";
    }
    
    @Override
    public String getDescr() {  // Mudado de description para getDescr
        String data = oldJeep.getData();
        String[] parts = data.split(";");
        return parts.length > 1 ? parts[1] : "";
    }
    
    @Override
    public double getPoints() {  // Mudado de points para getPoints
        String data = oldJeep.getData();
        String[] parts = data.split(";");
        return parts.length > 2 ? Double.parseDouble(parts[2]) : 0.0;
    }
    
    @Override
    public String toString() {
        return "Jeep [code=" + getCode() + ", descr=" + getDescr() + ", points=" + getPoints() + "]";
    }
}