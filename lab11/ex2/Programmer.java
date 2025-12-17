package ex2;
public class Programmer extends Employee {
    
    public Programmer (String name) {
        super(name);
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isNull() {
        return false;
    }
}
