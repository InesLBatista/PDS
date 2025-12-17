package lab09.Stars;
import java.awt.Color;

public class FStar extends StarType{
    
    public FStar() { 
        super(2, new Color(255, 255, 245)); 
        this.description = "This is a long description of the F type star....";
        this.physicalProperties = new Float[10];
    }
}