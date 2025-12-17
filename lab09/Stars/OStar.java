package lab09.Stars;
import java.awt.Color;

public class OStar extends StarType{
    
    public OStar() { 
        super(5, new Color(225, 250, 250)); 
        this.description = "This is a long description of the O type star....";
        this.physicalProperties = new Float[10];
    }
}
