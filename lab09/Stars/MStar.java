package lab09.Stars;
import java.awt.Color;

public class MStar extends StarType{
    
    public MStar() {
        super(1, Color.RED); 
        this.description = "This is a long description of the M type star....";
        this.physicalProperties = new Float[10];
    }
}