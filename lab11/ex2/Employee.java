package ex2;

public abstract class Employee {
    
    protected String name; 

    public Employee(String name) {
        this.name = name;
    }
    
    public abstract String getName();
    
    public abstract boolean isNull();
}