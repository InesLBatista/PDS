package lab09.Stars;
import java.awt.Color;

public class GStar extends StarType{

    public GStar() { 
        super(1, new Color(245, 250, 250)); 
        this.description = "This is a long description of the G type star....";
        this.physicalProperties = new Float[10];
    }
}