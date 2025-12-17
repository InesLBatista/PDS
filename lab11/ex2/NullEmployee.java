package ex2;

public class NullEmployee extends Employee {

    public NullEmployee() {
        super("Not Available"); 
    }

    @Override
    public String getName() {
        return "Employee Not Found"; 
    }

    @Override
    public boolean isNull() {
        return true;
    }
}