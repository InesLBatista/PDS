package lab09.Stars;
import java.awt.Color;

public class KStar extends StarType{
    
    public KStar() { 
        super(1, new Color(230, 160, 10)); 
        this.description = "This is a long description of the K type star....";
        this.physicalProperties = new Float[10];
    }
}