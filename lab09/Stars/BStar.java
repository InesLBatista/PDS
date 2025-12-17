package lab09.Stars;
import java.awt.Color;

public class BStar extends StarType{
    
    public BStar() { 
        super(5, new Color(230, 252, 252)); 
        this.description = "This is a long description of the B type star....";
        this.physicalProperties = new Float[10];
    }
}